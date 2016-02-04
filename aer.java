import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.xmlpull.v1.XmlPullParser;

public class aer {
    private static Socket a;
    private static PrintWriter b;
    private static BufferedReader c;
    private static String d;
    private static String e;
    private static int f;

    static {
        a = null;
        b = null;
        c = null;
        d = "94.182.227.55";
        e = null;
        f = 8889;
    }

    private static void a() {
        try {
            Log.i("connectWithServer", "start connectWithServer");
            a = new Socket(d, f);
            a.setSoTimeout(5000);
            b = new PrintWriter(a.getOutputStream());
            Log.i(" BufferedReader ", " ready " + zn.a());
            c = new BufferedReader(new InputStreamReader(a.getInputStream()));
            Log.i(" BufferedReader ", " reset " + zn.a());
            Log.i("connectWithServer", "end connectWithServer");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("connectWithServer", e.getMessage());
        } catch (Exception e2) {
            Log.i("connectWithServer", e2.getMessage());
        }
    }

    public static synchronized void a(String str) {
        synchronized (aer.class) {
            if (str != null) {
                Log.i("connectWithServer", "start sendDataWithString");
                a();
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                    DataInputStream dataInputStream = new DataInputStream(a.getInputStream());
                    dataOutputStream.write(str.getBytes());
                    Log.i("connectWithServer", "end sendDataWithString");
                } catch (IOException e) {
                    Log.i("connectWithServer", "error sendDataWithString " + e.getMessage());
                } catch (Exception e2) {
                    Log.i("connectWithServer", "error sendDataWithString " + e2.getMessage());
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r10) {
        /*
        r0 = 0;
        r1 = "";
        r1 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r5 = new char[r1];	 Catch:{ IOException -> 0x012d }
        r1 = "step start";
        r2 = zn.a();	 Catch:{ IOException -> 0x012d }
        android.util.Log.i(r1, r2);	 Catch:{ IOException -> 0x012d }
        r1 = r0;
    L_0x0011:
        r0 = "connectWithServer";
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r2.<init>();	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r3 = "start charsRead ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r3 = zn.a();	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        android.util.Log.i(r0, r2);	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r0 = c;	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r0 = r0.read(r5);	 Catch:{ SocketException -> 0x010e, IOException -> 0x01ec }
        r2 = "connectWithServer";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012d }
        r3.<init>();	 Catch:{ IOException -> 0x012d }
        r4 = "end charsRead ";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x012d }
        r4 = zn.a();	 Catch:{ IOException -> 0x012d }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x012d }
        r3 = r3.toString();	 Catch:{ IOException -> 0x012d }
        android.util.Log.i(r2, r3);	 Catch:{ IOException -> 0x012d }
        if (r0 <= 0) goto L_0x01d1;
    L_0x0051:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x012d }
        r2.<init>(r5);	 Catch:{ IOException -> 0x012d }
        r3 = 0;
        r2 = r2.substring(r3, r0);	 Catch:{ IOException -> 0x012d }
        r0 = "messageTemp";
        android.util.Log.i(r0, r2);	 Catch:{ IOException -> 0x012d }
        r0 = "\\$";
        r2.split(r0);	 Catch:{ IOException -> 0x012d }
        r0 = "$";
        r0 = r2.indexOf(r0);	 Catch:{ IOException -> 0x012d }
        if (r0 <= 0) goto L_0x0011;
    L_0x006d:
        r0 = 0;
        r3 = "$";
        r3 = r2.indexOf(r3);	 Catch:{ IOException -> 0x012d }
        r0 = r2.substring(r0, r3);	 Catch:{ IOException -> 0x012d }
        r0 = ys.c(r10, r0);	 Catch:{ IOException -> 0x012d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x012d }
        r3 = r0.intValue();	 Catch:{ IOException -> 0x012d }
        if (r3 != 0) goto L_0x00a3;
    L_0x0086:
        r0 = 0;
        r4 = "$";
        r4 = r2.indexOf(r4);	 Catch:{ IOException -> 0x012d }
        r0 = r2.substring(r0, r4);	 Catch:{ IOException -> 0x012d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r0.intValue();	 Catch:{ IOException -> 0x012d }
        if (r0 != 0) goto L_0x00a3;
    L_0x009b:
        r0 = 4;
        r0 = r2.substring(r0);	 Catch:{ IOException -> 0x012d }
        zi.v(r0, r10);	 Catch:{ IOException -> 0x012d }
    L_0x00a3:
        r0 = "$";
        r0 = r2.indexOf(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r0 + 1;
        r4 = r2.substring(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r4.length();	 Catch:{ IOException -> 0x012d }
        r9 = r0;
        r0 = r4;
        r4 = r3;
        r3 = r9;
    L_0x00b7:
        if (r4 == r3) goto L_0x01c6;
    L_0x00b9:
        if (r4 >= r3) goto L_0x0190;
    L_0x00bb:
        r2 = 0;
        r2 = r0.substring(r2, r4);	 Catch:{ IOException -> 0x012d }
        zi.a(r2, r10);	 Catch:{ IOException -> 0x012d }
        r2 = r0.substring(r4);	 Catch:{ IOException -> 0x012d }
        r0 = "";
        r6 = "$";
        r6 = r2.indexOf(r6);	 Catch:{ IOException -> 0x012d }
        if (r6 <= 0) goto L_0x0138;
    L_0x00d1:
        r3 = 0;
        r4 = "$";
        r4 = r2.indexOf(r4);	 Catch:{ IOException -> 0x012d }
        r3 = r2.substring(r3, r4);	 Catch:{ IOException -> 0x012d }
        r3 = ys.c(r10, r3);	 Catch:{ IOException -> 0x012d }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ IOException -> 0x012d }
        r3 = r3.intValue();	 Catch:{ IOException -> 0x012d }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012d }
        r4.<init>();	 Catch:{ IOException -> 0x012d }
        r0 = r4.append(r0);	 Catch:{ IOException -> 0x012d }
        r4 = "$";
        r4 = r2.indexOf(r4);	 Catch:{ IOException -> 0x012d }
        r4 = r4 + 1;
        r4 = r2.substring(r4);	 Catch:{ IOException -> 0x012d }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x012d }
        r4 = r0.toString();	 Catch:{ IOException -> 0x012d }
        r0 = r4.length();	 Catch:{ IOException -> 0x012d }
        r9 = r0;
        r0 = r4;
        r4 = r3;
        r3 = r9;
        goto L_0x00b7;
    L_0x010e:
        r0 = move-exception;
        r2 = "connectWithServer";
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012d }
        r3.<init>();	 Catch:{ IOException -> 0x012d }
        r4 = "-";
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x012d }
        r0 = r0.getMessage();	 Catch:{ IOException -> 0x012d }
        r0 = r3.append(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r0.toString();	 Catch:{ IOException -> 0x012d }
        android.util.Log.i(r2, r0);	 Catch:{ IOException -> 0x012d }
        goto L_0x0011;
    L_0x012d:
        r0 = move-exception;
        r1 = "NetClient";
        r0 = r0.getMessage();
        android.util.Log.i(r1, r0);
    L_0x0137:
        return;
    L_0x0138:
        r6 = c;	 Catch:{ IOException -> 0x012d }
        r6 = r6.read(r5);	 Catch:{ IOException -> 0x012d }
        if (r6 <= 0) goto L_0x015b;
    L_0x0140:
        r7 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012d }
        r7.<init>();	 Catch:{ IOException -> 0x012d }
        r2 = r7.append(r2);	 Catch:{ IOException -> 0x012d }
        r7 = new java.lang.String;	 Catch:{ IOException -> 0x012d }
        r7.<init>(r5);	 Catch:{ IOException -> 0x012d }
        r8 = 0;
        r6 = r7.substring(r8, r6);	 Catch:{ IOException -> 0x012d }
        r2 = r2.append(r6);	 Catch:{ IOException -> 0x012d }
        r2 = r2.toString();	 Catch:{ IOException -> 0x012d }
    L_0x015b:
        r6 = "$";
        r6 = r2.indexOf(r6);	 Catch:{ IOException -> 0x012d }
        if (r6 <= 0) goto L_0x01c6;
    L_0x0163:
        r0 = 0;
        r3 = "$";
        r3 = r2.indexOf(r3);	 Catch:{ IOException -> 0x012d }
        r0 = r2.substring(r0, r3);	 Catch:{ IOException -> 0x012d }
        r0 = ys.c(r10, r0);	 Catch:{ IOException -> 0x012d }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x012d }
        r3 = r0.intValue();	 Catch:{ IOException -> 0x012d }
        r0 = "$";
        r0 = r2.indexOf(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r0 + 1;
        r4 = r2.substring(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r4.length();	 Catch:{ IOException -> 0x012d }
        r9 = r0;
        r0 = r4;
        r4 = r3;
        r3 = r9;
        goto L_0x00b7;
    L_0x0190:
        r0 = c;	 Catch:{ IOException -> 0x012d }
        r0 = r0.read(r5);	 Catch:{ IOException -> 0x012d }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012d }
        r3.<init>();	 Catch:{ IOException -> 0x012d }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x012d }
        r3 = new java.lang.String;	 Catch:{ IOException -> 0x012d }
        r3.<init>(r5);	 Catch:{ IOException -> 0x012d }
        r6 = 0;
        r0 = r3.substring(r6, r0);	 Catch:{ IOException -> 0x012d }
        r0 = r2.append(r0);	 Catch:{ IOException -> 0x012d }
        r2 = r0.toString();	 Catch:{ IOException -> 0x012d }
        r0 = "$";
        r0 = r2.indexOf(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r0 + 1;
        r3 = r2.substring(r0);	 Catch:{ IOException -> 0x012d }
        r0 = r3.length();	 Catch:{ IOException -> 0x012d }
        r9 = r0;
        r0 = r3;
        r3 = r9;
        goto L_0x00b7;
    L_0x01c6:
        if (r4 != r3) goto L_0x0011;
    L_0x01c8:
        if (r4 <= 0) goto L_0x0011;
    L_0x01ca:
        zi.a(r0, r10);	 Catch:{ IOException -> 0x012d }
        r0 = "";
        goto L_0x0011;
    L_0x01d1:
        r0 = r1 + 1;
        r1 = 20;
        if (r0 <= r1) goto L_0x01e0;
    L_0x01d7:
        r0 = "messageTemp";
        r1 = "end";
        android.util.Log.i(r0, r1);	 Catch:{ IOException -> 0x012d }
        goto L_0x0137;
    L_0x01e0:
        r1 = "step else";
        r2 = zn.a();	 Catch:{ IOException -> 0x012d }
        android.util.Log.i(r1, r2);	 Catch:{ IOException -> 0x012d }
        r1 = r0;
        goto L_0x0011;
    L_0x01ec:
        r0 = move-exception;
        goto L_0x01d7;
        */
        throw new UnsupportedOperationException("Method not decompiled: aer.a(android.content.Context):void");
    }

    public static synchronized void b(Context context) {
        synchronized (aer.class) {
            try {
                String str = XmlPullParser.NO_NAMESPACE;
                char[] cArr = new char[2048];
                Log.i("step3", zn.a());
                int read = c.read(cArr);
                if (read > 0) {
                    str = new String(cArr).substring(0, read);
                    if (!TextUtils.isEmpty(str)) {
                        zi.a(str, context);
                    }
                    Log.i("step1", str);
                }
            } catch (IOException e) {
                Log.i("s", e.getMessage() + XmlPullParser.NO_NAMESPACE);
            }
        }
    }

    public static synchronized void c(Context context) {
        synchronized (aer.class) {
            try {
                int read;
                String str = XmlPullParser.NO_NAMESPACE;
                char[] cArr = new char[2048];
                Log.i("step start", zn.a());
                try {
                    Log.i("connectWithServer", "start charsRead " + zn.a());
                    read = c.read(cArr);
                } catch (Exception e) {
                    Log.i("connectWithServer", e.getMessage());
                    read = 0;
                }
                Log.i("connectWithServer", "end charsRead " + zn.a());
                if (read > 0) {
                    str = new String(cArr).substring(0, read);
                    Log.i("messageTemp", str);
                    str.split("\\$");
                    if (str.indexOf("$") > 0) {
                        int intValue = Integer.valueOf(ys.c(context, str.substring(0, str.indexOf("$")))).intValue();
                        if (intValue == 0 && Integer.valueOf(str.substring(0, str.indexOf("$"))).intValue() == 0) {
                            zi.v(str.substring(4), context);
                        }
                        String substring = str.substring(str.indexOf("$") + 1);
                        int length = substring.length();
                        while (intValue != length) {
                            if (intValue < length) {
                                zi.a(substring.substring(0, intValue), context);
                                str = substring.substring(intValue);
                                substring = XmlPullParser.NO_NAMESPACE;
                                if (str.indexOf("$") > 0) {
                                    intValue = Integer.valueOf(ys.c(context, str.substring(0, str.indexOf("$")))).intValue();
                                    substring = substring + str.substring(str.indexOf("$") + 1);
                                    length = substring.length();
                                } else {
                                    int read2 = c.read(cArr);
                                    if (read2 > 0) {
                                        str = str + new String(cArr).substring(0, read2);
                                    }
                                    if (str.indexOf("$") > 0) {
                                        intValue = Integer.valueOf(ys.c(context, str.substring(0, str.indexOf("$")))).intValue();
                                        substring = str.substring(str.indexOf("$") + 1);
                                        length = substring.length();
                                    }
                                }
                            } else {
                                str = str + new String(cArr).substring(0, c.read(cArr));
                                substring = str.substring(str.indexOf("$") + 1);
                                length = substring.length();
                            }
                        }
                        if (intValue == length && intValue > 0) {
                            zi.a(substring, context);
                            str = XmlPullParser.NO_NAMESPACE;
                        }
                    }
                }
            } catch (IOException e2) {
                Log.i("NetClient", e2.getMessage());
            }
        }
    }
}
