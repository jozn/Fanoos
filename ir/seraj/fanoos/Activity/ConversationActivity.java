package ir.seraj.fanoos.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import ir.seraj.fanoos.Fragment.ConversationFragment;
import ir.seraj.fanoos3.R;
import org.xmlpull.v1.XmlPullParser;

public class ConversationActivity extends ActionBarActivity {
    String n;
    String o;

    public ConversationActivity() {
        this.n = XmlPullParser.NO_NAMESPACE;
        this.o = XmlPullParser.NO_NAMESPACE;
    }

    public void a(String str, String str2, Boolean bool) {
        ImageView imageView = (ImageView) findViewById(R.id.toolbar_header_setting_imageView);
        TextView textView = (TextView) findViewById(R.id.toolbar_header_subTitle_textView);
        ((TextView) findViewById(R.id.toolbar_header_title_textView)).setText(str);
        textView.setText(str2);
        if (bool.booleanValue()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_conversation);
        g().c();
        if (bundle == null && getIntent().getExtras() != null) {
            this.o = getIntent().getStringExtra("IsGroup");
            this.n = getIntent().getStringExtra("MobileNumber");
            String stringExtra = getIntent().getStringExtra("MessageId");
            String stringExtra2 = getIntent().getStringExtra("IsShare");
            if (this.o == null) {
                this.o = XmlPullParser.NO_NAMESPACE;
            }
            if (this.n == null) {
                this.n = XmlPullParser.NO_NAMESPACE;
            }
            if (stringExtra == null) {
                stringExtra = XmlPullParser.NO_NAMESPACE;
            }
            if (stringExtra2 == null) {
                stringExtra2 = XmlPullParser.NO_NAMESPACE;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("MobileNumber", this.n);
            bundle2.putString("IsGroup", this.o);
            if (stringExtra2.equals("1")) {
                bundle2.putString("IsShare", stringExtra2);
                bundle2.putString("ShareType", getIntent().getStringExtra("ShareType"));
                bundle2.putString("ShareFilePath", getIntent().getStringExtra("ShareFilePath"));
            } else if (stringExtra.length() > 0) {
                bundle2.putString("MessageId", stringExtra);
            }
            if (this.o.length() > 0 && this.n.length() > 0) {
                Fragment conversationFragment = new ConversationFragment();
                conversationFragment.g(bundle2);
                f().a().a(R.id.container, conversationFragment, "ConversationFragment").b();
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_conversation, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
