package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.mClient.convertToString((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Object runQueryOnBackgroundThread = this.mClient.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
        } else {
            filterResults.count = 0;
            runQueryOnBackgroundThread = null;
        }
        filterResults.values = runQueryOnBackgroundThread;
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.mClient.getCursor();
        Cursor cursor2 = filterResults.values;
        if (cursor2 != null && cursor2 != cursor) {
            this.mClient.changeCursor(cursor2);
        }
    }
}
