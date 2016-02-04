import android.content.Context;
import android.graphics.RectF;
import android.view.View;

class adu implements Runnable {
    final /* synthetic */ adq a;
    private final ael b;
    private int c;
    private int d;

    public adu(adq adq, Context context) {
        this.a = adq;
        this.b = ael.a(context);
    }

    public void a() {
        if (adq.c) {
            aef.a().a("PhotoViewAttacher", "Cancel Fling");
        }
        this.b.a(true);
    }

    public void a(int i, int i2, int i3, int i4) {
        RectF b = this.a.b();
        if (b != null) {
            int round;
            int i5;
            int round2;
            int i6;
            int round3 = Math.round(-b.left);
            if (((float) i) < b.width()) {
                round = Math.round(b.width() - ((float) i));
                i5 = 0;
            } else {
                round = round3;
                i5 = round3;
            }
            int round4 = Math.round(-b.top);
            if (((float) i2) < b.height()) {
                round2 = Math.round(b.height() - ((float) i2));
                i6 = 0;
            } else {
                round2 = round4;
                i6 = round4;
            }
            this.c = round3;
            this.d = round4;
            if (adq.c) {
                aef.a().a("PhotoViewAttacher", "fling. StartX:" + round3 + " StartY:" + round4 + " MaxX:" + round + " MaxY:" + round2);
            }
            if (round3 != round || round4 != round2) {
                this.b.a(round3, round4, i3, i4, i5, round, i6, round2, 0, 0);
            }
        }
    }

    public void run() {
        if (!this.b.b()) {
            View c = this.a.c();
            if (c != null && this.b.a()) {
                int c2 = this.b.c();
                int d = this.b.d();
                if (adq.c) {
                    aef.a().a("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + c2 + " NewY:" + d);
                }
                this.a.m.postTranslate((float) (this.c - c2), (float) (this.d - d));
                this.a.b(this.a.k());
                this.c = c2;
                this.d = d;
                adn.a(c, this);
            }
        }
    }
}
