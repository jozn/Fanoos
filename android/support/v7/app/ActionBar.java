package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import mx;
import nv;
import ru;
import rv;

public abstract class ActionBar {

    public class LayoutParams extends MarginLayoutParams {
        public int a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nv.ActionBarLayout);
            this.a = obtainStyledAttributes.getInt(nv.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }

    public abstract int a();

    public abstract void a(int i);

    public abstract void a(mx mxVar);

    public abstract mx b();

    public abstract void b(int i);

    public abstract void c();

    public void a(boolean z) {
    }

    public Context d() {
        return null;
    }

    public void b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
    }

    public void a(Configuration configuration) {
    }

    public void e(boolean z) {
    }

    public ru a(rv rvVar) {
        return null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public void a(CharSequence charSequence) {
    }
}
