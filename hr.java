import android.view.View;

class hr {
    public static void a(View view) {
        view.requestApplyInsets();
    }

    public static void a(View view, float f) {
        view.setElevation(f);
    }

    public static void a(View view, gz gzVar) {
        view.setOnApplyWindowInsetsListener(new hs(gzVar));
    }
}
