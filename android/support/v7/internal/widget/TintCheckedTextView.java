package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import rk;
import rn;

public class TintCheckedTextView extends CheckedTextView {
    private static final int[] a;
    private final rk b;

    static {
        a = new int[]{16843016};
    }

    public TintCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public TintCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, a, i, 0);
        setCheckMarkDrawable(a.a(0));
        a.b();
        this.b = a.c();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(this.b.a(i));
    }
}
