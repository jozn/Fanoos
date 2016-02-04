import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import ir.seraj.fanoos.Activity.ChatsActivity;
import ir.seraj.fanoos.communication.IntentServiceGeneralCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class zi {
    public static String a(String str, Context context) {
        Log.i("DispatchCommandString ", str);
        if (str.length() <= 0) {
            return XmlPullParser.NO_NAMESPACE;
        }
        new afc(context, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String b(String str, Context context) {
        String[] split = str.split(zh.c);
        if (0 >= split.length) {
            return XmlPullParser.NO_NAMESPACE;
        }
        zh.f++;
        try {
            String c;
            Integer valueOf = Integer.valueOf(Integer.parseInt(split[0].substring(0, 2)));
            if (ys.k(context).booleanValue()) {
                c = ys.c(context, split[0].substring(2));
            } else {
                c = ys.a(context, split[0].substring(2));
            }
            Log.i("CommandCode", String.valueOf(valueOf));
            switch (valueOf.intValue()) {
                case nv.Toolbar_titleMargins /*11*/:
                    a(c);
                    break;
                case nv.Toolbar_titleMarginStart /*12*/:
                    b(c);
                    break;
                case nv.Toolbar_titleMarginEnd /*13*/:
                    c(c);
                    break;
                case nv.Toolbar_titleMarginTop /*14*/:
                    d(c);
                    break;
                case nv.Toolbar_maxButtonHeight /*16*/:
                    d(c, context);
                    break;
                case nv.Toolbar_collapseIcon /*18*/:
                    c(c, context);
                    break;
                case nv.Toolbar_navigationIcon /*20*/:
                    f(c, context);
                    break;
                case nv.Toolbar_navigationContentDescription /*21*/:
                    m(c, context);
                    break;
                case nv.Theme_actionMenuTextColor /*22*/:
                    e(c, context);
                    break;
                case nv.Theme_actionModeStyle /*23*/:
                    k(c, context);
                    break;
                case nv.Theme_actionModeCloseButtonStyle /*24*/:
                    l(c, context);
                    break;
                case nv.Theme_actionModeBackground /*25*/:
                    g(c, context);
                    break;
                case nv.Theme_actionModeSplitBackground /*26*/:
                    i(c, context);
                    break;
                case nv.Theme_actionModeCloseDrawable /*27*/:
                    h(c, context);
                    break;
                case nv.Theme_actionModeCutDrawable /*28*/:
                    j(c, context);
                    break;
                case nv.Theme_actionModeCopyDrawable /*29*/:
                    n(c, context);
                    break;
                case nv.Theme_actionModeShareDrawable /*32*/:
                    o(c, context);
                    break;
                case nv.Theme_actionModeFindDrawable /*33*/:
                    p(c, context);
                    break;
                case nv.Theme_actionModeWebSearchDrawable /*34*/:
                    q(c, context);
                    break;
                case nv.Theme_actionModePopupWindowStyle /*35*/:
                    r(c, context);
                    break;
                case nv.Theme_textAppearanceLargePopupMenu /*36*/:
                    s(c, context);
                    break;
                case nv.Theme_textAppearanceSmallPopupMenu /*37*/:
                    t(c, context);
                    break;
                case nv.Theme_actionDropDownStyle /*38*/:
                    u(c, context);
                    break;
                case nv.Theme_dropdownListPreferredItemHeight /*39*/:
                    v(c, context);
                    break;
            }
            return XmlPullParser.NO_NAMESPACE;
        } catch (Exception e) {
            return "error";
        }
    }

    public static String a(String str) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String b(String str) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String c(String str) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String d(String str) {
        afs.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static List a(Context context, String str, Hashtable hashtable) {
        String[] split = str.split(zh.a);
        List arrayList = new ArrayList();
        for (String split2 : split) {
            String[] split3 = split2.split(zh.b);
            if (split3[0].length() == 11) {
                zg zgVar = new zg();
                zgVar.a(split3[0]);
                zgVar.e((String) hashtable.get(split3[0]));
                zgVar.d(split3[1]);
                zgVar.b(Integer.valueOf(1));
                arrayList.add(zgVar);
            }
        }
        return arrayList;
    }

    public static String c(String str, Context context) {
        yz yzVar = new yz();
        ze zeVar = new ze();
        try {
            String[] split = str.split(zh.b);
            yzVar.a(String.valueOf(split[0]));
            zeVar.a(String.valueOf(split[1]));
            yzVar.a(Long.valueOf(split[2]));
            zeVar.a(Long.valueOf(split[3]));
            zeVar.c(ze.b);
            yz.a(context, yzVar, zeVar);
            ze.b(context, String.valueOf(zeVar.a()));
        } catch (Exception e) {
        }
        return str;
    }

    public static String d(String str, Context context) {
        Exception exception;
        Exception exception2;
        aas aas;
        List<zb> arrayList = new ArrayList();
        if (str.length() < 2) {
            return XmlPullParser.NO_NAMESPACE;
        }
        String substring = str.substring(0, str.length() - zh.b.length());
        String[] split = substring.split(zh.a);
        int length = split.length;
        Boolean valueOf = Boolean.valueOf(false);
        String str2 = XmlPullParser.NO_NAMESPACE;
        String str3 = XmlPullParser.NO_NAMESPACE;
        String str4 = XmlPullParser.NO_NAMESPACE;
        int i = 0;
        String str5 = XmlPullParser.NO_NAMESPACE;
        String str6 = str4;
        Boolean bool = valueOf;
        while (i < length) {
            try {
                String[] split2 = split[i].split(zh.b);
                if (split2.length == 9 || split2.length == 7) {
                    zb zbVar;
                    yz yzVar;
                    ze zeVar;
                    if (Integer.valueOf(split2[5]).intValue() == 0) {
                        if (ze.a(context, split2[4]).booleanValue()) {
                            zbVar = new zb();
                            zbVar.a(Boolean.valueOf(false));
                            zbVar.b(Boolean.valueOf(false));
                            zbVar.a(split2[4]);
                            arrayList.add(zbVar);
                            i++;
                        } else {
                            yzVar = new yz();
                            yzVar.a(String.valueOf(split2[0]));
                            yzVar.c(split2[1]);
                            yzVar.b(split2[2]);
                            zeVar = new ze();
                            zeVar.e(split2[3]);
                            zeVar.a(String.valueOf(split2[4]));
                            zeVar.a(Integer.valueOf(split2[5]));
                            zeVar.d(String.valueOf(1));
                            zeVar.f(zn.a());
                            yz.b(context, yzVar, zeVar);
                            zb zbVar2 = new zb();
                            zbVar2.a(Boolean.valueOf(false));
                            zbVar2.b(Boolean.valueOf(false));
                            zbVar2.a(String.valueOf(zeVar.b()));
                            zg zgVar = new zg();
                            zgVar.e(zeVar.h());
                            zgVar.a(zeVar.h());
                            zg.a(context, zgVar);
                            if (yz.a(String.valueOf(zeVar.f()), String.valueOf(zeVar.h()), context).booleanValue() || !aeq.c(context).booleanValue()) {
                                valueOf = bool;
                                str4 = str6;
                                str6 = str5;
                            } else {
                                valueOf = Boolean.valueOf(true);
                                try {
                                    String str7 = " : ";
                                    str3 = zg.a(context, zeVar.h()).h() + r17 + yz.a(yzVar);
                                    str2 = "\u0641\u0627\u0646\u0648\u0633";
                                    str4 = String.valueOf(zeVar.f());
                                    try {
                                        str6 = String.valueOf(zeVar.h());
                                    } catch (Exception e) {
                                        exception = e;
                                        str6 = str4;
                                        bool = valueOf;
                                        exception2 = exception;
                                        aas = new aas();
                                        aas.a("ir.seraj.fanoos");
                                        aas.e(ys.a(context));
                                        aas.d(zn.a());
                                        aas.c("GetMessage");
                                        aas.b(exception2.getMessage() + "res: " + substring);
                                        aas.a(Integer.valueOf(0));
                                        aas.a(context);
                                        i++;
                                    }
                                } catch (Exception e2) {
                                    exception = e2;
                                    bool = valueOf;
                                    exception2 = exception;
                                    aas = new aas();
                                    aas.a("ir.seraj.fanoos");
                                    aas.e(ys.a(context));
                                    aas.d(zn.a());
                                    aas.c("GetMessage");
                                    aas.b(exception2.getMessage() + "res: " + substring);
                                    aas.a(Integer.valueOf(0));
                                    aas.a(context);
                                    i++;
                                }
                            }
                            try {
                                arrayList.add(zbVar2);
                                str5 = str6;
                                str6 = str4;
                                bool = valueOf;
                            } catch (Exception e3) {
                                exception = e3;
                                str5 = str6;
                                str6 = str4;
                                bool = valueOf;
                                exception2 = exception;
                                aas = new aas();
                                aas.a("ir.seraj.fanoos");
                                aas.e(ys.a(context));
                                aas.d(zn.a());
                                aas.c("GetMessage");
                                aas.b(exception2.getMessage() + "res: " + substring);
                                aas.a(Integer.valueOf(0));
                                aas.a(context);
                                i++;
                            }
                        }
                    } else if (Integer.valueOf(split2[5]).intValue() == 1 && split2[3].startsWith(zh.e + zh.d)) {
                        if (ze.a(context, split2[4]).booleanValue()) {
                            zbVar = new zb();
                            zbVar.a(Boolean.valueOf(true));
                            zbVar.b(Boolean.valueOf(true));
                            zbVar.a(split2[4]);
                            arrayList.add(zbVar);
                            i++;
                        } else {
                            yz yzVar2 = new yz();
                            yzVar2.a(String.valueOf(split2[0]));
                            yzVar2.c(split2[1]);
                            yzVar2.b(split2[2]);
                            ze zeVar2 = new ze();
                            zeVar2.e(split2[3]);
                            zeVar2.a(String.valueOf(split2[4]));
                            zeVar2.a(Integer.valueOf(split2[5]));
                            zeVar2.d(String.valueOf(split2[6]));
                            zeVar2.f(zn.a());
                            yz.b(context, yzVar2, zeVar2);
                            yw.f(split2[3], split2[6], context);
                            zbVar = new zb();
                            zbVar.a(String.valueOf(zeVar2.b()));
                            zbVar.a(Boolean.valueOf(true));
                            zbVar.b(Boolean.valueOf(true));
                            if (!yw.d(String.valueOf(split2[6]), context).booleanValue()) {
                                zbVar.b(split2[6]);
                            }
                            arrayList.add(zbVar);
                        }
                    } else if (Integer.valueOf(split2[5]).intValue() == 1) {
                        if (ze.a(context, split2[4]).booleanValue()) {
                            zbVar = new zb();
                            zbVar.a(Boolean.valueOf(true));
                            zbVar.b(Boolean.valueOf(false));
                            zbVar.a(split2[4]);
                            arrayList.add(zbVar);
                            i++;
                        } else {
                            yzVar = new yz();
                            yzVar.a(String.valueOf(split2[0]));
                            yzVar.c(split2[1]);
                            yzVar.b(split2[2]);
                            zeVar = new ze();
                            zeVar.e(split2[3]);
                            zeVar.a(String.valueOf(split2[4]));
                            zeVar.a(Integer.valueOf(split2[5]));
                            zeVar.d(String.valueOf(split2[6]));
                            zeVar.f(zn.a());
                            yz.b(context, yzVar, zeVar);
                            zb zbVar3 = new zb();
                            zbVar3.a(String.valueOf(zeVar.b()));
                            zbVar3.a(Boolean.valueOf(true));
                            zbVar3.b(Boolean.valueOf(false));
                            valueOf = Boolean.valueOf(false);
                            if (!yw.d(String.valueOf(split2[6]), context).booleanValue()) {
                                zbVar3.b(split2[6]);
                                valueOf = Boolean.valueOf(true);
                            }
                            String str8 = split2[3];
                            String str9 = split2[7];
                            yx.a(str8, r19, split2[8], context);
                            arrayList.add(zbVar3);
                            if (!(valueOf.booleanValue() || yz.a(String.valueOf(zeVar.f()), String.valueOf(zeVar.g()), context).booleanValue() || !aeq.d(context).booleanValue())) {
                                valueOf = Boolean.valueOf(true);
                                str3 = yw.c(String.valueOf(zeVar.g()), context).c() + " : " + yz.a(yzVar);
                                str2 = "\u0641\u0627\u0646\u0648\u0633";
                                str4 = String.valueOf(zeVar.f());
                                str5 = String.valueOf(zeVar.h());
                                str6 = str4;
                                bool = valueOf;
                            }
                        }
                    }
                    context.sendBroadcast(new Intent("ir.dayasoft.BroadCastGetNewMessage"));
                    i++;
                } else {
                    i++;
                }
            } catch (Exception e4) {
                exception2 = e4;
                aas = new aas();
                aas.a("ir.seraj.fanoos");
                aas.e(ys.a(context));
                aas.d(zn.a());
                aas.c("GetMessage");
                aas.b(exception2.getMessage() + "res: " + substring);
                aas.a(Integer.valueOf(0));
                aas.a(context);
                i++;
            }
        }
        if (bool.booleanValue()) {
            HashMap hashMap = new HashMap();
            hashMap.put("IsGroup", str6);
            hashMap.put("MobileNumber", str5);
            new aep().a(context, ChatsActivity.class, str2, str3, hashMap);
        }
        if (arrayList.size() > 0) {
            List arrayList2 = new ArrayList();
            Collection arrayList3 = new ArrayList();
            for (zb zbVar4 : arrayList) {
                if (zbVar4.c().booleanValue()) {
                    arrayList3.add(zbVar4.b());
                }
                arrayList2.add(zbVar4.a());
            }
            zj.b(aeq.o(context), arrayList2, context);
            for (String str52 : new HashSet(arrayList3)) {
                if (str52 != null) {
                    aer.a(zj.k(aeq.o(context), str52, context));
                }
            }
        }
        return substring;
    }

    public static String e(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String f(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        afn.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String g(String str, Context context) {
        int i = 0;
        if (str.length() < 2) {
            return XmlPullParser.NO_NAMESPACE;
        }
        Log.i("lasttttttttt", str);
        String substring = str.substring(0, str.length() - zh.b.length());
        List arrayList = new ArrayList();
        if (substring.length() < 1) {
            return XmlPullParser.NO_NAMESPACE;
        }
        String[] split = substring.split(zh.b);
        int length = split.length;
        while (i < length) {
            arrayList.add(split[i]);
            Log.i("lasttttttttt", split[i]);
            i++;
        }
        ze.a(context, arrayList);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String h(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String i(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String j(String str, Context context) {
        afj.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String k(String str, Context context) {
        aez.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String l(String str, Context context) {
        aez.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String m(String str, Context context) {
        afe.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String n(String str, Context context) {
        afq.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String o(String str, Context context) {
        Intent intent = new Intent("ir.dayasoft.BroadCastConversationEvent");
        intent.putExtra("ConversationEventStatus", str);
        context.sendBroadcast(intent);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String p(String str, Context context) {
        aey.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String q(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        return "0";
    }

    public static String r(String str, Context context) {
        IntentServiceGeneralCommand.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static yw s(String str, Context context) {
        String[] split = str.split(zh.a);
        Object obj = split[0];
        String[] split2 = split[1].split(zh.b);
        String[] split3 = split[2].split(zh.b);
        yw ywVar = new yw();
        ywVar.b(String.valueOf(obj));
        ywVar.c(split2[0]);
        ywVar.a(split2[1]);
        ywVar.e(split2[2]);
        ywVar.f(split3[0]);
        int length = split.length;
        List arrayList = new ArrayList();
        for (int i = 2; i < length; i++) {
            yx yxVar = new yx();
            String[] split4 = split[i].split(zh.b);
            yxVar.b(String.valueOf(obj));
            yxVar.a(split4[0]);
            yxVar.c(split4[1]);
            yxVar.d(split4[2]);
            arrayList.add(yxVar);
        }
        yw.a(ywVar, arrayList, context);
        return ywVar;
    }

    public static String t(String str, Context context) {
        c(str, context);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String u(String str, Context context) {
        afb.a(str);
        return XmlPullParser.NO_NAMESPACE;
    }

    public static String v(String str, Context context) {
        if (ys.d(context, str).equals("-100")) {
            ys.f(context, XmlPullParser.NO_NAMESPACE);
            ys.b(context, Boolean.valueOf(false));
            aeq.f(context, Boolean.valueOf(false));
            ys.a(context, Boolean.valueOf(true));
            aau aau = new aau(context);
            aau.a();
            aau.c();
            aau.b();
        }
        return XmlPullParser.NO_NAMESPACE;
    }
}
