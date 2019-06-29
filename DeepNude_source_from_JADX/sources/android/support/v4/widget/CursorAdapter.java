package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilterClient {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected ChangeObserver mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected CursorFilter mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter.this.onContentChanged();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        public void onChanged() {
            BaseAdapter baseAdapter = CursorAdapter.this;
            baseAdapter.mDataValid = true;
            baseAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            BaseAdapter baseAdapter = CursorAdapter.this;
            baseAdapter.mDataValid = false;
            baseAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        init(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        init(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        cursor = swapCursor(cursor);
        if (cursor != null) {
            cursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                return cursor.getCount();
            }
        }
        return 0;
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int i) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null) {
                cursor.moveToPosition(i);
                return this.mCursor;
            }
        }
        return null;
    }

    public long getItemId(int i) {
        if (this.mDataValid) {
            Cursor cursor = this.mCursor;
            if (cursor != null && cursor.moveToPosition(i)) {
                return this.mCursor.getLong(this.mRowIDColumn);
            }
        }
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("couldn't move cursor to position ");
            stringBuilder.append(i);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    void init(Context context, Cursor cursor, int i) {
        DataSetObserver myDataSetObserver;
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.mChangeObserver = new ChangeObserver();
            myDataSetObserver = new MyDataSetObserver();
        } else {
            myDataSetObserver = null;
            this.mChangeObserver = null;
        }
        this.mDataSetObserver = myDataSetObserver;
        if (z) {
            ContentObserver contentObserver = this.mChangeObserver;
            if (contentObserver != null) {
                cursor.registerContentObserver(contentObserver);
            }
            myDataSetObserver = this.mDataSetObserver;
            if (myDataSetObserver != null) {
                cursor.registerDataSetObserver(myDataSetObserver);
            }
        }
    }

    @Deprecated
    protected void init(Context context, Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void onContentChanged() {
        if (this.mAutoRequery) {
            Cursor cursor = this.mCursor;
            if (cursor != null && !cursor.isClosed()) {
                this.mDataValid = this.mCursor.requery();
            }
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        ContentObserver contentObserver;
        DataSetObserver dataSetObserver;
        if (cursor2 != null) {
            contentObserver = this.mChangeObserver;
            if (contentObserver != null) {
                cursor2.unregisterContentObserver(contentObserver);
            }
            dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            contentObserver = this.mChangeObserver;
            if (contentObserver != null) {
                cursor.registerContentObserver(contentObserver);
            }
            dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
