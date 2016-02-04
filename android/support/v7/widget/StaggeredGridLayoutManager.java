package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import hg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import jp;
import kt;
import sr;
import tk;
import tv;
import tz;
import uf;
import uk;
import up;
import uq;
import ur;
import us;

public class StaggeredGridLayoutManager extends tv {
    private final Runnable A;
    public tk a;
    tk b;
    boolean c;
    int d;
    int e;
    public LazySpanLookup f;
    private int g;
    private us[] k;
    private int l;
    private int m;
    private sr n;
    private boolean o;
    private BitSet p;
    private int q;
    private boolean r;
    private boolean s;
    private SavedState t;
    private int u;
    private int v;
    private int w;
    private final up x;
    private boolean y;
    private boolean z;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public us e;
        public boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class LazySpanLookup {
        int[] a;
        List b;

        public class FullSpanItem implements Parcelable {
            public static final Creator CREATOR;
            int a;
            public int b;
            int[] c;

            public FullSpanItem(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            public int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            static {
                CREATOR = new uq();
            }
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            Arrays.fill(this.a, i, g + 1, -1);
            return g + 1;
        }

        int c(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            return this.a[i];
        }

        void a(int i, us usVar) {
            e(i);
            this.a[i] = usVar.d;
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                this.a = new int[d(i)];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.b.get(i2);
            this.b.remove(i2);
            return f.a;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        public FullSpanItem f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem a(int i, int i2, int i3) {
            if (this.b == null) {
                return null;
            }
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i && (i3 == 0 || fullSpanItem.b == i3)) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.i = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.j = z2;
            this.g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            if (this.h) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.i) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.j) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeList(this.g);
        }

        static {
            CREATOR = new ur();
        }
    }

    private void y() {
        if (m() != 0 && this.q != 0) {
            int B;
            int C;
            if (this.c) {
                B = B();
                C = C();
            } else {
                B = C();
                C = B();
            }
            if (B == 0 && e() != null) {
                this.f.a();
                x();
                j();
            } else if (this.y) {
                int i = this.c ? -1 : 1;
                FullSpanItem a = this.f.a(B, C + 1, i);
                if (a == null) {
                    this.y = false;
                    this.f.a(C + 1);
                    return;
                }
                FullSpanItem a2 = this.f.a(B, a.a, i * -1);
                if (a2 == null) {
                    this.f.a(a.a);
                } else {
                    this.f.a(a2.a + 1);
                }
                x();
                j();
            }
        }
    }

    public void g(int i) {
        if (i == 0) {
            y();
        }
    }

    public void a(RecyclerView recyclerView, tz tzVar) {
        for (int i = 0; i < this.g; i++) {
            this.k[i].e();
        }
    }

    View e() {
        int i;
        int i2;
        int m = m() - 1;
        BitSet bitSet = new BitSet(this.g);
        bitSet.set(0, this.g, true);
        boolean z = (this.l == 1 && f()) ? true : true;
        if (this.c) {
            m--;
            i = -1;
        } else {
            i = m;
            m = 0;
        }
        if (m < i) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int i3 = m;
        while (i3 != i) {
            View d = d(i3);
            LayoutParams layoutParams = (LayoutParams) d.getLayoutParams();
            if (bitSet.get(layoutParams.e.d)) {
                if (a(layoutParams.e)) {
                    return d;
                }
                bitSet.clear(layoutParams.e.d);
            }
            if (!(layoutParams.f || i3 + i2 == i)) {
                boolean z2;
                View d2 = d(i3 + i2);
                int b;
                if (this.c) {
                    m = this.a.b(d);
                    b = this.a.b(d2);
                    if (m < b) {
                        return d;
                    }
                    if (m == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    m = this.a.a(d);
                    b = this.a.a(d2);
                    if (m > b) {
                        return d;
                    }
                    if (m == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if (layoutParams.e.d - ((LayoutParams) d2.getLayoutParams()).e.d < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != (z >= false)) {
                        return d;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    private boolean a(us usVar) {
        if (this.c) {
            if (usVar.d() < this.a.d()) {
                return true;
            }
        } else if (usVar.b() > this.a.c()) {
            return true;
        }
        return false;
    }

    public void a(boolean z) {
        a(null);
        if (!(this.t == null || this.t.h == z)) {
            this.t.h = z;
        }
        this.o = z;
        j();
    }

    public void a(String str) {
        if (this.t == null) {
            super.a(str);
        }
    }

    private void z() {
        if (this.a == null) {
            this.a = tk.a(this, this.l);
            this.b = tk.a(this, 1 - this.l);
            this.n = new sr();
        }
    }

    private void A() {
        boolean z = true;
        if (this.l == 1 || !f()) {
            this.c = this.o;
            return;
        }
        if (this.o) {
            z = false;
        }
        this.c = z;
    }

    boolean f() {
        return l() == 1;
    }

    public void a(tz tzVar, uf ufVar) {
        z();
        up upVar = this.x;
        upVar.a();
        if (this.t != null) {
            a(upVar);
        } else {
            A();
            upVar.c = this.c;
        }
        a(ufVar, upVar);
        if (this.t == null && !(upVar.c == this.r && f() == this.s)) {
            this.f.a();
            upVar.d = true;
        }
        if (m() > 0 && (this.t == null || this.t.c < 1)) {
            int i;
            if (upVar.d) {
                for (i = 0; i < this.g; i++) {
                    this.k[i].e();
                    if (upVar.b != Integer.MIN_VALUE) {
                        this.k[i].c(upVar.b);
                    }
                }
            } else {
                for (i = 0; i < this.g; i++) {
                    this.k[i].a(this.c, upVar.b);
                }
            }
        }
        a(tzVar);
        this.y = false;
        g();
        sr srVar;
        if (upVar.c) {
            a(upVar.a, ufVar);
            a(tzVar, this.n, ufVar);
            b(upVar.a, ufVar);
            srVar = this.n;
            srVar.b += this.n.c;
            a(tzVar, this.n, ufVar);
        } else {
            b(upVar.a, ufVar);
            a(tzVar, this.n, ufVar);
            a(upVar.a, ufVar);
            srVar = this.n;
            srVar.b += this.n.c;
            a(tzVar, this.n, ufVar);
        }
        if (m() > 0) {
            if (this.c) {
                a(tzVar, ufVar, true);
                b(tzVar, ufVar, false);
            } else {
                b(tzVar, ufVar, true);
                a(tzVar, ufVar, false);
            }
        }
        if (!ufVar.a()) {
            if (m() > 0 && this.d != -1 && this.y) {
                hg.a(d(0), this.A);
            }
            this.d = -1;
            this.e = Integer.MIN_VALUE;
        }
        this.r = upVar.c;
        this.s = f();
        this.t = null;
    }

    private void a(up upVar) {
        if (this.t.c > 0) {
            if (this.t.c == this.g) {
                for (int i = 0; i < this.g; i++) {
                    this.k[i].e();
                    int i2 = this.t.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.t.i) {
                            i2 += this.a.d();
                        } else {
                            i2 += this.a.c();
                        }
                    }
                    this.k[i].c(i2);
                }
            } else {
                this.t.a();
                this.t.a = this.t.b;
            }
        }
        this.s = this.t.j;
        a(this.t.h);
        A();
        if (this.t.a != -1) {
            this.d = this.t.a;
            upVar.c = this.t.i;
        } else {
            upVar.c = this.c;
        }
        if (this.t.e > 1) {
            this.f.a = this.t.f;
            this.f.b = this.t.g;
        }
    }

    void a(uf ufVar, up upVar) {
        if (!b(ufVar, upVar) && !c(ufVar, upVar)) {
            upVar.b();
            upVar.a = 0;
        }
    }

    private boolean c(uf ufVar, up upVar) {
        upVar.a = this.r ? q(ufVar.e()) : p(ufVar.e());
        upVar.b = Integer.MIN_VALUE;
        return true;
    }

    boolean b(uf ufVar, up upVar) {
        boolean z = false;
        if (ufVar.a() || this.d == -1) {
            return false;
        }
        if (this.d < 0 || this.d >= ufVar.e()) {
            this.d = -1;
            this.e = Integer.MIN_VALUE;
            return false;
        } else if (this.t == null || this.t.a == -1 || this.t.c < 1) {
            View a = a(this.d);
            if (a != null) {
                upVar.a = this.c ? B() : C();
                if (this.e != Integer.MIN_VALUE) {
                    if (upVar.c) {
                        upVar.b = (this.a.d() - this.e) - this.a.b(a);
                        return true;
                    }
                    upVar.b = (this.a.c() + this.e) - this.a.a(a);
                    return true;
                } else if (this.a.c(a) > this.a.f()) {
                    upVar.b = upVar.c ? this.a.d() : this.a.c();
                    return true;
                } else {
                    int a2 = this.a.a(a) - this.a.c();
                    if (a2 < 0) {
                        upVar.b = -a2;
                        return true;
                    }
                    a2 = this.a.d() - this.a.b(a);
                    if (a2 < 0) {
                        upVar.b = a2;
                        return true;
                    }
                    upVar.b = Integer.MIN_VALUE;
                    return true;
                }
            }
            upVar.a = this.d;
            if (this.e == Integer.MIN_VALUE) {
                if (o(upVar.a) == 1) {
                    z = true;
                }
                upVar.c = z;
                upVar.b();
            } else {
                upVar.a(this.e);
            }
            upVar.d = true;
            return true;
        } else {
            upVar.b = Integer.MIN_VALUE;
            upVar.a = this.d;
            return true;
        }
    }

    void g() {
        this.m = this.b.f() / this.g;
        this.u = MeasureSpec.makeMeasureSpec(this.b.f(), 1073741824);
        if (this.l == 1) {
            this.v = MeasureSpec.makeMeasureSpec(this.m, 1073741824);
            this.w = MeasureSpec.makeMeasureSpec(0, 0);
            return;
        }
        this.w = MeasureSpec.makeMeasureSpec(this.m, 1073741824);
        this.v = MeasureSpec.makeMeasureSpec(0, 0);
    }

    public boolean i() {
        return this.t == null;
    }

    public int b(uf ufVar) {
        return a(ufVar);
    }

    private int a(uf ufVar) {
        boolean z = true;
        if (m() == 0) {
            return 0;
        }
        z();
        tk tkVar = this.a;
        View b = b(!this.z);
        if (this.z) {
            z = false;
        }
        return uk.a(ufVar, tkVar, b, c(z), this, this.z, this.c);
    }

    public int c(uf ufVar) {
        return a(ufVar);
    }

    public int d(uf ufVar) {
        return h(ufVar);
    }

    private int h(uf ufVar) {
        boolean z = true;
        if (m() == 0) {
            return 0;
        }
        z();
        tk tkVar = this.a;
        View b = b(!this.z);
        if (this.z) {
            z = false;
        }
        return uk.a(ufVar, tkVar, b, c(z), this, this.z);
    }

    public int e(uf ufVar) {
        return h(ufVar);
    }

    public int f(uf ufVar) {
        return i(ufVar);
    }

    private int i(uf ufVar) {
        boolean z = true;
        if (m() == 0) {
            return 0;
        }
        z();
        tk tkVar = this.a;
        View b = b(!this.z);
        if (this.z) {
            z = false;
        }
        return uk.b(ufVar, tkVar, b, c(z), this, this.z);
    }

    public int g(uf ufVar) {
        return i(ufVar);
    }

    private void a(View view, LayoutParams layoutParams) {
        if (!layoutParams.f) {
            b(view, this.v, this.w);
        } else if (this.l == 1) {
            b(view, this.u, this.w);
        } else {
            b(view, this.v, this.u);
        }
    }

    private void b(View view, int i, int i2) {
        Rect e = this.i.e(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(a(i, layoutParams.leftMargin + e.left, layoutParams.rightMargin + e.right), a(i2, layoutParams.topMargin + e.top, layoutParams.bottomMargin + e.bottom));
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.t = (SavedState) parcelable;
            j();
        }
    }

    public Parcelable b() {
        if (this.t != null) {
            return new SavedState(this.t);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.o;
        savedState.i = this.r;
        savedState.j = this.s;
        if (this.f == null || this.f.a == null) {
            savedState.e = 0;
        } else {
            savedState.f = this.f.a;
            savedState.e = savedState.f.length;
            savedState.g = this.f.b;
        }
        if (m() > 0) {
            z();
            savedState.a = this.r ? B() : C();
            savedState.b = h();
            savedState.c = this.g;
            savedState.d = new int[this.g];
            for (int i = 0; i < this.g; i++) {
                int b;
                if (this.r) {
                    b = this.k[i].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.a.d();
                    }
                } else {
                    b = this.k[i].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.a.c();
                    }
                }
                savedState.d[i] = b;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = 0;
        }
        return savedState;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (m() > 0) {
            kt a = jp.a(accessibilityEvent);
            View b = b(false);
            View c = c(false);
            if (b != null && c != null) {
                int d = d(b);
                int d2 = d(c);
                if (d < d2) {
                    a.b(d);
                    a.c(d2);
                    return;
                }
                a.b(d2);
                a.c(d);
            }
        }
    }

    int h() {
        View c = this.c ? c(true) : b(true);
        return c == null ? -1 : d(c);
    }

    public int c(tz tzVar, uf ufVar) {
        if (this.l == 0) {
            return this.g;
        }
        return super.c(tzVar, ufVar);
    }

    public int d(tz tzVar, uf ufVar) {
        if (this.l == 1) {
            return this.g;
        }
        return super.d(tzVar, ufVar);
    }

    View b(boolean z) {
        z();
        int c = this.a.c();
        int d = this.a.d();
        int m = m();
        for (int i = 0; i < m; i++) {
            View d2 = d(i);
            if ((!z || this.a.a(d2) >= c) && this.a.b(d2) <= d) {
                return d2;
            }
        }
        return null;
    }

    View c(boolean z) {
        z();
        int c = this.a.c();
        int d = this.a.d();
        for (int m = m() - 1; m >= 0; m--) {
            View d2 = d(m);
            if (this.a.a(d2) >= c && (!z || this.a.b(d2) <= d)) {
                return d2;
            }
        }
        return null;
    }

    private void a(tz tzVar, uf ufVar, boolean z) {
        int d = this.a.d() - l(this.a.d());
        if (d > 0) {
            d -= -c(-d, tzVar, ufVar);
            if (z && d > 0) {
                this.a.a(d);
            }
        }
    }

    private void b(tz tzVar, uf ufVar, boolean z) {
        int k = k(this.a.c()) - this.a.c();
        if (k > 0) {
            k -= c(k, tzVar, ufVar);
            if (z && k > 0) {
                this.a.a(-k);
            }
        }
    }

    private void a(int i, uf ufVar) {
        int i2 = 1;
        this.n.a = 0;
        this.n.b = i;
        if (k()) {
            if (this.c == (ufVar.c() < i)) {
                this.n.e = 0;
            } else {
                this.n.e = this.a.f();
            }
        } else {
            this.n.e = 0;
        }
        this.n.d = -1;
        sr srVar = this.n;
        if (!this.c) {
            i2 = -1;
        }
        srVar.c = i2;
    }

    private void b(int i, uf ufVar) {
        int i2 = 1;
        this.n.a = 0;
        this.n.b = i;
        if (k()) {
            if (this.c == (ufVar.c() > i)) {
                this.n.e = 0;
            } else {
                this.n.e = this.a.f();
            }
        } else {
            this.n.e = 0;
        }
        this.n.d = 1;
        sr srVar = this.n;
        if (this.c) {
            i2 = -1;
        }
        srVar.c = i2;
    }

    public void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.k[i2].d(i);
        }
    }

    public void f(int i) {
        super.f(i);
        for (int i2 = 0; i2 < this.g; i2++) {
            this.k[i2].d(i);
        }
    }

    public void d(RecyclerView recyclerView) {
        this.f.a();
        j();
    }

    private int a(tz tzVar, sr srVar, uf ufVar) {
        int d;
        int i;
        int g;
        this.p.set(0, this.g, true);
        if (srVar.d == 1) {
            d = this.a.d() + this.n.a;
            i = d;
            g = (this.n.e + d) + this.a.g();
        } else {
            d = this.a.c() - this.n.a;
            i = d;
            g = (d - this.n.e) - this.a.c();
        }
        c(srVar.d, g);
        int d2 = this.c ? this.a.d() : this.a.c();
        while (srVar.a(ufVar) && !this.p.isEmpty()) {
            us usVar;
            int c;
            View a = srVar.a(tzVar);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            if (srVar.d == 1) {
                b(a);
            } else {
                b(a, 0);
            }
            a(a, layoutParams);
            int c2 = layoutParams.c();
            int c3 = this.f.c(c2);
            Object obj = c3 == -1 ? 1 : null;
            if (obj != null) {
                us a2 = layoutParams.f ? this.k[0] : a(srVar);
                this.f.a(c2, a2);
                usVar = a2;
            } else {
                usVar = this.k[c3];
            }
            if (srVar.d == 1) {
                if (layoutParams.f) {
                    d = l(d2);
                } else {
                    d = usVar.b(d2);
                }
                c = d + this.a.c(a);
                if (obj == null || !layoutParams.f) {
                    c3 = d;
                } else {
                    FullSpanItem h = h(d);
                    h.b = -1;
                    h.a = c2;
                    this.f.a(h);
                    c3 = d;
                }
            } else {
                if (layoutParams.f) {
                    d = k(d2);
                } else {
                    d = usVar.a(d2);
                }
                c3 = d - this.a.c(a);
                if (obj != null && layoutParams.f) {
                    FullSpanItem i2 = i(d);
                    i2.b = 1;
                    i2.a = c2;
                    this.f.a(i2);
                }
                c = d;
            }
            if (layoutParams.f && srVar.c == -1 && obj != null) {
                this.y = true;
            }
            layoutParams.e = usVar;
            a(a, layoutParams, srVar);
            int c4 = layoutParams.f ? this.b.c() : this.b.c() + (usVar.d * this.m);
            c2 = c4 + this.b.c(a);
            if (this.l == 1) {
                b(a, c4, c3, c2, c);
            } else {
                b(a, c3, c4, c, c2);
            }
            if (layoutParams.f) {
                c(this.n.d, g);
            } else {
                a(usVar, this.n.d, g);
            }
            a(tzVar, this.n, usVar, i);
        }
        if (this.n.d == -1) {
            return Math.max(0, (i - k(this.a.c())) + this.n.a);
        }
        return Math.max(0, (l(this.a.d()) - i) + this.n.a);
    }

    private FullSpanItem h(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.g];
        for (int i2 = 0; i2 < this.g; i2++) {
            fullSpanItem.c[i2] = i - this.k[i2].b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem i(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.g];
        for (int i2 = 0; i2 < this.g; i2++) {
            fullSpanItem.c[i2] = this.k[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, sr srVar) {
        if (srVar.d == 1) {
            if (layoutParams.f) {
                o(view);
            } else {
                layoutParams.e.b(view);
            }
        } else if (layoutParams.f) {
            p(view);
        } else {
            layoutParams.e.a(view);
        }
    }

    private void a(tz tzVar, sr srVar, us usVar, int i) {
        if (srVar.d == -1) {
            b(tzVar, Math.max(i, j(usVar.b())) + (this.a.e() - this.a.c()));
        } else {
            a(tzVar, Math.min(i, m(usVar.d())) - (this.a.e() - this.a.c()));
        }
    }

    private void o(View view) {
        for (int i = this.g - 1; i >= 0; i--) {
            this.k[i].b(view);
        }
    }

    private void p(View view) {
        for (int i = this.g - 1; i >= 0; i--) {
            this.k[i].a(view);
        }
    }

    private void b(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        a(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void c(int i, int i2) {
        for (int i3 = 0; i3 < this.g; i3++) {
            if (!this.k[i3].f.isEmpty()) {
                a(this.k[i3], i, i2);
            }
        }
    }

    private void a(us usVar, int i, int i2) {
        int i3 = usVar.i();
        if (i == -1) {
            if (i3 + usVar.b() < i2) {
                this.p.set(usVar.d, false);
            }
        } else if (usVar.d() - i3 > i2) {
            this.p.set(usVar.d, false);
        }
    }

    private int j(int i) {
        int a = this.k[0].a(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int a2 = this.k[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int k(int i) {
        int a = this.k[0].a(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int a2 = this.k[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private int l(int i) {
        int b = this.k[0].b(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int b2 = this.k[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private int m(int i) {
        int b = this.k[0].b(i);
        for (int i2 = 1; i2 < this.g; i2++) {
            int b2 = this.k[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void a(tz tzVar, int i) {
        while (m() > 0) {
            View d = d(0);
            if (this.a.b(d) < i) {
                LayoutParams layoutParams = (LayoutParams) d.getLayoutParams();
                if (layoutParams.f) {
                    for (int i2 = 0; i2 < this.g; i2++) {
                        this.k[i2].h();
                    }
                } else {
                    layoutParams.e.h();
                }
                a(d, tzVar);
            } else {
                return;
            }
        }
    }

    private void b(tz tzVar, int i) {
        int m = m() - 1;
        while (m >= 0) {
            View d = d(m);
            if (this.a.a(d) > i) {
                LayoutParams layoutParams = (LayoutParams) d.getLayoutParams();
                if (layoutParams.f) {
                    for (int i2 = 0; i2 < this.g; i2++) {
                        this.k[i2].g();
                    }
                } else {
                    layoutParams.e.g();
                }
                a(d, tzVar);
                m--;
            } else {
                return;
            }
        }
    }

    private boolean n(int i) {
        if (this.l == 0) {
            boolean z;
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.c) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.c) != f()) {
            return false;
        }
        return true;
    }

    private us a(sr srVar) {
        int i;
        int i2;
        us usVar = null;
        int i3 = -1;
        if (n(srVar.d)) {
            i = this.g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.g;
            i3 = 1;
        }
        int c;
        int i4;
        us usVar2;
        int b;
        us usVar3;
        if (srVar.d == 1) {
            c = this.a.c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                usVar2 = this.k[i4];
                b = usVar2.b(c);
                if (b < i) {
                    usVar3 = usVar2;
                } else {
                    b = i;
                    usVar3 = usVar;
                }
                i4 += i3;
                usVar = usVar3;
                i = b;
            }
        } else {
            c = this.a.d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                usVar2 = this.k[i4];
                b = usVar2.a(c);
                if (b > i) {
                    usVar3 = usVar2;
                } else {
                    b = i;
                    usVar3 = usVar;
                }
                i4 += i3;
                usVar = usVar3;
                i = b;
            }
        }
        return usVar;
    }

    public boolean d() {
        return this.l == 1;
    }

    public boolean c() {
        return this.l == 0;
    }

    public int a(int i, tz tzVar, uf ufVar) {
        return c(i, tzVar, ufVar);
    }

    public int b(int i, tz tzVar, uf ufVar) {
        return c(i, tzVar, ufVar);
    }

    private int o(int i) {
        int i2 = -1;
        if (m() != 0) {
            if ((i < C()) == this.c) {
                i2 = 1;
            }
            return i2;
        } else if (this.c) {
            return 1;
        } else {
            return -1;
        }
    }

    int c(int i, tz tzVar, uf ufVar) {
        int i2 = 1;
        int i3 = -1;
        z();
        sr srVar;
        if (i > 0) {
            this.n.d = 1;
            srVar = this.n;
            if (!this.c) {
                i3 = 1;
            }
            srVar.c = i3;
            i3 = B();
        } else {
            this.n.d = -1;
            srVar = this.n;
            if (!this.c) {
                i2 = -1;
            }
            srVar.c = i2;
            i3 = C();
        }
        this.n.b = i3 + this.n.c;
        i2 = Math.abs(i);
        this.n.a = i2;
        this.n.e = k() ? this.a.f() : 0;
        i3 = a(tzVar, this.n, ufVar);
        if (i2 >= i3) {
            i = i < 0 ? -i3 : i3;
        }
        this.a.a(-i);
        this.r = this.c;
        return i;
    }

    private int B() {
        int m = m();
        return m == 0 ? 0 : d(d(m - 1));
    }

    private int C() {
        if (m() == 0) {
            return 0;
        }
        return d(d(0));
    }

    private int p(int i) {
        int m = m();
        for (int i2 = 0; i2 < m; i2++) {
            int d = d(d(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int q(int i) {
        for (int m = m() - 1; m >= 0; m--) {
            int d = d(d(m));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
