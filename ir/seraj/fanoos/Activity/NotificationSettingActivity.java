package ir.seraj.fanoos.Activity;

import aeq;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import ir.seraj.fanoos3.R;
import wj;
import wk;
import wl;
import wm;

public class NotificationSettingActivity extends ActionBarActivity {
    Button n;
    ImageView o;
    public Boolean p;
    public Boolean q;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_notification_setting);
        this.q = aeq.d(this);
        this.p = aeq.c(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.notification_user_notifyTitle_radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.notification_group_notifyTitle_radioGroup);
        this.o = (ImageView) findViewById(R.id.toolbar_header_back_imageView);
        this.o.setOnClickListener(new wj(this));
        this.n = (Button) findViewById(R.id.notification_save_button);
        this.n.setOnClickListener(new wk(this));
        RadioButton radioButton = (RadioButton) findViewById(R.id.notification_on_user_radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.notification_off_user_radioButton);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.notification_on_group_radioButton);
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.notification_off_group_radioButton);
        if (this.q.booleanValue()) {
            radioButton3.setChecked(true);
        } else {
            radioButton4.setChecked(true);
        }
        if (this.p.booleanValue()) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        radioGroup2.setOnCheckedChangeListener(new wl(this));
        radioGroup.setOnCheckedChangeListener(new wm(this));
    }
}
