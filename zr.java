import android.content.Context;
import android.telephony.TelephonyManager;
import org.xmlpull.v1.XmlPullParser;

public class zr {
    public static String a(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (deviceId.equals(null) || XmlPullParser.NO_NAMESPACE.equals(deviceId)) {
                return "111";
            }
            return deviceId;
        } catch (Exception e) {
            return "111";
        }
    }

    public static String b(Context context) {
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            if (simSerialNumber.equals(null) || XmlPullParser.NO_NAMESPACE.equals(simSerialNumber)) {
                return "111";
            }
            return simSerialNumber;
        } catch (Exception e) {
            return "111";
        }
    }
}
