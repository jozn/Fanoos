package ir.seraj.fanoos.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import ir.seraj.fanoos.Fragment.GroupInfoFragment;
import ir.seraj.fanoos3.R;

public class GroupInfoActivity extends ActionBarActivity {
    String n;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_group_info);
        this.n = getIntent().getStringExtra("GroupId");
        if (bundle == null) {
            Fragment groupInfoFragment = new GroupInfoFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("GroupId", this.n);
            groupInfoFragment.g(bundle2);
            f().a().a(R.id.container, groupInfoFragment).b();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_group_info, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
