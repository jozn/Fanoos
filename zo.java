import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.kobjects.base64.Base64;

public class zo {
    public static String a(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Object obj = new byte[16];
            Object bytes = str2.getBytes("UTF-8");
            int length = bytes.length;
            if (length > obj.length) {
                length = obj.length;
            }
            System.arraycopy(bytes, 0, obj, 0, length);
            instance.init(2, new SecretKeySpec(obj, "AES"), new IvParameterSpec(obj));
            Base64 base64 = new Base64();
            return new String(instance.doFinal(Base64.decode(str)), "UTF-8");
        } catch (Exception e) {
            return "0";
        }
    }

    public static String b(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Object obj = new byte[16];
            Object bytes = str2.getBytes("UTF-8");
            int length = bytes.length;
            if (length > obj.length) {
                length = obj.length;
            }
            System.arraycopy(bytes, 0, obj, 0, length);
            instance.init(1, new SecretKeySpec(obj, "AES"), new IvParameterSpec(obj));
            return android.util.Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception e) {
            return "0";
        }
    }
}
