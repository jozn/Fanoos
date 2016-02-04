package ir.seraj.fanoos.Activity;

import aay;
import afd;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos3.R;
import xm;
import xn;
import xo;
import yx;
import zg;
import zk;

public class UserInfoActivity extends ActionBarActivity {
    public zg n;
    aay o;
    public TextView p;
    BroadcastReceiver q;
    Boolean r;

    public UserInfoActivity() {
        this.q = new xo(this);
        this.r = Boolean.valueOf(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_user_info);
        String stringExtra = getIntent().getStringExtra("MobileNumber");
        this.o = new aay(this, null, Boolean.valueOf(true), Boolean.valueOf(true), zk.c);
        this.n = zg.a((Context) this, stringExtra);
        if (this.n.c().longValue() < 0) {
            yx b = yx.b(stringExtra, this);
            this.n.e(b.c());
            this.n.a(b.a());
        }
        TextView textView = (TextView) findViewById(R.id.userInfo_registration_phone);
        this.o.a(this.n.g(), (ImageView) findViewById(R.id.userInfo_profileImage_imageView), Integer.valueOf(R.drawable.default_image_profile));
        Button button = (Button) findViewById(R.id.userInfo_call_button);
        Button button2 = (Button) findViewById(R.id.userInfo_sms_button);
        TextView textView2 = (TextView) findViewById(R.id.userInfo_name_textView);
        this.p = (TextView) findViewById(R.id.userInfo_status_textView);
        textView2.setText(this.n.h());
        textView.setText(this.n.d());
        button.setOnClickListener(new xm(this));
        button2.setOnClickListener(new xn(this));
    }

    protected void onResume() {
        new afd(this, this.n.d(), Integer.valueOf(1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        if (!this.r.booleanValue()) {
            registerReceiver(this.q, new IntentFilter("ir.dayasoft.BroadCastConversationEvent"));
            this.r = Boolean.valueOf(true);
        }
        super.onResume();
    }

    protected void onPause() {
        new afd(this, this.n.d(), Integer.valueOf(0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        if (this.r.booleanValue()) {
            unregisterReceiver(this.q);
            this.r = Boolean.valueOf(false);
        }
        super.onPause();
    }
}
