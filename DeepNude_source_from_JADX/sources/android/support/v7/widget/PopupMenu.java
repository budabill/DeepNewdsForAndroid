package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.C0222R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;

public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    /* renamed from: android.support.v7.widget.PopupMenu$2 */
    class C02482 implements android.widget.PopupWindow.OnDismissListener {
        C02482() {
        }

        public void onDismiss() {
            PopupMenu popupMenu = PopupMenu.this;
            OnDismissListener onDismissListener = popupMenu.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(popupMenu);
            }
        }
    }

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.PopupMenu$1 */
    class C07951 implements Callback {
        C07951() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = PopupMenu.this.mMenuItemClickListener;
            return onMenuItemClickListener != null ? onMenuItemClickListener.onMenuItemClick(menuItem) : false;
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, C0222R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.mAnchor = view;
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(new C07951());
        this.mPopup = new MenuPopupHelper(context, this.mMenu, view, false, i2, i3);
        this.mPopup.setGravity(i);
        this.mPopup.setOnDismissListener(new C02482());
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ForwardingListener(this.mAnchor) {
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.mPopup.getPopup();
                }

                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    ListView getMenuListView() {
        return !this.mPopup.isShowing() ? null : this.mPopup.getListView();
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void setGravity(int i) {
        this.mPopup.setGravity(i);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
