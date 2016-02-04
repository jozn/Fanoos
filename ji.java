import android.view.View;

class ji {
    public static void a(View view, jm jmVar) {
        view.animate().setUpdateListener(new jj(jmVar, view));
    }
}
