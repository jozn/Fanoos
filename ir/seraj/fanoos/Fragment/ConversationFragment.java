package ir.seraj.fanoos.Fragment;

import aas;
import abe;
import abf;
import abn;
import abo;
import abs;
import abt;
import abu;
import abv;
import abw;
import abx;
import aby;
import abz;
import aca;
import acb;
import acc;
import acd;
import ace;
import acf;
import acg;
import ach;
import aci;
import ack;
import acl;
import acm;
import acn;
import aes;
import afa;
import afd;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.seraj.fanoos.Activity.ConversationActivity;
import ir.seraj.fanoos.Activity.ForwardActivity;
import ir.seraj.fanoos.Activity.ImageEditorActivity;
import ir.seraj.fanoos3.R;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import ve;
import xp;
import xv;
import yi;
import yq;
import ys;
import yw;
import yz;
import zc;
import ze;
import zg;
import zn;
import zs;

public class ConversationFragment extends Fragment {
    public static int aC;
    View a;
    public xv aA;
    public ListView aB;
    String aD;
    String aE;
    Boolean aF;
    public aes aG;
    public Boolean aH;
    public Boolean aI;
    public Boolean aJ;
    public String aK;
    public RelativeLayout aL;
    public ImageView aM;
    public TextView aN;
    Boolean aO;
    Boolean aP;
    public int aQ;
    BroadcastReceiver aR;
    BroadcastReceiver aS;
    public yz aT;
    private HashMap aU;
    private acn aV;
    private Intent aW;
    ImageView aj;
    ImageView ak;
    ImageView al;
    ImageView am;
    ImageView an;
    ImageView ao;
    public int ap;
    public ImageView aq;
    public ImageView ar;
    ImageView as;
    public EditText at;
    public Integer au;
    public FrameLayout av;
    public TextView aw;
    public String ax;
    public Integer ay;
    public List az;
    public String b;
    String c;
    public GridView d;
    xp e;
    public String f;
    public RelativeLayout g;
    public GridView h;
    public GridView i;

    public ConversationFragment() {
        this.f = XmlPullParser.NO_NAMESPACE;
        this.aU = new HashMap();
        this.ax = "09353708038";
        this.aF = Boolean.valueOf(false);
        this.aW = null;
        this.aH = Boolean.valueOf(false);
        this.aI = Boolean.valueOf(false);
        this.aJ = Boolean.valueOf(false);
        this.aO = Boolean.valueOf(false);
        this.aP = Boolean.valueOf(false);
        this.aR = new aca(this);
        this.aS = new acc(this);
    }

    static {
        aC = 50;
    }

    private void a() {
        ((InputMethodManager) h().getSystemService("input_method")).hideSoftInputFromWindow(this.at.getWindowToken(), 0);
    }

    private void M() {
        this.aD = XmlPullParser.NO_NAMESPACE;
        if (g() != null) {
            this.aD = g().getString("MessageId");
            if (this.aD == null) {
                this.aD = XmlPullParser.NO_NAMESPACE;
            }
            this.aE = g().getString("IsShare");
            if (this.aE == null) {
                this.aE = XmlPullParser.NO_NAMESPACE;
            }
            this.ax = g().getString("MobileNumber");
            this.ay = Integer.valueOf(g().getString("IsGroup"));
        }
    }

    private void N() {
        if (this.ay.intValue() == 0) {
            ((ConversationActivity) h()).a(this.b, XmlPullParser.NO_NAMESPACE, Boolean.valueOf(true));
        } else {
            ((ConversationActivity) h()).a(this.b, XmlPullParser.NO_NAMESPACE, Boolean.valueOf(false));
        }
        ((ImageView) h().findViewById(R.id.toolbar_header_setting_imageView)).setOnClickListener(new abn(this));
        ((ImageView) h().findViewById(R.id.toolbar_header_back_imageView)).setOnClickListener(new acb(this));
    }

    private void O() {
        yz a;
        this.aB = (ListView) this.a.findViewById(R.id.conversation_listView);
        this.ax = g().getString("MobileNumber");
        this.ay = Integer.valueOf(g().getString("IsGroup"));
        this.aw = (TextView) this.a.findViewById(R.id.conversation_block_textView);
        a(this.aB);
        if (this.aD.length() > 0) {
            a = yz.a(h(), this.aD);
            this.at.setText(XmlPullParser.NO_NAMESPACE);
            if (this.ay.intValue() == 1) {
                yz.e(h(), yz.b(a), String.valueOf(this.ax));
                this.az = zc.b(h(), this.ax, Math.max(50, aC));
            } else {
                yz.d(h(), yz.b(a), this.ax);
                this.az = zc.a(h(), this.ax, Math.max(50, aC));
            }
        }
        if (this.aE.equals("1")) {
            a = new yz();
            a.b(g().getString("ShareFilePath"));
            a.c(g().getString("ShareType"));
            if (a.f().equals(String.valueOf(2))) {
                this.aW = new Intent(h(), ImageEditorActivity.class);
                this.aW.setType("image/*");
                this.aW.putExtra("return-data", true);
                this.aW.setData(Uri.parse(a.d()));
                a(this.aW, 1192);
            } else if (this.ay.intValue() == 1) {
                yz.b(h(), a, a.d(), String.valueOf(this.ax));
            } else {
                yz.a(h(), a, a.d(), this.ax);
            }
        }
    }

    private void P() {
        if (this.ay.intValue() == 1) {
            this.b = yw.c(String.valueOf(this.ax), h()).c();
            this.c = XmlPullParser.NO_NAMESPACE;
            if (yw.c(String.valueOf(this.ax), h()).f().equals(yw.m)) {
                this.aw.setVisibility(0);
                this.at.setVisibility(8);
            } else {
                this.aw.setVisibility(4);
                this.at.setVisibility(0);
            }
            aC = yw.b(String.valueOf(this.ax), h()).intValue();
            this.az = zc.b(h(), this.ax, Math.max(50, aC));
            Collections.reverse(this.az);
        } else {
            this.b = zg.a(h(), this.ax).h();
            if (TextUtils.isEmpty(this.b)) {
                zg zgVar = new zg();
                zgVar.e(this.ax);
                zgVar.a(this.ax);
                zg.a(h(), zgVar);
                this.b = zg.a(h(), this.ax).h();
            }
            aC = zg.d(h(), this.ax);
            this.az = zc.a(h(), this.ax, Math.max(50, aC));
            Collections.reverse(this.az);
        }
        if (this.az.size() >= 50) {
            View button = new Button(h());
            button.setText("\u0646\u0645\u0627\u06cc\u0634 \u067e\u06cc\u0627\u0645 \u0647\u0627\u06cc \u0642\u0628\u0644\u06cc");
            button.setOnClickListener(new acf(this));
            if (!this.aO.booleanValue()) {
                this.aB.addHeaderView(button);
                this.aO = Boolean.valueOf(true);
            }
        }
        this.aA = new xv(h(), this.az);
        Log.i("adaptor", "2");
        this.aB.setAdapter(this.aA);
        this.aB.post(new acg(this));
        N();
    }

    private void Q() {
        this.au = Integer.valueOf(0);
        this.av = (FrameLayout) this.a.findViewById(R.id.footer_drawer_frameLayout);
        this.aq = (ImageView) this.a.findViewById(R.id.conversation_sendMedia_ImageView);
        this.ar = (ImageView) this.a.findViewById(R.id.conversation_sendSticky_ImageView);
        this.as = (ImageView) this.a.findViewById(R.id.conversation_sendMsg_ImageView);
        this.at = (EditText) this.a.findViewById(R.id.conversation_newMsg_editText);
        a();
        this.at.setOnFocusChangeListener(new ach(this));
        this.aq.setOnClickListener(new aci(this));
        this.ar.setOnClickListener(new ack(this));
        this.as.setOnClickListener(new acl(this));
    }

    private void R() {
        this.d = (GridView) this.a.findViewById(R.id.conversation_add_media_gridView);
        this.e = new xp(h());
        this.d.setAdapter(this.e);
        this.d.setOnItemClickListener(new acm(this));
    }

    private void S() {
        this.aL = (RelativeLayout) this.a.findViewById(R.id.conversation_record_frame_relativeLayout);
        this.aM = (ImageView) this.a.findViewById(R.id.conversation_record_imageView);
        this.aN = (TextView) this.a.findViewById(R.id.conversation_record_timer_TextView);
        this.aM.setOnTouchListener(new abo(this));
    }

    private void a(int i) {
        switch (i) {
            case ve.CropImageView_guidelines /*0*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object);
                this.aj.setImageResource(R.drawable.ic_sticky_tab_press);
                this.ao.setImageResource(R.drawable.emoji_btn_normal);
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl_press);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object);
                this.aj.setImageResource(R.drawable.ic_sticky_tab);
                this.ao.setImageResource(R.drawable.emoji_btn_normal);
            case ve.CropImageView_aspectRatioX /*2*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy_press);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object);
                this.aj.setImageResource(R.drawable.ic_sticky_tab);
                this.ao.setImageResource(R.drawable.emoji_btn_normal);
            case ve.CropImageView_aspectRatioY /*3*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word_press);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object);
                this.aj.setImageResource(R.drawable.ic_sticky_tab);
                this.ao.setImageResource(R.drawable.emoji_btn_normal);
            case ve.CropImageView_imageResource /*4*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object_press);
                this.aj.setImageResource(R.drawable.ic_sticky_tab);
                this.ao.setImageResource(R.drawable.emoji_btn_normal);
            case Node.CDSECT /*5*/:
                this.ak.setImageResource(R.drawable.ic_sticky_tab_girl);
                this.al.setImageResource(R.drawable.ic_sticky_tab_boy);
                this.am.setImageResource(R.drawable.ic_sticky_tab_word);
                this.an.setImageResource(R.drawable.ic_sticky_tab_object);
                this.aj.setImageResource(R.drawable.ic_sticky_tab);
                this.ao.setImageResource(R.drawable.emoji_btn_pressed);
            default:
        }
    }

    private void T() {
        this.aU = abe.a();
        this.aV = new acn(this.at);
        String[] stringArray = i().getStringArray(R.array.sticky_array);
        String[] stringArray2 = i().getStringArray(R.array.emotion_array);
        this.ak = (ImageView) this.a.findViewById(R.id.conversation_sticky_tab_girls_imageView);
        this.al = (ImageView) this.a.findViewById(R.id.conversation_sticky_tab_boys_imageView);
        this.am = (ImageView) this.a.findViewById(R.id.conversation_sticky_tab_words_imageView);
        this.an = (ImageView) this.a.findViewById(R.id.conversation_sticky_tab_object_imageView);
        this.aj = (ImageView) this.a.findViewById(R.id.conversation_sticky_tab_imageView);
        this.ao = (ImageView) this.a.findViewById(R.id.conversation_emotion_tab_imageView);
        this.h = (GridView) this.a.findViewById(R.id.conversation_sticky_gridView);
        this.i = (GridView) this.a.findViewById(R.id.conversation_emotion_gridView);
        this.g = (RelativeLayout) this.a.findViewById(R.id.conversation_sticky_frame_relativeLayout);
        ListAdapter yiVar = new yi(h(), stringArray2);
        this.h.setAdapter(new yq(h(), stringArray, new Integer[]{Integer.valueOf(0), Integer.valueOf(11)}));
        this.i.setAdapter(yiVar);
        this.i.setVisibility(0);
        this.h.setVisibility(4);
        this.ap = 0;
        this.ao.setOnClickListener(new abs(this));
        this.aj.setOnClickListener(new abt(this, stringArray));
        this.am.setOnClickListener(new abu(this, stringArray));
        this.ak.setOnClickListener(new abv(this, stringArray));
        this.al.setOnClickListener(new abw(this, stringArray));
        this.an.setOnClickListener(new abx(this, stringArray));
        this.i.setOnItemClickListener(new aby(this, stringArray2));
        this.h.setOnItemClickListener(new abz(this));
    }

    private void U() {
        this.aW = new Intent("android.intent.action.GET_CONTENT", null);
        this.aW.setType("image/*");
        this.aW.putExtra("return-data", true);
        a(this.aW, 1189);
    }

    private void V() {
        this.aW = new Intent("android.intent.action.GET_CONTENT", null);
        this.aW.setType("video/*");
        this.aW.putExtra("return-data", true);
        a(this.aW, 1191);
    }

    private void W() {
        this.aW = new Intent("android.media.action.IMAGE_CAPTURE");
        this.aW.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg")));
        a(this.aW, 1888);
    }

    private void X() {
        this.aW = new Intent();
        this.aW.setAction("android.intent.action.GET_CONTENT");
        this.aW.setType("audio/mpeg");
        Intent intent = this.aW;
        a(Intent.createChooser(this.aW, "\u0644\u0637\u0641\u0627 \u0627\u0646\u062a\u062e\u0627\u0628 \u06a9\u0646\u06cc\u062f"), 1190);
    }

    private void Y() {
        if (this.ay.intValue() != 1) {
            return;
        }
        if (yw.c(String.valueOf(this.ax), h()).f().equals(yw.m)) {
            this.aw.setVisibility(0);
            this.at.setVisibility(8);
            return;
        }
        this.aw.setVisibility(4);
        this.at.setVisibility(0);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            c(true);
        } catch (Exception e) {
            e.getMessage();
        }
        this.a = layoutInflater.inflate(R.layout.fragment_conversation, viewGroup, false);
        M();
        Q();
        O();
        N();
        Q();
        R();
        T();
        S();
        return this.a;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view.getId() == R.id.conversation_listView) {
            zc zcVar = (zc) ((ListView) view).getItemAtPosition(((AdapterContextMenuInfo) contextMenuInfo).position);
            contextMenu.add(0, 445, 0, "\u06a9\u067e\u06cc \u06a9\u0631\u062f\u0646");
            contextMenu.add(0, 446, 0, "\u0627\u0646\u062a\u0642\u0627\u0644 \u067e\u06cc\u0627\u0645");
            contextMenu.add(0, 447, 0, "\u062d\u0630\u0641 \u067e\u06cc\u0627\u0645");
            contextMenu.add(0, 448, 0, "\u0627\u0634\u062a\u0631\u0627\u06a9 \u067e\u06cc\u0627\u0645");
        }
    }

    public boolean b(MenuItem menuItem) {
        int i;
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
        if (this.az.size() < 50) {
            i = adapterContextMenuInfo.position;
        } else {
            i = adapterContextMenuInfo.position - 1;
        }
        if (menuItem.getItemId() != 445) {
            if (menuItem.getItemId() != 446) {
                if (menuItem.getItemId() != 447) {
                    if (menuItem.getItemId() == 448) {
                        switch (Integer.valueOf(((zc) this.az.get(i)).e()).intValue()) {
                            case ve.CropImageView_fixAspectRatio /*1*/:
                                zs.a(XmlPullParser.NO_NAMESPACE, ((zc) this.az.get(i)).d(), h());
                                break;
                            case ve.CropImageView_aspectRatioX /*2*/:
                                zs.a(yz.a((zc) this.az.get(i)), h());
                                break;
                            case ve.CropImageView_aspectRatioY /*3*/:
                                zs.b(yz.a((zc) this.az.get(i)), h());
                                break;
                            case ve.CropImageView_imageResource /*4*/:
                                zs.c(yz.a((zc) this.az.get(i)), h());
                                break;
                            default:
                                break;
                        }
                    }
                }
                ((zc) this.az.get(i)).g();
                ze.e(h(), String.valueOf(((zc) this.az.get(i)).g()));
                this.az.remove(i);
                this.aA.notifyDataSetChanged();
            } else {
                Intent intent = new Intent(h(), ForwardActivity.class);
                intent.putExtra("MessageId", String.valueOf(((zc) this.az.get(i)).c()));
                h().startActivity(intent);
            }
        } else if (((zc) this.az.get(i)).e().equals(String.valueOf(1))) {
            ((ClipboardManager) h().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", ((zc) this.az.get(i)).d()));
        }
        return super.b(menuItem);
    }

    public void q() {
        P();
        Y();
        new afd(h(), this.ax, Integer.valueOf(1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        new afa(h(), Integer.valueOf(1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        yz.b(String.valueOf(this.ay), this.ax, h());
        if (this.ay.intValue() == 1) {
            h().setTitle(yw.c(String.valueOf(this.ax), h()).c());
            aC = yw.b(String.valueOf(this.ax), h()).intValue();
        } else {
            h().setTitle(zg.a(h(), this.ax).h());
            aC = zg.d(h(), this.ax);
        }
        ((NotificationManager) h().getSystemService("notification")).cancel(1);
        if (!this.aF.booleanValue()) {
            h().registerReceiver(this.aR, new IntentFilter("com.mycompany.myapp.SOME_MESSAGE"));
            h().registerReceiver(this.aR, new IntentFilter("ir.dayasoft.BroadCastGetDeliverMessage"));
            h().registerReceiver(this.aS, new IntentFilter("ir.dayasoft.BroadCastConversationEvent"));
            h().registerReceiver(this.aR, new IntentFilter("ir.dayasoft.BroadCastSizeError"));
            this.aF = Boolean.valueOf(true);
        }
        super.q();
    }

    public void r() {
        new afa(h(), Integer.valueOf(0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        if (this.ay.intValue() == 1) {
            yw.a(h(), this.ax);
        } else {
            new afd(h(), this.ax, Integer.valueOf(0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            zg.c(h(), this.ax);
        }
        if (this.aG != null) {
            this.aG.a();
        }
        h().setTitle("\u0641\u0627\u0646\u0648\u0633");
        yz.a(h());
        if (this.aF.booleanValue()) {
            h().unregisterReceiver(this.aR);
            h().unregisterReceiver(this.aS);
            this.aF = Boolean.valueOf(false);
        }
        super.r();
    }

    public void a(int i, int i2, Intent intent) {
        this.aT = new yz();
        if (i == 1192 && i2 == -1 && intent != null) {
            intent.getData();
            this.aT.c(String.valueOf(2));
            this.aT.a(-1);
            this.f = intent.getStringExtra("ir.seraj.intent.ImageEditUri");
        }
        if (i == 1888 && i2 == -1) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            this.aW = new Intent(h(), ImageEditorActivity.class);
            this.aW.setType("image/*");
            this.aW.putExtra("return-data", true);
            this.aW.setData(Uri.fromFile(file));
            a(this.aW, 1192);
        } else if (i == 1189 && i2 == -1 && intent != null) {
            this.aW = new Intent(h(), ImageEditorActivity.class);
            this.aW.setType("image/*");
            this.aW.putExtra("return-data", true);
            this.aW.setData(intent.getData());
            a(this.aW, 1192);
        } else {
            Uri data;
            String[] strArr;
            Cursor query;
            int columnIndex;
            int columnIndex2;
            String str;
            if (i == 1191 && i2 == -1 && intent != null) {
                data = intent.getData();
                if (VERSION.SDK_INT < 19) {
                    strArr = new String[]{"_data", "_size"};
                    query = h().getContentResolver().query(data, strArr, null, null, null);
                    query.moveToFirst();
                    columnIndex = query.getColumnIndex(strArr[0]);
                    columnIndex2 = query.getColumnIndex(strArr[1]);
                    this.f = query.getString(columnIndex);
                    this.aT.a(query.getInt(columnIndex2));
                    query.close();
                } else if (data != null) {
                    if (data == null) {
                        try {
                            this.f = data.getPath();
                        } catch (Exception e) {
                            strArr = new String[]{"_data", "_size"};
                            query = h().getContentResolver().query(data, strArr, null, null, null);
                            query.moveToFirst();
                            columnIndex = query.getColumnIndex(strArr[0]);
                            columnIndex2 = query.getColumnIndex(strArr[1]);
                            this.f = query.getString(columnIndex);
                            this.aT.a(query.getInt(columnIndex2));
                            query.close();
                        }
                    } else {
                        str = DocumentsContract.getDocumentId(intent.getData()).split(":")[1];
                        strArr = new String[]{"_data"};
                        query = h().getContentResolver().query(abf.a(), strArr, "_id=?", new String[]{str}, null);
                        if (query != null) {
                            columnIndex = query.getColumnIndexOrThrow("_data");
                            if (query.moveToFirst()) {
                                this.f = query.getString(columnIndex);
                            }
                            query.close();
                        } else {
                            this.f = data.getPath();
                        }
                    }
                }
                try {
                    this.aT.c(String.valueOf(3));
                } catch (Exception e2) {
                    aas aas = new aas();
                    aas.a("ir.seraj.fanoos");
                    aas.e(ys.a(h()));
                    aas.d(zn.a());
                    aas.c("back To app from  Gallery");
                    aas.b(e2.getMessage());
                    aas.a(Integer.valueOf(0));
                    aas.a(h());
                    return;
                }
            }
            if (!(i != 1190 || i2 != -1 || intent == null || intent == null || intent.getData() == null)) {
                data = intent.getData();
                if (VERSION.SDK_INT < 19) {
                    strArr = new String[]{"_data", "_size"};
                    query = h().getContentResolver().query(data, strArr, null, null, null);
                    query.moveToFirst();
                    columnIndex = query.getColumnIndex(strArr[0]);
                    columnIndex2 = query.getColumnIndex(strArr[1]);
                    this.f = query.getString(columnIndex);
                    this.aT.a(query.getInt(columnIndex2));
                    query.close();
                } else if (data != null) {
                    if (data == null) {
                        try {
                            this.f = data.getPath();
                        } catch (Exception e3) {
                            strArr = new String[]{"_data", "_size"};
                            query = h().getContentResolver().query(data, strArr, null, null, null);
                            query.moveToFirst();
                            columnIndex = query.getColumnIndex(strArr[0]);
                            columnIndex2 = query.getColumnIndex(strArr[1]);
                            this.f = query.getString(columnIndex);
                            this.aT.a(query.getInt(columnIndex2));
                            query.close();
                        }
                    } else {
                        str = DocumentsContract.getDocumentId(intent.getData()).split(":")[1];
                        strArr = new String[]{"_data"};
                        query = h().getContentResolver().query(abf.b(), strArr, "_id=?", new String[]{str}, null);
                        if (query != null) {
                            columnIndex = query.getColumnIndexOrThrow("_data");
                            if (query.moveToFirst()) {
                                this.f = query.getString(columnIndex);
                            }
                            query.close();
                        } else {
                            this.f = data.getPath();
                        }
                    }
                }
                this.aT.c(String.valueOf(4));
            }
            if ((i == 1190 || i == 1192 || i == 1189 || i == 1888 || i == 1191) && i2 == -1) {
                new Builder(h()).setTitle("\u0627\u0646\u062a\u062e\u0627\u0628 \u0641\u0627\u06cc\u0644").setMessage("\u0622\u06cc\u0627 \u0641\u0627\u06cc\u0644 \u0627\u0646\u062a\u062e\u0627\u0628\u06cc \u0627\u0631\u0633\u0627\u0644 \u0634\u0648\u062f\u061f").setPositiveButton(17039379, new ace(this)).setNegativeButton(17039369, new acd(this)).setIcon(17301543).show();
            }
        }
    }
}
