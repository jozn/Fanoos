package ir.seraj.fanoos.Fragment;

import abk;
import abl;
import abm;
import aeq;
import afk;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import xt;
import zg;
import zt;

public class AddGroupSingleParticipantsFragment extends Fragment implements afk {
    public List a;
    public String b;
    public ListView c;
    public xt d;
    public String e;
    Boolean f;
    BroadcastReceiver g;
    public MyResultReceiver h;
    ProgressDialog i;

    public AddGroupSingleParticipantsFragment() {
        this.b = XmlPullParser.NO_NAMESPACE;
        this.f = Boolean.valueOf(false);
        this.g = new abm(this);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_add_group_participants, viewGroup, false);
        this.h = new MyResultReceiver(new Handler());
        this.i = new ProgressDialog(h());
        this.e = g().getString("GroupId");
        this.c = (ListView) inflate.findViewById(R.id.listView);
        ((Button) inflate.findViewById(R.id.create_group_submit_button)).setVisibility(8);
        this.a = zg.a(h(), XmlPullParser.NO_NAMESPACE, this.e);
        this.d = new xt(h(), this.a);
        this.c.setOnItemClickListener(new abk(this));
        this.c.setAdapter(this.d);
        ((EditText) inflate.findViewById(R.id.search_word_textView)).addTextChangedListener(new abl(this));
        return inflate;
    }

    public void q() {
        this.h.a(this);
        if (!this.f.booleanValue()) {
            h().registerReceiver(this.g, new IntentFilter("ir.dayasoft.BroadCastCreateGroupComplete"));
            this.f = Boolean.valueOf(true);
        }
        super.q();
    }

    public void r() {
        this.h.a(null);
        if (this.f.booleanValue()) {
            h().unregisterReceiver(this.g);
            this.f = Boolean.valueOf(false);
        }
        super.r();
    }

    public void a(int i, Bundle bundle) {
        int i2;
        String str = XmlPullParser.NO_NAMESPACE;
        if (bundle != null) {
            i2 = bundle.getInt("CommandCode");
        } else {
            i2 = 0;
        }
        aeq.o(h());
        if (i2 == 7) {
            str = bundle.getString("ParticipantsManegmentAsyncTask");
            if (i == 0) {
                this.i.setCancelable(false);
                this.i.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0627\u0641\u0632\u0648\u062f\u0646 \u0628\u0647 \u06af\u0631\u0648\u0647");
                this.i.show();
                return;
            }
            this.i.dismiss();
            if (str.equals("1")) {
                h().sendBroadcast(new Intent("ir.dayasoft.BroadCastUpdateGroupInfo"));
                Intent intent = new Intent(h(), ChatsActivity.class);
                intent.setFlags(67108864);
                h().startActivity(intent);
                return;
            }
            new zt().b(h());
        }
    }
}
