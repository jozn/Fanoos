package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import nv;
import oe;

public class CompatTextView extends TextView {
    public CompatTextView(Context context) {
        this(context, null);
    }

    public CompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nv.CompatTextView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(nv.CompatTextView_textAllCaps, false);
        obtainStyledAttributes.recycle();
        if (z) {
            setTransformationMethod(new oe(context));
        }
    }
}
