import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ProgressBar;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import org.xmlpull.v1.XmlPullParser;

public class afe extends AsyncTask {
    static String c;
    static Boolean k;
    Context a;
    URL b;
    String d;
    String e;
    FileInputStream f;
    String g;
    String h;
    Boolean i;
    ProgressBar j;

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
        k = Boolean.valueOf(false);
    }

    public static void a(String str) {
        c = str;
        k = Boolean.valueOf(true);
    }

    protected Integer a(String... strArr) {
        this.d = aeq.o(this.a);
        this.e = zj.c(this.d, String.valueOf(2), this.a);
        b(this.g);
        a();
        try {
            if (this.i.booleanValue()) {
                return Integer.valueOf(0);
            }
            c = XmlPullParser.NO_NAMESPACE;
            k = Boolean.valueOf(false);
            aer.a(zj.b(this.d, ys.c(this.a, this.h), this.a));
            int i = 0;
            do {
                if (!k.booleanValue()) {
                    try {
                        Thread.sleep(1000);
                        i += 1000;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (!c.equals("1")) {
                    return Integer.valueOf(1);
                } else {
                    zp.a(zk.a, this.g.substring(this.g.lastIndexOf("/") + 1), zk.a + File.separator + "myProfileImage.jpg");
                    return Integer.valueOf(1);
                }
            } while (i <= 20000);
            return Integer.valueOf(0);
        } catch (Exception e2) {
            this.i = Boolean.valueOf(true);
            return Integer.valueOf(0);
        }
    }

    public afe(Context context, ProgressBar progressBar, String str) {
        this.f = null;
        this.a = context;
        this.g = str;
        this.i = Boolean.valueOf(false);
        this.h = XmlPullParser.NO_NAMESPACE;
        this.d = aeq.o(this.a);
        this.j = progressBar;
        try {
            this.b = new URL("http://94.182.227.16/getfilesnew/");
        } catch (MalformedURLException e) {
            this.i = Boolean.valueOf(true);
            e.printStackTrace();
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
                this.f = new FileInputStream(externalStorageDirectory);
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
                    this.f = new FileInputStream(externalStorageDirectory);
                    channel.close();
                }
            } catch (Exception e2) {
                this.i = Boolean.valueOf(true);
            }
        }
    }

    protected void onPreExecute() {
        this.j.setVisibility(0);
    }

    protected void a(Integer num) {
        this.j.setVisibility(8);
        if (num.intValue() == 0) {
            new zt().b(this.a);
        }
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
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.b.openConnection();
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
            dataOutputStream.writeBytes(this.d);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"parameters\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.e);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + str + "\"" + str2);
            dataOutputStream.writeBytes(str2);
            Log.e(str5, "Headers are written");
            int min = Math.min(this.f.available(), 1024);
            byte[] bArr = new byte[min];
            int read = this.f.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(this.f.available(), 1024);
                read = this.f.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            this.f.close();
            dataOutputStream.flush();
            c = String.valueOf(httpURLConnection.getResponseCode());
            Log.e(str5, "File Sent, Response: " + String.valueOf(httpURLConnection.getResponseCode()));
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                min = inputStream.read();
                if (min != -1) {
                    stringBuffer.append((char) min);
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    c = stringBuffer2;
                    this.h = stringBuffer2;
                    dataOutputStream.close();
                    return;
                }
            }
        } catch (Throwable e) {
            this.i = Boolean.valueOf(true);
            Log.e(str5, "URL error: " + e.getMessage(), e);
        } catch (Throwable e2) {
            this.i = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            this.i = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e22.getMessage(), e22);
        }
    }
}
