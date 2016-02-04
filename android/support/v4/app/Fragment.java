package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import as;
import cs;
import ct;
import es;
import fd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import l;
import m;
import n;
import org.kxml2.wap.Wbxml;
import s;
import u;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final fd a;
    static final Object j;
    public boolean A;
    public int B;
    public u C;
    public FragmentActivity D;
    public u E;
    public Fragment F;
    public int G;
    public int H;
    public String I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public ViewGroup R;
    public View S;
    public View T;
    public boolean U;
    public boolean V;
    public as W;
    boolean X;
    boolean Y;
    Object Z;
    Object aa;
    Object ab;
    Object ac;
    Object ad;
    Object ae;
    Boolean af;
    Boolean ag;
    public cs ah;
    public cs ai;
    public int k;
    public View l;
    public int m;
    public Bundle n;
    public SparseArray o;
    public int p;
    public String q;
    Bundle r;
    public Fragment s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class SavedState implements Parcelable {
        public static final Creator CREATOR;
        final Bundle a;

        public SavedState(Bundle bundle) {
            this.a = bundle;
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader != null && this.a != null) {
                this.a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }

        static {
            CREATOR = new n();
        }
    }

    static {
        a = new fd();
        j = new Object();
    }

    public Fragment() {
        this.k = 0;
        this.p = -1;
        this.t = -1;
        this.O = true;
        this.V = true;
        this.Z = null;
        this.aa = j;
        this.ab = null;
        this.ac = j;
        this.ad = null;
        this.ae = j;
        this.ah = null;
        this.ai = null;
    }

    public static Fragment a(Context context, String str) {
        return a(context, str, null);
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new m("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    public static boolean b(Context context, String str) {
        try {
            Class cls = (Class) a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public final void f(Bundle bundle) {
        if (this.o != null) {
            this.T.restoreHierarchyState(this.o);
            this.o = null;
        }
        this.P = false;
        h(bundle);
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final void a(int i, Fragment fragment) {
        this.p = i;
        if (fragment != null) {
            this.q = fragment.q + ":" + this.p;
        } else {
            this.q = "android:fragment:" + this.p;
        }
    }

    public final boolean f() {
        return this.B > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Wbxml.EXT_T_0);
        es.a(this, stringBuilder);
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.G != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.G));
        }
        if (this.I != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.I);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void g(Bundle bundle) {
        if (this.p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.r = bundle;
    }

    public final Bundle g() {
        return this.r;
    }

    public void a(SavedState savedState) {
        if (this.p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.a == null) ? null : savedState.a;
        this.n = bundle;
    }

    public final FragmentActivity h() {
        return this.D;
    }

    public final Resources i() {
        if (this.D != null) {
            return this.D.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final s j() {
        return this.C;
    }

    public final s k() {
        if (this.E == null) {
            D();
            if (this.k >= 5) {
                this.E.n();
            } else if (this.k >= 4) {
                this.E.m();
            } else if (this.k >= 2) {
                this.E.l();
            } else if (this.k >= 1) {
                this.E.k();
            }
        }
        return this.E;
    }

    public final boolean l() {
        return this.D != null && this.v;
    }

    public final boolean m() {
        return this.K;
    }

    public final boolean n() {
        return (!l() || o() || this.S == null || this.S.getWindowToken() == null || this.S.getVisibility() != 0) ? false : true;
    }

    public final boolean o() {
        return this.J;
    }

    public void b(boolean z) {
    }

    public void c(boolean z) {
        if (this.N != z) {
            this.N = z;
            if (l() && !o()) {
                this.D.d();
            }
        }
    }

    public void d(boolean z) {
        if (this.O != z) {
            this.O = z;
            if (this.N && l() && !o()) {
                this.D.d();
            }
        }
    }

    public void e(boolean z) {
        if (!this.V && z && this.k < 4) {
            this.C.b(this);
        }
        this.V = z;
        this.U = !z;
    }

    public void a(Intent intent) {
        if (this.D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.D.a(this, intent, -1);
    }

    public void a(Intent intent, int i) {
        if (this.D == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.D.a(this, intent, i);
    }

    public void a(int i, int i2, Intent intent) {
    }

    public LayoutInflater b(Bundle bundle) {
        LayoutInflater cloneInContext = this.D.getLayoutInflater().cloneInContext(this.D);
        k();
        cloneInContext.setFactory(this.E.u());
        return cloneInContext;
    }

    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
    }

    public void a(Activity activity) {
        this.P = true;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(Bundle bundle) {
        this.P = true;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void a(View view, Bundle bundle) {
    }

    public View p() {
        return this.S;
    }

    public void d(Bundle bundle) {
        this.P = true;
    }

    public void h(Bundle bundle) {
        this.P = true;
    }

    public void c() {
        this.P = true;
        if (!this.X) {
            this.X = true;
            if (!this.Y) {
                this.Y = true;
                this.W = this.D.a(this.q, this.X, false);
            }
            if (this.W != null) {
                this.W.b();
            }
        }
    }

    public void q() {
        this.P = true;
    }

    public void e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.P = true;
    }

    public void r() {
        this.P = true;
    }

    public void d() {
        this.P = true;
    }

    public void onLowMemory() {
        this.P = true;
    }

    public void e() {
        this.P = true;
    }

    public void s() {
        this.P = true;
        if (!this.Y) {
            this.Y = true;
            this.W = this.D.a(this.q, this.X, false);
        }
        if (this.W != null) {
            this.W.h();
        }
    }

    public void t() {
        this.p = -1;
        this.q = null;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = 0;
        this.C = null;
        this.E = null;
        this.D = null;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = false;
        this.K = false;
        this.M = false;
        this.W = null;
        this.X = false;
        this.Y = false;
    }

    public void b() {
        this.P = true;
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(Menu menu) {
    }

    public void u() {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public void b(Menu menu) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        h().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void a(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public Object v() {
        return this.Z;
    }

    public Object w() {
        return this.aa == j ? v() : this.aa;
    }

    public Object x() {
        return this.ab;
    }

    public Object y() {
        return this.ac == j ? x() : this.ac;
    }

    public Object z() {
        return this.ad;
    }

    public Object A() {
        return this.ae == j ? z() : this.ae;
    }

    public boolean B() {
        return this.ag == null ? true : this.ag.booleanValue();
    }

    public boolean C() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mTag=");
        printWriter.println(this.I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.p);
        printWriter.print(" mWho=");
        printWriter.print(this.q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.w);
        printWriter.print(" mResumed=");
        printWriter.print(this.x);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.y);
        printWriter.print(" mInLayout=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.J);
        printWriter.print(" mDetached=");
        printWriter.print(this.K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.C);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.print("mActivity=");
            printWriter.println(this.D);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.F);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.r);
        }
        if (this.n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.n);
        }
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.o);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.u);
        }
        if (this.Q != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.S);
        }
        if (this.T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.S);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.m);
        }
        if (this.W != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.W.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.E + ":");
            this.E.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void D() {
        this.E = new u();
        this.E.a(this.D, new l(this), this);
    }

    public void i(Bundle bundle) {
        if (this.E != null) {
            this.E.j();
        }
        this.P = false;
        a(bundle);
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.E == null) {
                    D();
                }
                this.E.a(parcelable, null);
                this.E.k();
            }
        }
    }

    public View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.E != null) {
            this.E.j();
        }
        return a(layoutInflater, viewGroup, bundle);
    }

    public void j(Bundle bundle) {
        if (this.E != null) {
            this.E.j();
        }
        this.P = false;
        d(bundle);
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.E != null) {
            this.E.l();
        }
    }

    public void E() {
        if (this.E != null) {
            this.E.j();
            this.E.f();
        }
        this.P = false;
        c();
        if (this.P) {
            if (this.E != null) {
                this.E.m();
            }
            if (this.W != null) {
                this.W.g();
                return;
            }
            return;
        }
        throw new ct("Fragment " + this + " did not call through to super.onStart()");
    }

    public void F() {
        if (this.E != null) {
            this.E.j();
            this.E.f();
        }
        this.P = false;
        q();
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.E != null) {
            this.E.n();
            this.E.f();
        }
    }

    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.E != null) {
            this.E.a(configuration);
        }
    }

    public void G() {
        onLowMemory();
        if (this.E != null) {
            this.E.t();
        }
    }

    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            z = true;
            a(menu, menuInflater);
        }
        if (this.E != null) {
            return z | this.E.a(menu, menuInflater);
        }
        return z;
    }

    public boolean c(Menu menu) {
        boolean z = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            z = true;
            a(menu);
        }
        if (this.E != null) {
            return z | this.E.a(menu);
        }
        return z;
    }

    public boolean c(MenuItem menuItem) {
        if (!this.J) {
            if (this.N && this.O && a(menuItem)) {
                return true;
            }
            if (this.E != null && this.E.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean d(MenuItem menuItem) {
        if (!this.J) {
            if (b(menuItem)) {
                return true;
            }
            if (this.E != null && this.E.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void d(Menu menu) {
        if (!this.J) {
            if (this.N && this.O) {
                b(menu);
            }
            if (this.E != null) {
                this.E.b(menu);
            }
        }
    }

    public void k(Bundle bundle) {
        e(bundle);
        if (this.E != null) {
            Parcelable i = this.E.i();
            if (i != null) {
                bundle.putParcelable("android:support:fragments", i);
            }
        }
    }

    public void H() {
        if (this.E != null) {
            this.E.o();
        }
        this.P = false;
        r();
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void I() {
        if (this.E != null) {
            this.E.p();
        }
        this.P = false;
        d();
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void J() {
        if (this.E != null) {
            this.E.q();
        }
        if (this.X) {
            this.X = false;
            if (!this.Y) {
                this.Y = true;
                this.W = this.D.a(this.q, this.X, false);
            }
            if (this.W == null) {
                return;
            }
            if (this.D.h) {
                this.W.d();
            } else {
                this.W.c();
            }
        }
    }

    public void K() {
        if (this.E != null) {
            this.E.r();
        }
        this.P = false;
        e();
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.W != null) {
            this.W.f();
        }
    }

    public void L() {
        if (this.E != null) {
            this.E.s();
        }
        this.P = false;
        s();
        if (!this.P) {
            throw new ct("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }
}
