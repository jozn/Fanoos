import java.util.Random;

public class yy {
    public static String a(String str) {
        return "fanoos" + str + a(8) + ".jpg";
    }

    public static String a(int i) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int nextInt = random.nextInt(i);
        for (int i2 = 0; i2 < nextInt; i2++) {
            stringBuilder.append((char) (random.nextInt(24) + 97));
        }
        return stringBuilder.toString();
    }
}
