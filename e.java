import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import org.kxml2.kdom.Node;
import org.kxml2.wap.Wbxml;

public final class e extends ag implements Runnable {
    final u a;
    public i b;
    i c;
    public int d;
    int e;
    int f;
    int g;
    int h;
    public int i;
    public int j;
    public boolean k;
    boolean l;
    public String m;
    boolean n;
    public int o;
    public int p;
    public CharSequence q;
    public int r;
    public CharSequence s;
    public ArrayList t;
    public ArrayList u;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Wbxml.EXT_T_0);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.o);
        }
        if (this.m != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.m);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.m);
            printWriter.print(" mIndex=");
            printWriter.print(this.o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.n);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.g == 0 && this.h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.q);
            }
            if (!(this.r == 0 && this.s == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.s);
            }
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            i iVar = this.b;
            while (iVar != null) {
                String str3;
                switch (iVar.c) {
                    case ve.CropImageView_guidelines /*0*/:
                        str3 = "NULL";
                        break;
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        str3 = "ADD";
                        break;
                    case ve.CropImageView_aspectRatioX /*2*/:
                        str3 = "REPLACE";
                        break;
                    case ve.CropImageView_aspectRatioY /*3*/:
                        str3 = "REMOVE";
                        break;
                    case ve.CropImageView_imageResource /*4*/:
                        str3 = "HIDE";
                        break;
                    case Node.CDSECT /*5*/:
                        str3 = "SHOW";
                        break;
                    case Node.ENTITY_REF /*6*/:
                        str3 = "DETACH";
                        break;
                    case Node.IGNORABLE_WHITESPACE /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + iVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(iVar.d);
                if (z) {
                    if (!(iVar.e == 0 && iVar.f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(iVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(iVar.f));
                    }
                    if (!(iVar.g == 0 && iVar.h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(iVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(iVar.h));
                    }
                }
                if (iVar.i != null && iVar.i.size() > 0) {
                    for (int i2 = 0; i2 < iVar.i.size(); i2++) {
                        printWriter.print(str2);
                        if (iVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(iVar.i.get(i2));
                    }
                }
                iVar = iVar.a;
                i++;
            }
        }
    }

    public e(u uVar) {
        this.l = true;
        this.o = -1;
        this.a = uVar;
    }

    public void a(i iVar) {
        if (this.b == null) {
            this.c = iVar;
            this.b = iVar;
        } else {
            iVar.b = this.c;
            this.c.a = iVar;
            this.c = iVar;
        }
        iVar.e = this.e;
        iVar.f = this.f;
        iVar.g = this.g;
        iVar.h = this.h;
        this.d++;
    }

    public ag a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public ag a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.C = this.a;
        if (str != null) {
            if (fragment.I == null || str.equals(fragment.I)) {
                fragment.I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.I + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.G == 0 || fragment.G == i) {
                fragment.G = i;
                fragment.H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.G + " now " + i);
            }
        }
        i iVar = new i();
        iVar.c = i2;
        iVar.d = fragment;
        a(iVar);
    }

    public ag b(int i, Fragment fragment) {
        return b(i, fragment, null);
    }

    public ag b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    public ag a(Fragment fragment) {
        i iVar = new i();
        iVar.c = 3;
        iVar.d = fragment;
        a(iVar);
        return this;
    }

    public ag b(Fragment fragment) {
        i iVar = new i();
        iVar.c = 6;
        iVar.d = fragment;
        a(iVar);
        return this;
    }

    public ag c(Fragment fragment) {
        i iVar = new i();
        iVar.c = 7;
        iVar.d = fragment;
        a(iVar);
        return this;
    }

    public ag a(String str) {
        if (this.l) {
            this.k = true;
            this.m = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public ag a() {
        if (this.k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.l = false;
        return this;
    }

    public void a(int i) {
        if (this.k) {
            if (u.a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (i iVar = this.b; iVar != null; iVar = iVar.a) {
                Fragment fragment;
                if (iVar.d != null) {
                    fragment = iVar.d;
                    fragment.B += i;
                    if (u.a) {
                        Log.v("FragmentManager", "Bump nesting of " + iVar.d + " to " + iVar.d.B);
                    }
                }
                if (iVar.i != null) {
                    for (int size = iVar.i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) iVar.i.get(size);
                        fragment.B += i;
                        if (u.a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.B);
                        }
                    }
                }
            }
        }
    }

    public int b() {
        return a(false);
    }

    public int c() {
        return a(true);
    }

    int a(boolean z) {
        if (this.n) {
            throw new IllegalStateException("commit already called");
        }
        if (u.a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", null, new PrintWriter(new et("FragmentManager")), null);
        }
        this.n = true;
        if (this.k) {
            this.o = this.a.a(this);
        } else {
            this.o = -1;
        }
        this.a.a((Runnable) this, z);
        return this.o;
    }

    public void run() {
        if (u.a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.k || this.o >= 0) {
            j a;
            a(1);
            if (VERSION.SDK_INT >= 21) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                b(sparseArray, sparseArray2);
                a = a(sparseArray, sparseArray2, false);
            } else {
                Object obj = null;
            }
            int i = a != null ? 0 : this.j;
            int i2 = a != null ? 0 : this.i;
            i iVar = this.b;
            while (iVar != null) {
                int i3 = a != null ? 0 : iVar.e;
                int i4 = a != null ? 0 : iVar.f;
                Fragment fragment;
                switch (iVar.c) {
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        fragment = iVar.d;
                        fragment.Q = i3;
                        this.a.a(fragment, false);
                        break;
                    case ve.CropImageView_aspectRatioX /*2*/:
                        Fragment fragment2;
                        fragment = iVar.d;
                        if (this.a.g != null) {
                            fragment2 = fragment;
                            for (int i5 = 0; i5 < this.a.g.size(); i5++) {
                                fragment = (Fragment) this.a.g.get(i5);
                                if (u.a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment2 == null || fragment.H == fragment2.H) {
                                    if (fragment == fragment2) {
                                        iVar.d = null;
                                        fragment2 = null;
                                    } else {
                                        if (iVar.i == null) {
                                            iVar.i = new ArrayList();
                                        }
                                        iVar.i.add(fragment);
                                        fragment.Q = i4;
                                        if (this.k) {
                                            fragment.B++;
                                            if (u.a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.B);
                                            }
                                        }
                                        this.a.a(fragment, i2, i);
                                    }
                                }
                            }
                        } else {
                            fragment2 = fragment;
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.Q = i3;
                        this.a.a(fragment2, false);
                        break;
                    case ve.CropImageView_aspectRatioY /*3*/:
                        fragment = iVar.d;
                        fragment.Q = i4;
                        this.a.a(fragment, i2, i);
                        break;
                    case ve.CropImageView_imageResource /*4*/:
                        fragment = iVar.d;
                        fragment.Q = i4;
                        this.a.b(fragment, i2, i);
                        break;
                    case Node.CDSECT /*5*/:
                        fragment = iVar.d;
                        fragment.Q = i3;
                        this.a.c(fragment, i2, i);
                        break;
                    case Node.ENTITY_REF /*6*/:
                        fragment = iVar.d;
                        fragment.Q = i4;
                        this.a.d(fragment, i2, i);
                        break;
                    case Node.IGNORABLE_WHITESPACE /*7*/:
                        fragment = iVar.d;
                        fragment.Q = i3;
                        this.a.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + iVar.c);
                }
                iVar = iVar.a;
            }
            this.a.a(this.a.n, i2, i, true);
            if (this.k) {
                this.a.b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.H;
            if (i != 0 && !fragment.o() && fragment.l() && fragment.p() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void b(SparseArray sparseArray, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.H;
            if (i != 0) {
                sparseArray.put(i, fragment);
            }
        }
    }

    private void b(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.a.p.a()) {
            for (i iVar = this.b; iVar != null; iVar = iVar.a) {
                switch (iVar.c) {
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        b(sparseArray2, iVar.d);
                        break;
                    case ve.CropImageView_aspectRatioX /*2*/:
                        Fragment fragment;
                        Fragment fragment2 = iVar.d;
                        if (this.a.g != null) {
                            fragment = fragment2;
                            for (int i = 0; i < this.a.g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.a.g.get(i);
                                if (fragment == null || fragment3.H == fragment.H) {
                                    if (fragment3 == fragment) {
                                        fragment = null;
                                    } else {
                                        a(sparseArray, fragment3);
                                    }
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        b(sparseArray2, fragment);
                        break;
                    case ve.CropImageView_aspectRatioY /*3*/:
                        a(sparseArray, iVar.d);
                        break;
                    case ve.CropImageView_imageResource /*4*/:
                        a(sparseArray, iVar.d);
                        break;
                    case Node.CDSECT /*5*/:
                        b(sparseArray2, iVar.d);
                        break;
                    case Node.ENTITY_REF /*6*/:
                        a(sparseArray, iVar.d);
                        break;
                    case Node.IGNORABLE_WHITESPACE /*7*/:
                        b(sparseArray2, iVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void a(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.a.p.a()) {
            for (i iVar = this.b; iVar != null; iVar = iVar.a) {
                switch (iVar.c) {
                    case ve.CropImageView_fixAspectRatio /*1*/:
                        a(sparseArray, iVar.d);
                        break;
                    case ve.CropImageView_aspectRatioX /*2*/:
                        if (iVar.i != null) {
                            for (int size = iVar.i.size() - 1; size >= 0; size--) {
                                b(sparseArray2, (Fragment) iVar.i.get(size));
                            }
                        }
                        a(sparseArray, iVar.d);
                        break;
                    case ve.CropImageView_aspectRatioY /*3*/:
                        b(sparseArray2, iVar.d);
                        break;
                    case ve.CropImageView_imageResource /*4*/:
                        b(sparseArray2, iVar.d);
                        break;
                    case Node.CDSECT /*5*/:
                        a(sparseArray, iVar.d);
                        break;
                    case Node.ENTITY_REF /*6*/:
                        b(sparseArray2, iVar.d);
                        break;
                    case Node.IGNORABLE_WHITESPACE /*7*/:
                        a(sparseArray, iVar.d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public j a(boolean z, j jVar, SparseArray sparseArray, SparseArray sparseArray2) {
        if (u.a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", null, new PrintWriter(new et("FragmentManager")), null);
        }
        if (jVar == null) {
            if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                jVar = a(sparseArray, sparseArray2, true);
            }
        } else if (!z) {
            a(jVar, this.u, this.t);
        }
        a(-1);
        int i = jVar != null ? 0 : this.j;
        int i2 = jVar != null ? 0 : this.i;
        i iVar = this.c;
        while (iVar != null) {
            int i3 = jVar != null ? 0 : iVar.g;
            int i4 = jVar != null ? 0 : iVar.h;
            Fragment fragment;
            Fragment fragment2;
            switch (iVar.c) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    fragment = iVar.d;
                    fragment.Q = i4;
                    this.a.a(fragment, u.c(i2), i);
                    break;
                case ve.CropImageView_aspectRatioX /*2*/:
                    fragment = iVar.d;
                    if (fragment != null) {
                        fragment.Q = i4;
                        this.a.a(fragment, u.c(i2), i);
                    }
                    if (iVar.i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < iVar.i.size(); i5++) {
                        fragment2 = (Fragment) iVar.i.get(i5);
                        fragment2.Q = i3;
                        this.a.a(fragment2, false);
                    }
                    break;
                case ve.CropImageView_aspectRatioY /*3*/:
                    fragment2 = iVar.d;
                    fragment2.Q = i3;
                    this.a.a(fragment2, false);
                    break;
                case ve.CropImageView_imageResource /*4*/:
                    fragment2 = iVar.d;
                    fragment2.Q = i3;
                    this.a.c(fragment2, u.c(i2), i);
                    break;
                case Node.CDSECT /*5*/:
                    fragment = iVar.d;
                    fragment.Q = i4;
                    this.a.b(fragment, u.c(i2), i);
                    break;
                case Node.ENTITY_REF /*6*/:
                    fragment2 = iVar.d;
                    fragment2.Q = i3;
                    this.a.e(fragment2, u.c(i2), i);
                    break;
                case Node.IGNORABLE_WHITESPACE /*7*/:
                    fragment2 = iVar.d;
                    fragment2.Q = i3;
                    this.a.d(fragment2, u.c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + iVar.c);
            }
            iVar = iVar.b;
        }
        if (z) {
            this.a.a(this.a.n, u.c(i2), i, true);
            jVar = null;
        }
        if (this.o >= 0) {
            this.a.b(this.o);
            this.o = -1;
        }
        return jVar;
    }

    public String d() {
        return this.m;
    }

    public boolean e() {
        return this.d == 0;
    }

    private j a(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        int i = 0;
        j jVar = new j(this);
        jVar.d = new View(this.a.o);
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4;
            if (a(sparseArray.keyAt(i2), jVar, z, sparseArray, sparseArray2)) {
                i4 = 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && a(i4, jVar, z, sparseArray, sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        if (i3 == 0) {
            return null;
        }
        return jVar;
    }

    private static Object a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ah.a(z ? fragment.y() : fragment.v());
    }

    private static Object b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return ah.a(z ? fragment.w() : fragment.x());
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return ah.a(z ? fragment2.A() : fragment.z());
    }

    private static Object a(Object obj, Fragment fragment, ArrayList arrayList, ep epVar) {
        if (obj != null) {
            return ah.a(obj, fragment.p(), arrayList, (Map) epVar);
        }
        return obj;
    }

    private ep a(j jVar, Fragment fragment, boolean z) {
        ep epVar = new ep();
        if (this.t != null) {
            ah.a((Map) epVar, fragment.p());
            if (z) {
                epVar.a(this.u);
            } else {
                epVar = a(this.t, this.u, epVar);
            }
        }
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.a(this.u, epVar);
            }
            a(jVar, epVar, false);
        } else {
            if (fragment.ai != null) {
                fragment.ai.a(this.u, epVar);
            }
            b(jVar, epVar, false);
        }
        return epVar;
    }

    private boolean a(int i, j jVar, boolean z, SparseArray sparseArray, SparseArray sparseArray2) {
        View view = (ViewGroup) this.a.p.a(i);
        if (view == null) {
            return false;
        }
        Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a = a(fragment, z);
        Object a2 = a(fragment, fragment2, z);
        Object b = b(fragment2, z);
        if (a == null && a2 == null && b == null) {
            return false;
        }
        ep epVar = null;
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            epVar = a(jVar, fragment2, z);
            if (epVar.isEmpty()) {
                arrayList.add(jVar.d);
            } else {
                arrayList.addAll(epVar.values());
            }
            cs csVar = z ? fragment2.ah : fragment.ah;
            if (csVar != null) {
                csVar.a(new ArrayList(epVar.keySet()), new ArrayList(epVar.values()), null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Object a3 = a(b, fragment2, arrayList2, epVar);
        if (!(this.u == null || epVar == null)) {
            View view2 = (View) epVar.get(this.u.get(0));
            if (view2 != null) {
                if (a3 != null) {
                    ah.a(a3, view2);
                }
                if (a2 != null) {
                    ah.a(a2, view2);
                }
            }
        }
        an fVar = new f(this, fragment);
        if (a2 != null) {
            a(jVar, view, a2, fragment, fragment2, z, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        Map epVar2 = new ep();
        Object a4 = ah.a(a, a3, a2, z ? fragment.C() : fragment.B());
        if (a4 != null) {
            ah.a(a, a2, view, fVar, jVar.d, jVar.c, jVar.a, arrayList3, epVar2, arrayList);
            a(view, jVar, i, a4);
            ah.a(a4, jVar.d, true);
            a(jVar, i, a4);
            ah.a((ViewGroup) view, a4);
            ah.a(view, jVar.d, a, arrayList3, a3, arrayList2, a2, arrayList, a4, jVar.b, epVar2);
        }
        if (a4 != null) {
            return true;
        }
        return false;
    }

    private void a(j jVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new g(this, view, obj, arrayList, jVar, z, fragment, fragment2));
    }

    private void a(j jVar, Fragment fragment, Fragment fragment2, boolean z, ep epVar) {
        cs csVar = z ? fragment2.ah : fragment.ah;
        if (csVar != null) {
            csVar.b(new ArrayList(epVar.keySet()), new ArrayList(epVar.values()), null);
        }
    }

    private void a(ep epVar, j jVar) {
        if (this.u != null && !epVar.isEmpty()) {
            View view = (View) epVar.get(this.u.get(0));
            if (view != null) {
                jVar.c.a = view;
            }
        }
    }

    private ep a(j jVar, boolean z, Fragment fragment) {
        ep b = b(jVar, fragment, z);
        if (z) {
            if (fragment.ai != null) {
                fragment.ai.a(this.u, b);
            }
            a(jVar, b, true);
        } else {
            if (fragment.ah != null) {
                fragment.ah.a(this.u, b);
            }
            b(jVar, b, true);
        }
        return b;
    }

    private static ep a(ArrayList arrayList, ArrayList arrayList2, ep epVar) {
        if (epVar.isEmpty()) {
            return epVar;
        }
        ep epVar2 = new ep();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) epVar.get(arrayList.get(i));
            if (view != null) {
                epVar2.put(arrayList2.get(i), view);
            }
        }
        return epVar2;
    }

    private ep b(j jVar, Fragment fragment, boolean z) {
        ep epVar = new ep();
        View p = fragment.p();
        if (p == null || this.t == null) {
            return epVar;
        }
        ah.a((Map) epVar, p);
        if (z) {
            return a(this.t, this.u, epVar);
        }
        epVar.a(this.u);
        return epVar;
    }

    private void a(View view, j jVar, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new h(this, view, jVar, i, obj));
    }

    private void a(j jVar, int i, Object obj) {
        if (this.a.g != null) {
            for (int i2 = 0; i2 < this.a.g.size(); i2++) {
                Fragment fragment = (Fragment) this.a.g.get(i2);
                if (!(fragment.S == null || fragment.R == null || fragment.H != i)) {
                    if (!fragment.J) {
                        ah.a(obj, fragment.S, false);
                        jVar.b.remove(fragment.S);
                    } else if (!jVar.b.contains(fragment.S)) {
                        ah.a(obj, fragment.S, true);
                        jVar.b.add(fragment.S);
                    }
                }
            }
        }
    }

    private static void a(ep epVar, String str, String str2) {
        if (str != null && str2 != null && !str.equals(str2)) {
            for (int i = 0; i < epVar.size(); i++) {
                if (str.equals(epVar.c(i))) {
                    epVar.a(i, (Object) str2);
                    return;
                }
            }
            epVar.put(str, str2);
        }
    }

    private static void a(j jVar, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                a(jVar.a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void a(j jVar, ep epVar, boolean z) {
        int size = this.u == null ? 0 : this.u.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.t.get(i);
            View view = (View) epVar.get((String) this.u.get(i));
            if (view != null) {
                String a = ah.a(view);
                if (z) {
                    a(jVar.a, str, a);
                } else {
                    a(jVar.a, a, str);
                }
            }
        }
    }

    private void b(j jVar, ep epVar, boolean z) {
        int size = epVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) epVar.b(i);
            String a = ah.a((View) epVar.c(i));
            if (z) {
                a(jVar.a, str, a);
            } else {
                a(jVar.a, a, str);
            }
        }
    }
}
