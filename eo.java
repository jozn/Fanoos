import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

public class eo {
    public static final Locale a;
    private static String b;
    private static String c;

    public static int a(Locale locale) {
        if (!(locale == null || locale.equals(a))) {
            String a = ej.a(ej.b(locale.toString()));
            if (a == null) {
                return b(locale);
            }
            if (a.equalsIgnoreCase(b) || a.equalsIgnoreCase(c)) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioX /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    static {
        a = new Locale(XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE);
        b = "Arab";
        c = "Hebr";
    }
}
