import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class ey implements Set {
    final /* synthetic */ ev a;

    ey(ev evVar) {
        this.a = evVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object obj) {
        return this.a.a(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        return ev.a(this.a.b(), collection);
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator iterator() {
        return new ew(this.a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.a.a(obj);
        if (a < 0) {
            return false;
        }
        this.a.a(a);
        return true;
    }

    public boolean removeAll(Collection collection) {
        return ev.b(this.a.b(), collection);
    }

    public boolean retainAll(Collection collection) {
        return ev.c(this.a.b(), collection);
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        return this.a.b(0);
    }

    public Object[] toArray(Object[] objArr) {
        return this.a.a(objArr, 0);
    }

    public boolean equals(Object obj) {
        return ev.a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.a.a() - 1; a >= 0; a--) {
            Object a2 = this.a.a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }
}
