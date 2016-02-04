package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import java.lang.reflect.Field;
import rn;

public class TintSpinner extends Spinner {
    private static final int[] a;

    static {
        a = new int[]{16842964, 16843126};
    }

    public TintSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842881);
    }

    public TintSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rn a = rn.a(context, attributeSet, a, i, 0);
        setBackgroundDrawable(a.a(0));
        if (a.d(1)) {
            Drawable a2 = a.a(1);
            if (VERSION.SDK_INT >= 16) {
                setPopupBackgroundDrawable(a2);
            } else if (VERSION.SDK_INT >= 11) {
                a(this, a2);
            }
        }
        a.b();
    }

    @TargetApi(11)
    private static void a(Spinner spinner, Drawable drawable) {
        try {
            Field declaredField = Spinner.class.getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(spinner);
            if (obj instanceof ListPopupWindow) {
                ((ListPopupWindow) obj).setBackgroundDrawable(drawable);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
}
