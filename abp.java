import ir.seraj.fanoos.Fragment.ConversationFragment;
import java.util.Collections;

class abp extends Thread {
    final /* synthetic */ abo a;

    abp(abo abo) {
        this.a = abo;
    }

    public void run() {
        this.a.a.aQ = 0;
        this.a.a.aJ = Boolean.valueOf(false);
        while (this.a.a.aH.booleanValue() && this.a.a.aQ < 60000) {
            try {
                Thread.sleep(1000);
                ConversationFragment conversationFragment = this.a.a;
                conversationFragment.aQ += 1000;
                if (this.a.a.aQ <= 3000) {
                    this.a.a.aJ = Boolean.valueOf(true);
                } else {
                    this.a.a.aJ = Boolean.valueOf(false);
                }
                this.a.a.h().runOnUiThread(new abq(this));
            } catch (InterruptedException e) {
                return;
            } catch (Exception e2) {
                return;
            }
        }
        if (this.a.a.aI.booleanValue()) {
            this.a.a.aG.a(false);
        }
        this.a.a.aH = Boolean.valueOf(false);
        this.a.a.aI = Boolean.valueOf(false);
        this.a.a.h().runOnUiThread(new abr(this));
        if (this.a.a.aQ <= 3000) {
            this.a.a.aJ = Boolean.valueOf(true);
            return;
        }
        this.a.a.f = this.a.a.aK;
        this.a.a.aT = new yz();
        this.a.a.aT.c(String.valueOf(4));
        this.a.a.aT.b(this.a.a.f);
        if (this.a.a.ay.intValue() == 1) {
            yz.b(this.a.a.h(), this.a.a.aT, this.a.a.f, String.valueOf(this.a.a.ax));
            this.a.a.az = zc.b(this.a.a.h(), this.a.a.ax, this.a.a.az.size() + 50);
            Collections.reverse(this.a.a.az);
            return;
        }
        yz.a(this.a.a.h(), this.a.a.aT, this.a.a.f, this.a.a.ax);
        this.a.a.az = zc.a(this.a.a.h(), this.a.a.ax, this.a.a.az.size() + 50);
        Collections.reverse(this.a.a.az);
    }
}
