package ir.seraj.fanoos.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import ir.seraj.fanoos.Fragment.CreateGroupFragment;
import ir.seraj.fanoos3.R;

public class CreateGroupActivity extends ActionBarActivity {
    public void b(boolean z) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (z) {
            toolbar.setVisibility(8);
        } else {
            toolbar.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_create_group);
        if (bundle == null) {
            f().a().a(R.id.container, new CreateGroupFragment()).b();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_group, menu);
        return true;
    }
}
