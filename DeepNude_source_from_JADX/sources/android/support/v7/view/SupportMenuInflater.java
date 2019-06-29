package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class};
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = new Class[]{MenuItem.class};
        private Method mMethod;
        private Object mRealOwner;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.mRealOwner = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(str);
                stringBuilder.append(" in class ");
                stringBuilder.append(cls.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.mRealOwner, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.mRealOwner, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class MenuState {
        private static final int defaultGroupId = 0;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemEnabled = true;
        private static final int defaultItemId = 0;
        private static final int defaultItemOrder = 0;
        private static final boolean defaultItemVisible = true;
        private int groupCategory;
        private int groupCheckable;
        private boolean groupEnabled;
        private int groupId;
        private int groupOrder;
        private boolean groupVisible;
        ActionProvider itemActionProvider;
        private String itemActionProviderClassName;
        private String itemActionViewClassName;
        private int itemActionViewLayout;
        private boolean itemAdded;
        private int itemAlphabeticModifiers;
        private char itemAlphabeticShortcut;
        private int itemCategoryOrder;
        private int itemCheckable;
        private boolean itemChecked;
        private CharSequence itemContentDescription;
        private boolean itemEnabled;
        private int itemIconResId;
        private ColorStateList itemIconTintList = null;
        private Mode itemIconTintMode = null;
        private int itemId;
        private String itemListenerMethodName;
        private int itemNumericModifiers;
        private char itemNumericShortcut;
        private int itemShowAsAction;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private CharSequence itemTooltipText;
        private boolean itemVisible;
        private Menu menu;

        public MenuState(Menu menu) {
            this.menu = menu;
            resetGroup();
        }

        private char getShortcut(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = SupportMenuInflater.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                str = constructor.newInstance(objArr);
                return str;
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot instantiate class: ");
                stringBuilder.append(str);
                Log.w(SupportMenuInflater.LOG_TAG, stringBuilder.toString(), e);
                return null;
            }
        }

        private void setItem(MenuItem menuItem) {
            Object obj = null;
            menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled).setCheckable(this.itemCheckable >= 1).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
            int i = this.itemShowAsAction;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.itemListenerMethodName != null) {
                if (SupportMenuInflater.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.getRealOwner(), this.itemListenerMethodName));
            }
            boolean z = menuItem instanceof MenuItemImpl;
            if (z) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
            }
            if (this.itemCheckable >= 2) {
                if (z) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.itemActionViewClassName;
            if (str != null) {
                menuItem.setActionView((View) newInstance(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
                obj = 1;
            }
            i = this.itemActionViewLayout;
            if (i > 0) {
                if (obj == null) {
                    menuItem.setActionView(i);
                } else {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.itemActionProvider;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
            MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
            MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
            Mode mode = this.itemIconTintMode;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.itemIconTintList;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void addItem() {
            this.itemAdded = true;
            setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
        }

        public SubMenu addSubMenuItem() {
            this.itemAdded = true;
            SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
            setItem(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean hasAddedItem() {
            return this.itemAdded;
        }

        public void readGroup(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, C0222R.styleable.MenuGroup);
            this.groupId = obtainStyledAttributes.getResourceId(C0222R.styleable.MenuGroup_android_id, 0);
            this.groupCategory = obtainStyledAttributes.getInt(C0222R.styleable.MenuGroup_android_menuCategory, 0);
            this.groupOrder = obtainStyledAttributes.getInt(C0222R.styleable.MenuGroup_android_orderInCategory, 0);
            this.groupCheckable = obtainStyledAttributes.getInt(C0222R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.groupVisible = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuGroup_android_visible, true);
            this.groupEnabled = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void readItem(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, C0222R.styleable.MenuItem);
            this.itemId = obtainStyledAttributes.getResourceId(C0222R.styleable.MenuItem_android_id, 0);
            this.itemCategoryOrder = (obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_android_menuCategory, this.groupCategory) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & SupportMenu.USER_MASK);
            this.itemTitle = obtainStyledAttributes.getText(C0222R.styleable.MenuItem_android_title);
            this.itemTitleCondensed = obtainStyledAttributes.getText(C0222R.styleable.MenuItem_android_titleCondensed);
            this.itemIconResId = obtainStyledAttributes.getResourceId(C0222R.styleable.MenuItem_android_icon, 0);
            this.itemAlphabeticShortcut = getShortcut(obtainStyledAttributes.getString(C0222R.styleable.MenuItem_android_alphabeticShortcut));
            this.itemAlphabeticModifiers = obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.itemNumericShortcut = getShortcut(obtainStyledAttributes.getString(C0222R.styleable.MenuItem_android_numericShortcut));
            this.itemNumericModifiers = obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_numericModifiers, 4096);
            this.itemCheckable = obtainStyledAttributes.hasValue(C0222R.styleable.MenuItem_android_checkable) ? obtainStyledAttributes.getBoolean(C0222R.styleable.MenuItem_android_checkable, false) : this.groupCheckable;
            this.itemChecked = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuItem_android_checked, false);
            this.itemVisible = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuItem_android_visible, this.groupVisible);
            this.itemEnabled = obtainStyledAttributes.getBoolean(C0222R.styleable.MenuItem_android_enabled, this.groupEnabled);
            this.itemShowAsAction = obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_showAsAction, -1);
            this.itemListenerMethodName = obtainStyledAttributes.getString(C0222R.styleable.MenuItem_android_onClick);
            this.itemActionViewLayout = obtainStyledAttributes.getResourceId(C0222R.styleable.MenuItem_actionLayout, 0);
            this.itemActionViewClassName = obtainStyledAttributes.getString(C0222R.styleable.MenuItem_actionViewClass);
            this.itemActionProviderClassName = obtainStyledAttributes.getString(C0222R.styleable.MenuItem_actionProviderClass);
            Object obj = this.itemActionProviderClassName != null ? 1 : null;
            if (obj != null && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (obj != null) {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.itemActionProvider = null;
            }
            this.itemContentDescription = obtainStyledAttributes.getText(C0222R.styleable.MenuItem_contentDescription);
            this.itemTooltipText = obtainStyledAttributes.getText(C0222R.styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(C0222R.styleable.MenuItem_iconTintMode)) {
                this.itemIconTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0222R.styleable.MenuItem_iconTintMode, -1), this.itemIconTintMode);
            } else {
                this.itemIconTintMode = null;
            }
            if (obtainStyledAttributes.hasValue(C0222R.styleable.MenuItem_iconTint)) {
                this.itemIconTintList = obtainStyledAttributes.getColorStateList(C0222R.styleable.MenuItem_iconTint);
            } else {
                this.itemIconTintList = null;
            }
            obtainStyledAttributes.recycle();
            this.itemAdded = false;
        }

        public void resetGroup() {
            this.groupId = 0;
            this.groupCategory = 0;
            this.groupOrder = 0;
            this.groupCheckable = 0;
            this.groupVisible = true;
            this.groupEnabled = true;
        }
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        this.mActionViewConstructorArguments = new Object[]{context};
    }

    private Object findRealOwner(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            obj = findRealOwner(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    private void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            String str = XML_MENU;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals(str)) {
                    eventType = xmlPullParser.next();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expecting menu, got ");
                    stringBuilder.append(name);
                    throw new RuntimeException(stringBuilder.toString());
                }
            }
            eventType = xmlPullParser.next();
            i = eventType;
            obj = null;
            obj2 = null;
            obj3 = null;
            while (obj2 == null) {
                String str2;
                String str3;
                String name2;
                ActionProvider actionProvider;
                if (i == 1) {
                    str2 = XML_ITEM;
                    str3 = XML_GROUP;
                    if (i == 2) {
                        if (i != 3) {
                            name2 = xmlPullParser.getName();
                            if (obj3 == null && name2.equals(r8)) {
                                obj = null;
                                obj3 = null;
                            } else if (name2.equals(str3)) {
                                menuState.resetGroup();
                            } else if (name2.equals(str2)) {
                                if (name2.equals(str)) {
                                    obj2 = 1;
                                }
                            } else if (!menuState.hasAddedItem()) {
                                actionProvider = menuState.itemActionProvider;
                                if (actionProvider == null && actionProvider.hasSubMenu()) {
                                    menuState.addSubMenuItem();
                                } else {
                                    menuState.addItem();
                                }
                            }
                        }
                    } else if (obj3 != null) {
                        name2 = xmlPullParser.getName();
                        if (name2.equals(str3)) {
                            menuState.readGroup(attributeSet);
                        } else if (name2.equals(str2)) {
                            menuState.readItem(attributeSet);
                        } else if (name2.equals(str)) {
                            obj = name2;
                            obj3 = 1;
                        } else {
                            parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                        }
                    }
                    i = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Unexpected end of document");
                }
            }
        } while (eventType != 1);
        i = eventType;
        obj = null;
        obj2 = null;
        obj3 = null;
        while (obj2 == null) {
            if (i == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            str2 = XML_ITEM;
            str3 = XML_GROUP;
            if (i == 2) {
                if (obj3 != null) {
                    name2 = xmlPullParser.getName();
                    if (name2.equals(str3)) {
                        menuState.readGroup(attributeSet);
                    } else if (name2.equals(str2)) {
                        menuState.readItem(attributeSet);
                    } else if (name2.equals(str)) {
                        obj = name2;
                        obj3 = 1;
                    } else {
                        parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                    }
                }
            } else if (i != 3) {
                name2 = xmlPullParser.getName();
                if (obj3 == null) {
                }
                if (name2.equals(str3)) {
                    menuState.resetGroup();
                } else if (name2.equals(str2)) {
                    if (name2.equals(str)) {
                        obj2 = 1;
                    }
                } else if (!menuState.hasAddedItem()) {
                    actionProvider = menuState.itemActionProvider;
                    if (actionProvider == null) {
                    }
                    menuState.addItem();
                }
            }
            i = xmlPullParser.next();
        }
    }

    Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    public void inflate(int i, Menu menu) {
        String str = "Error inflating menu XML";
        if (menu instanceof SupportMenu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException(str, e);
            } catch (Throwable e2) {
                throw new InflateException(str, e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
