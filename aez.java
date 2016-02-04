import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import org.xmlpull.v1.XmlPullParser;

public class aez extends AsyncTask {
    static String b;
    static Boolean m;
    Context a;
    String c;
    ProgressDialog d;
    String e;
    URL f;
    String g;
    String h;
    FileInputStream i;
    String j;
    String k;
    Boolean l;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    static {
        b = XmlPullParser.NO_NAMESPACE;
        m = Boolean.valueOf(false);
    }

    public aez(Context context, String str, String str2, String str3) {
        this.i = null;
        this.a = context;
        this.g = aeq.o(this.a);
        this.d = new ProgressDialog(context);
        this.c = str;
        this.j = str2;
        this.e = str3;
        this.l = Boolean.valueOf(false);
        this.k = XmlPullParser.NO_NAMESPACE;
        try {
            this.f = new URL("http://94.182.227.16/getfilesnew/");
        } catch (MalformedURLException e) {
            this.l = Boolean.valueOf(true);
            e.printStackTrace();
        }
    }

    public static void a(String str) {
        b = str;
        m = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        int i;
        if (!this.c.equals(XmlPullParser.NO_NAMESPACE)) {
            b = XmlPullParser.NO_NAMESPACE;
            m = Boolean.valueOf(false);
            aer.a(zj.b(this.g, this.e, this.c, this.a));
            i = 0;
            while (!m.booleanValue()) {
                try {
                    Thread.sleep(1000);
                    i += 1000;
                    if (i > 20000) {
                        return Integer.valueOf(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (b.equals("1")) {
                return Integer.valueOf(1);
            }
            return Integer.valueOf(0);
        } else if (TextUtils.isEmpty(this.j)) {
            return Integer.valueOf(0);
        } else {
            this.h = zj.c(this.g, String.valueOf(2), this.a);
            b(this.j);
            if (this.l.booleanValue()) {
                return Integer.valueOf(0);
            }
            a();
            b = XmlPullParser.NO_NAMESPACE;
            m = Boolean.valueOf(false);
            aer.a(zj.c(this.g, this.e, ys.c(this.a, this.k), this.a));
            i = 0;
            while (!m.booleanValue()) {
                try {
                    Thread.sleep(1000);
                    i += 1000;
                    if (i > 20000) {
                        return Integer.valueOf(0);
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (b.equals("1")) {
                return Integer.valueOf(1);
            }
            return Integer.valueOf(0);
        }
    }

    protected void onPreExecute() {
        this.d.setCancelable(false);
        this.d.setMessage("\u062f\u0631 \u062d\u0627\u0644 \u0628\u0631\u0648\u0632\u0631\u0633\u0627\u0646\u06cc \u06af\u0631\u0648\u0647");
        this.d.show();
    }

    protected void a(Integer num) {
        this.d.dismiss();
        if (num.intValue() == 0) {
            new zt().b(this.a);
            return;
        }
        this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastUpdateGroupInfo"));
    }

    protected void a(Integer... numArr) {
    }

    void a() {
        String str = "test2.pdf";
        String str2 = "\r\n";
        String str3 = "--";
        String str4 = "*****";
        String str5 = "fSnd";
        try {
            Log.e(str5, "Starting Http File Sending to URL");
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.f.openConnection();
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
            dataOutputStream.writeBytes(this.g);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"parameters\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.h);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + str + "\"" + str2);
            dataOutputStream.writeBytes(str2);
            Log.e(str5, "Headers are written");
            int min = Math.min(this.i.available(), 1024);
            byte[] bArr = new byte[min];
            int read = this.i.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(this.i.available(), 1024);
                read = this.i.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            this.i.close();
            dataOutputStream.flush();
            b = String.valueOf(httpURLConnection.getResponseCode());
            Log.e(str5, "File Sent, Response: " + String.valueOf(httpURLConnection.getResponseCode()));
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                min = inputStream.read();
                if (min != -1) {
                    stringBuffer.append((char) min);
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    b = stringBuffer2;
                    this.k = stringBuffer2;
                    dataOutputStream.close();
                    return;
                }
            }
        } catch (Throwable e) {
            this.l = Boolean.valueOf(true);
            Log.e(str5, "URL error: " + e.getMessage(), e);
        } catch (Throwable e2) {
            this.l = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            this.l = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e22.getMessage(), e22);
        }
    }

    private void b(String str) {
        File externalStorageDirectory;
        FileChannel channel;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                externalStorageDirectory = new File(str);
                channel = new FileInputStream(externalStorageDirectory).getChannel();
                this.i = new FileInputStream(externalStorageDirectory);
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
                    this.i = new FileInputStream(externalStorageDirectory);
                    channel.close();
                }
            } catch (Exception e2) {
                this.l = Boolean.valueOf(true);
            }
        }
    }
}
