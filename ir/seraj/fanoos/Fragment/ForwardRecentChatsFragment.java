package ir.seraj.fanoos.Fragment;

import act;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import ir.seraj.fanoos3.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import yo;
import zd;

public class ForwardRecentChatsFragment extends Fragment {
    public List a;
    ListView b;
    yo c;
    public String d;
    public String e;
    public String f;
    public String g;

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_forward_recent_chat, viewGroup, false);
        this.d = g().getString("MessageId");
        this.e = g().getString("ShareFilePath");
        this.f = g().getString("ShareType");
        this.g = g().getString("IsShare");
        if (this.g == null) {
            this.g = XmlPullParser.NO_NAMESPACE;
        }
        this.b = (ListView) inflate.findViewById(R.id.listView);
        this.a = zd.a(h(), XmlPullParser.NO_NAMESPACE);
        this.b.setAdapter(this.c);
        this.b.setOnItemClickListener(new act(this));
        a(this.b);
        return inflate;
    }

    public void q() {
        this.a = zd.a(h(), XmlPullParser.NO_NAMESPACE);
        this.c = new yo(h(), this.a);
        this.b.setAdapter(this.c);
        super.q();
    }

    public void r() {
        super.r();
    }
}
