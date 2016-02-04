package ir.seraj.fanoos.Activity;

import aeq;
import afk;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;
import wr;
import ws;
import ys;
import zt;

public class RestoreActivity extends ActionBarActivity implements afk {
    public MyResultReceiver n;
    ProgressDialog o;
    TextView p;
    Button q;
    Button r;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_restore);
        this.n = new MyResultReceiver(new Handler());
        this.o = new ProgressDialog(this);
        this.p = (TextView) findViewById(R.id.restore_warning_title_textView);
        this.q = (Button) findViewById(R.id.restore_ok_button);
        this.r = (Button) findViewById(R.id.restore_cancel_button);
        this.r.setOnClickListener(new wr(this));
        this.q.setOnClickListener(new ws(this));
        Intent intent = new Intent(this, IntentServiceGeneralCommand.class);
        intent.putExtra("receiverTag", this.n);
        intent.putExtra("CommandCode", 6);
        startService(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_restore, menu);
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
        aeq.o(this);
        if (i2 == 6) {
            if (i == 0) {
                this.o.setCancelable(false);
                this.o.setMessage("\u062f\u0631 \u062d\u0627\u0644 \u0628\u0631\u0642\u0631\u0627\u0631\u06cc \u0627\u0631\u062a\u0628\u0627\u0637");
                this.o.show();
                return;
            }
            this.o.dismiss();
            str = bundle.getString("haveMessageBefor");
            if (str.equals("1")) {
                this.p.setText("\u0634\u0645\u0627 \u0637\u06cc 5 \u0631\u0648\u0632 \u06af\u0630\u0634\u062a\u0647 " + bundle.getInt("userMsg") + " \u067e\u06cc\u0627\u0645 \u0634\u062e\u0635\u06cc \u0648 " + bundle.getInt("groupMsg") + " \u067e\u06cc\u0627\u0645 \u06af\u0631\u0648\u0647\u06cc \u062f\u0627\u0634\u062a\u0647 \u0627\u06cc\u062f");
            } else if (str.equals("0")) {
                ys.c(this);
                startActivity(new Intent(this, ProfileCreateActivity.class));
            } else {
                new zt().b(this);
            }
        } else if (i2 != 3) {
        } else {
            if (i == 0) {
                this.o.setCancelable(false);
                this.o.setMessage("\u062f\u0631 \u062d\u0627\u0644 \u0628\u0627\u0632\u06cc\u0627\u0628\u06cc \u067e\u06cc\u0627\u0645\u0647\u0627\u06cc \u06af\u0630\u0634\u062a\u0647 \u0639\u0645\u0644\u06cc\u0627\u062a \u0628\u0627\u0632\u06cc\u0627\u0628\u06cc \u0645\u0645\u06a9\u0646 \u0627\u0633\u062a \u0627\u0646\u062f\u06a9\u06cc \u0637\u0648\u0644 \u0628\u06a9\u0634\u062f \u060c\u0644\u0637\u0641\u0627 \u0635\u0628\u0631 \u06a9\u0646\u06cc\u062f");
                this.o.show();
                return;
            }
            this.o.dismiss();
            startActivity(new Intent(this, ProfileCreateActivity.class));
        }
    }

    protected void onPause() {
        this.n.a(null);
        super.onPause();
    }

    protected void onResume() {
        this.n.a(this);
        super.onResume();
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, ProfileCreateActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
