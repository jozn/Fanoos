import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParser;

public class aau {
    Context a;
    private SQLiteDatabase b;
    private aaq c;
    private String[] d;

    public aau(Context context) {
        this.d = new String[]{"status", "TextOfMessage", "_id", "PK_MessageId", "StickyImageId", "AttachmentType", "AttachmentValue", "AttachmentSize"};
        this.c = new aaq(context);
        this.a = context;
    }

    public void a() {
        this.b = this.c.getWritableDatabase();
    }

    public void b() {
        this.c.close();
        this.b.close();
    }

    public yz a(yz yzVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(yzVar.g()));
        contentValues.put("TextOfMessage", yzVar.d());
        contentValues.put("PK_MessageId", yzVar.c());
        contentValues.put("StickyImageId", Integer.valueOf(yzVar.e()));
        contentValues.put("AttachmentType", yzVar.f());
        contentValues.put("AttachmentValue", yzVar.h());
        contentValues.put("AttachmentSize", Integer.valueOf(yzVar.a()));
        yzVar.a(Long.valueOf(this.b.insert("Message", null, contentValues)));
        return yzVar;
    }

    public int b(yz yzVar) {
        ContentValues contentValues = new ContentValues();
        if (yzVar.g() != -1) {
            contentValues.put("status", Integer.valueOf(yzVar.g()));
        }
        if (!(yzVar.d() == null || yzVar.d() == XmlPullParser.NO_NAMESPACE)) {
            contentValues.put("TextOfMessage", yzVar.d());
        }
        if (!(yzVar.c() == null || yzVar.c() == XmlPullParser.NO_NAMESPACE)) {
            contentValues.put("PK_MessageId", yzVar.c());
        }
        if (yzVar.e() != -1) {
            contentValues.put("StickyImageId", Integer.valueOf(yzVar.e()));
        }
        if (!(yzVar.f() == null || yzVar.f() == XmlPullParser.NO_NAMESPACE)) {
            contentValues.put("AttachmentType", yzVar.f());
        }
        if (!(yzVar.h() == null || yzVar.h() == XmlPullParser.NO_NAMESPACE)) {
            contentValues.put("AttachmentValue", yzVar.h());
        }
        return this.b.update("Message", contentValues, "_id=?", new String[]{String.valueOf(yzVar.b())});
    }

    public yz a(Long l) {
        Cursor query = this.b.query("Message", this.d, "_id=?", new String[]{String.valueOf(l)}, null, null, null);
        query.moveToFirst();
        yz yzVar = new yz();
        if (query.getCount() > 0) {
            yzVar = a(query);
        } else {
            yzVar.a(String.valueOf(-1));
        }
        query.close();
        return yzVar;
    }

    public yz a(Cursor cursor) {
        yz yzVar = new yz();
        yzVar.c(cursor.getInt(cursor.getColumnIndex("status")));
        yzVar.b(cursor.getString(cursor.getColumnIndex("TextOfMessage")));
        yzVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        yzVar.a(cursor.getString(cursor.getColumnIndex("PK_MessageId")));
        yzVar.b(cursor.getInt(cursor.getColumnIndex("StickyImageId")));
        yzVar.c(cursor.getString(cursor.getColumnIndex("AttachmentType")));
        yzVar.d(cursor.getString(cursor.getColumnIndex("AttachmentValue")));
        yzVar.a(cursor.getInt(cursor.getColumnIndex("AttachmentSize")));
        return yzVar;
    }

    public void a(Integer num, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("AttachmentSize", num);
        this.b.update("Message", contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    public int c() {
        this.b.delete("Message", null, null);
        this.b.delete("SendReceive", null, null);
        return 1;
    }
}
