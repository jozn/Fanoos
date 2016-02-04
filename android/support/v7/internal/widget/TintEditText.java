package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import rn;

public class TintEditText extends EditText {
    private static final int[] a;

    static {
        a = new int[]{16842964};
    }

    public TintEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public TintEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, a, i, 0);
        setBackgroundDrawable(a.a(0));
        a.b();
    }
}
