import android.view.View;
import java.util.List;

public class su {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public List j;

    public su() {
        this.a = true;
        this.h = 0;
        this.i = false;
        this.j = null;
    }

    public boolean a(uf ufVar) {
        return this.d >= 0 && this.d < ufVar.e();
    }

    public View a(tz tzVar) {
        if (this.j != null) {
            return a();
        }
        View b = tzVar.b(this.d);
        this.d += this.e;
        return b;
    }

    private View a() {
        ui uiVar;
        int size = this.j.size();
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        ui uiVar2 = null;
        while (i2 < size) {
            int i3;
            ui uiVar3;
            uiVar = (ui) this.j.get(i2);
            if (this.i || !uiVar.p()) {
                int d = (uiVar.d() - this.d) * this.e;
                if (d < 0) {
                    i3 = i;
                    uiVar3 = uiVar2;
                } else if (d >= i) {
                    i3 = i;
                    uiVar3 = uiVar2;
                } else if (d == 0) {
                    break;
                } else {
                    uiVar3 = uiVar;
                    i3 = d;
                }
            } else {
                i3 = i;
                uiVar3 = uiVar2;
            }
            i2++;
            uiVar2 = uiVar3;
            i = i3;
        }
        uiVar = uiVar2;
        if (uiVar == null) {
            return null;
        }
        this.d = uiVar.d() + this.e;
        return uiVar.a;
    }
}
