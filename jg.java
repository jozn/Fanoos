import android.view.View;

class jg {
    public static void a(View view, jk jkVar) {
        if (jkVar != null) {
            view.animate().setListener(new jh(jkVar, view));
        } else {
            view.animate().setListener(null);
        }
    }
}
