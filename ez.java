import java.util.Iterator;
import java.util.Map.Entry;

final class ez implements Iterator, Entry {
    int a;
    int b;
    boolean c;
    final /* synthetic */ ev d;

    public /* synthetic */ Object next() {
        return a();
    }

    ez(ev evVar) {
        this.d = evVar;
        this.c = false;
        this.a = evVar.a() - 1;
        this.b = -1;
    }

    public boolean hasNext() {
        return this.b < this.a;
    }

    public Entry a() {
        this.b++;
        this.c = true;
        return this;
    }

    public void remove() {
        if (this.c) {
            this.d.a(this.b);
            this.b--;
            this.a--;
            this.c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public Object getKey() {
        if (this.c) {
            return this.d.a(this.b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.c) {
            return this.d.a(this.b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object setValue(Object obj) {
        if (this.c) {
            return this.d.a(this.b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(er.a(entry.getKey(), this.d.a(this.b, 0)) && er.a(entry.getValue(), this.d.a(this.b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.c) {
            Object a = this.d.a(this.b, 0);
            Object a2 = this.d.a(this.b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
