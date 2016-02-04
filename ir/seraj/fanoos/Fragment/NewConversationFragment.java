package ir.seraj.fanoos.Fragment;

import add;
import ade;
import adf;
import adg;
import aeq;
import afs;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
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
import ir.seraj.fanoos.Activity.UserInfoActivity;
import ir.seraj.fanoos3.R;
import java.util.ArrayList;
import java.util.List;
import wc;
import yk;
import ys;
import zg;
import zt;

public class NewConversationFragment extends Fragment implements wc {
    Boolean a;
    public String aj;
    BroadcastReceiver ak;
    public List b;
    public ListView c;
    public yk d;
    public ImageView e;
    public Toolbar f;
    Boolean g;
    FrameLayout h;
    public EditText i;

    public NewConversationFragment() {
        this.a = Boolean.valueOf(false);
        this.g = Boolean.valueOf(false);
        this.ak = new adg(this);
    }

    private void a() {
        this.f = (Toolbar) h().findViewById(R.id.toolbarSearchFooter);
        this.h = (FrameLayout) h().findViewById(R.id.toolbar_footer_frame_search_frameLayout);
        this.i = (EditText) h().findViewById(R.id.toolbar_footer_search_editText);
        this.h.setOnClickListener(new add(this));
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(true);
        View inflate = layoutInflater.inflate(R.layout.fragment_start_new_conversation, viewGroup, false);
        this.c = (ListView) inflate.findViewById(R.id.startNewConversation_listView);
        this.e = (ImageView) inflate.findViewById(R.id.ssss);
        this.b = zg.a(h());
        ((ChatsActivity) h()).a(Boolean.valueOf(true), Boolean.valueOf(false));
        if (ys.p(h()).booleanValue()) {
            if (aeq.g(h()).booleanValue()) {
                ((ChatsActivity) h()).a(Boolean.valueOf(true), Boolean.valueOf(true));
                aeq.e(h(), Boolean.valueOf(false));
                this.e.setVisibility(8);
            } else {
                this.e.setOnClickListener(new ade(this));
                if (this.b.size() == 0) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setVisibility(8);
                }
            }
            a();
            new afs(h()).execute(new String[0]);
        }
        this.d = new yk(h(), this.b);
        this.c.setAdapter(this.d);
        this.c.setOnItemClickListener(new adf(this));
        a(this.c);
        return inflate;
    }

    public void q() {
        if (!this.a.booleanValue()) {
            h().registerReceiver(this.ak, new IntentFilter("ir.dayasoft.BroadCastSyncContact"));
            this.a = Boolean.valueOf(true);
        }
        super.q();
    }

    public void r() {
        if (this.a.booleanValue()) {
            h().unregisterReceiver(this.ak);
            this.a = Boolean.valueOf(false);
        }
        super.r();
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public boolean a(MenuItem menuItem) {
        return super.a(menuItem);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getId() == R.id.startNewConversation_listView) {
            zg zgVar = (zg) ((ListView) view).getItemAtPosition(((AdapterContextMenuInfo) contextMenuInfo).position);
            contextMenu.add(0, 446, 0, "\u0645\u0634\u062e\u0635\u0627\u062a");
        }
    }

    public boolean b(MenuItem menuItem) {
        int i = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (menuItem.getItemId() == 446) {
            Intent intent = new Intent(h(), UserInfoActivity.class);
            intent.putExtra("MobileNumber", ((zg) this.b.get(i)).d());
            a(intent);
        }
        return super.b(menuItem);
    }

    public void a(int i, int i2, Intent intent) {
        if (i == 1888 && i2 == -1) {
            try {
                Uri data = intent.getData();
                List arrayList = new ArrayList();
                ContentResolver contentResolver = h().getContentResolver();
                Cursor query = h().getContentResolver().query(data, null, null, null, null);
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("_id"));
                    if (Integer.parseInt(query.getString(query.getColumnIndex("has_phone_number"))) > 0) {
                        String str = "data1";
                        Cursor query2 = contentResolver.query(Phone.CONTENT_URI, null, "contact_id" + " = ?", new String[]{string}, null);
                        Boolean valueOf = Boolean.valueOf(false);
                        while (query2.moveToNext()) {
                            String string2 = query2.getString(query2.getColumnIndex(str));
                            valueOf = Boolean.valueOf(true);
                            string2 = zg.g(string2);
                            if (zg.h(string2).booleanValue()) {
                                arrayList.add(string2);
                            } else {
                                Toast.makeText(h(), "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0635\u062d\u06cc\u062d \u0646\u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
                            }
                        }
                        query2.close();
                        if (arrayList.size() < 1) {
                            Toast.makeText(h(), "\u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0635\u062d\u06cc\u062d \u0646\u0645\u06cc \u0628\u0627\u0634\u062f", 0).show();
                        } else {
                            zt ztVar = new zt();
                        }
                        if (!valueOf.booleanValue()) {
                            Toast.makeText(h(), "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(h(), "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
                    return;
                }
                Toast.makeText(h(), "\u0645\u062e\u0627\u0637\u0628 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644 \u0646\u062f\u0627\u0631\u062f", 0).show();
            } catch (Exception e) {
                Toast.makeText(h(), "\u062e\u0637\u0627 \u062f\u0631 \u062e\u0648\u0627\u0646\u062f\u0646 \u0634\u0645\u0627\u0631\u0647 \u0645\u0648\u0628\u0627\u06cc\u0644", 0).show();
            }
        }
    }

    public void a(String str) {
        this.b = zg.b(h(), str);
        this.d.a(this.b);
        this.c.setAdapter(this.d);
    }
}
