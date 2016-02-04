import android.view.View;

class iz implements jk {
    iu a;

    iz(iu iuVar) {
        this.a = iuVar;
    }

    public void a(View view) {
        jk jkVar;
        if (this.a.e >= 0) {
            hg.a(view, 2, null);
        }
        if (this.a.c != null) {
            this.a.c.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof jk) {
            jkVar = (jk) tag;
        } else {
            jkVar = null;
        }
        if (jkVar != null) {
            jkVar.a(view);
        }
    }

    public void b(View view) {
        jk jkVar;
        if (this.a.e >= 0) {
            hg.a(view, this.a.e, null);
            this.a.e = -1;
        }
        if (this.a.d != null) {
            this.a.d.run();
        }
        Object tag = view.getTag(2113929216);
        if (tag instanceof jk) {
            jkVar = (jk) tag;
        } else {
            jkVar = null;
        }
        if (jkVar != null) {
            jkVar.b(view);
        }
    }

    public void c(View view) {
        jk jkVar;
        Object tag = view.getTag(2113929216);
        if (tag instanceof jk) {
            jkVar = (jk) tag;
        } else {
            jkVar = null;
        }
        if (jkVar != null) {
            jkVar.c(view);
        }
    }
}
