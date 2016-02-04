import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import org.kxml2.kdom.Node;
import org.kxml2.wap.Wbxml;

public final class u extends s implements Factory {
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;
    public static boolean a;
    static final boolean b;
    static final Interpolator z;
    ArrayList c;
    Runnable[] d;
    boolean e;
    public ArrayList f;
    ArrayList g;
    ArrayList h;
    ArrayList i;
    ArrayList j;
    ArrayList k;
    ArrayList l;
    ArrayList m;
    int n;
    FragmentActivity o;
    r p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    Bundle w;
    SparseArray x;
    Runnable y;

    public u() {
        this.n = 0;
        this.w = null;
        this.x = null;
        this.y = new v(this);
    }

    static {
        boolean z = false;
        a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        b = z;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        B = new AccelerateInterpolator(2.5f);
        C = new AccelerateInterpolator(1.5f);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new et("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.dump("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public ag a() {
        return new e(this);
    }

    public boolean b() {
        return f();
    }

    public void c() {
        a(new w(this), false);
    }

    public boolean d() {
        v();
        b();
        return a(this.o.a, null, -1, 0);
    }

    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a(new x(this, i, i2), false);
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.p < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.p);
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public SavedState a(Fragment fragment) {
        if (fragment.p < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.k <= 0) {
            return null;
        }
        Bundle g = g(fragment);
        if (g != null) {
            return new SavedState(g);
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Wbxml.EXT_T_0);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.q != null) {
            es.a(this.q, stringBuilder);
        } else {
            es.a(this.o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f != null) {
            size = this.f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    Fragment fragment;
                    fragment = (Fragment) this.f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.a(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.g != null) {
            size = this.g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.j != null) {
            size = this.j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.i != null) {
            size = this.i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    e eVar = (e) this.i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(eVar.toString());
                    eVar.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.k != null) {
                int size2 = this.k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        eVar = (e) this.k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(eVar);
                    }
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null) {
            i = this.c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(z);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation a(Fragment fragment, int i, boolean z, int i2) {
        Animation a = fragment.a(i, z, fragment.Q);
        if (a != null) {
            return a;
        }
        if (fragment.Q != 0) {
            a = AnimationUtils.loadAnimation(this.o, fragment.Q);
            if (a != null) {
                return a;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return a(this.o, 1.125f, 1.0f, 0.0f, 1.0f);
            case ve.CropImageView_aspectRatioX /*2*/:
                return a(this.o, 1.0f, 0.975f, 1.0f, 0.0f);
            case ve.CropImageView_aspectRatioY /*3*/:
                return a(this.o, 0.975f, 1.0f, 0.0f, 1.0f);
            case ve.CropImageView_imageResource /*4*/:
                return a(this.o, 1.0f, 1.075f, 1.0f, 0.0f);
            case Node.CDSECT /*5*/:
                return a(this.o, 0.0f, 1.0f);
            case Node.ENTITY_REF /*6*/:
                return a(this.o, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.o.getWindow() != null) {
                    i2 = this.o.getWindow().getAttributes().windowAnimations;
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void b(Fragment fragment) {
        if (!fragment.U) {
            return;
        }
        if (this.e) {
            this.v = true;
            return;
        }
        fragment.U = false;
        a(fragment, this.n, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
        r9 = this;
        r8 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r10.v;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r10.K;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r11 <= r5) goto L_0x0010;
    L_0x000f:
        r11 = r5;
    L_0x0010:
        r0 = r10.w;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r10.k;
        if (r11 <= r0) goto L_0x001a;
    L_0x0018:
        r11 = r10.k;
    L_0x001a:
        r0 = r10.U;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r10.k;
        if (r0 >= r8) goto L_0x0025;
    L_0x0022:
        if (r11 <= r6) goto L_0x0025;
    L_0x0024:
        r11 = r6;
    L_0x0025:
        r0 = r10.k;
        if (r0 >= r11) goto L_0x024b;
    L_0x0029:
        r0 = r10.y;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r10.z;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r10.l;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r10.l = r7;
        r2 = r10.m;
        r0 = r9;
        r1 = r10;
        r4 = r3;
        r0.a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r10.k;
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0131;
            case 2: goto L_0x01fa;
            case 3: goto L_0x01fa;
            case 4: goto L_0x021b;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.k = r11;
        goto L_0x0031;
    L_0x0048:
        r0 = a;
        if (r0 == 0) goto L_0x0064;
    L_0x004c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0064:
        r0 = r10.n;
        if (r0 == 0) goto L_0x00a8;
    L_0x0068:
        r0 = r10.n;
        r1 = r9.o;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r10.n;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r10.o = r0;
        r0 = r10.n;
        r1 = "android:target_state";
        r0 = r9.a(r0, r1);
        r10.s = r0;
        r0 = r10.s;
        if (r0 == 0) goto L_0x0095;
    L_0x008b:
        r0 = r10.n;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r10.u = r0;
    L_0x0095:
        r0 = r10.n;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r10.V = r0;
        r0 = r10.V;
        if (r0 != 0) goto L_0x00a8;
    L_0x00a3:
        r10.U = r5;
        if (r11 <= r6) goto L_0x00a8;
    L_0x00a7:
        r11 = r6;
    L_0x00a8:
        r0 = r9.o;
        r10.D = r0;
        r0 = r9.q;
        r10.F = r0;
        r0 = r9.q;
        if (r0 == 0) goto L_0x00e4;
    L_0x00b4:
        r0 = r9.q;
        r0 = r0.E;
    L_0x00b8:
        r10.C = r0;
        r10.P = r3;
        r0 = r9.o;
        r10.a(r0);
        r0 = r10.P;
        if (r0 != 0) goto L_0x00e9;
    L_0x00c5:
        r0 = new ct;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e4:
        r0 = r9.o;
        r0 = r0.b;
        goto L_0x00b8;
    L_0x00e9:
        r0 = r10.F;
        if (r0 != 0) goto L_0x00f2;
    L_0x00ed:
        r0 = r9.o;
        r0.a(r10);
    L_0x00f2:
        r0 = r10.M;
        if (r0 != 0) goto L_0x00fb;
    L_0x00f6:
        r0 = r10.n;
        r10.i(r0);
    L_0x00fb:
        r10.M = r3;
        r0 = r10.y;
        if (r0 == 0) goto L_0x0131;
    L_0x0101:
        r0 = r10.n;
        r0 = r10.b(r0);
        r1 = r10.n;
        r0 = r10.b(r0, r7, r1);
        r10.S = r0;
        r0 = r10.S;
        if (r0 == 0) goto L_0x0244;
    L_0x0113:
        r0 = r10.S;
        r10.T = r0;
        r0 = r10.S;
        r0 = az.a(r0);
        r10.S = r0;
        r0 = r10.J;
        if (r0 == 0) goto L_0x012a;
    L_0x0123:
        r0 = r10.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x012a:
        r0 = r10.S;
        r1 = r10.n;
        r10.a(r0, r1);
    L_0x0131:
        if (r11 <= r5) goto L_0x01fa;
    L_0x0133:
        r0 = a;
        if (r0 == 0) goto L_0x014f;
    L_0x0137:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x014f:
        r0 = r10.y;
        if (r0 != 0) goto L_0x01ea;
    L_0x0153:
        r0 = r10.H;
        if (r0 == 0) goto L_0x03a6;
    L_0x0157:
        r0 = r9.p;
        r1 = r10.H;
        r0 = r0.a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01a6;
    L_0x0163:
        r1 = r10.A;
        if (r1 != 0) goto L_0x01a6;
    L_0x0167:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "No view found for id 0x";
        r2 = r2.append(r3);
        r3 = r10.H;
        r3 = java.lang.Integer.toHexString(r3);
        r2 = r2.append(r3);
        r3 = " (";
        r2 = r2.append(r3);
        r3 = r10.i();
        r4 = r10.H;
        r3 = r3.getResourceName(r4);
        r2 = r2.append(r3);
        r3 = ") for fragment ";
        r2 = r2.append(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        r1.<init>(r2);
        r9.a(r1);
    L_0x01a6:
        r10.R = r0;
        r1 = r10.n;
        r1 = r10.b(r1);
        r2 = r10.n;
        r1 = r10.b(r1, r0, r2);
        r10.S = r1;
        r1 = r10.S;
        if (r1 == 0) goto L_0x0248;
    L_0x01ba:
        r1 = r10.S;
        r10.T = r1;
        r1 = r10.S;
        r1 = az.a(r1);
        r10.S = r1;
        if (r0 == 0) goto L_0x01d8;
    L_0x01c8:
        r1 = r9.a(r10, r12, r5, r13);
        if (r1 == 0) goto L_0x01d3;
    L_0x01ce:
        r2 = r10.S;
        r2.startAnimation(r1);
    L_0x01d3:
        r1 = r10.S;
        r0.addView(r1);
    L_0x01d8:
        r0 = r10.J;
        if (r0 == 0) goto L_0x01e3;
    L_0x01dc:
        r0 = r10.S;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01e3:
        r0 = r10.S;
        r1 = r10.n;
        r10.a(r0, r1);
    L_0x01ea:
        r0 = r10.n;
        r10.j(r0);
        r0 = r10.S;
        if (r0 == 0) goto L_0x01f8;
    L_0x01f3:
        r0 = r10.n;
        r10.f(r0);
    L_0x01f8:
        r10.n = r7;
    L_0x01fa:
        if (r11 <= r6) goto L_0x021b;
    L_0x01fc:
        r0 = a;
        if (r0 == 0) goto L_0x0218;
    L_0x0200:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0218:
        r10.E();
    L_0x021b:
        if (r11 <= r8) goto L_0x0045;
    L_0x021d:
        r0 = a;
        if (r0 == 0) goto L_0x0239;
    L_0x0221:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0239:
        r10.x = r5;
        r10.F();
        r10.n = r7;
        r10.o = r7;
        goto L_0x0045;
    L_0x0244:
        r10.T = r7;
        goto L_0x0131;
    L_0x0248:
        r10.T = r7;
        goto L_0x01ea;
    L_0x024b:
        r0 = r10.k;
        if (r0 <= r11) goto L_0x0045;
    L_0x024f:
        r0 = r10.k;
        switch(r0) {
            case 1: goto L_0x0256;
            case 2: goto L_0x02d6;
            case 3: goto L_0x02b5;
            case 4: goto L_0x0294;
            case 5: goto L_0x0270;
            default: goto L_0x0254;
        };
    L_0x0254:
        goto L_0x0045;
    L_0x0256:
        if (r11 >= r5) goto L_0x0045;
    L_0x0258:
        r0 = r9.t;
        if (r0 == 0) goto L_0x0267;
    L_0x025c:
        r0 = r10.l;
        if (r0 == 0) goto L_0x0267;
    L_0x0260:
        r0 = r10.l;
        r10.l = r7;
        r0.clearAnimation();
    L_0x0267:
        r0 = r10.l;
        if (r0 == 0) goto L_0x0343;
    L_0x026b:
        r10.m = r11;
        r11 = r5;
        goto L_0x0045;
    L_0x0270:
        r0 = 5;
        if (r11 >= r0) goto L_0x0294;
    L_0x0273:
        r0 = a;
        if (r0 == 0) goto L_0x028f;
    L_0x0277:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x028f:
        r10.H();
        r10.x = r3;
    L_0x0294:
        if (r11 >= r8) goto L_0x02b5;
    L_0x0296:
        r0 = a;
        if (r0 == 0) goto L_0x02b2;
    L_0x029a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b2:
        r10.I();
    L_0x02b5:
        if (r11 >= r6) goto L_0x02d6;
    L_0x02b7:
        r0 = a;
        if (r0 == 0) goto L_0x02d3;
    L_0x02bb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02d3:
        r10.J();
    L_0x02d6:
        r0 = 2;
        if (r11 >= r0) goto L_0x0256;
    L_0x02d9:
        r0 = a;
        if (r0 == 0) goto L_0x02f5;
    L_0x02dd:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f5:
        r0 = r10.S;
        if (r0 == 0) goto L_0x0308;
    L_0x02f9:
        r0 = r9.o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0308;
    L_0x0301:
        r0 = r10.o;
        if (r0 != 0) goto L_0x0308;
    L_0x0305:
        r9.f(r10);
    L_0x0308:
        r10.K();
        r0 = r10.S;
        if (r0 == 0) goto L_0x033b;
    L_0x030f:
        r0 = r10.R;
        if (r0 == 0) goto L_0x033b;
    L_0x0313:
        r0 = r9.n;
        if (r0 <= 0) goto L_0x03a3;
    L_0x0317:
        r0 = r9.t;
        if (r0 != 0) goto L_0x03a3;
    L_0x031b:
        r0 = r9.a(r10, r12, r3, r13);
    L_0x031f:
        if (r0 == 0) goto L_0x0334;
    L_0x0321:
        r1 = r10.S;
        r10.l = r1;
        r10.m = r11;
        r1 = new y;
        r1.<init>(r9, r10);
        r0.setAnimationListener(r1);
        r1 = r10.S;
        r1.startAnimation(r0);
    L_0x0334:
        r0 = r10.R;
        r1 = r10.S;
        r0.removeView(r1);
    L_0x033b:
        r10.R = r7;
        r10.S = r7;
        r10.T = r7;
        goto L_0x0256;
    L_0x0343:
        r0 = a;
        if (r0 == 0) goto L_0x035f;
    L_0x0347:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x035f:
        r0 = r10.M;
        if (r0 != 0) goto L_0x0366;
    L_0x0363:
        r10.L();
    L_0x0366:
        r10.P = r3;
        r10.b();
        r0 = r10.P;
        if (r0 != 0) goto L_0x038e;
    L_0x036f:
        r0 = new ct;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x038e:
        if (r14 != 0) goto L_0x0045;
    L_0x0390:
        r0 = r10.M;
        if (r0 != 0) goto L_0x0399;
    L_0x0394:
        r9.e(r10);
        goto L_0x0045;
    L_0x0399:
        r10.D = r7;
        r10.F = r7;
        r10.C = r7;
        r10.E = r7;
        goto L_0x0045;
    L_0x03a3:
        r0 = r7;
        goto L_0x031f;
    L_0x03a6:
        r0 = r7;
        goto L_0x01a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: u.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void c(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    void a(int i, boolean z) {
        a(i, 0, 0, z);
    }

    void a(int i, int i2, int i3, boolean z) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.W != null) {
                            a = i5 | fragment.W.a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    e();
                }
                if (this.r && this.o != null && this.n == 5) {
                    this.o.d();
                    this.r = false;
                }
            }
        }
    }

    void e() {
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null) {
                    b(fragment);
                }
            }
        }
    }

    void d(Fragment fragment) {
        if (fragment.p < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList();
                }
                fragment.a(this.f.size(), this.q);
                this.f.add(fragment);
            } else {
                fragment.a(((Integer) this.h.remove(this.h.size() - 1)).intValue(), this.q);
                this.f.set(fragment.p, fragment);
            }
            if (a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void e(Fragment fragment) {
        if (fragment.p >= 0) {
            if (a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f.set(fragment.p, null);
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.add(Integer.valueOf(fragment.p));
            this.o.a(fragment.q);
            fragment.t();
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        d(fragment);
        if (!fragment.K) {
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.g.add(fragment);
            fragment.v = true;
            fragment.w = false;
            if (fragment.N && fragment.O) {
                this.r = true;
            }
            if (z) {
                c(fragment);
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.B);
        }
        boolean z = !fragment.f();
        if (!fragment.K || z) {
            int i3;
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.N && fragment.O) {
                this.r = true;
            }
            fragment.v = false;
            fragment.w = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            a(fragment, i3, i, i2, false);
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.J) {
            fragment.J = true;
            if (fragment.S != null) {
                Animation a = a(fragment, i, false, i2);
                if (a != null) {
                    fragment.S.startAnimation(a);
                }
                fragment.S.setVisibility(8);
            }
            if (fragment.v && fragment.N && fragment.O) {
                this.r = true;
            }
            fragment.b(true);
        }
    }

    public void c(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.J) {
            fragment.J = false;
            if (fragment.S != null) {
                Animation a = a(fragment, i, true, i2);
                if (a != null) {
                    fragment.S.startAnimation(a);
                }
                fragment.S.setVisibility(0);
            }
            if (fragment.v && fragment.N && fragment.O) {
                this.r = true;
            }
            fragment.b(false);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.K) {
            fragment.K = true;
            if (fragment.v) {
                if (this.g != null) {
                    if (a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.g.remove(fragment);
                }
                if (fragment.N && fragment.O) {
                    this.r = true;
                }
                fragment.v = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.K) {
            fragment.K = false;
            if (!fragment.v) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (this.g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.g.add(fragment);
                fragment.v = true;
                if (fragment.N && fragment.O) {
                    this.r = true;
                }
                a(fragment, this.n, i, i2, false);
            }
        }
    }

    public Fragment a(int i) {
        int size;
        Fragment fragment;
        if (this.g != null) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && fragment.G == i) {
                    return fragment;
                }
            }
        }
        if (this.f != null) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && fragment.G == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment a(String str) {
        int size;
        Fragment fragment;
        if (!(this.g == null || str == null)) {
            for (size = this.g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.g.get(size);
                if (fragment != null && str.equals(fragment.I)) {
                    return fragment;
                }
            }
        }
        if (!(this.f == null || str == null)) {
            for (size = this.f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f.get(size);
                if (fragment != null && str.equals(fragment.I)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    private void v() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    public void a(Runnable runnable, boolean z) {
        if (!z) {
            v();
        }
        synchronized (this) {
            if (this.t || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.a.removeCallbacks(this.y);
                this.o.a.post(this.y);
            }
        }
    }

    public int a(e eVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                }
                size = this.k.size();
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
                }
                this.k.add(eVar);
            } else {
                size = ((Integer) this.l.remove(this.l.size() - 1)).intValue();
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + eVar);
                }
                this.k.set(size, eVar);
            }
        }
        return size;
    }

    public void a(int i, e eVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            int size = this.k.size();
            if (i < size) {
                if (a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + eVar);
                }
                this.k.set(i, eVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList();
                    }
                    if (a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + eVar);
                }
                this.k.add(eVar);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.o;
        r3 = r3.a;
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0024;
    L_0x001c:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0024:
        r1 = r2;
    L_0x0025:
        monitor-enter(r6);
        r3 = r6.c;	 Catch:{ all -> 0x0097 }
        if (r3 == 0) goto L_0x0032;
    L_0x002a:
        r3 = r6.c;	 Catch:{ all -> 0x0097 }
        r3 = r3.size();	 Catch:{ all -> 0x0097 }
        if (r3 != 0) goto L_0x005a;
    L_0x0032:
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r0 = r6.v;
        if (r0 == 0) goto L_0x00a5;
    L_0x0037:
        r3 = r2;
        r4 = r2;
    L_0x0039:
        r0 = r6.f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x009e;
    L_0x0041:
        r0 = r6.f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r5 = r0.W;
        if (r5 == 0) goto L_0x0056;
    L_0x004f:
        r0 = r0.W;
        r0 = r0.a();
        r4 = r4 | r0;
    L_0x0056:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0039;
    L_0x005a:
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r3 = r1.size();	 Catch:{ all -> 0x0097 }
        r1 = r6.d;	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0069;
    L_0x0064:
        r1 = r6.d;	 Catch:{ all -> 0x0097 }
        r1 = r1.length;	 Catch:{ all -> 0x0097 }
        if (r1 >= r3) goto L_0x006d;
    L_0x0069:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0097 }
        r6.d = r1;	 Catch:{ all -> 0x0097 }
    L_0x006d:
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r4 = r6.d;	 Catch:{ all -> 0x0097 }
        r1.toArray(r4);	 Catch:{ all -> 0x0097 }
        r1 = r6.c;	 Catch:{ all -> 0x0097 }
        r1.clear();	 Catch:{ all -> 0x0097 }
        r1 = r6.o;	 Catch:{ all -> 0x0097 }
        r1 = r1.a;	 Catch:{ all -> 0x0097 }
        r4 = r6.y;	 Catch:{ all -> 0x0097 }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x0097 }
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        r6.e = r0;
        r1 = r2;
    L_0x0086:
        if (r1 >= r3) goto L_0x009a;
    L_0x0088:
        r4 = r6.d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x0086;
    L_0x0097:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0097 }
        throw r0;
    L_0x009a:
        r6.e = r2;
        r1 = r0;
        goto L_0x0025;
    L_0x009e:
        if (r4 != 0) goto L_0x00a5;
    L_0x00a0:
        r6.v = r2;
        r6.e();
    L_0x00a5:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f():boolean");
    }

    void g() {
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                ((t) this.m.get(i)).a();
            }
        }
    }

    void b(e eVar) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(eVar);
        g();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x0037;
    L_0x000a:
        if (r14 >= 0) goto L_0x0037;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x0037;
    L_0x0010:
        r0 = r11.i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.i;
        r0 = r1.remove(r0);
        r0 = (e) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r0.a(r1, r3);
        r0.a(r2, r4, r1, r3);
        r11.g();
    L_0x0035:
        r3 = r2;
        goto L_0x0007;
    L_0x0037:
        r0 = -1;
        if (r13 != 0) goto L_0x003c;
    L_0x003a:
        if (r14 < 0) goto L_0x008b;
    L_0x003c:
        r0 = r11.i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0044:
        if (r1 < 0) goto L_0x005a;
    L_0x0046:
        r0 = r11.i;
        r0 = r0.get(r1);
        r0 = (e) r0;
        if (r13 == 0) goto L_0x0081;
    L_0x0050:
        r5 = r0.d();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x005a:
        if (r1 < 0) goto L_0x0007;
    L_0x005c:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008a;
    L_0x0060:
        r1 = r1 + -1;
    L_0x0062:
        if (r1 < 0) goto L_0x008a;
    L_0x0064:
        r0 = r11.i;
        r0 = r0.get(r1);
        r0 = (e) r0;
        if (r13 == 0) goto L_0x0078;
    L_0x006e:
        r5 = r0.d();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x007e;
    L_0x0078:
        if (r14 < 0) goto L_0x008a;
    L_0x007a:
        r0 = r0.o;
        if (r14 != r0) goto L_0x008a;
    L_0x007e:
        r1 = r1 + -1;
        goto L_0x0062;
    L_0x0081:
        if (r14 < 0) goto L_0x0087;
    L_0x0083:
        r0 = r0.o;
        if (r14 == r0) goto L_0x005a;
    L_0x0087:
        r1 = r1 + -1;
        goto L_0x0044;
    L_0x008a:
        r0 = r1;
    L_0x008b:
        r1 = r11.i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0095:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a2:
        if (r1 <= r0) goto L_0x00b0;
    L_0x00a4:
        r5 = r11.i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a2;
    L_0x00b0:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r1 = r3;
    L_0x00c1:
        if (r1 > r7) goto L_0x00d0;
    L_0x00c3:
        r0 = r6.get(r1);
        r0 = (e) r0;
        r0.a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c1;
    L_0x00d0:
        r5 = r4;
        r4 = r3;
    L_0x00d2:
        if (r4 > r7) goto L_0x0108;
    L_0x00d4:
        r0 = a;
        if (r0 == 0) goto L_0x00f4;
    L_0x00d8:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00f4:
        r0 = r6.get(r4);
        r0 = (e) r0;
        if (r4 != r7) goto L_0x0106;
    L_0x00fc:
        r1 = r2;
    L_0x00fd:
        r1 = r0.a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00d2;
    L_0x0106:
        r1 = r3;
        goto L_0x00fd;
    L_0x0108:
        r11.g();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: u.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    public ArrayList h() {
        ArrayList arrayList = null;
        if (this.f != null) {
            for (int i = 0; i < this.f.size(); i++) {
                Fragment fragment = (Fragment) this.f.get(i);
                if (fragment != null && fragment.L) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.M = true;
                    fragment.t = fragment.s != null ? fragment.s.p : -1;
                    if (a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void f(Fragment fragment) {
        if (fragment.T != null) {
            if (this.x == null) {
                this.x = new SparseArray();
            } else {
                this.x.clear();
            }
            fragment.T.saveHierarchyState(this.x);
            if (this.x.size() > 0) {
                fragment.o = this.x;
                this.x = null;
            }
        }
    }

    Bundle g(Fragment fragment) {
        Bundle bundle;
        if (this.w == null) {
            this.w = new Bundle();
        }
        fragment.k(this.w);
        if (this.w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.w;
            this.w = null;
        }
        if (fragment.S != null) {
            f(fragment);
        }
        if (fragment.o != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.o);
        }
        if (!fragment.V) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.V);
        }
        return bundle;
    }

    public Parcelable i() {
        BackStackState[] backStackStateArr = null;
        f();
        if (b) {
            this.s = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f.get(i);
            if (fragment != null) {
                if (fragment.p < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.p));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.k <= 0 || fragmentState.j != null) {
                    fragmentState.j = fragment.n;
                } else {
                    fragmentState.j = g(fragment);
                    if (fragment.s != null) {
                        if (fragment.s.p < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.s));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, "android:target_state", fragment.s);
                        if (fragment.u != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.u);
                        }
                    }
                }
                if (a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.g != null) {
                i = this.g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.g.get(i2)).p;
                        if (iArr[i2] < 0) {
                            a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                        }
                    }
                    if (this.i != null) {
                        i = this.i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState(this, (e) this.i.get(i2));
                                if (a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.a = fragmentStateArr;
                    fragmentManagerState.b = iArr;
                    fragmentManagerState.c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.i != null) {
                i = this.i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState(this, (e) this.i.get(i2));
                        if (a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.a = fragmentStateArr;
            fragmentManagerState.b = iArr;
            fragmentManagerState.c = backStackStateArr;
            return fragmentManagerState;
        } else if (!a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (arrayList != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        fragment = (Fragment) arrayList.get(i);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.a[fragment.p];
                        fragmentState.k = fragment;
                        fragment.o = null;
                        fragment.B = 0;
                        fragment.z = false;
                        fragment.v = false;
                        fragment.s = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.o = fragmentState.j.getSparseParcelableArray("android:view_state");
                            fragment.n = fragmentState.j;
                        }
                    }
                }
                this.f = new ArrayList(fragmentManagerState.a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.a(this.o, this.q);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f.add(a);
                        fragmentState2.k = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        fragment = (Fragment) arrayList.get(i3);
                        if (fragment.t >= 0) {
                            if (fragment.t < this.f.size()) {
                                fragment.s = (Fragment) this.f.get(fragment.t);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.t);
                                fragment.s = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList(fragmentManagerState.b.length);
                    for (i = 0; i < fragmentManagerState.b.length; i++) {
                        fragment = (Fragment) this.f.get(fragmentManagerState.b[i]);
                        if (fragment == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i]));
                        }
                        fragment.v = true;
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(fragment);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList(fragmentManagerState.c.length);
                    for (i2 = 0; i2 < fragmentManagerState.c.length; i2++) {
                        e a2 = fragmentManagerState.c[i2].a(this);
                        if (a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.o + "): " + a2);
                            a2.a("  ", new PrintWriter(new et("FragmentManager")), false);
                        }
                        this.i.add(a2);
                        if (a2.o >= 0) {
                            a(a2.o, a2);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public void a(FragmentActivity fragmentActivity, r rVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = fragmentActivity;
        this.p = rVar;
        this.q = fragment;
    }

    public void j() {
        this.s = false;
    }

    public void k() {
        this.s = false;
        a(1, false);
    }

    public void l() {
        this.s = false;
        a(2, false);
    }

    public void m() {
        this.s = false;
        a(4, false);
    }

    public void n() {
        this.s = false;
        a(5, false);
    }

    public void o() {
        a(4, false);
    }

    public void p() {
        this.s = true;
        a(3, false);
    }

    public void q() {
        a(2, false);
    }

    public void r() {
        a(1, false);
    }

    public void s() {
        this.t = true;
        f();
        a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void a(Configuration configuration) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.a(configuration);
                }
            }
        }
    }

    public void t() {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.G();
                }
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.g.size()) {
                fragment = (Fragment) this.g.get(i2);
                if (fragment != null && fragment.b(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.j != null) {
            while (i < this.j.size()) {
                fragment = (Fragment) this.j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.u();
                }
                i++;
            }
        }
        this.j = arrayList;
        return z;
    }

    public boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null && fragment.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                Fragment fragment = (Fragment) this.g.get(i);
                if (fragment != null) {
                    fragment.d(menu);
                }
            }
        }
    }

    public static int c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (!"fragment".equals(str)) {
            return view;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(view, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.b(this.o, string)) {
            return view;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        if (resourceId != -1) {
            Fragment a = a(resourceId);
        } else {
            Object obj = view;
        }
        if (a == null && string2 != null) {
            a = a(string2);
        }
        if (a == null && id != -1) {
            a = a(id);
        }
        if (a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment a2 = Fragment.a(context, string);
            a2.y = true;
            a2.G = resourceId != 0 ? resourceId : id;
            a2.H = id;
            a2.I = string2;
            a2.z = true;
            a2.C = this;
            a2.a(this.o, attributeSet, a2.n);
            a(a2, true);
            fragment = a2;
        } else if (a.z) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.z = true;
            if (!a.M) {
                a.a(this.o, attributeSet, a.n);
            }
            fragment = a;
        }
        if (this.n >= 1 || !fragment.y) {
            c(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        if (fragment.S == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.S.setId(resourceId);
        }
        if (fragment.S.getTag() == null) {
            fragment.S.setTag(string2);
        }
        return fragment.S;
    }

    public Factory u() {
        return this;
    }
}
