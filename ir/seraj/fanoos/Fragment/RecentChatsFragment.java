package ir.seraj.fanoos.Fragment;

import adi;
import adj;
import adk;
import adl;
import adm;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.Activity.GroupInfoActivity;
import ir.seraj.fanoos.Activity.UserInfoActivity;
import ir.seraj.fanoos3.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import wc;
import yo;
import yw;
import zd;
import zt;

public class RecentChatsFragment extends Fragment implements wc {
    public List a;
    BroadcastReceiver aj;
    public ListView b;
    public yo c;
    Boolean d;
    public String e;
    public Toolbar f;
    FrameLayout g;
    public EditText h;
    BroadcastReceiver i;

    public RecentChatsFragment() {
        this.d = Boolean.valueOf(false);
        this.i = new adl(this);
        this.aj = new adm(this);
    }

    private void a() {
        this.f = (Toolbar) h().findViewById(R.id.toolbarSearchFooter);
        this.g = (FrameLayout) h().findViewById(R.id.toolbar_footer_frame_search_frameLayout);
        this.h = (EditText) h().findViewById(R.id.toolbar_footer_search_editText);
        this.g.setOnClickListener(new adi(this));
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        this.e = XmlPullParser.NO_NAMESPACE;
        h();
        View inflate = layoutInflater.inflate(R.layout.fragment_chats, viewGroup, false);
        this.b = (ListView) inflate.findViewById(R.id.listView);
        ((ImageView) inflate.findViewById(16908292)).setOnClickListener(new adj(this));
        this.a = zd.a(h(), this.e);
        this.c = new yo(h(), this.a);
        this.b.setAdapter(this.c);
        this.b.setOnItemClickListener(new adk(this));
        a();
        a(this.b);
        return inflate;
    }

    public void q() {
        ((ChatsActivity) h()).a(Boolean.valueOf(false), Boolean.valueOf(false));
        if (!this.d.booleanValue()) {
            h().registerReceiver(this.i, new IntentFilter("ir.dayasoft.BroadCastGetNewMessage"));
            h().registerReceiver(this.aj, new IntentFilter("ir.dayasoft.BroadCastBackPress"));
            this.d = Boolean.valueOf(true);
        }
        this.a = zd.a(h(), this.e);
        this.c = new yo(h(), this.a);
        this.b.setAdapter(this.c);
        super.q();
    }

    public void r() {
        if (this.d.booleanValue()) {
            h().unregisterReceiver(this.i);
            h().unregisterReceiver(this.aj);
            this.d = Boolean.valueOf(false);
        }
        super.r();
    }

    public void a(Menu menu, MenuInflater menuInflater) {
        menu.clear();
    }

    public boolean a(MenuItem menuItem) {
        menuItem.getItemId();
        return super.a(menuItem);
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getId() == R.id.listView) {
            zd zdVar = (zd) ((ListView) view).getItemAtPosition(((AdapterContextMenuInfo) contextMenuInfo).position);
            contextMenu.add(0, 445, 0, "\u062d\u0630\u0641 \u067e\u06cc\u0627\u0645 \u0647\u0627");
            contextMenu.add(0, 446, 0, "\u0645\u0634\u062e\u0635\u0627\u062a");
        }
    }

    public boolean b(MenuItem menuItem) {
        int i = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (menuItem.getItemId() == 445) {
            if (((zd) this.a.get(i)).c().equals("0")) {
                new zt().b(((zd) this.a.get(i)).e(), ((zd) this.a.get(i)).c(), h());
            } else {
                new zt().b(((zd) this.a.get(i)).d(), ((zd) this.a.get(i)).c(), h());
            }
        } else if (((zd) this.a.get(i)).c().equals("0")) {
            Intent intent = new Intent(h(), UserInfoActivity.class);
            intent.putExtra("MobileNumber", ((zd) this.a.get(i)).e());
            a(intent);
        } else if (yw.c(String.valueOf(((zd) this.a.get(i)).d()), h()).f().equals(yw.m)) {
            Toast.makeText(h(), "\u0634\u0645\u0627 \u0639\u0636\u0648 \u0627\u06cc\u0646 \u06af\u0631\u0648\u0647 \u0646\u0645\u06cc \u0628\u0627\u0634\u06cc\u062f", 0).show();
            return true;
        } else {
            Intent intent2 = new Intent(h(), GroupInfoActivity.class);
            intent2.putExtra("GroupId", String.valueOf(((zd) this.a.get(i)).d()));
            h().startActivity(intent2);
            return true;
        }
        return super.b(menuItem);
    }

    public void a(String str) {
        this.a = zd.a(h(), str);
        this.c.a(this.a);
        this.b.setAdapter(this.c);
    }
}
