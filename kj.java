import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class kj implements kp {
    final /* synthetic */ kg a;
    final /* synthetic */ ki b;

    kj(ki kiVar, kg kgVar) {
        this.b = kiVar;
        this.a = kgVar;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }

    public List a(String str, int i) {
        List a = this.a.a(str, i);
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((jt) a.get(i2)).a());
        }
        return arrayList;
    }

    public Object a(int i) {
        jt a = this.a.a(i);
        if (a == null) {
            return null;
        }
        return a.a();
    }
}
