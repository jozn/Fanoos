import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;

public class afp extends AsyncTask {
    Context a;
    URL b;
    String c;
    String d;
    String e;
    yz f;
    ze g;
    FileInputStream h;
    String i;
    String j;
    Boolean k;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    public afp(Context context, yz yzVar, ze zeVar, String str) {
        this.h = null;
        this.a = context;
        this.f = yzVar;
        this.g = zeVar;
        this.i = str;
        this.k = Boolean.valueOf(false);
        this.j = XmlPullParser.NO_NAMESPACE;
        try {
            this.b = new URL("http://94.182.227.16/getfilesnew/");
        } catch (MalformedURLException e) {
            this.k = Boolean.valueOf(true);
            e.printStackTrace();
        }
    }

    private void a(String str) {
        File externalStorageDirectory;
        FileChannel channel;
        try {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
            Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                externalStorageDirectory = new File(str);
                channel = new FileInputStream(externalStorageDirectory).getChannel();
                this.h = new FileInputStream(externalStorageDirectory);
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
                    this.h = new FileInputStream(externalStorageDirectory);
                    channel.close();
                }
            } catch (Exception e2) {
                this.k = Boolean.valueOf(true);
            }
        }
    }

    protected Integer a(String... strArr) {
        this.d = aeq.o(this.a);
        this.e = zj.c(this.d, this.f.f(), this.a);
        switch (Integer.valueOf(this.f.f()).intValue()) {
            case ve.CropImageView_aspectRatioX /*2*/:
                a(this.i);
                try {
                    if (this.h.getChannel().size() < 14000000) {
                        a();
                        break;
                    }
                    ze.e(this.a, String.valueOf(this.g.a()));
                    this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastSizeError"));
                    return Integer.valueOf(0);
                } catch (Exception e) {
                    return Integer.valueOf(0);
                }
            case ve.CropImageView_aspectRatioY /*3*/:
                a(this.i);
                try {
                    if (this.h.getChannel().size() < 14000000) {
                        a();
                        break;
                    }
                    ze.e(this.a, String.valueOf(this.g.a()));
                    this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastSizeError"));
                    return Integer.valueOf(0);
                } catch (Exception e2) {
                    return Integer.valueOf(0);
                }
            case ve.CropImageView_imageResource /*4*/:
                a(this.i);
                try {
                    if (this.h.getChannel().size() < 14000000) {
                        a();
                        break;
                    }
                    ze.e(this.a, String.valueOf(this.g.a()));
                    this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastSizeError"));
                    return Integer.valueOf(0);
                } catch (Exception e3) {
                    return Integer.valueOf(0);
                }
            case Node.CDSECT /*5*/:
                a(this.i);
                try {
                    if (this.h.getChannel().size() < 14000000) {
                        a();
                        break;
                    }
                    ze.e(this.a, String.valueOf(this.g.a()));
                    this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastSizeError"));
                    return Integer.valueOf(0);
                } catch (Exception e4) {
                    return Integer.valueOf(0);
                }
            case Node.ENTITY_REF /*6*/:
                a(this.i);
                a();
                break;
            case Node.IGNORABLE_WHITESPACE /*7*/:
                a(this.i);
                a();
                break;
        }
        try {
            if (!this.k.booleanValue()) {
                this.f.b(ys.c(this.a, this.j));
                aer.a(zj.a(this.d, this.f, this.g, this.a));
                Thread.sleep(5000);
                ze.c(this.a, String.valueOf(this.g.a()));
            } else if (ze.c(this.a, this.g) == 1) {
                this.a.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetDeliverMessage"));
                return Integer.valueOf(0);
            }
        } catch (Exception e5) {
            this.k = Boolean.valueOf(true);
        }
        return Integer.valueOf(0);
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
            int min = Math.min(this.h.available(), 1024);
            byte[] bArr = new byte[min];
            int read = this.h.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(this.h.available(), 1024);
                read = this.h.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            this.h.close();
            dataOutputStream.flush();
            this.c = String.valueOf(httpURLConnection.getResponseCode());
            Log.e(str5, "File Sent, Response: " + String.valueOf(httpURLConnection.getResponseCode()));
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                min = inputStream.read();
                if (min != -1) {
                    stringBuffer.append((char) min);
                } else {
                    String stringBuffer2 = stringBuffer.toString();
                    this.c = stringBuffer2;
                    this.j = stringBuffer2;
                    dataOutputStream.close();
                    return;
                }
            }
        } catch (Throwable e) {
            this.k = Boolean.valueOf(true);
            Log.e(str5, "URL error: " + e.getMessage(), e);
        } catch (Throwable e2) {
            this.k = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e2.getMessage(), e2);
        } catch (Throwable e22) {
            this.k = Boolean.valueOf(true);
            Log.e(str5, "IO error: " + e22.getMessage(), e22);
        }
    }
}
