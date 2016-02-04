package android.support.v4.app;

import a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import as;
import c;
import fd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import o;
import org.kxml2.kdom.Node;
import org.kxml2.wap.Wbxml;
import p;
import q;
import r;
import s;
import u;
import ve;

public class FragmentActivity extends Activity {
    public final Handler a;
    public final u b;
    final r c;
    boolean d;
    boolean e;
    public boolean f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    fd l;
    as m;

    public FragmentActivity() {
        this.a = new o(this);
        this.b = new u();
        this.c = new p(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.b.j();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            if (this.b.f == null || i3 < 0 || i3 >= this.b.f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = (Fragment) this.b.f.get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.b.d()) {
            a_();
        }
    }

    public void a_() {
        a.b(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.a(configuration);
    }

    public void onCreate(Bundle bundle) {
        this.b.a(this, this.c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        q qVar = (q) getLastNonConfigurationInstance();
        if (qVar != null) {
            this.l = qVar.e;
        }
        if (bundle != null) {
            ArrayList arrayList;
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            u uVar = this.b;
            if (qVar != null) {
                arrayList = qVar.d;
            } else {
                arrayList = null;
            }
            uVar.a(parcelable, arrayList);
        }
        this.b.k();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.b.a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View onCreateView = this.b.onCreateView(str, context, attributeSet);
        if (onCreateView == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.b.s();
        if (this.m != null) {
            this.m.h();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.t();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                return this.b.a(menuItem);
            case Node.ENTITY_REF /*6*/:
                return this.b.b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                this.b.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.e = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            b();
        }
        this.b.o();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.j();
    }

    public void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.e = true;
        this.b.f();
    }

    public void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        b();
        this.b.f();
    }

    public void b() {
        this.b.n();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.i) {
            this.i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return a(view, menu) | this.b.a(menu);
    }

    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        int i = 0;
        if (this.f) {
            a(true);
        }
        Object c = c();
        ArrayList h = this.b.h();
        int i2;
        if (this.l != null) {
            int size = this.l.size();
            as[] asVarArr = new as[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                asVarArr[i3] = (as) this.l.c(i3);
            }
            i2 = 0;
            while (i < size) {
                as asVar = asVarArr[i];
                if (asVar.g) {
                    i2 = true;
                } else {
                    asVar.h();
                    this.l.remove(asVar.d);
                }
                i++;
            }
        } else {
            i2 = 0;
        }
        if (h == null && r0 == 0 && c == null) {
            return null;
        }
        Object qVar = new q();
        qVar.a = null;
        qVar.b = c;
        qVar.c = null;
        qVar.d = h;
        qVar.e = this.l;
        return qVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable i = this.b.i();
        if (i != null) {
            bundle.putParcelable("android:support:fragments", i);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f = false;
        this.g = false;
        this.a.removeMessages(1);
        if (!this.d) {
            this.d = true;
            this.b.l();
        }
        this.b.j();
        this.b.f();
        if (!this.k) {
            this.k = true;
            if (this.m != null) {
                this.m.b();
            } else if (!this.j) {
                this.m = a("(root)", this.k, false);
                if (!(this.m == null || this.m.f)) {
                    this.m.b();
                }
            }
            this.j = true;
        }
        this.b.m();
        if (this.l != null) {
            int size = this.l.size();
            as[] asVarArr = new as[size];
            for (int i = size - 1; i >= 0; i--) {
                asVarArr[i] = (as) this.l.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                as asVar = asVarArr[i2];
                asVar.e();
                asVar.g();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.f = true;
        this.a.sendEmptyMessage(1);
        this.b.p();
    }

    public Object c() {
        return null;
    }

    public void d() {
        if (VERSION.SDK_INT >= 11) {
            c.a(this);
        } else {
            this.i = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.d);
            printWriter.print("mResumed=");
            printWriter.print(this.e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.k);
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.d);
            printWriter.print("mResumed=");
            printWriter.print(this.e);
            printWriter.print(" mStopped=");
            printWriter.print(this.f);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.g);
            printWriter.print(str2);
            printWriter.print("mLoadersStarted=");
            printWriter.println(this.k);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.m)));
            printWriter.println(":");
            this.m.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.b.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(Wbxml.EXT_T_0);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case ve.CropImageView_guidelines /*0*/:
                stringBuilder.append('V');
                break;
            case ve.CropImageView_imageResource /*4*/:
                stringBuilder.append('I');
                break;
            case Node.PROCESSING_INSTRUCTION /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void a(boolean z) {
        if (!this.g) {
            this.g = true;
            this.h = z;
            this.a.removeMessages(1);
            e();
        }
    }

    void e() {
        if (this.k) {
            this.k = false;
            if (this.m != null) {
                if (this.h) {
                    this.m.d();
                } else {
                    this.m.c();
                }
            }
        }
        this.b.q();
    }

    public void a(Fragment fragment) {
    }

    public s f() {
        return this.b;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.p + 1) << 16) + (65535 & i));
        }
    }

    public void a(String str) {
        if (this.l != null) {
            as asVar = (as) this.l.get(str);
            if (asVar != null && !asVar.g) {
                asVar.h();
                this.l.remove(str);
            }
        }
    }

    as a(String str, boolean z, boolean z2) {
        if (this.l == null) {
            this.l = new fd();
        }
        as asVar = (as) this.l.get(str);
        if (asVar != null) {
            asVar.a(this);
            return asVar;
        } else if (!z2) {
            return asVar;
        } else {
            asVar = new as(str, this, z);
            this.l.put(str, asVar);
            return asVar;
        }
    }
}
