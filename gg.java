import android.view.KeyEvent;

class gg {
    public static int a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
