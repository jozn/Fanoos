import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

public class aff extends AsyncTask {
    Context a;
    URL b;
    String c;
    String d;
    FileInputStream e;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Integer[]) objArr);
    }

    public aff(Context context, String str, String str2, String str3) {
        this.e = null;
        this.a = context;
        try {
            this.b = new URL(str);
            this.c = str2;
            this.d = str3;
        } catch (Exception e) {
            Log.i("HttpFileUpload", "URL Malformatted");
        }
    }

    protected Integer a(String... strArr) {
        b();
        a();
        return Integer.valueOf(0);
    }

    protected void onPreExecute() {
    }

    protected void a(Integer num) {
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
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"project\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.c);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"DBNAme\"" + str2);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(this.d);
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str2);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + this.d + "\"" + str2);
            dataOutputStream.writeBytes(str2);
            Log.e(str5, "Headers are written");
            int min = Math.min(this.e.available(), 1024);
            byte[] bArr = new byte[min];
            int read = this.e.read(bArr, 0, min);
            while (read > 0) {
                dataOutputStream.write(bArr, 0, min);
                min = Math.min(this.e.available(), 1024);
                read = this.e.read(bArr, 0, min);
            }
            dataOutputStream.writeBytes(str2);
            dataOutputStream.writeBytes(str3 + str4 + str3 + str2);
            this.e.close();
            dataOutputStream.flush();
            Log.e(str5, "File Sent, Response: " + String.valueOf(httpURLConnection.getResponseCode()));
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                min = inputStream.read();
                if (min != -1) {
                    stringBuffer.append((char) min);
                } else {
                    Log.i("Response", stringBuffer.toString());
                    dataOutputStream.close();
                    return;
                }
            }
        } catch (Throwable e) {
            Log.e(str5, "URL error: " + e.getMessage(), e);
        } catch (Throwable e2) {
            Log.e(str5, "IO error: " + e2.getMessage(), e2);
        }
    }

    private void b() {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File dataDirectory = Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                String str = zk.f + File.separator + "DbSystem600";
                File file = new File(dataDirectory, "//data//ir.seraj.fanoos3//databases//DbSystem");
                File file2 = new File(externalStorageDirectory, str);
                Object channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                channel2.transferFrom(channel, 0, channel.size());
                FileInputStream fileInputStream = new FileInputStream(file);
                channel.close();
                channel2.close();
                this.e = fileInputStream;
            }
        } catch (Exception e) {
            Toast.makeText(this.a, "Backup Failed!", 0).show();
        }
    }
}
