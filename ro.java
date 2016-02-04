import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.SpinnerCompat;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ro implements qo {
    private Toolbar a;
    private int b;
    private View c;
    private SpinnerCompat d;
    private View e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private boolean i;
    private CharSequence j;
    private CharSequence k;
    private CharSequence l;
    private nx m;
    private boolean n;
    private ActionMenuPresenter o;
    private int p;
    private final rk q;
    private int r;
    private Drawable s;

    public ro(Toolbar toolbar, boolean z) {
        this(toolbar, z, nt.abc_action_bar_up_description, np.abc_ic_ab_back_mtrl_am_alpha);
    }

    public ro(Toolbar toolbar, boolean z, int i, int i2) {
        this.p = 0;
        this.r = 0;
        this.a = toolbar;
        this.j = toolbar.getTitle();
        this.k = toolbar.getSubtitle();
        this.i = this.j != null;
        if (z) {
            rn a = rn.a(toolbar.getContext(), null, nv.ActionBar, nl.actionBarStyle, 0);
            CharSequence b = a.b(nv.ActionBar_title);
            if (!TextUtils.isEmpty(b)) {
                b(b);
            }
            b = a.b(nv.ActionBar_subtitle);
            if (!TextUtils.isEmpty(b)) {
                c(b);
            }
            Drawable a2 = a.a(nv.ActionBar_logo);
            if (a2 != null) {
                c(a2);
            }
            a2 = a.a(nv.ActionBar_icon);
            if (a2 != null) {
                a(a2);
            }
            a2 = a.a(nv.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                d(a2);
            }
            c(a.a(nv.ActionBar_displayOptions, 0));
            int f = a.f(nv.ActionBar_customNavigationLayout, 0);
            if (f != 0) {
                a(LayoutInflater.from(this.a.getContext()).inflate(f, this.a, false));
                c(this.b | 16);
            }
            f = a.e(nv.ActionBar_height, 0);
            if (f > 0) {
                LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = f;
                this.a.setLayoutParams(layoutParams);
            }
            f = a.c(nv.ActionBar_contentInsetStart, -1);
            int c = a.c(nv.ActionBar_contentInsetEnd, -1);
            if (f >= 0 || c >= 0) {
                this.a.a(Math.max(f, 0), Math.max(c, 0));
            }
            f = a.f(nv.ActionBar_titleTextStyle, 0);
            if (f != 0) {
                this.a.a(this.a.getContext(), f);
            }
            f = a.f(nv.ActionBar_subtitleTextStyle, 0);
            if (f != 0) {
                this.a.b(this.a.getContext(), f);
            }
            int f2 = a.f(nv.ActionBar_popupTheme, 0);
            if (f2 != 0) {
                this.a.setPopupTheme(f2);
            }
            a.b();
            this.q = a.c();
        } else {
            this.b = s();
            this.q = new rk(toolbar.getContext());
        }
        g(i);
        this.l = this.a.getNavigationContentDescription();
        b(this.q.a(i2));
        this.a.setNavigationOnClickListener(new rp(this));
    }

    public void g(int i) {
        if (i != this.r) {
            this.r = i;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                h(this.r);
            }
        }
    }

    public void b(Drawable drawable) {
        if (this.s != drawable) {
            this.s = drawable;
            w();
        }
    }

    private int s() {
        if (this.a.getNavigationIcon() != null) {
            return 15;
        }
        return 11;
    }

    public ViewGroup a() {
        return this.a;
    }

    public Context b() {
        return this.a.getContext();
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return this.a.g();
    }

    public void e() {
        this.a.h();
    }

    public void a(nx nxVar) {
        this.m = nxVar;
    }

    public void a(CharSequence charSequence) {
        if (!this.i) {
            e(charSequence);
        }
    }

    public CharSequence f() {
        return this.a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.i = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.k = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void h() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void a(int i) {
        a(i != 0 ? this.q.a(i) : null);
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        t();
    }

    public void b(int i) {
        c(i != 0 ? this.q.a(i) : null);
    }

    public void c(Drawable drawable) {
        this.g = drawable;
        t();
    }

    private void t() {
        Drawable drawable = null;
        if ((this.b & 2) != 0) {
            drawable = (this.b & 1) != 0 ? this.g != null ? this.g : this.f : this.f;
        }
        this.a.setLogo(drawable);
    }

    public boolean i() {
        return this.a.a();
    }

    public boolean j() {
        return this.a.b();
    }

    public boolean k() {
        return this.a.c();
    }

    public boolean l() {
        return this.a.d();
    }

    public boolean m() {
        return this.a.e();
    }

    public void n() {
        this.n = true;
    }

    public void a(Menu menu, pn pnVar) {
        if (this.o == null) {
            this.o = new ActionMenuPresenter(this.a.getContext());
            this.o.a(nq.action_menu_presenter);
        }
        this.o.a(pnVar);
        this.a.a((ox) menu, this.o);
    }

    public void o() {
        this.a.f();
    }

    public int p() {
        return this.b;
    }

    public void c(int i) {
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    w();
                    v();
                } else {
                    this.a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.j);
                    this.a.setSubtitle(this.k);
                } else {
                    this.a.setTitle(null);
                    this.a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.e != null) {
                if ((i & 16) != 0) {
                    this.a.addView(this.e);
                } else {
                    this.a.removeView(this.e);
                }
            }
        }
    }

    public void a(qv qvVar) {
        if (this.c != null && this.c.getParent() == this.a) {
            this.a.removeView(this.c);
        }
        this.c = qvVar;
        if (qvVar != null && this.p == 2) {
            this.a.addView(this.c, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.a = 8388691;
            qvVar.setAllowCollapse(true);
        }
    }

    public void a(boolean z) {
        this.a.setCollapsible(z);
    }

    public void b(boolean z) {
    }

    public int q() {
        return this.p;
    }

    public void d(int i) {
        int i2 = this.p;
        if (i != i2) {
            switch (i2) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    if (this.d != null && this.d.getParent() == this.a) {
                        this.a.removeView(this.d);
                        break;
                    }
                case ve.CropImageView_aspectRatioX /*2*/:
                    if (this.c != null && this.c.getParent() == this.a) {
                        this.a.removeView(this.c);
                        break;
                    }
            }
            this.p = i;
            switch (i) {
                case ve.CropImageView_guidelines /*0*/:
                case ve.CropImageView_fixAspectRatio /*1*/:
                    u();
                    this.a.addView(this.d, 0);
                case ve.CropImageView_aspectRatioX /*2*/:
                    if (this.c != null) {
                        this.a.addView(this.c, 0);
                        Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.c.getLayoutParams();
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        layoutParams.a = 8388691;
                    }
                default:
                    throw new IllegalArgumentException("Invalid navigation mode " + i);
            }
        }
    }

    private void u() {
        if (this.d == null) {
            this.d = new SpinnerCompat(b(), null, nl.actionDropDownStyle);
            this.d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    public void e(int i) {
        if (this.d == null) {
            throw new IllegalStateException("Can't set dropdown selected position without an adapter");
        }
        this.d.setSelection(i);
    }

    public int r() {
        return this.d != null ? this.d.getSelectedItemPosition() : 0;
    }

    public void a(View view) {
        if (!(this.e == null || (this.b & 16) == 0)) {
            this.a.removeView(this.e);
        }
        this.e = view;
        if (view != null && (this.b & 16) != 0) {
            this.a.addView(this.e);
        }
    }

    public void f(int i) {
        if (i == 8) {
            hg.m(this.a).a(0.0f).a(new rq(this));
        } else if (i == 0) {
            hg.m(this.a).a(1.0f).a(new rr(this));
        }
    }

    public void d(Drawable drawable) {
        this.h = drawable;
        w();
    }

    public void d(CharSequence charSequence) {
        this.l = charSequence;
        v();
    }

    public void h(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void v() {
        if ((this.b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.l)) {
            this.a.setNavigationContentDescription(this.r);
        } else {
            this.a.setNavigationContentDescription(this.l);
        }
    }

    private void w() {
        if ((this.b & 4) != 0) {
            this.a.setNavigationIcon(this.h != null ? this.h : this.s);
        }
    }
}
