import android.graphics.Bitmap;

class aaz implements Runnable {
    Bitmap a;
    aba b;
    final /* synthetic */ aay c;

    public aaz(aay aay, Bitmap bitmap, aba aba) {
        this.c = aay;
        this.a = bitmap;
        this.b = aba;
    }

    public void run() {
        if (!this.c.a(this.b) && this.a != null) {
            if (this.c.d.booleanValue()) {
                this.c.a(this.b.b, this.a);
            } else {
                this.b.b.setImageBitmap(this.a);
            }
        }
    }
}
