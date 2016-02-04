import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;

class rl extends eu {
    public rl(int i) {
        super(i);
    }

    PorterDuffColorFilter a(int i, Mode mode) {
        return (PorterDuffColorFilter) a((Object) Integer.valueOf(b(i, mode)));
    }

    PorterDuffColorFilter a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
    }

    private static int b(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }
}
