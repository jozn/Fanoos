import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.kxml2.wap.Wbxml;

public class as extends aq {
    static boolean a;
    final fe b;
    final fe c;
    public final String d;
    FragmentActivity e;
    public boolean f;
    public boolean g;

    static {
        a = false;
    }

    public as(String str, FragmentActivity fragmentActivity, boolean z) {
        this.b = new fe();
        this.c = new fe();
        this.d = str;
        this.e = fragmentActivity;
        this.f = z;
    }

    public void a(FragmentActivity fragmentActivity) {
        this.e = fragmentActivity;
    }

    public void b() {
        if (a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f = true;
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((at) this.b.b(b)).a();
        }
    }

    public void c() {
        if (a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f) {
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((at) this.b.b(b)).e();
            }
            this.f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    public void d() {
        if (a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f) {
            this.g = true;
            this.f = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((at) this.b.b(b)).b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    public void e() {
        if (this.g) {
            if (a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.g = false;
            for (int b = this.b.b() - 1; b >= 0; b--) {
                ((at) this.b.b(b)).c();
            }
        }
    }

    public void f() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((at) this.b.b(b)).k = true;
        }
    }

    public void g() {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            ((at) this.b.b(b)).d();
        }
    }

    public void h() {
        int b;
        if (!this.g) {
            if (a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.b.b() - 1; b >= 0; b--) {
                ((at) this.b.b(b)).f();
            }
            this.b.c();
        }
        if (a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.c.b() - 1; b >= 0; b--) {
            ((at) this.c.b(b)).f();
        }
        this.c.c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Wbxml.EXT_T_0);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        es.a(this.e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.b.b(); i2++) {
                at atVar = (at) this.b.b(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.b.a(i2));
                printWriter.print(": ");
                printWriter.println(atVar.toString());
                atVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.c.b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.c.b()) {
                atVar = (at) this.c.b(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.c.a(i));
                printWriter.print(": ");
                printWriter.println(atVar.toString());
                atVar.a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean a() {
        int b = this.b.b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            at atVar = (at) this.b.b(i);
            if (!atVar.h || atVar.f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
