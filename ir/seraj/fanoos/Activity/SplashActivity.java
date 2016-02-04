package ir.seraj.fanoos.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import ir.seraj.fanoos3.R;
import xl;
import ys;

public class SplashActivity extends ActionBarActivity {
    private Runnable n;

    public SplashActivity() {
        this.n = new xl(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ys.k(this).booleanValue()) {
            if (ys.p(this).booleanValue()) {
                startActivity(new Intent(this, ChatsActivity.class));
                finish();
                return;
            }
            startActivity(new Intent(this, ProfileCreateActivity.class));
            finish();
        } else if (!ys.m(this).booleanValue()) {
            setContentView((int) R.layout.activity_splash);
            g().c();
            new Handler().postDelayed(this.n, 5000);
        } else if (ys.n(this).booleanValue()) {
            Intent intent = new Intent(this, SmsVerificationActivity.class);
            intent.putExtra("IsForwardFromIntro", true);
            startActivity(intent);
            finish();
        } else {
            startActivity(new Intent(this, EnterPhoneNumberActivity.class));
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
