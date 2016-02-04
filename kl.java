import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class kl implements ks {
    final /* synthetic */ kg a;
    final /* synthetic */ kk b;

    kl(kk kkVar, kg kgVar) {
        this.b = kkVar;
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

    public Object b(int i) {
        jt b = this.a.b(i);
        if (b == null) {
            return null;
        }
        return b.a();
    }
}
