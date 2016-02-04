package ir.seraj.fanoos.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import ir.seraj.fanoos3.R;
import my;
import we;
import wf;
import wg;

public class ForwardActivity extends ActionBarActivity {
    wg n;
    public ViewPager o;
    public String p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_forward);
        this.p = getIntent().getStringExtra("MessageId");
        ActionBar g = g();
        this.n = new wg(this, f());
        this.o = (ViewPager) findViewById(R.id.pager);
        this.o.setAdapter(this.n);
        this.o.setOnPageChangeListener(new we(this));
        my wfVar = new wf(this);
        g.b(2);
        g.a(g.b().a((CharSequence) "\u06af\u0641\u062a\u06af\u0648\u0647\u0627").a(wfVar));
        g.a(g.b().a((CharSequence) "\u062f\u0648\u0633\u062a\u0627\u0646").a(wfVar));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
