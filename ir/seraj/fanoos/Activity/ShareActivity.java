package ir.seraj.fanoos.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import ir.seraj.fanoos3.R;
import my;
import xg;
import xh;
import xi;

public class ShareActivity extends ActionBarActivity {
    xi n;
    public ViewPager o;
    String p;
    public String q;
    public int r;

    void c(Intent intent) {
        if (intent.getStringExtra("android.intent.extra.TEXT") != null) {
            this.r = 2;
        }
    }

    void d(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            this.q = uri.toString();
            this.r = 2;
        }
    }

    void e(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            this.q = uri.getPath();
            this.r = 3;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_forward);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (!"android.intent.action.SEND".equals(action) || type == null) {
            this.p = getIntent().getStringExtra("MessageId");
        } else if ("text/plain".equals(type)) {
            c(intent);
        } else if (type.startsWith("image/")) {
            d(intent);
        } else if (type.startsWith("video/")) {
            e(intent);
        }
        ActionBar g = g();
        this.n = new xi(this, f());
        this.o = (ViewPager) findViewById(R.id.pager);
        this.o.setAdapter(this.n);
        this.o.setOnPageChangeListener(new xg(this));
        my xhVar = new xh(this);
        g.b(2);
        g.a(g.b().a((CharSequence) "\u06af\u0641\u062a\u06af\u0648\u0647\u0627").a(xhVar));
        g.a(g.b().a((CharSequence) "\u062f\u0648\u0633\u062a\u0627\u0646").a(xhVar));
    }
}
