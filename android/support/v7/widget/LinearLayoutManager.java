package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import jp;
import kt;
import nv;
import org.kxml2.wap.Wbxml;
import ss;
import st;
import su;
import sv;
import tk;
import tv;
import tz;
import uf;
import ui;
import uk;
import ve;

public class LinearLayoutManager extends tv {
    int a;
    public tk b;
    boolean c;
    int d;
    int e;
    SavedState f;
    final ss g;
    private su k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        int a;
        int b;
        boolean c;

        public SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        static {
            CREATOR = new sv();
        }
    }

    public LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public void a(RecyclerView recyclerView, tz tzVar) {
        super.a(recyclerView, tzVar);
        if (this.p) {
            c(tzVar);
            tzVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (m() > 0) {
            kt a = jp.a(accessibilityEvent);
            a.b(g());
            a.c(h());
        }
    }

    public Parcelable b() {
        if (this.f != null) {
            return new SavedState(this.f);
        }
        Parcelable savedState = new SavedState();
        if (m() > 0) {
            f();
            boolean z = this.l ^ this.c;
            savedState.c = z;
            View A;
            if (z) {
                A = A();
                savedState.b = this.b.d() - this.b.b(A);
                savedState.a = d(A);
                return savedState;
            }
            A = z();
            savedState.a = d(A);
            savedState.b = this.b.a(A) - this.b.c();
            return savedState;
        }
        savedState.b();
        return savedState;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f = (SavedState) parcelable;
            j();
        }
    }

    public boolean c() {
        return this.a == 0;
    }

    public boolean d() {
        return this.a == 1;
    }

    private void y() {
        boolean z = true;
        if (this.a == 1 || !e()) {
            this.c = this.m;
            return;
        }
        if (this.m) {
            z = false;
        }
        this.c = z;
    }

    public View a(int i) {
        int m = m();
        if (m == 0) {
            return null;
        }
        int d = i - d(d(0));
        if (d < 0 || d >= m) {
            return null;
        }
        return d(d);
    }

    protected int a(uf ufVar) {
        if (ufVar.d()) {
            return this.b.f();
        }
        return 0;
    }

    public void a(tz tzVar, uf ufVar) {
        int i;
        if (this.f != null && this.f.a()) {
            this.d = this.f.a;
        }
        f();
        this.k.a = false;
        y();
        this.g.a();
        this.g.c = this.c ^ this.n;
        b(ufVar, this.g);
        int a = a(ufVar);
        if ((ufVar.c() < this.g.a) == this.c) {
            i = a;
            a = 0;
        } else {
            i = 0;
        }
        a += this.b.c();
        i += this.b.g();
        if (!(!ufVar.a() || this.d == -1 || this.e == Integer.MIN_VALUE)) {
            View a2 = a(this.d);
            if (a2 != null) {
                int d;
                if (this.c) {
                    d = (this.b.d() - this.b.b(a2)) - this.e;
                } else {
                    d = this.e - (this.b.a(a2) - this.b.c());
                }
                if (d > 0) {
                    a += d;
                } else {
                    i -= d;
                }
            }
        }
        a(ufVar, this.g);
        a(tzVar);
        this.k.i = ufVar.a();
        if (this.g.c) {
            b(this.g);
            this.k.h = a;
            a(tzVar, this.k, ufVar, false);
            a = this.k.b;
            if (this.k.c > 0) {
                i += this.k.c;
            }
            a(this.g);
            this.k.h = i;
            su suVar = this.k;
            suVar.d += this.k.e;
            a(tzVar, this.k, ufVar, false);
            i = this.k.b;
        } else {
            a(this.g);
            this.k.h = i;
            a(tzVar, this.k, ufVar, false);
            i = this.k.b;
            if (this.k.c > 0) {
                a += this.k.c;
            }
            b(this.g);
            this.k.h = a;
            su suVar2 = this.k;
            suVar2.d += this.k.e;
            a(tzVar, this.k, ufVar, false);
            a = this.k.b;
        }
        if (m() > 0) {
            int a3;
            if ((this.c ^ this.n) != 0) {
                a3 = a(i, tzVar, ufVar, true);
                a += a3;
                i += a3;
                a3 = b(a, tzVar, ufVar, false);
                a += a3;
                i += a3;
            } else {
                a3 = b(a, tzVar, ufVar, true);
                a += a3;
                i += a3;
                a3 = a(i, tzVar, ufVar, false);
                a += a3;
                i += a3;
            }
        }
        b(tzVar, ufVar, a, i);
        if (!ufVar.a()) {
            this.d = -1;
            this.e = Integer.MIN_VALUE;
            this.b.a();
        }
        this.l = this.n;
        this.f = null;
    }

    void a(uf ufVar, ss ssVar) {
    }

    private void b(tz tzVar, uf ufVar, int i, int i2) {
        if (ufVar.b() && m() != 0 && !ufVar.a() && i()) {
            su suVar;
            int i3 = 0;
            int i4 = 0;
            List b = tzVar.b();
            int size = b.size();
            int d = d(d(0));
            int i5 = 0;
            while (i5 < size) {
                int c;
                int i6;
                ui uiVar = (ui) b.get(i5);
                if (((uiVar.d() < d) != this.c ? -1 : 1) == -1) {
                    c = this.b.c(uiVar.a) + i3;
                    i6 = i4;
                } else {
                    i6 = this.b.c(uiVar.a) + i4;
                    c = i3;
                }
                i5++;
                i3 = c;
                i4 = i6;
            }
            this.k.j = b;
            if (i3 > 0) {
                d(d(z()), i);
                this.k.h = i3;
                this.k.c = 0;
                suVar = this.k;
                suVar.d = (this.c ? 1 : -1) + suVar.d;
                a(tzVar, this.k, ufVar, false);
            }
            if (i4 > 0) {
                c(d(A()), i2);
                this.k.h = i4;
                this.k.c = 0;
                suVar = this.k;
                suVar.d = (this.c ? -1 : 1) + suVar.d;
                a(tzVar, this.k, ufVar, false);
            }
            this.k.j = null;
        }
    }

    private void b(uf ufVar, ss ssVar) {
        if (!d(ufVar, ssVar) && !c(ufVar, ssVar)) {
            ssVar.b();
            ssVar.a = this.n ? ufVar.e() - 1 : 0;
        }
    }

    private boolean c(uf ufVar, ss ssVar) {
        boolean z = false;
        if (m() == 0) {
            return false;
        }
        View t = t();
        if (t != null && ssVar.a(t, ufVar)) {
            return true;
        }
        if (this.l != this.n) {
            return false;
        }
        t = ssVar.c ? k(ufVar) : l(ufVar);
        if (t == null) {
            return false;
        }
        ssVar.a(t);
        if (!ufVar.a() && i()) {
            if (this.b.a(t) >= this.b.d() || this.b.b(t) < this.b.c()) {
                z = true;
            }
            if (z) {
                ssVar.b = ssVar.c ? this.b.d() : this.b.c();
            }
        }
        return true;
    }

    private boolean d(uf ufVar, ss ssVar) {
        boolean z = false;
        if (ufVar.a() || this.d == -1) {
            return false;
        }
        if (this.d < 0 || this.d >= ufVar.e()) {
            this.d = -1;
            this.e = Integer.MIN_VALUE;
            return false;
        }
        ssVar.a = this.d;
        if (this.f != null && this.f.a()) {
            ssVar.c = this.f.c;
            if (ssVar.c) {
                ssVar.b = this.b.d() - this.f.b;
                return true;
            }
            ssVar.b = this.b.c() + this.f.b;
            return true;
        } else if (this.e == Integer.MIN_VALUE) {
            View a = a(this.d);
            if (a == null) {
                if (m() > 0) {
                    boolean z2;
                    if (this.d < d(d(0))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 == this.c) {
                        z = true;
                    }
                    ssVar.c = z;
                }
                ssVar.b();
                return true;
            } else if (this.b.c(a) > this.b.f()) {
                ssVar.b();
                return true;
            } else if (this.b.a(a) - this.b.c() < 0) {
                ssVar.b = this.b.c();
                ssVar.c = false;
                return true;
            } else if (this.b.d() - this.b.b(a) < 0) {
                ssVar.b = this.b.d();
                ssVar.c = true;
                return true;
            } else {
                ssVar.b = ssVar.c ? this.b.b(a) + this.b.b() : this.b.a(a);
                return true;
            }
        } else {
            ssVar.c = this.c;
            if (this.c) {
                ssVar.b = this.b.d() - this.e;
                return true;
            }
            ssVar.b = this.b.c() + this.e;
            return true;
        }
    }

    private int a(int i, tz tzVar, uf ufVar, boolean z) {
        int d = this.b.d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -c(-d, tzVar, ufVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.b.d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.b.a(i2);
        return d + i2;
    }

    private int b(int i, tz tzVar, uf ufVar, boolean z) {
        int c = i - this.b.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, tzVar, ufVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.b.c();
        if (i2 <= 0) {
            return c;
        }
        this.b.a(-i2);
        return c - i2;
    }

    private void a(ss ssVar) {
        c(ssVar.a, ssVar.b);
    }

    private void c(int i, int i2) {
        this.k.c = this.b.d() - i2;
        this.k.e = this.c ? -1 : 1;
        this.k.d = i;
        this.k.f = 1;
        this.k.b = i2;
        this.k.g = Integer.MIN_VALUE;
    }

    private void b(ss ssVar) {
        d(ssVar.a, ssVar.b);
    }

    private void d(int i, int i2) {
        this.k.c = i2 - this.b.c();
        this.k.d = i;
        this.k.e = this.c ? 1 : -1;
        this.k.f = -1;
        this.k.b = i2;
        this.k.g = Integer.MIN_VALUE;
    }

    protected boolean e() {
        return l() == 1;
    }

    void f() {
        if (this.k == null) {
            this.k = new su();
        }
        if (this.b == null) {
            this.b = tk.a(this, this.a);
        }
    }

    public int a(int i, tz tzVar, uf ufVar) {
        if (this.a == 1) {
            return 0;
        }
        return c(i, tzVar, ufVar);
    }

    public int b(int i, tz tzVar, uf ufVar) {
        if (this.a == 0) {
            return 0;
        }
        return c(i, tzVar, ufVar);
    }

    public int b(uf ufVar) {
        return h(ufVar);
    }

    public int c(uf ufVar) {
        return h(ufVar);
    }

    public int d(uf ufVar) {
        return i(ufVar);
    }

    public int e(uf ufVar) {
        return i(ufVar);
    }

    public int f(uf ufVar) {
        return j(ufVar);
    }

    public int g(uf ufVar) {
        return j(ufVar);
    }

    private int h(uf ufVar) {
        if (m() == 0) {
            return 0;
        }
        f();
        return uk.a(ufVar, this.b, z(), A(), this, this.o, this.c);
    }

    private int i(uf ufVar) {
        if (m() == 0) {
            return 0;
        }
        f();
        return uk.a(ufVar, this.b, z(), A(), this, this.o);
    }

    private int j(uf ufVar) {
        if (m() == 0) {
            return 0;
        }
        f();
        return uk.b(ufVar, this.b, z(), A(), this, this.o);
    }

    private void a(int i, int i2, boolean z, uf ufVar) {
        int i3 = -1;
        int i4 = 1;
        this.k.h = a(ufVar);
        this.k.f = i;
        View A;
        su suVar;
        if (i == 1) {
            su suVar2 = this.k;
            suVar2.h += this.b.g();
            A = A();
            suVar = this.k;
            if (!this.c) {
                i3 = 1;
            }
            suVar.e = i3;
            this.k.d = d(A) + this.k.e;
            this.k.b = this.b.b(A);
            i3 = this.b.b(A) - this.b.d();
        } else {
            A = z();
            suVar = this.k;
            suVar.h += this.b.c();
            suVar = this.k;
            if (!this.c) {
                i4 = -1;
            }
            suVar.e = i4;
            this.k.d = d(A) + this.k.e;
            this.k.b = this.b.a(A);
            i3 = (-this.b.a(A)) + this.b.c();
        }
        this.k.c = i2;
        if (z) {
            su suVar3 = this.k;
            suVar3.c -= i3;
        }
        this.k.g = i3;
    }

    int c(int i, tz tzVar, uf ufVar) {
        if (m() == 0 || i == 0) {
            return 0;
        }
        this.k.a = true;
        f();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, ufVar);
        int a = this.k.g + a(tzVar, this.k, ufVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.b.a(-i);
        return i;
    }

    public void a(String str) {
        if (this.f == null) {
            super.a(str);
        }
    }

    private void a(tz tzVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, tzVar);
                }
                return;
            }
            while (i > i2) {
                a(i, tzVar);
                i--;
            }
        }
    }

    private void a(tz tzVar, int i) {
        if (i >= 0) {
            int m = m();
            int i2;
            if (this.c) {
                for (i2 = m - 1; i2 >= 0; i2--) {
                    if (this.b.b(d(i2)) > i) {
                        a(tzVar, m - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < m; i2++) {
                if (this.b.b(d(i2)) > i) {
                    a(tzVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void b(tz tzVar, int i) {
        int m = m();
        if (i >= 0) {
            int e = this.b.e() - i;
            int i2;
            if (this.c) {
                for (i2 = 0; i2 < m; i2++) {
                    if (this.b.a(d(i2)) < e) {
                        a(tzVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = m - 1; i2 >= 0; i2--) {
                if (this.b.a(d(i2)) < e) {
                    a(tzVar, m - 1, i2);
                    return;
                }
            }
        }
    }

    private void a(tz tzVar, su suVar) {
        if (!suVar.a) {
            return;
        }
        if (suVar.f == -1) {
            b(tzVar, suVar.g);
        } else {
            a(tzVar, suVar.g);
        }
    }

    int a(tz tzVar, su suVar, uf ufVar, boolean z) {
        int i = suVar.c;
        if (suVar.g != Integer.MIN_VALUE) {
            if (suVar.c < 0) {
                suVar.g += suVar.c;
            }
            a(tzVar, suVar);
        }
        int i2 = suVar.c + suVar.h;
        st stVar = new st();
        while (i2 > 0 && suVar.a(ufVar)) {
            stVar.a();
            a(tzVar, ufVar, suVar, stVar);
            if (!stVar.b) {
                suVar.b += stVar.a * suVar.f;
                if (!(stVar.c && this.k.j == null && ufVar.a())) {
                    suVar.c -= stVar.a;
                    i2 -= stVar.a;
                }
                if (suVar.g != Integer.MIN_VALUE) {
                    suVar.g += stVar.a;
                    if (suVar.c < 0) {
                        suVar.g += suVar.c;
                    }
                    a(tzVar, suVar);
                }
                if (z && stVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - suVar.c;
    }

    void a(tz tzVar, uf ufVar, su suVar, st stVar) {
        View a = suVar.a(tzVar);
        if (a == null) {
            stVar.b = true;
            return;
        }
        int n;
        int d;
        int i;
        int i2;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (suVar.j == null) {
            if (this.c == (suVar.f == -1)) {
                b(a);
            } else {
                b(a, 0);
            }
        } else {
            boolean z;
            boolean z2 = this.c;
            if (suVar.f == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                a(a);
            } else {
                a(a, 0);
            }
        }
        a(a, 0, 0);
        stVar.a = this.b.c(a);
        if (this.a == 1) {
            if (e()) {
                n = n() - r();
                d = n - this.b.d(a);
            } else {
                d = p();
                n = this.b.d(a) + d;
            }
            if (suVar.f == -1) {
                i = suVar.b - stVar.a;
                i2 = n;
                n = suVar.b;
            } else {
                i = suVar.b;
                i2 = n;
                n = suVar.b + stVar.a;
            }
        } else {
            i = q();
            n = this.b.d(a) + i;
            if (suVar.f == -1) {
                d = suVar.b - stVar.a;
                i2 = suVar.b;
            } else {
                d = suVar.b;
                i2 = suVar.b + stVar.a;
            }
        }
        a(a, d + layoutParams.leftMargin, i + layoutParams.topMargin, i2 - layoutParams.rightMargin, n - layoutParams.bottomMargin);
        if (layoutParams.a() || layoutParams.b()) {
            stVar.c = true;
        }
        stVar.d = a.isFocusable();
    }

    private int h(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return -1;
            case ve.CropImageView_aspectRatioX /*2*/:
                return 1;
            case nv.Toolbar_theme /*17*/:
                if (this.a != 0) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case nv.Theme_actionModeFindDrawable /*33*/:
                if (this.a != 1) {
                    return Integer.MIN_VALUE;
                }
                return -1;
            case Wbxml.EXT_I_2 /*66*/:
                if (this.a != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case Wbxml.EXT_T_2 /*130*/:
                if (this.a == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View z() {
        return d(this.c ? m() - 1 : 0);
    }

    private View A() {
        return d(this.c ? 0 : m() - 1);
    }

    private View k(uf ufVar) {
        return this.c ? i(ufVar.e()) : j(ufVar.e());
    }

    private View l(uf ufVar) {
        return this.c ? j(ufVar.e()) : i(ufVar.e());
    }

    private View i(int i) {
        return a(0, m(), i);
    }

    private View j(int i) {
        return a(m() - 1, -1, i);
    }

    private View a(int i, int i2, int i3) {
        View view = null;
        f();
        int c = this.b.c();
        int d = this.b.d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View d2 = d(i);
            int d3 = d(d2);
            if (d3 >= 0 && d3 < i3) {
                if (((LayoutParams) d2.getLayoutParams()).a()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = d2;
                    }
                } else if (this.b.a(d2) < d && this.b.b(d2) >= c) {
                    return d2;
                } else {
                    if (view == null) {
                        view3 = d2;
                        d2 = view2;
                        i += i4;
                        view = view3;
                        view2 = d2;
                    }
                }
            }
            view3 = view;
            d2 = view2;
            i += i4;
            view = view3;
            view2 = d2;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public int g() {
        View a = a(0, m(), false);
        return a == null ? -1 : d(a);
    }

    public int h() {
        View a = a(m() - 1, -1, false);
        if (a == null) {
            return -1;
        }
        return d(a);
    }

    View a(int i, int i2, boolean z) {
        f();
        int c = this.b.c();
        int d = this.b.d();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View d2 = d(i);
            int a = this.b.a(d2);
            int b = this.b.b(d2);
            if (a < d && b > c) {
                if (!z) {
                    return d2;
                }
                if (a >= c && b <= d) {
                    return d2;
                }
            }
            i += i3;
        }
        return null;
    }

    public View a(View view, int i, tz tzVar, uf ufVar) {
        y();
        if (m() == 0) {
            return null;
        }
        int h = h(i);
        if (h == Integer.MIN_VALUE) {
            return null;
        }
        View l;
        f();
        if (h == -1) {
            l = l(ufVar);
        } else {
            l = k(ufVar);
        }
        if (l == null) {
            return null;
        }
        View z;
        f();
        a(h, (int) (0.33f * ((float) this.b.f())), false, ufVar);
        this.k.g = Integer.MIN_VALUE;
        this.k.a = false;
        a(tzVar, this.k, ufVar, true);
        if (h == -1) {
            z = z();
        } else {
            z = A();
        }
        if (z == l || !z.isFocusable()) {
            return null;
        }
        return z;
    }

    public boolean i() {
        return this.f == null && this.l == this.n;
    }
}
