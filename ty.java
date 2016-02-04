import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class ty {
    private SparseArray a;
    private SparseIntArray b;
    private int c;

    public ty() {
        this.a = new SparseArray();
        this.b = new SparseIntArray();
        this.c = 0;
    }

    public void a() {
        this.a.clear();
    }

    public ui a(int i) {
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size() - 1;
        ui uiVar = (ui) arrayList.get(size);
        arrayList.remove(size);
        return uiVar;
    }

    public void a(ui uiVar) {
        int f = uiVar.f();
        ArrayList b = b(f);
        if (this.b.get(f) > b.size()) {
            uiVar.r();
            b.add(uiVar);
        }
    }

    void a(to toVar) {
        this.c++;
    }

    void b() {
        this.c--;
    }

    void a(to toVar, to toVar2, boolean z) {
        if (toVar != null) {
            b();
        }
        if (!z && this.c == 0) {
            a();
        }
        if (toVar2 != null) {
            a(toVar2);
        }
    }

    private ArrayList b(int i) {
        ArrayList arrayList = (ArrayList) this.a.get(i);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.a.put(i, arrayList);
            if (this.b.indexOfKey(i) < 0) {
                this.b.put(i, 5);
            }
        }
        return arrayList;
    }
}
