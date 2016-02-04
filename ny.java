import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

public class ny extends ActionBar implements qf {
    static final /* synthetic */ boolean h;
    private static final boolean i;
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private on H;
    private boolean I;
    oc a;
    ru b;
    rv c;
    boolean d;
    final jk e;
    final jk f;
    final jm g;
    private Context j;
    private Context k;
    private FragmentActivity l;
    private ActionBarOverlayLayout m;
    private ActionBarContainer n;
    private qo o;
    private ActionBarContextView p;
    private ActionBarContainer q;
    private View r;
    private qv s;
    private ArrayList t;
    private od u;
    private int v;
    private boolean w;
    private boolean x;
    private ArrayList y;
    private int z;

    static {
        boolean z = true;
        h = !ny.class.desiredAssertionStatus();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        i = z;
    }

    public ny(ActionBarActivity actionBarActivity, boolean z) {
        this.t = new ArrayList();
        this.v = -1;
        this.y = new ArrayList();
        this.B = 0;
        this.C = true;
        this.G = true;
        this.e = new nz(this);
        this.f = new oa(this);
        this.g = new ob(this);
        this.l = actionBarActivity;
        View decorView = actionBarActivity.getWindow().getDecorView();
        a(decorView);
        if (!z) {
            this.r = decorView.findViewById(16908290);
        }
    }

    private void a(View view) {
        this.m = (ActionBarOverlayLayout) view.findViewById(nq.decor_content_parent);
        if (this.m != null) {
            this.m.setActionBarVisibilityCallback(this);
        }
        this.o = b(view.findViewById(nq.action_bar));
        this.p = (ActionBarContextView) view.findViewById(nq.action_context_bar);
        this.n = (ActionBarContainer) view.findViewById(nq.action_bar_container);
        this.q = (ActionBarContainer) view.findViewById(nq.split_action_bar);
        if (this.o == null || this.p == null || this.n == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        boolean z;
        this.j = this.o.b();
        this.z = this.o.c() ? 1 : 0;
        if ((this.o.p() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.w = true;
        }
        og a = og.a(this.j);
        if (a.f() || z) {
            z = true;
        } else {
            z = false;
        }
        a(z);
        k(a.d());
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(null, nv.ActionBar, nl.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(nv.ActionBar_hideOnContentScroll, false)) {
            b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(nv.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private qo b(View view) {
        if (view instanceof qo) {
            return (qo) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void a(float f) {
        hg.e(this.n, f);
        if (this.q != null) {
            hg.e(this.q, f);
        }
    }

    public void a(Configuration configuration) {
        k(og.a(this.j).d());
    }

    private void k(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.A = z;
        if (this.A) {
            this.n.setTabContainer(null);
            this.o.a(this.s);
        } else {
            this.o.a(null);
            this.n.setTabContainer(this.s);
        }
        if (h() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.s != null) {
            if (z2) {
                this.s.setVisibility(0);
                if (this.m != null) {
                    hg.o(this.m);
                }
            } else {
                this.s.setVisibility(8);
            }
        }
        qo qoVar = this.o;
        if (this.A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        qoVar.a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.m;
        if (this.A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    private void n() {
        if (this.s == null) {
            qv qvVar = new qv(this.j);
            if (this.A) {
                qvVar.setVisibility(0);
                this.o.a(qvVar);
            } else {
                if (h() == 2) {
                    qvVar.setVisibility(0);
                    if (this.m != null) {
                        hg.o(this.m);
                    }
                } else {
                    qvVar.setVisibility(8);
                }
                this.n.setTabContainer(qvVar);
            }
            this.s = qvVar;
        }
    }

    void g() {
        if (this.c != null) {
            this.c.a(this.b);
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        this.B = i;
    }

    public void d(boolean z) {
        this.I = z;
        if (!z && this.H != null) {
            this.H.b();
        }
    }

    public void e(boolean z) {
        if (z != this.x) {
            this.x = z;
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                ((mw) this.y.get(i)).a(z);
            }
        }
    }

    public void f(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public void a(boolean z) {
        this.o.b(z);
    }

    public void a(int i) {
        switch (this.o.q()) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.o.e(i);
            case ve.CropImageView_aspectRatioX /*2*/:
                b((mx) this.t.get(i));
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void a(CharSequence charSequence) {
        this.o.a(charSequence);
    }

    public void a(int i, int i2) {
        int p = this.o.p();
        if ((i2 & 4) != 0) {
            this.w = true;
        }
        this.o.c((p & (i2 ^ -1)) | (i & i2));
    }

    public int h() {
        return this.o.q();
    }

    public int a() {
        return this.o.p();
    }

    public ru a(rv rvVar) {
        if (this.a != null) {
            this.a.c();
        }
        this.m.setHideOnContentScrollEnabled(false);
        this.p.c();
        ru ocVar = new oc(this, rvVar);
        if (!ocVar.e()) {
            return null;
        }
        ocVar.d();
        this.p.a(ocVar);
        j(true);
        if (!(this.q == null || this.z != 1 || this.q.getVisibility() == 0)) {
            this.q.setVisibility(0);
            if (this.m != null) {
                hg.o(this.m);
            }
        }
        this.p.sendAccessibilityEvent(32);
        this.a = ocVar;
        return ocVar;
    }

    private void a(mx mxVar, int i) {
        od odVar = (od) mxVar;
        if (odVar.g() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        odVar.a(i);
        this.t.add(i, odVar);
        int size = this.t.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((od) this.t.get(i2)).a(i2);
        }
    }

    public void a(mx mxVar) {
        a(mxVar, this.t.isEmpty());
    }

    public void a(mx mxVar, boolean z) {
        n();
        this.s.a(mxVar, z);
        a(mxVar, this.t.size());
        if (z) {
            b(mxVar);
        }
    }

    public mx b() {
        return new od(this);
    }

    public void b(mx mxVar) {
        int i = -1;
        if (h() != 2) {
            if (mxVar != null) {
                i = mxVar.a();
            }
            this.v = i;
            return;
        }
        ag a = this.o.a().isInEditMode() ? null : this.l.f().a().a();
        if (this.u != mxVar) {
            qv qvVar = this.s;
            if (mxVar != null) {
                i = mxVar.a();
            }
            qvVar.setTabSelected(i);
            if (this.u != null) {
                this.u.g().b(this.u, a);
            }
            this.u = (od) mxVar;
            if (this.u != null) {
                this.u.g().a(this.u, a);
            }
        } else if (this.u != null) {
            this.u.g().c(this.u, a);
            this.s.a(mxVar.a());
        }
        if (a != null && !a.e()) {
            a.b();
        }
    }

    public void g(boolean z) {
        this.C = z;
    }

    private void o() {
        if (!this.F) {
            this.F = true;
            if (this.m != null) {
                this.m.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    public void i() {
        if (this.E) {
            this.E = false;
            l(true);
        }
    }

    public void c() {
        if (!this.D) {
            this.D = true;
            l(false);
        }
    }

    private void p() {
        if (this.F) {
            this.F = false;
            if (this.m != null) {
                this.m.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    public void j() {
        if (!this.E) {
            this.E = true;
            l(true);
        }
    }

    public void b(boolean z) {
        if (!z || this.m.a()) {
            this.d = z;
            this.m.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private static boolean b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void l(boolean z) {
        if (b(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                h(z);
            }
        } else if (this.G) {
            this.G = false;
            i(z);
        }
    }

    public void h(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        this.n.setVisibility(0);
        if (this.B == 0 && i && (this.I || z)) {
            hg.b(this.n, 0.0f);
            float f = (float) (-this.n.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.n.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            hg.b(this.n, f);
            on onVar = new on();
            iu c = hg.m(this.n).c(0.0f);
            c.a(this.g);
            onVar.a(c);
            if (this.C && this.r != null) {
                hg.b(this.r, f);
                onVar.a(hg.m(this.r).c(0.0f));
            }
            if (this.q != null && this.z == 1) {
                hg.b(this.q, (float) this.q.getHeight());
                this.q.setVisibility(0);
                onVar.a(hg.m(this.q).c(0.0f));
            }
            onVar.a(AnimationUtils.loadInterpolator(this.j, 17432582));
            onVar.a(250);
            onVar.a(this.f);
            this.H = onVar;
            onVar.a();
        } else {
            hg.c(this.n, 1.0f);
            hg.b(this.n, 0.0f);
            if (this.C && this.r != null) {
                hg.b(this.r, 0.0f);
            }
            if (this.q != null && this.z == 1) {
                hg.c(this.q, 1.0f);
                hg.b(this.q, 0.0f);
                this.q.setVisibility(0);
            }
            this.f.b(null);
        }
        if (this.m != null) {
            hg.o(this.m);
        }
    }

    public void i(boolean z) {
        if (this.H != null) {
            this.H.b();
        }
        if (this.B == 0 && i && (this.I || z)) {
            hg.c(this.n, 1.0f);
            this.n.setTransitioning(true);
            on onVar = new on();
            float f = (float) (-this.n.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.n.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            iu c = hg.m(this.n).c(f);
            c.a(this.g);
            onVar.a(c);
            if (this.C && this.r != null) {
                onVar.a(hg.m(this.r).c(f));
            }
            if (this.q != null && this.q.getVisibility() == 0) {
                hg.c(this.q, 1.0f);
                onVar.a(hg.m(this.q).c((float) this.q.getHeight()));
            }
            onVar.a(AnimationUtils.loadInterpolator(this.j, 17432581));
            onVar.a(250);
            onVar.a(this.e);
            this.H = onVar;
            onVar.a();
            return;
        }
        this.e.b(null);
    }

    public void j(boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            o();
        } else {
            p();
        }
        qo qoVar = this.o;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        qoVar.f(i);
        ActionBarContextView actionBarContextView = this.p;
        if (!z) {
            i2 = 8;
        }
        actionBarContextView.a(i2);
    }

    public Context d() {
        if (this.k == null) {
            TypedValue typedValue = new TypedValue();
            this.j.getTheme().resolveAttribute(nl.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.k = new ContextThemeWrapper(this.j, i);
            } else {
                this.k = this.j;
            }
        }
        return this.k;
    }

    public void k() {
        if (this.H != null) {
            this.H.b();
            this.H = null;
        }
    }

    public void l() {
    }

    public boolean f() {
        if (this.o == null || !this.o.d()) {
            return false;
        }
        this.o.e();
        return true;
    }

    public int m() {
        switch (this.o.q()) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return this.o.r();
            case ve.CropImageView_aspectRatioX /*2*/:
                if (this.u != null) {
                    return this.u.a();
                }
                return -1;
            default:
                return -1;
        }
    }

    public void b(int i) {
        boolean z;
        boolean z2 = true;
        int q = this.o.q();
        switch (q) {
            case ve.CropImageView_aspectRatioX /*2*/:
                this.v = m();
                b(null);
                this.s.setVisibility(8);
                break;
        }
        if (!(q == i || this.A || this.m == null)) {
            hg.o(this.m);
        }
        this.o.d(i);
        switch (i) {
            case ve.CropImageView_aspectRatioX /*2*/:
                n();
                this.s.setVisibility(0);
                if (this.v != -1) {
                    a(this.v);
                    this.v = -1;
                    break;
                }
                break;
        }
        qo qoVar = this.o;
        if (i != 2 || this.A) {
            z = false;
        } else {
            z = true;
        }
        qoVar.a(z);
        ActionBarOverlayLayout actionBarOverlayLayout = this.m;
        if (i != 2 || this.A) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    public void c(boolean z) {
        if (!this.w) {
            f(z);
        }
    }
}
