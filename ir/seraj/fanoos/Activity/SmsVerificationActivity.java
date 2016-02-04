package ir.seraj.fanoos.Activity;

import aeq;
import afk;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;
import xj;
import xk;
import ys;
import zt;

public class SmsVerificationActivity extends ActionBarActivity implements afk {
    public EditText n;
    Boolean o;
    public MyResultReceiver p;
    ProgressDialog q;

    public SmsVerificationActivity() {
        this.o = Boolean.valueOf(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sms_verification);
        g().c();
        this.p = new MyResultReceiver(new Handler());
        this.q = new ProgressDialog(this);
        this.n = (EditText) findViewById(R.id.verification_code);
        ((Button) findViewById(R.id.verification_submit)).setOnClickListener(new xj(this));
        ((LinearLayout) findViewById(R.id.verification_call_LL)).setOnClickListener(new xk(this));
    }

    protected void onResume() {
        this.p.a(this);
        if (ys.p(this).booleanValue()) {
            finish();
        }
        super.onPause();
    }

    protected void onPause() {
        this.p.a(null);
        super.onPause();
    }

    public void onBackPressed() {
        finish();
    }

    public void a(int i, Bundle bundle) {
        int i2;
        String str = XmlPullParser.NO_NAMESPACE;
        if (bundle != null) {
            i2 = bundle.getInt("CommandCode");
        } else {
            i2 = 0;
        }
        aeq.o(this);
        if (i2 == 2) {
            str = bundle.getString("res");
            if (i == 0) {
                this.q.setCancelable(false);
                this.q.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0628\u0631\u0642\u0631\u0627\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637");
                this.q.show();
                return;
            }
            this.q.dismiss();
            if (str.equals("1")) {
                startActivity(new Intent(this, RestoreActivity.class));
            } else if (str.equals("0")) {
                new zt().c(this);
            } else {
                new zt().b(this);
            }
        }
    }
}
