package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import au;
import hg;
import hz;
import mz;
import nb;
import nc;
import nd;
import ne;
import nf;
import ng;
import nh;
import ni;
import nl;
import nn;
import nq;
import ns;
import nu;
import nv;
import nx;
import ny;
import oh;
import ov;
import ox;
import oy;
import pn;
import po;
import qn;
import qq;
import rt;
import ru;
import rv;
import ve;

public class ActionBarActivityDelegateBase extends mz implements oy {
    private boolean A;
    private ov B;
    private Rect C;
    private Rect D;
    public ru g;
    public ActionBarContextView h;
    public PopupWindow i;
    public Runnable j;
    private qn k;
    private nf l;
    private ni m;
    private boolean n;
    private ViewGroup o;
    private ViewGroup p;
    private View q;
    private CharSequence r;
    private boolean s;
    private boolean t;
    private boolean u;
    private PanelFeatureState[] v;
    private PanelFeatureState w;
    private boolean x;
    private int y;
    private final Runnable z;

    public final class PanelFeatureState {
        public int a;
        ViewGroup b;
        View c;
        ox d;
        ov e;
        Context f;
        boolean g;
        boolean h;
        boolean i;
        public boolean j;
        boolean k;
        boolean l;
        Bundle m;

        public class SavedState implements Parcelable {
            public static final Creator CREATOR;
            int a;
            boolean b;
            Bundle c;

            private SavedState() {
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b ? 1 : 0);
                if (this.b) {
                    parcel.writeBundle(this.c);
                }
            }

            private static SavedState b(Parcel parcel) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.b = z;
                if (savedState.b) {
                    savedState.c = parcel.readBundle();
                }
                return savedState;
            }

            static {
                CREATOR = new nh();
            }
        }

        PanelFeatureState(int i) {
            this.a = i;
            this.k = false;
        }

        public boolean a() {
            if (this.c != null && this.e.a().getCount() > 0) {
                return true;
            }
            return false;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(nl.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(nl.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(nu.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f = contextThemeWrapper;
        }

        void a(ox oxVar) {
            if (oxVar != this.d) {
                if (this.d != null) {
                    this.d.b(this.e);
                }
                this.d = oxVar;
                if (oxVar != null && this.e != null) {
                    oxVar.a(this.e);
                }
            }
        }

        po a(pn pnVar) {
            if (this.d == null) {
                return null;
            }
            if (this.e == null) {
                this.e = new ov(this.f, ns.abc_list_menu_item_layout);
                this.e.a(pnVar);
                this.d.a(this.e);
            }
            return this.e.a(this.b);
        }
    }

    public ActionBarActivityDelegateBase(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.z = new nb(this);
    }

    void a(Bundle bundle) {
        super.a(bundle);
        this.o = (ViewGroup) this.a.getWindow().getDecorView();
        if (au.b(this.a) != null) {
            ActionBar c = c();
            if (c == null) {
                this.A = true;
            } else {
                c.c(true);
            }
        }
    }

    public ActionBar a() {
        n();
        ActionBar nyVar = new ny(this.a, this.c);
        nyVar.c(this.A);
        return nyVar;
    }

    public void a(Configuration configuration) {
        if (this.b && this.n) {
            ActionBar b = b();
            if (b != null) {
                b.a(configuration);
            }
        }
    }

    public void e() {
        ActionBar b = b();
        if (b != null) {
            b.d(false);
        }
    }

    public void f() {
        ActionBar b = b();
        if (b != null) {
            b.d(true);
        }
    }

    public void a(View view) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.a.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.a.i();
    }

    public void a(int i) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.a.findViewById(16908290);
        viewGroup.removeAllViews();
        this.a.getLayoutInflater().inflate(i, viewGroup);
        this.a.i();
    }

    public void a(View view, LayoutParams layoutParams) {
        n();
        ViewGroup viewGroup = (ViewGroup) this.a.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.a.i();
    }

    public void b(View view, LayoutParams layoutParams) {
        n();
        ((ViewGroup) this.a.findViewById(16908290)).addView(view, layoutParams);
        this.a.i();
    }

    public void i() {
    }

    final void n() {
        if (!this.n) {
            if (this.b) {
                Context contextThemeWrapper;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(nl.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    contextThemeWrapper = new ContextThemeWrapper(this.a, typedValue.resourceId);
                } else {
                    contextThemeWrapper = this.a;
                }
                this.p = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(ns.abc_screen_toolbar, null);
                this.k = (qn) this.p.findViewById(nq.decor_content_parent);
                this.k.setWindowCallback(k());
                if (this.c) {
                    this.k.a(9);
                }
                if (this.s) {
                    this.k.a(2);
                }
                if (this.t) {
                    this.k.a(5);
                }
            } else {
                if (this.d) {
                    this.p = (ViewGroup) LayoutInflater.from(this.a).inflate(ns.abc_screen_simple_overlay_action_mode, null);
                } else {
                    this.p = (ViewGroup) LayoutInflater.from(this.a).inflate(ns.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    hg.a(this.p, new nc(this));
                } else {
                    ((qq) this.p).setOnFitSystemWindowsListener(new nd(this));
                }
            }
            rt.b(this.p);
            this.a.a(this.p);
            View findViewById = this.a.findViewById(16908290);
            findViewById.setId(-1);
            this.a.findViewById(nq.action_bar_activity_content).setId(16908290);
            if (findViewById instanceof FrameLayout) {
                ((FrameLayout) findViewById).setForeground(null);
            }
            if (!(this.r == null || this.k == null)) {
                this.k.setWindowTitle(this.r);
                this.r = null;
            }
            p();
            o();
            this.n = true;
            PanelFeatureState a = a(0, false);
            if (!m()) {
                if (a == null || a.d == null) {
                    c(8);
                }
            }
        }
    }

    public void o() {
    }

    private void p() {
        TypedValue typedValue;
        TypedValue typedValue2;
        TypedValue typedValue3;
        int dimension;
        int dimension2;
        TypedValue typedValue4 = null;
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(nv.Theme);
        if (obtainStyledAttributes.hasValue(nv.Theme_windowFixedWidthMajor)) {
            if (null == null) {
                typedValue = new TypedValue();
            } else {
                typedValue = null;
            }
            obtainStyledAttributes.getValue(nv.Theme_windowFixedWidthMajor, typedValue);
        } else {
            typedValue = null;
        }
        if (obtainStyledAttributes.hasValue(nv.Theme_windowFixedWidthMinor)) {
            if (null == null) {
                typedValue2 = new TypedValue();
            } else {
                typedValue2 = null;
            }
            obtainStyledAttributes.getValue(nv.Theme_windowFixedWidthMinor, typedValue2);
        } else {
            typedValue2 = null;
        }
        if (obtainStyledAttributes.hasValue(nv.Theme_windowFixedHeightMajor)) {
            if (null == null) {
                typedValue3 = new TypedValue();
            } else {
                typedValue3 = null;
            }
            obtainStyledAttributes.getValue(nv.Theme_windowFixedHeightMajor, typedValue3);
        } else {
            typedValue3 = null;
        }
        if (obtainStyledAttributes.hasValue(nv.Theme_windowFixedHeightMinor)) {
            if (null == null) {
                typedValue4 = new TypedValue();
            }
            obtainStyledAttributes.getValue(nv.Theme_windowFixedHeightMinor, typedValue4);
        }
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        Object obj = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        if (obj == null) {
            typedValue2 = typedValue;
        }
        if (!(typedValue2 == null || typedValue2.type == 0)) {
            if (typedValue2.type == 5) {
                dimension = (int) typedValue2.getDimension(displayMetrics);
            } else if (typedValue2.type == 6) {
                dimension = (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
            }
            if (obj == null) {
                typedValue3 = typedValue4;
            }
            if (!(typedValue3 == null || typedValue3.type == 0)) {
                if (typedValue3.type != 5) {
                    dimension2 = (int) typedValue3.getDimension(displayMetrics);
                } else if (typedValue3.type == 6) {
                    dimension2 = (int) typedValue3.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                }
                if (!(dimension == -1 && dimension2 == -1)) {
                    this.a.getWindow().setLayout(dimension, dimension2);
                }
                obtainStyledAttributes.recycle();
            }
            dimension2 = -1;
            this.a.getWindow().setLayout(dimension, dimension2);
            obtainStyledAttributes.recycle();
        }
        dimension = -1;
        if (obj == null) {
            typedValue3 = typedValue4;
        }
        if (typedValue3.type != 5) {
            if (typedValue3.type == 6) {
                dimension2 = (int) typedValue3.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
            }
            dimension2 = -1;
        } else {
            dimension2 = (int) typedValue3.getDimension(displayMetrics);
        }
        this.a.getWindow().setLayout(dimension, dimension2);
        obtainStyledAttributes.recycle();
    }

    public void a(CharSequence charSequence) {
        if (this.k != null) {
            this.k.setWindowTitle(charSequence);
        } else if (b() != null) {
            b().a(charSequence);
        } else {
            this.r = charSequence;
        }
    }

    public View b(int i) {
        if (this.g != null) {
            return null;
        }
        View a;
        nx k = k();
        if (k != null) {
            a = k.a(i);
        } else {
            a = null;
        }
        if (a != null || this.B != null) {
            return a;
        }
        PanelFeatureState a2 = a(i, true);
        a(a2, null);
        if (a2.i) {
            return a2.c;
        }
        return a;
    }

    public boolean c(int i, Menu menu) {
        if (i != 0) {
            return k().a(i, menu);
        }
        return false;
    }

    public boolean a(int i, View view, Menu menu) {
        if (i != 0) {
            return k().a(i, view, menu);
        }
        return false;
    }

    public void a(int i, Menu menu) {
        PanelFeatureState a = a(i, false);
        if (a != null) {
            a(a, false);
        }
        if (i == 8) {
            ActionBar b = b();
            if (b != null) {
                b.e(false);
            }
        } else if (!m()) {
            this.a.b(i, menu);
        }
    }

    boolean b(int i, Menu menu) {
        if (i != 8) {
            return this.a.c(i, menu);
        }
        ActionBar b = b();
        if (b == null) {
            return true;
        }
        b.e(true);
        return true;
    }

    public boolean a(ox oxVar, MenuItem menuItem) {
        nx k = k();
        if (!(k == null || m())) {
            PanelFeatureState a = a(oxVar.p());
            if (a != null) {
                return k.a(a.a, menuItem);
            }
        }
        return false;
    }

    public void a(ox oxVar) {
        a(oxVar, true);
    }

    public ru b(rv rvVar) {
        if (rvVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.g != null) {
            this.g.c();
        }
        rv ngVar = new ng(this, rvVar);
        ActionBar b = b();
        if (b != null) {
            this.g = b.a(ngVar);
            if (this.g != null) {
                this.a.a(this.g);
            }
        }
        if (this.g == null) {
            this.g = a(ngVar);
        }
        return this.g;
    }

    public void g() {
        ActionBar b = b();
        if (b == null || !b.e()) {
            c(0);
        }
    }

    ru a(rv rvVar) {
        if (this.g != null) {
            this.g.c();
        }
        rv ngVar = new ng(this, rvVar);
        Context j = j();
        if (this.h == null) {
            if (this.e) {
                this.h = new ActionBarContextView(j);
                this.i = new PopupWindow(j, null, nl.actionModePopupWindowStyle);
                this.i.setContentView(this.h);
                this.i.setWidth(-1);
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(nl.actionBarSize, typedValue, true);
                this.h.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, this.a.getResources().getDisplayMetrics()));
                this.i.setHeight(-2);
                this.j = new ne(this);
            } else {
                ViewStubCompat viewStubCompat = (ViewStubCompat) this.a.findViewById(nq.action_mode_bar_stub);
                if (viewStubCompat != null) {
                    viewStubCompat.setLayoutInflater(LayoutInflater.from(j));
                    this.h = (ActionBarContextView) viewStubCompat.a();
                }
            }
        }
        if (this.h != null) {
            boolean z;
            this.h.c();
            ActionBarContextView actionBarContextView = this.h;
            if (this.i == null) {
                z = true;
            } else {
                z = false;
            }
            ru ohVar = new oh(j, actionBarContextView, ngVar, z);
            if (rvVar.a(ohVar, ohVar.b())) {
                ohVar.d();
                this.h.a(ohVar);
                this.h.setVisibility(0);
                this.g = ohVar;
                if (this.i != null) {
                    this.a.getWindow().getDecorView().post(this.j);
                }
                this.h.sendAccessibilityEvent(32);
                if (this.h.getParent() != null) {
                    hg.o((View) this.h.getParent());
                }
            } else {
                this.g = null;
            }
        }
        if (!(this.g == null || this.a == null)) {
            this.a.a(this.g);
        }
        return this.g;
    }

    public boolean h() {
        if (this.g != null) {
            this.g.c();
            return true;
        }
        ActionBar b = b();
        if (b == null || !b.f()) {
            return false;
        }
        return true;
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (this.w == null || !a(this.w, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.w == null) {
                PanelFeatureState a = a(0, true);
                b(a, keyEvent);
                boolean a2 = a(a, keyEvent.getKeyCode(), keyEvent, 1);
                a.g = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        } else if (this.w == null) {
            return true;
        } else {
            this.w.h = true;
            return true;
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return b(i, keyEvent);
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (VERSION.SDK_INT < 21) {
            Object obj = -1;
            switch (str.hashCode()) {
                case -1455429095:
                    if (str.equals("CheckedTextView")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -339785223:
                    if (str.equals("Spinner")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 776382189:
                    if (str.equals("RadioButton")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1601505219:
                    if (str.equals("CheckBox")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1666676343:
                    if (str.equals("EditText")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case ve.CropImageView_guidelines /*0*/:
                    return new TintEditText(context, attributeSet);
                case ve.CropImageView_fixAspectRatio /*1*/:
                    return new TintSpinner(context, attributeSet);
                case ve.CropImageView_aspectRatioX /*2*/:
                    return new TintCheckBox(context, attributeSet);
                case ve.CropImageView_aspectRatioY /*3*/:
                    return new TintRadioButton(context, attributeSet);
                case ve.CropImageView_imageResource /*4*/:
                    return new TintCheckedTextView(context, attributeSet);
            }
        }
        return null;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (!panelFeatureState.i && !m()) {
            if (panelFeatureState.a == 0) {
                Context context = this.a;
                boolean z = (context.getResources().getConfiguration().screenLayout & 15) == 4;
                boolean z2;
                if (context.getApplicationInfo().targetSdkVersion >= 11) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z && r3) {
                    return;
                }
            }
            nx k = k();
            if (k != null && !k.c(panelFeatureState.a, panelFeatureState.d)) {
                a(panelFeatureState, true);
            } else if (b(panelFeatureState, keyEvent)) {
                if (panelFeatureState.b == null || panelFeatureState.k) {
                    a(panelFeatureState);
                }
                if (c(panelFeatureState) && panelFeatureState.a()) {
                    panelFeatureState.h = false;
                    panelFeatureState.i = true;
                }
            }
        }
    }

    private void a(PanelFeatureState panelFeatureState) {
        panelFeatureState.b = this.o;
        panelFeatureState.a(j());
    }

    private void a(ox oxVar, boolean z) {
        if (this.k == null || !this.k.d() || (hz.b(ViewConfiguration.get(this.a)) && !this.k.f())) {
            PanelFeatureState a = a(0, true);
            a.k = true;
            a(a, false);
            a(a, null);
            return;
        }
        nx k = k();
        if (this.k.e() && z) {
            this.k.h();
            if (!m()) {
                this.a.onPanelClosed(8, a(0, true).d);
            }
        } else if (k != null && !m()) {
            if (this.x && (this.y & 1) != 0) {
                this.o.removeCallbacks(this.z);
                this.z.run();
            }
            PanelFeatureState a2 = a(0, true);
            if (a2.d != null && !a2.l && k.a(0, null, a2.d)) {
                k.c(8, a2.d);
                this.k.g();
            }
        }
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context contextThemeWrapper;
        ox oxVar;
        Context context = this.a;
        if ((panelFeatureState.a == 0 || panelFeatureState.a == 8) && this.k != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(nl.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(nl.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(nl.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(theme3);
                oxVar = new ox(contextThemeWrapper);
                oxVar.a((oy) this);
                panelFeatureState.a(oxVar);
                return true;
            }
        }
        contextThemeWrapper = context;
        oxVar = new ox(contextThemeWrapper);
        oxVar.a((oy) this);
        panelFeatureState.a(oxVar);
        return true;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.d == null) {
            return false;
        }
        if (this.m == null) {
            this.m = new ni();
        }
        panelFeatureState.c = (View) panelFeatureState.a(this.m);
        return panelFeatureState.c != null;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (m()) {
            return false;
        }
        if (panelFeatureState.g) {
            return true;
        }
        if (!(this.w == null || this.w == panelFeatureState)) {
            a(this.w, false);
        }
        boolean z = panelFeatureState.a == 0 || panelFeatureState.a == 8;
        if (z && this.k != null) {
            this.k.i();
        }
        if (panelFeatureState.d == null || panelFeatureState.l) {
            if (panelFeatureState.d == null && (!b(panelFeatureState) || panelFeatureState.d == null)) {
                return false;
            }
            if (z && this.k != null) {
                if (this.l == null) {
                    this.l = new nf();
                }
                this.k.a(panelFeatureState.d, this.l);
            }
            panelFeatureState.d.g();
            if (k().a(panelFeatureState.a, panelFeatureState.d)) {
                panelFeatureState.l = false;
            } else {
                panelFeatureState.a(null);
                if (!z || this.k == null) {
                    return false;
                }
                this.k.a(null, this.l);
                return false;
            }
        }
        panelFeatureState.d.g();
        if (panelFeatureState.m != null) {
            panelFeatureState.d.b(panelFeatureState.m);
            panelFeatureState.m = null;
        }
        if (k().a(0, null, panelFeatureState.d)) {
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            panelFeatureState.j = z;
            panelFeatureState.d.setQwertyMode(panelFeatureState.j);
            panelFeatureState.d.h();
            panelFeatureState.g = true;
            panelFeatureState.h = false;
            this.w = panelFeatureState;
            return true;
        }
        if (z && this.k != null) {
            this.k.a(null, this.l);
        }
        panelFeatureState.d.h();
        return false;
    }

    private void b(ox oxVar) {
        if (!this.u) {
            this.u = true;
            this.k.j();
            nx k = k();
            if (!(k == null || m())) {
                k.b(8, oxVar);
            }
            this.u = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.a == 0 && this.k != null && this.k.e()) {
            b(panelFeatureState.d);
            return;
        }
        if (panelFeatureState.i && z) {
            a(panelFeatureState.a, panelFeatureState, null);
        }
        panelFeatureState.g = false;
        panelFeatureState.h = false;
        panelFeatureState.i = false;
        panelFeatureState.c = null;
        panelFeatureState.k = true;
        if (this.w == panelFeatureState) {
            this.w = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.v.length) {
                panelFeatureState = this.v[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.d;
            }
        }
        if (panelFeatureState == null || panelFeatureState.i) {
            k().b(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.v;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.d == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState a(int i, boolean z) {
        Object obj = this.v;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.v = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    final boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.g || b(panelFeatureState, keyEvent)) && panelFeatureState.d != null) {
                z = panelFeatureState.d.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.k == null) {
                a(panelFeatureState, true);
            }
        }
        return z;
    }

    private void c(int i) {
        this.y |= 1 << i;
        if (!this.x && this.o != null) {
            hg.a(this.o, this.z);
            this.x = true;
        }
    }

    private void d(int i) {
        PanelFeatureState a = a(i, true);
        if (a.d != null) {
            Bundle bundle = new Bundle();
            a.d.a(bundle);
            if (bundle.size() > 0) {
                a.m = bundle;
            }
            a.d.g();
            a.d.clear();
        }
        a.l = true;
        a.k = true;
        if ((i == 8 || i == 0) && this.k != null) {
            a = a(0, false);
            if (a != null) {
                a.g = false;
                b(a, null);
            }
        }
    }

    private int e(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.h == null || !(this.h.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.h.getLayoutParams();
            if (this.h.isShown()) {
                if (this.C == null) {
                    this.C = new Rect();
                    this.D = new Rect();
                }
                Rect rect = this.C;
                Rect rect2 = this.D;
                rect.set(0, i, 0, 0);
                rt.a(this.p, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.q == null) {
                        this.q = new View(this.a);
                        this.q.setBackgroundColor(this.a.getResources().getColor(nn.abc_input_method_navigation_guard));
                        this.p.addView(this.q, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.q.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.q.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.q == null) {
                    i3 = 0;
                }
                if (!(this.d || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.h.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.q != null) {
            View view = this.q;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }
}
