package android.support.v7.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import ox;
import oz;
import pb;
import po;
import rn;

public final class ExpandedMenuView extends ListView implements OnItemClickListener, oz, po {
    private static final int[] a;
    private ox b;
    private int c;

    static {
        a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        rn a = rn.a(context, attributeSet, a, i, 0);
        if (a.d(0)) {
            setBackgroundDrawable(a.a(0));
        }
        if (a.d(1)) {
            setDivider(a.a(1));
        }
        a.b();
    }

    public void a(ox oxVar) {
        this.b = oxVar;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean a(pb pbVar) {
        return this.b.a((MenuItem) pbVar, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((pb) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.c;
    }
}
