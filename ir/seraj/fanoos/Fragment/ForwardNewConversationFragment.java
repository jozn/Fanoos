package ir.seraj.fanoos.Fragment;

import acs;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import ir.seraj.fanoos3.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import yk;
import zg;

public class ForwardNewConversationFragment extends Fragment {
    public List a;
    ListView b;
    yk c;
    public String d;
    public String e;
    public String f;
    public String g;

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_start_new_conversation, viewGroup, false);
        this.d = g().getString("MessageId");
        this.e = g().getString("ShareFilePath");
        this.f = g().getString("ShareType");
        this.g = g().getString("IsShare");
        if (this.g == null) {
            this.g = XmlPullParser.NO_NAMESPACE;
        }
        this.b = (ListView) inflate.findViewById(R.id.startNewConversation_listView);
        this.a = zg.a(h());
        this.c = new yk(h(), this.a);
        this.b.setAdapter(this.c);
        this.b.setOnItemClickListener(new acs(this));
        a(this.b);
        return inflate;
    }

    public void q() {
        super.q();
    }

    public void r() {
        super.r();
    }

    public void a(Menu menu, MenuInflater menuInflater) {
        menu.clear();
    }
}
