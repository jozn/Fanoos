package ir.seraj.fanoos.Activity;

import aeq;
import afk;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;
import wd;
import ys;
import zt;

public class EnterPhoneNumberActivity extends ActionBarActivity implements afk {
    public EditText n;
    public MyResultReceiver o;
    ProgressDialog p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_enter_phone_number);
        g().c();
        this.o = new MyResultReceiver(new Handler());
        this.p = new ProgressDialog(this);
        Button button = (Button) findViewById(R.id.registration_submit);
        this.n = (EditText) findViewById(R.id.registration_phone);
        button.setOnClickListener(new wd(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_enter_phone_number, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void a(int i, Bundle bundle) {
        int i2;
        String str = XmlPullParser.NO_NAMESPACE;
        if (bundle != null) {
            i2 = bundle.getInt("CommandCode");
        } else {
            i2 = 0;
        }
        String o = aeq.o(this);
        if (i2 == 0) {
            str = bundle.getString("d");
            if (i == 0) {
                this.p.setCancelable(false);
                this.p.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0628\u0631\u0642\u0631\u0627\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637");
                this.p.show();
                return;
            }
            this.p.dismiss();
            if (str.equals(o)) {
                new zt().a(o, this.o, (Context) this);
            } else if (str.equals("-1")) {
                new zt().a(this);
            } else {
                new zt().b(this);
            }
        } else if (i2 == 1) {
            str = bundle.getString("resGetVerificationCodeAsync");
            if (i == 0) {
                this.p.setCancelable(false);
                this.p.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0627\u0631\u0633\u0627\u0644 \u06a9\u062f \u0641\u0639\u0627\u0644\u0633\u0627\u0632\u06cc");
                this.p.show();
                return;
            }
            this.p.dismiss();
            if (str.equals("1")) {
                ys.b((Context) this, Boolean.valueOf(true));
                startActivity(new Intent(this, SmsVerificationActivity.class));
            } else if (str.equals("-1")) {
                new zt().a(this);
            } else {
                ys.b((Context) this, Boolean.valueOf(true));
                startActivity(new Intent(this, SmsVerificationActivity.class));
            }
        }
    }

    protected void onResume() {
        this.o.a(this);
        super.onResume();
        if (ys.p(this).booleanValue()) {
            finish();
        }
    }

    protected void onPause() {
        this.o.a(null);
        super.onPause();
    }
}
