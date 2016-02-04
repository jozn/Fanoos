import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import org.kxml2.kdom.Node;
import org.kxml2.wap.Wbxml;
import org.kxml2.wap.WbxmlParser;

public class jt {
    private static final jw a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new ju();
        } else if (VERSION.SDK_INT >= 19) {
            a = new jz();
        } else if (VERSION.SDK_INT >= 18) {
            a = new jy();
        } else if (VERSION.SDK_INT >= 16) {
            a = new jx();
        } else if (VERSION.SDK_INT >= 14) {
            a = new jv();
        } else {
            a = new ka();
        }
    }

    public jt(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public int b() {
        return a.a(this.b);
    }

    public void a(int i) {
        a.a(this.b, i);
    }

    public void a(View view) {
        a.a(this.b, view);
    }

    public void a(Rect rect) {
        a.a(this.b, rect);
    }

    public void b(Rect rect) {
        a.b(this.b, rect);
    }

    public boolean c() {
        return a.f(this.b);
    }

    public boolean d() {
        return a.g(this.b);
    }

    public boolean e() {
        return a.j(this.b);
    }

    public boolean f() {
        return a.k(this.b);
    }

    public boolean g() {
        return a.o(this.b);
    }

    public boolean h() {
        return a.h(this.b);
    }

    public boolean i() {
        return a.l(this.b);
    }

    public boolean j() {
        return a.i(this.b);
    }

    public boolean k() {
        return a.m(this.b);
    }

    public boolean l() {
        return a.n(this.b);
    }

    public void a(boolean z) {
        a.a(this.b, z);
    }

    public CharSequence m() {
        return a.d(this.b);
    }

    public CharSequence n() {
        return a.b(this.b);
    }

    public void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public CharSequence o() {
        return a.e(this.b);
    }

    public CharSequence p() {
        return a.c(this.b);
    }

    public String q() {
        return a.p(this.b);
    }

    public void a(Object obj) {
        a.a(this.b, ((kb) obj).a);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        jt jtVar = (jt) obj;
        if (this.b == null) {
            if (jtVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(jtVar.b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m());
        stringBuilder.append("; className: ").append(n());
        stringBuilder.append("; text: ").append(o());
        stringBuilder.append("; contentDescription: ").append(p());
        stringBuilder.append("; viewId: ").append(q());
        stringBuilder.append("; checkable: ").append(c());
        stringBuilder.append("; checked: ").append(d());
        stringBuilder.append("; focusable: ").append(e());
        stringBuilder.append("; focused: ").append(f());
        stringBuilder.append("; selected: ").append(g());
        stringBuilder.append("; clickable: ").append(h());
        stringBuilder.append("; longClickable: ").append(i());
        stringBuilder.append("; enabled: ").append(j());
        stringBuilder.append("; password: ").append(k());
        stringBuilder.append("; scrollable: " + l());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String b(int i) {
        switch (i) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                return "ACTION_FOCUS";
            case ve.CropImageView_aspectRatioX /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case ve.CropImageView_imageResource /*4*/:
                return "ACTION_SELECT";
            case Node.PROCESSING_INSTRUCTION /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case nv.Toolbar_maxButtonHeight /*16*/:
                return "ACTION_CLICK";
            case nv.Theme_actionModeShareDrawable /*32*/:
                return "ACTION_LONG_CLICK";
            case WbxmlParser.WAP_EXTENSION /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case Wbxml.EXT_T_0 /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
