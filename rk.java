import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class rk {
    static final Mode a;
    private static final String b;
    private static final rl c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private final Context i;
    private final Resources j;
    private final TypedValue k;
    private ColorStateList l;
    private ColorStateList m;
    private ColorStateList n;

    static {
        b = rk.class.getSimpleName();
        a = Mode.SRC_IN;
        c = new rl(6);
        d = new int[]{np.abc_ic_ab_back_mtrl_am_alpha, np.abc_ic_go_search_api_mtrl_alpha, np.abc_ic_search_api_mtrl_alpha, np.abc_ic_commit_search_api_mtrl_alpha, np.abc_ic_clear_mtrl_alpha, np.abc_ic_menu_share_mtrl_alpha, np.abc_ic_menu_copy_mtrl_am_alpha, np.abc_ic_menu_cut_mtrl_alpha, np.abc_ic_menu_selectall_mtrl_alpha, np.abc_ic_menu_paste_mtrl_am_alpha, np.abc_ic_menu_moreoverflow_mtrl_alpha, np.abc_ic_voice_search_api_mtrl_alpha, np.abc_textfield_search_default_mtrl_alpha, np.abc_textfield_default_mtrl_alpha};
        e = new int[]{np.abc_textfield_activated_mtrl_alpha, np.abc_textfield_search_activated_mtrl_alpha, np.abc_cab_background_top_mtrl_alpha};
        f = new int[]{np.abc_popup_background_mtrl_mult, np.abc_cab_background_internal_bg, np.abc_menu_hardkey_panel_mtrl_mult};
        g = new int[]{np.abc_edit_text_material, np.abc_tab_indicator_material, np.abc_textfield_search_material, np.abc_spinner_mtrl_am_alpha, np.abc_btn_check_material, np.abc_btn_radio_material};
        h = new int[]{np.abc_cab_background_top_material};
    }

    public static Drawable a(Context context, int i) {
        if (d(i)) {
            return new rk(context).a(i);
        }
        return da.a(context, i);
    }

    public rk(Context context) {
        this.i = context;
        this.j = new rm(context.getResources(), this);
        this.k = new TypedValue();
    }

    public Drawable a(int i) {
        Drawable a = da.a(this.i, i);
        if (a != null) {
            if (a(g, i)) {
                return new rj(a, a());
            }
            if (i == np.abc_switch_track_mtrl_alpha) {
                return new rj(a, b());
            }
            if (i == np.abc_switch_thumb_material) {
                return new rj(a, c(), Mode.MULTIPLY);
            }
            if (a(h, i)) {
                return this.j.getDrawable(i);
            }
            a(i, a);
        }
        return a;
    }

    void a(int i, Drawable drawable) {
        int i2;
        Mode mode;
        Object obj;
        int i3;
        int i4;
        if (a(d, i)) {
            i2 = nl.colorControlNormal;
            mode = null;
            obj = 1;
            i3 = -1;
        } else if (a(e, i)) {
            i2 = nl.colorControlActivated;
            mode = null;
            i4 = 1;
            i3 = -1;
        } else if (a(f, i)) {
            i4 = 1;
            i3 = -1;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
        } else if (i == np.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            mode = null;
            i4 = 1;
            i3 = Math.round(40.8f);
        } else {
            i3 = -1;
            i2 = 0;
            mode = null;
            obj = null;
        }
        if (obj != null) {
            ColorFilter colorFilter;
            if (mode == null) {
                mode = a;
            }
            i4 = b(i2);
            ColorFilter a = c.a(i4, mode);
            if (a == null) {
                a = new PorterDuffColorFilter(i4, mode);
                c.a(i4, mode, a);
                colorFilter = a;
            } else {
                colorFilter = a;
            }
            drawable.setColorFilter(colorFilter);
            if (i3 != -1) {
                drawable.setAlpha(i3);
            }
        }
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(int i) {
        return a(f, i) || a(d, i) || a(e, i) || a(g, i) || a(h, i);
    }

    private ColorStateList a() {
        if (this.l == null) {
            int b = b(nl.colorControlNormal);
            int b2 = b(nl.colorControlActivated);
            r2 = new int[7][];
            r3 = new int[7];
            r2[0] = new int[]{-16842910};
            r3[0] = c(nl.colorControlNormal);
            r2[1] = new int[]{16842908};
            r3[1] = b2;
            r2[2] = new int[]{16843518};
            r3[2] = b2;
            r2[3] = new int[]{16842919};
            r3[3] = b2;
            r2[4] = new int[]{16842912};
            r3[4] = b2;
            r2[5] = new int[]{16842913};
            r3[5] = b2;
            r2[6] = new int[0];
            r3[6] = b;
            this.l = new ColorStateList(r2, r3);
        }
        return this.l;
    }

    private ColorStateList b() {
        if (this.n == null) {
            r0 = new int[3][];
            r1 = new int[3];
            r0[0] = new int[]{-16842910};
            r1[0] = a(16842800, 0.1f);
            r0[1] = new int[]{16842912};
            r1[1] = a(nl.colorControlActivated, 0.3f);
            r0[2] = new int[0];
            r1[2] = a(16842800, 0.3f);
            this.n = new ColorStateList(r0, r1);
        }
        return this.n;
    }

    private ColorStateList c() {
        if (this.m == null) {
            r0 = new int[3][];
            r1 = new int[3];
            r0[0] = new int[]{-16842910};
            r1[0] = c(nl.colorSwitchThumbNormal);
            r0[1] = new int[]{16842912};
            r1[1] = b(nl.colorControlActivated);
            r0[2] = new int[0];
            r1[2] = b(nl.colorSwitchThumbNormal);
            this.m = new ColorStateList(r0, r1);
        }
        return this.m;
    }

    int b(int i) {
        if (this.i.getTheme().resolveAttribute(i, this.k, true)) {
            if (this.k.type >= 16 && this.k.type <= 31) {
                return this.k.data;
            }
            if (this.k.type == 3) {
                return this.j.getColor(this.k.resourceId);
            }
        }
        return 0;
    }

    int a(int i, float f) {
        int b = b(i);
        return (b & 16777215) | (Math.round(((float) Color.alpha(b)) * f) << 24);
    }

    int c(int i) {
        this.i.getTheme().resolveAttribute(16842803, this.k, true);
        return a(i, this.k.getFloat());
    }
}
