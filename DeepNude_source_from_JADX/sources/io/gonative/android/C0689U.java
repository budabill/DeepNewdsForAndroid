package io.gonative.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import io.gonative.android.p038a.C0700a;
import java.util.List;

/* renamed from: io.gonative.android.U */
class C0689U extends ArrayAdapter<String> {
    /* renamed from: a */
    final /* synthetic */ C0691V f1472a;

    C0689U(C0691V c0691v, Context context, int i, List list) {
        this.f1472a = c0691v;
        super(context, i, list);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
        textView.setTextColor(C0700a.m1851a(this.f1472a.f1475b).ca.intValue());
        return textView;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        textView.setTextColor(C0700a.m1851a(this.f1472a.f1475b).ca.intValue());
        return textView;
    }
}
