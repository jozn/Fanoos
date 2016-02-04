import android.graphics.Color;

class abq implements Runnable {
    final /* synthetic */ abp a;

    abq(abp abp) {
        this.a = abp;
    }

    public void run() {
        if (60 - (this.a.a.a.aQ / 1000) < 10) {
            this.a.a.a.aN.setTextColor(Color.parseColor("#FF0000"));
        } else {
            this.a.a.a.aN.setTextColor(Color.parseColor("#5889ff"));
        }
        this.a.a.a.aN.setText(String.valueOf(60 - (this.a.a.a.aQ / 1000)));
    }
}
