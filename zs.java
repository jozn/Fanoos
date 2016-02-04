import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

public class zs {
    public static Boolean a(String str, String str2, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            String str3 = "Here is the share content body";
            intent.putExtra("android.intent.extra.SUBJECT", str);
            intent.putExtra("android.intent.extra.TEXT", str2);
            context.startActivity(Intent.createChooser(intent, "\u0627\u0634\u062a\u0631\u0627\u06a9 \u0628\u0627"));
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    public static Boolean a(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            context.startActivity(Intent.createChooser(intent, "\u0627\u0634\u062a\u0631\u0627\u06a9 \u0628\u0627"));
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    public static Boolean b(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            context.startActivity(Intent.createChooser(intent, "\u0627\u0634\u062a\u0631\u0627\u06a9 \u0628\u0627"));
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    public static Boolean c(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("audio/mpeg");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            context.startActivity(Intent.createChooser(intent, "\u0627\u0634\u062a\u0631\u0627\u06a9 \u0628\u0627"));
            return Boolean.valueOf(true);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }
}
