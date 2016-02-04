package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import rk;
import rn;

public class TintCheckBox extends CheckBox {
    private static final int[] a;
    private final rk b;

    static {
        a = new int[]{16843015};
    }

    public TintCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842860);
    }

    public TintCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, a, i, 0);
        setButtonDrawable(a.a(0));
        a.b();
        this.b = a.c();
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.b.a(i));
    }
}
