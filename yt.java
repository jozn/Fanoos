import java.net.HttpURLConnection;
import java.util.List;

public class yt {
    public static int a(HttpURLConnection httpURLConnection) {
        List list = (List) httpURLConnection.getHeaderFields().get("content-Length");
        if (!(list == null || list.isEmpty())) {
            String str = (String) list.get(0);
            if (str != null) {
                return Integer.parseInt(str);
            }
        }
        return 0;
    }

    public static String a(int i) {
        double d = 0.1d;
        double d2 = ((double) i) / 1048576.0d;
        if (d2 >= 0.1d) {
            d = d2;
        }
        return String.format("%.1f", new Object[]{Double.valueOf(d)}) + "MB";
    }
}
