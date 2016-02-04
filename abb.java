import android.graphics.Bitmap;

class abb implements Runnable {
    aba a;
    final /* synthetic */ aay b;

    abb(aay aay, aba aba) {
        this.b = aay;
        this.a = aba;
    }

    public void run() {
        try {
            if (!this.b.a(this.a)) {
                Bitmap a = this.b.a(this.a.a);
                this.b.a.a(this.a.a, a);
                if (!this.b.a(this.a)) {
                    this.b.h.post(new aaz(this.b, a, this.a));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
