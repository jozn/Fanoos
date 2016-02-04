package ir.seraj.fanoos.Activity;

import aeq;
import afa;
import afb;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import ir.seraj.fanoos.Fragment.RecentChatsFragment;
import ir.seraj.fanoos3.R;
import vu;
import vv;
import vw;
import vx;
import vy;
import vz;
import wa;
import wb;
import wc;
import ys;
import zt;

public class ChatsActivity extends ActionBarActivity {
    public EditText A;
    public wc n;
    public FrameLayout o;
    public FrameLayout p;
    FrameLayout q;
    ProgressBar r;
    ImageView s;
    FrameLayout t;
    FrameLayout u;
    FrameLayout v;
    FrameLayout w;
    public Toolbar x;
    public Boolean y;
    FrameLayout z;

    public ChatsActivity() {
        this.y = Boolean.valueOf(false);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_chats);
        if (ys.q(this).length() > 5) {
            new zt().c(ys.q(this), ys.r(this), this);
        }
        new afb(this).execute(new String[0]);
        aeq.d((Context) this, Boolean.valueOf(false));
        k();
        j();
        if (bundle == null) {
            Object recentChatsFragment = new RecentChatsFragment();
            this.n = recentChatsFragment;
            f().a().a(R.id.container, recentChatsFragment, "RecentChatsFragment").b();
        }
    }

    public void a(Boolean bool) {
        this.y = bool;
    }

    public void a(Boolean bool, Boolean bool2) {
        if (bool.booleanValue()) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(4);
        }
        if (bool2.booleanValue()) {
            this.r.setVisibility(0);
            this.s.setVisibility(4);
            return;
        }
        this.r.setVisibility(4);
        this.s.setVisibility(0);
    }

    private void j() {
        this.o = (FrameLayout) findViewById(R.id.toolbar_header_frame_menu1_frameLayout);
        this.p = (FrameLayout) findViewById(R.id.toolbar_header_frame_menu2_frameLayout);
        this.q = (FrameLayout) findViewById(R.id.toolbar_header_frame_menu4_frameLayout);
        this.r = (ProgressBar) findViewById(R.id.toolbar_header_frame_refresh_progressBar);
        this.s = (ImageView) findViewById(R.id.toolbar_header_menu4_imageView);
        this.s.setOnClickListener(new vu(this));
        this.o.setOnClickListener(new vv(this));
        this.p.setOnClickListener(new vw(this));
        this.t = (FrameLayout) findViewById(R.id.toolbar_footer_frame_menu1_frameLayout);
        this.u = (FrameLayout) findViewById(R.id.toolbar_footer_frame_menu2_frameLayout);
        this.v = (FrameLayout) findViewById(R.id.toolbar_footer_frame_menu3_frameLayout);
        this.w = (FrameLayout) findViewById(R.id.toolbar_footer_frame_menu4_frameLayout);
        this.t.setOnClickListener(new vx(this));
        this.u.setOnClickListener(new vy(this));
        this.v.setOnClickListener(new vz(this));
        this.w.setOnClickListener(new wa(this));
    }

    private void k() {
        this.x = (Toolbar) findViewById(R.id.toolbarSearchFooter);
        this.z = (FrameLayout) findViewById(R.id.toolbar_footer_frame_search_frameLayout);
        this.A = (EditText) findViewById(R.id.toolbar_footer_search_editText);
        this.A.addTextChangedListener(new wb(this));
    }

    public void onBackPressed() {
        if (this.y.booleanValue()) {
            this.x.setVisibility(8);
            sendBroadcast(new Intent("ir.dayasoft.BroadCastBackPress"));
            this.y = Boolean.valueOf(false);
            return;
        }
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chats, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        new afa(this, Integer.valueOf(1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        super.onResume();
    }

    protected void onPause() {
        new afa(this, Integer.valueOf(0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        super.onPause();
    }
}
