package ir.seraj.fanoos.Fragment;

import abg;
import abh;
import abi;
import abj;
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
import android.widget.Toast;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Activity.CreateGroupActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import xr;
import zg;
import zt;

public class AddGroupParticipantsFragment extends Fragment implements afk {
    public List a;
    public MyResultReceiver aj;
    ProgressDialog ak;
    String b;
    String c;
    public String d;
    public ListView e;
    public xr f;
    public HashMap g;
    Boolean h;
    BroadcastReceiver i;

    public AddGroupParticipantsFragment() {
        this.b = XmlPullParser.NO_NAMESPACE;
        this.c = XmlPullParser.NO_NAMESPACE;
        this.d = XmlPullParser.NO_NAMESPACE;
        this.h = Boolean.valueOf(false);
        this.i = new abj(this);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_add_group_participants, viewGroup, false);
        ((CreateGroupActivity) h()).b(false);
        this.aj = new MyResultReceiver(new Handler());
        this.ak = new ProgressDialog(h());
        this.g = new HashMap();
        this.c = g().getString("GroupImage");
        this.b = g().getString("GroupName");
        this.e = (ListView) inflate.findViewById(R.id.listView);
        ((Button) inflate.findViewById(R.id.create_group_submit_button)).setOnClickListener(new abg(this));
        this.a = zg.b(h(), XmlPullParser.NO_NAMESPACE);
        this.f = new xr(h(), this.a);
        this.e.setOnItemClickListener(new abh(this));
        this.e.setAdapter(this.f);
        ((EditText) inflate.findViewById(R.id.search_word_textView)).addTextChangedListener(new abi(this));
        return inflate;
    }

    private void a() {
        ArrayList arrayList = new ArrayList();
        for (zg zgVar : this.a) {
            if (zgVar.b().booleanValue()) {
                arrayList.add(zgVar.d());
            }
        }
        if (arrayList.size() > 1) {
            Intent intent = new Intent(h(), IntentServiceGeneralCommand.class);
            intent.putExtra("receiverTag", this.aj);
            intent.putExtra("CommandCode", 5);
            intent.putExtra("GroupName", this.b);
            intent.putExtra("FileAddress", this.c);
            intent.putStringArrayListExtra("Participants", arrayList);
            h().startService(intent);
            return;
        }
        Toast.makeText(h(), "\u0628\u0631\u0627\u06cc \u0627\u06cc\u062c\u0627\u062f \u06af\u0631\u0648\u0647 \u062d\u062f\u0627\u0642\u0644 \u0628\u0627\u06cc\u062f 2 \u0646\u0641\u0631 \u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u0648\u0646\u062f", 0).show();
    }

    public void q() {
        this.aj.a(this);
        if (!this.h.booleanValue()) {
            h().registerReceiver(this.i, new IntentFilter("ir.dayasoft.BroadCastCreateGroupComplete"));
            this.h = Boolean.valueOf(true);
        }
        super.q();
    }

    public void r() {
        this.aj.a(null);
        if (this.h.booleanValue()) {
            h().unregisterReceiver(this.i);
            this.h = Boolean.valueOf(false);
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
        if (i2 == 5) {
            str = bundle.getString("CreateGroup");
            if (i == 0) {
                this.ak.setCancelable(false);
                this.ak.setMessage("\u062f\u0631\u062d\u0627\u0644 \u0627\u06cc\u062c\u0627\u062f \u06af\u0631\u0648\u0647");
                this.ak.show();
                return;
            }
            this.ak.dismiss();
            if (str.equals("1")) {
                h().sendBroadcast(new Intent("ir.dayasoft.BroadCastCreateGroupComplete"));
                Intent intent = new Intent(h(), ChatsActivity.class);
                intent.addFlags(67108864);
                h().startActivity(intent);
                return;
            }
            new zt().b(h());
        }
    }
}
