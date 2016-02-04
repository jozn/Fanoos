import android.util.Log;
import android.view.View;
import org.kxml2.wap.Wbxml;

public abstract class ui {
    public final View a;
    public int b;
    int c;
    long d;
    int e;
    int f;
    public ui g;
    public ui h;
    private int i;
    private int j;
    private tz k;

    public void a() {
        this.c = -1;
        this.f = -1;
    }

    public void b() {
        if (this.c == -1) {
            this.c = this.b;
        }
    }

    public boolean c() {
        return (this.i & Wbxml.EXT_T_0) != 0;
    }

    public final int d() {
        return this.f == -1 ? this.b : this.f;
    }

    public final long e() {
        return this.d;
    }

    public final int f() {
        return this.e;
    }

    boolean g() {
        return this.k != null;
    }

    void h() {
        this.k.c(this);
    }

    boolean i() {
        return (this.i & 32) != 0;
    }

    void j() {
        this.i &= -33;
    }

    public void k() {
        this.i &= -257;
    }

    void a(tz tzVar) {
        this.k = tzVar;
    }

    public boolean l() {
        return (this.i & 4) != 0;
    }

    boolean m() {
        return (this.i & 2) != 0;
    }

    public boolean n() {
        return (this.i & 64) != 0;
    }

    boolean o() {
        return (this.i & 1) != 0;
    }

    public boolean p() {
        return (this.i & 8) != 0;
    }

    public boolean q() {
        return (this.i & 256) != 0;
    }

    void a(int i, int i2) {
        this.i = (this.i & (i2 ^ -1)) | (i & i2);
    }

    public void a(int i) {
        this.i |= i;
    }

    void r() {
        this.i = 0;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = -1;
        this.j = 0;
        this.g = null;
        this.h = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
        if (g()) {
            stringBuilder.append(" scrap");
        }
        if (l()) {
            stringBuilder.append(" invalid");
        }
        if (!o()) {
            stringBuilder.append(" unbound");
        }
        if (m()) {
            stringBuilder.append(" update");
        }
        if (p()) {
            stringBuilder.append(" removed");
        }
        if (c()) {
            stringBuilder.append(" ignored");
        }
        if (n()) {
            stringBuilder.append(" changed");
        }
        if (q()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!s()) {
            stringBuilder.append(" not recyclable(" + this.j + ")");
        }
        if (this.a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(boolean z) {
        this.j = z ? this.j - 1 : this.j + 1;
        if (this.j < 0) {
            this.j = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.j == 1) {
            this.i |= 16;
        } else if (z && this.j == 0) {
            this.i &= -17;
        }
    }

    public final boolean s() {
        return (this.i & 16) == 0 && !hg.c(this.a);
    }
}
