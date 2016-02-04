import android.util.Log;
import ir.seraj.fanoos3.R;

class abr implements Runnable {
    final /* synthetic */ abp a;

    abr(abp abp) {
        this.a = abp;
    }

    public void run() {
        this.a.a.a.av.setVisibility(8);
        this.a.a.a.aL.setVisibility(8);
        this.a.a.a.d.setVisibility(8);
        this.a.a.a.aN.setVisibility(8);
        this.a.a.a.aM.setVisibility(0);
        this.a.a.a.g.setVisibility(8);
        this.a.a.a.aN.setText("60");
        this.a.a.a.au = Integer.valueOf(0);
        this.a.a.a.aq.setImageResource(R.drawable.ic_add_media);
        this.a.a.a.aM.setImageResource(R.drawable.ic_action_free_record);
        this.a.a.a.aA.a(this.a.a.a.az);
        Log.i("adaptor", "4");
        this.a.a.a.aB.setAdapter(this.a.a.a.aA);
    }
}
