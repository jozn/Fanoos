package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import rk;
import rn;

public class TintImageView extends ImageView {
    private static final int[] a;
    private final rk b;

    static {
        a = new int[]{16842964, 16843033};
    }

    public TintImageView(Context context) {
        this(context, null);
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, a, i, 0);
        if (a.a() > 0) {
            if (a.d(0)) {
                setBackgroundDrawable(a.a(0));
            }
            if (a.d(1)) {
                setImageDrawable(a.a(1));
            }
        }
        a.b();
        this.b = a.c();
    }

    public void setImageResource(int i) {
        setImageDrawable(this.b.a(i));
    }
}
