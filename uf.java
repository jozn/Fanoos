import android.util.SparseArray;

public class uf {
    public ep a;
    public ep b;
    public ep c;
    public int d;
    private int e;
    private SparseArray f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public boolean a() {
        return this.j;
    }

    public boolean b() {
        return this.l;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.e != -1;
    }

    public int e() {
        return this.j ? this.g - this.h : this.d;
    }

    public void a(ui uiVar) {
        this.a.remove(uiVar);
        this.b.remove(uiVar);
        if (this.c != null) {
            a(this.c, uiVar);
        }
    }

    private void a(ep epVar, ui uiVar) {
        for (int size = epVar.size() - 1; size >= 0; size--) {
            if (uiVar == epVar.c(size)) {
                epVar.d(size);
                return;
            }
        }
    }

    public String toString() {
        return "State{mTargetPosition=" + this.e + ", mPreLayoutHolderMap=" + this.a + ", mPostLayoutHolderMap=" + this.b + ", mData=" + this.f + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.g + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.h + ", mStructureChanged=" + this.i + ", mInPreLayout=" + this.j + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
    }
}
