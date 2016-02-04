import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ep extends fd implements Map {
    ev a;

    private ev b() {
        if (this.a == null) {
            this.a = new eq(this);
        }
        return this.a;
    }

    public void putAll(Map map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection collection) {
        return ev.c(this, collection);
    }

    public Set entrySet() {
        return b().d();
    }

    public Set keySet() {
        return b().e();
    }

    public Collection values() {
        return b().f();
    }
}
