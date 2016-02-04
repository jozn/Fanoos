package ir.seraj.fanoos.communication;

import android.app.IntentService;
import android.os.Environment;
import android.os.ResultReceiver;
import android.util.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

public class IntentServiceGeneralCommand extends IntentService {
    static Boolean g;
    static String h;
    URL a;
    String b;
    String c;
    FileInputStream d;
    String e;
    Boolean f;
    private ResultReceiver i;

    static {
        g = Boolean.valueOf(false);
    }

    public static void a(String str) {
        h = str;
        g = Boolean.valueOf(true);
    }

    public IntentServiceGeneralCommand() {
        super("IntentServiceGeneralCommand");
        this.d = null;
        this.i = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onHandleIntent(android.content.Intent r14) {
        /*
        r13 = this;
        r12 = 3;
        r11 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r10 = 1;
        r2 = 0;
        r0 = "receiverTag";
        r0 = r14.getParcelableExtra(r0);
        r0 = (android.os.ResultReceiver) r0;
        r1 = "CommandCode";
        r3 = -1;
        r1 = r14.getIntExtra(r1, r3);
        r3 = -1;
        if (r1 != r3) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r4 = new android.os.Bundle;
        r4.<init>();
        r5 = aeq.o(r13);
        switch(r1) {
            case 0: goto L_0x0025;
            case 1: goto L_0x0066;
            case 2: goto L_0x00ac;
            case 3: goto L_0x01c9;
            case 4: goto L_0x020f;
            case 5: goto L_0x0281;
            case 6: goto L_0x0143;
            case 7: goto L_0x0330;
            default: goto L_0x0024;
        };
    L_0x0024:
        goto L_0x0017;
    L_0x0025:
        r1 = "CommandCode";
        r4.putInt(r1, r2);
        r0.send(r2, r4);
        r1 = zr.a(r13);
        r3 = zr.b(r13);
        r1 = zj.a(r5, r1, r3);
        aer.a(r1);
        aer.b(r13);
        r1 = r2;
    L_0x0040:
        r3 = g;
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0051;
    L_0x0048:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0061 }
        r1 = r1 + 1000;
        if (r1 <= r11) goto L_0x0040;
    L_0x0051:
        r1 = "d";
        r3 = h;
        r4.putString(r1, r3);
        r1 = "CommandCode";
        r4.putInt(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0061:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0051;
    L_0x0066:
        r1 = "CommandCode";
        r4.putInt(r1, r10);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = zr.a(r13);
        r3 = zr.b(r13);
        r1 = zj.b(r5, r1, r3);
        aer.a(r1);
        aer.b(r13);
    L_0x008a:
        r1 = g;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x009b;
    L_0x0092:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x00a7 }
        r2 = r2 + 1000;
        if (r2 <= r11) goto L_0x008a;
    L_0x009b:
        r1 = "resGetVerificationCodeAsync";
        r2 = h;
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x00a7:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x009b;
    L_0x00ac:
        r1 = "CommandCode";
        r3 = 2;
        r4.putInt(r1, r3);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = "VerificationCode";
        r3 = r14.getStringExtra(r1);
        r1 = r2;
    L_0x00c6:
        if (r1 >= r12) goto L_0x00ec;
    L_0x00c8:
        r6 = zr.a(r13);
        r7 = zr.b(r13);
        r6 = zj.a(r5, r6, r7, r3, r13);
        aer.a(r6);
        aer.b(r13);
        r6 = h;
        r7 = "0";
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x00ec;
    L_0x00e4:
        r6 = h;
        r6 = r6.length();
        if (r6 <= 0) goto L_0x0110;
    L_0x00ec:
        r1 = h;
        r1 = r1.length();
        r3 = 5;
        if (r1 <= r3) goto L_0x0121;
    L_0x00f5:
        r1 = h;
        ys.f(r13, r1);
        ys.b(r13);
        r1 = java.lang.Boolean.valueOf(r2);
        ys.a(r13, r1);
        r1 = "res";
        r2 = "1";
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0110:
        r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        java.lang.Thread.sleep(r6);	 Catch:{ Exception -> 0x03f8 }
    L_0x0115:
        r6 = "retry";
        r7 = java.lang.String.valueOf(r1);
        android.util.Log.i(r6, r7);
        r1 = r1 + 1;
        goto L_0x00c6;
    L_0x0121:
        r1 = h;
        r2 = "0";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0137;
    L_0x012b:
        r1 = "res";
        r2 = "0";
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0137:
        r1 = "res";
        r2 = "3";
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0143:
        r1 = "CommandCode";
        r3 = 6;
        r4.putInt(r1, r3);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = "5";
        r1 = zj.i(r5, r1, r13);
        aer.a(r1);
        aer.c(r13);
    L_0x0162:
        r1 = g;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x0173;
    L_0x016a:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x01b3 }
        r2 = r2 + 1000;
        if (r2 <= r11) goto L_0x0162;
    L_0x0173:
        r1 = h;	 Catch:{ Exception -> 0x01c0 }
        r2 = zh.b;	 Catch:{ Exception -> 0x01c0 }
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x01c0 }
        r2 = 0;
        r2 = r1[r2];	 Catch:{ Exception -> 0x01c0 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x01c0 }
        r3 = 1;
        r1 = r1[r3];	 Catch:{ Exception -> 0x01c0 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x01c0 }
        r3 = r1.intValue();	 Catch:{ Exception -> 0x01c0 }
        if (r3 > 0) goto L_0x0195;
    L_0x018f:
        r3 = r2.intValue();	 Catch:{ Exception -> 0x01c0 }
        if (r3 <= 0) goto L_0x01b8;
    L_0x0195:
        r3 = "groupMsg";
        r1 = r1.intValue();	 Catch:{ Exception -> 0x01c0 }
        r4.putInt(r3, r1);	 Catch:{ Exception -> 0x01c0 }
        r1 = "userMsg";
        r2 = r2.intValue();	 Catch:{ Exception -> 0x01c0 }
        r4.putInt(r1, r2);	 Catch:{ Exception -> 0x01c0 }
        r1 = "haveMessageBefor";
        r2 = "1";
        r4.putString(r1, r2);	 Catch:{ Exception -> 0x01c0 }
    L_0x01ae:
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x01b3:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0173;
    L_0x01b8:
        r1 = "haveMessageBefor";
        r2 = "0";
        r4.putString(r1, r2);	 Catch:{ Exception -> 0x01c0 }
        goto L_0x01ae;
    L_0x01c0:
        r1 = move-exception;
        r1 = "haveMessageBefor";
        r2 = "0";
        r4.putString(r1, r2);
        goto L_0x01ae;
    L_0x01c9:
        r1 = "CommandCode";
        r4.putInt(r1, r12);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = java.lang.Boolean.valueOf(r10);
        aeq.d(r13, r1);
        r1 = "5";
        r1 = zj.j(r5, r1, r13);
        aer.a(r1);
        r1 = java.lang.Boolean.valueOf(r10);
        aeq.d(r13, r1);
        r1 = aeq.o(r13);
        r1 = zj.a(r1, r13);
        aer.a(r1);
        r6 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        java.lang.Thread.sleep(r6);	 Catch:{ Exception -> 0x03fb }
    L_0x0203:
        r1 = java.lang.Boolean.valueOf(r2);
        aeq.d(r13, r1);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x020f:
        r1 = "CommandCode";
        r3 = 4;
        r4.putInt(r1, r3);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = "nickName";
        r6 = r14.getStringExtra(r1);
        r3 = r2;
    L_0x0229:
        if (r3 >= r12) goto L_0x0246;
    L_0x022b:
        r1 = zj.a(r5, r6, r13);
        aer.a(r1);
        r1 = r2;
    L_0x0233:
        r7 = g;
        r7 = r7.booleanValue();
        if (r7 != 0) goto L_0x0244;
    L_0x023b:
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x025c }
        r1 = r1 + 1000;
        if (r1 <= r11) goto L_0x0233;
    L_0x0244:
        if (r1 >= r11) goto L_0x0261;
    L_0x0246:
        r1 = h;
        r2 = "1";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0265;
    L_0x0250:
        r1 = "InsertOrEditNikName";
        r2 = "";
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x025c:
        r7 = move-exception;
        r7.printStackTrace();
        goto L_0x0244;
    L_0x0261:
        r1 = r3 + 1;
        r3 = r1;
        goto L_0x0229;
    L_0x0265:
        r1 = ys.p(r13);
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x0017;
    L_0x026f:
        ys.o(r13);
        aeq.d(r13, r6);
        r1 = "InsertOrEditNikName";
        r2 = h;
        r4.putString(r1, r2);
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0281:
        r1 = "CommandCode";
        r3 = 5;
        r4.putInt(r1, r3);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = "GroupName";
        r3 = r14.getStringExtra(r1);
        r1 = "FileAddress";
        r5 = r14.getStringExtra(r1);
        r1 = "Participants";
        r6 = r14.getStringArrayListExtra(r1);
        r1 = java.lang.Boolean.valueOf(r2);
        r13.f = r1;
        r1 = "";
        r13.e = r1;
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0316 }
        r7 = "http://94.182.227.16/getfilesnew/";
        r1.<init>(r7);	 Catch:{ MalformedURLException -> 0x0316 }
        r13.a = r1;	 Catch:{ MalformedURLException -> 0x0316 }
    L_0x02b9:
        r1 = aeq.o(r13);
        r13.b = r1;
        r1 = r13.b;
        r7 = 2;
        r7 = java.lang.String.valueOf(r7);
        r1 = zj.c(r1, r7, r13);
        r13.c = r1;
        r13.b(r5);
        r1 = r13.f;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x02da;
    L_0x02d7:
        r13.a();
    L_0x02da:
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0326 }
        g = r1;	 Catch:{ Exception -> 0x0326 }
        r1 = r13.b;	 Catch:{ Exception -> 0x0326 }
        r5 = r13.e;	 Catch:{ Exception -> 0x0326 }
        r5 = ys.c(r13, r5);	 Catch:{ Exception -> 0x0326 }
        r1 = zj.a(r1, r3, r5, r6, r13);	 Catch:{ Exception -> 0x0326 }
        aer.a(r1);	 Catch:{ Exception -> 0x0326 }
    L_0x02f0:
        r1 = g;	 Catch:{ Exception -> 0x0326 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0326 }
        if (r1 != 0) goto L_0x0301;
    L_0x02f8:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0321 }
        r2 = r2 + 1000;
        if (r2 <= r11) goto L_0x02f0;
    L_0x0301:
        r1 = h;
        r1 = r1.length();
        r2 = 4;
        if (r1 <= r2) goto L_0x0328;
    L_0x030a:
        r1 = "CreateGroup";
        r2 = "1";
        r4.putString(r1, r2);
    L_0x0311:
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x0316:
        r1 = move-exception;
        r7 = java.lang.Boolean.valueOf(r10);
        r13.f = r7;
        r1.printStackTrace();
        goto L_0x02b9;
    L_0x0321:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0326 }
        goto L_0x0301;
    L_0x0326:
        r1 = move-exception;
        goto L_0x0301;
    L_0x0328:
        r1 = "CreateGroup";
        r2 = "0";
        r4.putString(r1, r2);
        goto L_0x0311;
    L_0x0330:
        r1 = "CommandCode";
        r3 = 7;
        r4.putInt(r1, r3);
        r0.send(r2, r4);
        r1 = "";
        h = r1;
        r1 = java.lang.Boolean.valueOf(r2);
        g = r1;
        r1 = "GroupId";
        r1 = r14.getStringExtra(r1);
        r3 = "IsRemove";
        r3 = r14.getBooleanExtra(r3, r2);
        r3 = java.lang.Boolean.valueOf(r3);
        r6 = "Participants";
        r6 = r14.getStringExtra(r6);
        r7 = java.lang.Boolean.valueOf(r2);
        r13.f = r7;
        r7 = "";
        r13.e = r7;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x03c0;
    L_0x0369:
        r3 = "";
        h = r3;
        r3 = java.lang.Boolean.valueOf(r2);
        g = r3;
        r3 = zj.a(r5, r1, r6, r13);
        aer.a(r3);
    L_0x037a:
        r3 = g;
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x038b;
    L_0x0382:
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x03bb }
        r2 = r2 + 1000;
        if (r2 <= r11) goto L_0x037a;
    L_0x038b:
        r2 = h;
        r3 = "1";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x03a7;
    L_0x0395:
        r2 = new yx;
        r2.<init>();
        r1 = java.lang.String.valueOf(r1);
        r2.b(r1);
        r2.a(r6);
        yx.a(r2, r13);
    L_0x03a7:
        r1 = h;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x03f0;
    L_0x03af:
        r1 = "ParticipantsManegmentAsyncTask";
        r2 = "1";
        r4.putString(r1, r2);
    L_0x03b6:
        r0.send(r10, r4);
        goto L_0x0017;
    L_0x03bb:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x038b;
    L_0x03c0:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r3.add(r6);
        r6 = "";
        h = r6;
        r6 = java.lang.Boolean.valueOf(r2);
        g = r6;
        r1 = zj.a(r5, r1, r3, r13);
        aer.a(r1);
    L_0x03d9:
        r1 = g;
        r1 = r1.booleanValue();
        if (r1 != 0) goto L_0x03a7;
    L_0x03e1:
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x03eb }
        r2 = r2 + 1000;
        if (r2 <= r11) goto L_0x03d9;
    L_0x03ea:
        goto L_0x03a7;
    L_0x03eb:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x03a7;
    L_0x03f0:
        r1 = "ParticipantsManegmentAsyncTask";
        r2 = "0";
        r4.putString(r1, r2);
        goto L_0x03b6;
    L_0x03f8:
        r6 = move-exception;
        goto L_0x0115;
    L_0x03fb:
        r1 = move-exception;
        goto L_0x0203;
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.seraj.fanoos.communication.IntentServiceGeneralCommand.onHandleIntent(android.content.Intent):void");
    }

    private void b(String str) {
        FileChannel channel;
        File externalStorageDirectory;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                externalStorageDirectory = new File(str);
                channel = new FileInputStream(externalStorageDirectory).getChannel();
                this.d = new FileInputStream(externalStorageDirectory);
                channel.close();
                Long.valueOf(externalStorageDirectory.length());
            }
        } catch (Exception e) {
            try {
                externalStorageDirectory = Environment.getExternalStorageDirectory();
                File dataDirectory = Environment.getDataDirectory();
                if (externalStorageDirectory.canWrite()) {
                    externalStorageDirectory = new File(dataDirectory, str);
                    channel = new FileInputStream(externalStorageDirectory).getChannel();
                    this.d = new FileInputStream(externalStorageDirectory);
                    channel.close();
                }
            } catch (Exception e2) {
                this.f = Boolean.valueOf(true);
            }
        }
    }

    void a() {
        String str = "test2.pdf";
        String str2 = "\r\n";
        String str3 = "--";
        String str4 = "*****";
        String str5 = "fSnd";
        try {
            Log.e(str5, "Starting Http File Sending to URL");
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.a.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str4);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"mobileNumber\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.b);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"parameters\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.c);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + str + "\"" + str2);
            dataOutputStream.writeBytes(str2);
            Log.e(str5, "Headers are written");
            int min = Math.min(this.d.available(), 1024);
            byte[] bArr = new byte[min];
            int read = this.d.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(this.d.available(), 1024);
                read = this.d.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            this.d.close();
            dataOutputStream.flush();
            h = String.valueOf(httpURLConnection.getResponseCode());
            Log.e(str5, "File Sent, Response: " + String.valueOf(httpURLConnection.getResponseCode()));
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                min = inputStream.read();
                if (min != -1) {
                    stringBuffer.append((char) min);
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    h = stringBuffer2;
                    this.e = stringBuffer2;
                    dataOutputStream.close();
                    return;
                }
            }
        } catch (Throwable e) {
            this.f = Boolean.valueOf(true);
            Log.e(str5, "URL error: " + e.getMessage(), e);
        } catch (Throwable e2) {
            this.f = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            this.f = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e22.getMessage(), e22);
        }
    }
}
