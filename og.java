import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class og {
    private Context a;

    public static og a(Context context) {
        return new og(context);
    }

    private og(Context context) {
        this.a = context;
    }

    public int a() {
        return this.a.getResources().getInteger(nr.abc_max_action_buttons);
    }

    public boolean b() {
        if (VERSION.SDK_INT < 19 && hz.b(ViewConfiguration.get(this.a))) {
            return false;
        }
        return true;
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d() {
        if (this.a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.a.getResources().getBoolean(nm.abc_action_bar_embed_tabs);
        }
        return this.a.getResources().getBoolean(nm.abc_action_bar_embed_tabs_pre_jb);
    }

    public int e() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, nv.ActionBar, nl.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(nv.ActionBar_height, 0);
        Resources resources = this.a.getResources();
        if (!d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(no.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean f() {
        return this.a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g() {
        return this.a.getResources().getDimensionPixelSize(no.abc_action_bar_stacked_tab_max_width);
    }
}
