import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import java.util.Collections;

public class aca extends BroadcastReceiver {
    final /* synthetic */ ConversationFragment a;

    public aca(ConversationFragment conversationFragment) {
        this.a = conversationFragment;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("ir.dayasoft.BroadCastSizeError")) {
            Toast.makeText(this.a.h(), "\u062d\u062c\u0645 \u0641\u0627\u06cc\u0644 \u0628\u06cc\u0634\u062a\u0631 \u0627\u0632 \u062d\u062c\u0645 \u0645\u062c\u0627\u0632 \u0645\u06cc \u0628\u0627\u0634\u062f", 1).show();
        }
        Log.i("adaptor", "6");
        int firstVisiblePosition = this.a.aB.getFirstVisiblePosition();
        if (this.a.ay.intValue() == 1) {
            this.a.az = zc.b(this.a.h(), this.a.ax, this.a.az.size());
            Collections.reverse(this.a.az);
        } else {
            if (this.a.az.size() < 10) {
                this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size() + 1);
            } else {
                this.a.az = zc.a(this.a.h(), this.a.ax, this.a.az.size());
            }
            Collections.reverse(this.a.az);
        }
        int size = this.a.az.size();
        if (intent.getAction().equals("ir.dayasoft.BroadCastGetDeliverMessage")) {
            this.a.aA.a(this.a.az);
            Log.i("adaptor", "7");
            this.a.aB.setAdapter(this.a.aA);
        }
        this.a.aA.a(this.a.az);
        Log.i("adaptor", "8");
        this.a.aB.setAdapter(this.a.aA);
        if (this.a.ay.intValue() == 1) {
            if (yw.c(String.valueOf(this.a.ax), this.a.h()).f().equals(yw.m)) {
                this.a.aw.setVisibility(0);
                this.a.at.setVisibility(8);
            } else {
                this.a.aw.setVisibility(4);
                this.a.at.setVisibility(0);
            }
        }
        if (size - firstVisiblePosition > 10 && firstVisiblePosition != 0) {
            Log.i("adaptor", "9");
            this.a.aB.setSelection(firstVisiblePosition);
            Log.i("conversation", String.valueOf(size) + " " + String.valueOf(firstVisiblePosition));
        }
        Log.i("conversation rec", String.valueOf(size) + " " + String.valueOf(firstVisiblePosition));
    }
}
