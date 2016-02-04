import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class aav {
    private SQLiteDatabase a;
    private aaq b;
    private String[] c;

    public aav(Context context) {
        this.c = new String[]{"FK_MessageId", "FK_ClientMessageId", "FK_ReceiverId", "_id", "ReceiverMobile", "ServerReceiveDate", "DeliverDate", "SendReceiveId", "SeenDate", "Seen", "CountUserOfGroupSeen", "Delivered", "ReciverIsUser", "status", "ServerReceived", "SenderMobile"};
        this.b = new aaq(context);
    }

    public void a() {
        this.a = this.b.getWritableDatabase();
    }

    public void b() {
        this.b.close();
        this.a.close();
    }

    public ze a(ze zeVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FK_MessageId", zeVar.c());
        contentValues.put("FK_ClientMessageId", zeVar.d());
        contentValues.put("FK_ReceiverId", zeVar.g());
        contentValues.put("ReceiverMobile", zeVar.h());
        contentValues.put("ServerReceiveDate", zeVar.j());
        contentValues.put("DeliverDate", zeVar.l());
        contentValues.put("SendReceiveId", zeVar.b());
        contentValues.put("SeenDate", zeVar.n());
        contentValues.put("Seen", zeVar.m());
        contentValues.put("CountUserOfGroupSeen", zeVar.p());
        contentValues.put("Delivered", zeVar.k());
        contentValues.put("ReciverIsUser", zeVar.f());
        contentValues.put("status", zeVar.o());
        contentValues.put("ServerReceived", zeVar.i());
        contentValues.put("SenderMobile", zeVar.e());
        zeVar.a(Long.valueOf(this.a.insert("SendReceive", null, contentValues)));
        return zeVar;
    }

    public void a(String str) {
        this.a.delete("SendReceive", "_id=" + str, null);
    }

    public int b(ze zeVar) {
        ContentValues contentValues = new ContentValues();
        if (zeVar.c() != "-1") {
            contentValues.put("FK_MessageId", zeVar.c());
        }
        if (zeVar.d().longValue() != -1) {
            contentValues.put("FK_ClientMessageId", zeVar.d());
        }
        if (zeVar.g() != "-1") {
            contentValues.put("FK_ReceiverId", zeVar.g());
        }
        if (zeVar.h() != "-1") {
            contentValues.put("ReceiverMobile", zeVar.h());
        }
        if (zeVar.j() != "-1") {
            contentValues.put("ServerReceiveDate", zeVar.j());
        }
        if (zeVar.l() != "-1") {
            contentValues.put("DeliverDate", zeVar.l());
        }
        if (zeVar.b() != "-1") {
            contentValues.put("SendReceiveId", zeVar.b());
        }
        if (zeVar.n() != "-1") {
            contentValues.put("SeenDate", zeVar.n());
        }
        if (zeVar.m().intValue() != -1) {
            contentValues.put("Seen", zeVar.m());
        }
        if (zeVar.p().intValue() != -1) {
            contentValues.put("CountUserOfGroupSeen", zeVar.p());
        }
        if (zeVar.k().intValue() != -1) {
            contentValues.put("Delivered", zeVar.k());
        }
        if (zeVar.f().intValue() != -1) {
            contentValues.put("ReciverIsUser", zeVar.f());
        }
        if (zeVar.o().intValue() != -1) {
            contentValues.put("status", zeVar.o());
        }
        if (zeVar.i().intValue() != -1) {
            contentValues.put("ServerReceived", zeVar.i());
        }
        if (zeVar.e() != "-1") {
            contentValues.put("SenderMobile", zeVar.e());
        }
        return this.a.update("SendReceive", contentValues, "_id=?", new String[]{String.valueOf(zeVar.a())});
    }

    public int a(List list) {
        String str = XmlPullParser.NO_NAMESPACE;
        str = XmlPullParser.NO_NAMESPACE;
        for (String str2 : list) {
            String[] split = str2.split(zh.a);
            String str3 = split[0];
            Object obj = split[1];
            ContentValues contentValues = new ContentValues();
            contentValues.put("Delivered", ze.c);
            contentValues.put("SendReceiveId", str3);
            int update = this.a.update("SendReceive", contentValues, "_id=?", new String[]{String.valueOf(obj)});
            Log.i("id3211", str2);
            if (update < 1) {
                Log.i("id3211E", str2);
            }
            contentValues.clear();
        }
        return 1;
    }

    public int b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", ze.d);
        return this.a.update("SendReceive", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int c(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Seen", "0");
        return this.a.update("SendReceive", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int a(String str, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Seen", "0");
        int update = this.a.update("SendReceive", contentValues, "_id=? and length(SendReceiveId)<4", new String[]{String.valueOf(str)});
        if (update > 0) {
            ze.w = Integer.valueOf(1);
            ys.i(context);
        }
        return update;
    }

    public int a(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        return this.a.update("SendReceive", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public Boolean d(String str) {
        Cursor rawQuery = this.a.rawQuery(" select SendReceiveId from SendReceive where SendReceiveId = '" + str + "'", null);
        rawQuery.moveToFirst();
        if (rawQuery.getCount() > 0) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public List c() {
        List arrayList = new ArrayList();
        Cursor rawQuery = this.a.rawQuery(" select * from SendReceive where Delivered = " + ze.a + " and " + "Seen" + " = " + "0", null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(a(rawQuery));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public ze a(Long l) {
        Cursor query = this.a.query("SendReceive", this.c, "_id=?", new String[]{String.valueOf(l)}, null, null, null);
        query.moveToFirst();
        ze zeVar = new ze();
        if (query.getCount() > 0) {
            zeVar = a(query);
        } else {
            zeVar.a(String.valueOf(-1));
        }
        query.close();
        return zeVar;
    }

    public ze a(Cursor cursor) {
        ze zeVar = new ze();
        zeVar.b(cursor.getString(cursor.getColumnIndex("FK_MessageId")));
        zeVar.b(Long.valueOf(cursor.getLong(cursor.getColumnIndex("FK_ClientMessageId"))));
        zeVar.d(cursor.getString(cursor.getColumnIndex("FK_ReceiverId")));
        zeVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        zeVar.e(cursor.getString(cursor.getColumnIndex("ReceiverMobile")));
        zeVar.f(cursor.getString(cursor.getColumnIndex("ServerReceiveDate")));
        zeVar.g(cursor.getString(cursor.getColumnIndex("DeliverDate")));
        zeVar.a(cursor.getString(cursor.getColumnIndex("SendReceiveId")));
        zeVar.h(cursor.getString(cursor.getColumnIndex("SeenDate")));
        zeVar.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("Seen"))));
        zeVar.f(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("CountUserOfGroupSeen"))));
        zeVar.c(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("Delivered"))));
        zeVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("ReciverIsUser"))));
        zeVar.e(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("status"))));
        zeVar.b(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("ServerReceived"))));
        zeVar.c(cursor.getString(cursor.getColumnIndex("SenderMobile")));
        return zeVar;
    }

    public int e(String str) {
        this.a.execSQL("delete  from SendReceive where ReceiverMobile like \"%" + str + "%\"" + " and  " + "ReciverIsUser" + " = " + "0");
        return 1;
    }

    public int f(String str) {
        this.a.delete("SendReceive", "FK_ReceiverId= '" + str + "'", null);
        return 1;
    }

    public int g(String str) {
        this.a.delete("SendReceive", "FK_ReceiverId=" + str + " and " + "ReciverIsUser" + "=1" + " and " + "status" + " = " + ze.a, null);
        return 1;
    }
}
