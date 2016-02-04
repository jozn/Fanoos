import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class aar {
    private SQLiteDatabase a;
    private aaq b;
    private String[] c;
    private String[] d;

    public aar(Context context) {
        this.c = new String[]{"CreateDate", "FK_CreatorUserId", "FK_AdminUserId", "status", "AdminNumber", "CreatorNumber", "_id", "GroupName", "Image", "NumberOfUnread"};
        this.d = new String[]{"PK_GroupId", "_id", "NickName", "status", "MobileNumber", "Image"};
        this.b = new aaq(context);
    }

    public void a() {
        this.a = this.b.getWritableDatabase();
    }

    public void b() {
        this.b.close();
        this.a.close();
    }

    public yw a(yw ywVar) {
        if (d(ywVar.b()).intValue() != -1) {
            ywVar.b(String.valueOf("-1"));
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CreateDate", ywVar.e());
            contentValues.put("status", yw.l);
            contentValues.put("AdminNumber", ywVar.g());
            contentValues.put("CreatorNumber", ywVar.d());
            contentValues.put("_id", ywVar.b());
            contentValues.put("GroupName", ywVar.c());
            contentValues.put("Image", ywVar.a());
            contentValues.put("NumberOfUnread", Integer.valueOf(0));
            ywVar.b(String.valueOf(this.a.insert("GroupTbl", null, contentValues)));
        }
        return ywVar;
    }

    public int b(yw ywVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("CreateDate", ywVar.e());
        contentValues.put("AdminNumber", ywVar.g());
        contentValues.put("_id", ywVar.b());
        contentValues.put("GroupName", ywVar.c());
        contentValues.put("Image", ywVar.a());
        int update = this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(ywVar.b())});
        if (update < 1) {
            a(ywVar);
        }
        return update;
    }

    public int a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("GroupName", str2);
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int b(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("AdminNumber", str2);
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int c(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Image", str2);
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", yw.m);
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int b(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", yw.l);
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public yw c(String str) {
        Cursor query = this.a.query("GroupTbl", this.c, "_id=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        yw ywVar = new yw();
        if (query.getCount() > 0) {
            ywVar = a(query);
        } else {
            ywVar.b(String.valueOf(-1));
        }
        query.close();
        return ywVar;
    }

    public Integer d(String str) {
        Cursor query = this.a.query("GroupTbl", new String[]{String.valueOf("status")}, "_id=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        Integer valueOf = Integer.valueOf(-1);
        if (query.getCount() > 0) {
            valueOf = Integer.valueOf(query.getInt(0));
        }
        query.close();
        return valueOf;
    }

    public Integer e(String str) {
        Cursor query = this.a.query("GroupTbl", new String[]{String.valueOf("NumberOfUnread")}, "_id=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        Integer valueOf = Integer.valueOf(-1);
        if (query.getCount() > 0) {
            valueOf = Integer.valueOf(query.getInt(0));
        }
        query.close();
        return valueOf;
    }

    public int f(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NumberOfUnread", Integer.valueOf(0));
        return this.a.update("GroupTbl", contentValues, "_id=?", new String[]{String.valueOf(str)});
    }

    public int g(String str) {
        this.a.execSQL("UPDATE GroupTbl   SET NumberOfUnread = NumberOfUnread + 1 where _id = '" + str + "'");
        return 1;
    }

    public yw a(Cursor cursor) {
        yw ywVar = new yw();
        ywVar.e(cursor.getString(cursor.getColumnIndex("CreateDate")));
        ywVar.b(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("FK_CreatorUserId"))));
        ywVar.c(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("FK_AdminUserId"))));
        ywVar.d(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("status"))));
        ywVar.f(cursor.getString(cursor.getColumnIndex("AdminNumber")));
        ywVar.d(cursor.getString(cursor.getColumnIndex("CreatorNumber")));
        ywVar.b(cursor.getString(cursor.getColumnIndex("_id")));
        ywVar.c(cursor.getString(cursor.getColumnIndex("GroupName")));
        ywVar.a(cursor.getString(cursor.getColumnIndex("Image")));
        ywVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("NumberOfUnread"))));
        return ywVar;
    }

    public yx b(Cursor cursor) {
        yx yxVar = new yx();
        yxVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        yxVar.b(cursor.getString(cursor.getColumnIndex("PK_GroupId")));
        yxVar.a(cursor.getString(cursor.getColumnIndex("MobileNumber")));
        yxVar.c(cursor.getString(cursor.getColumnIndex("NickName")));
        yxVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("status"))));
        yxVar.d(cursor.getString(cursor.getColumnIndex("Image")));
        return yxVar;
    }

    public List h(String str) {
        List arrayList = new ArrayList();
        Cursor query = this.a.query("GroupUser", this.d, "PK_GroupId=? and status=?", new String[]{String.valueOf(str), String.valueOf(1)}, null, null, null);
        query.moveToFirst();
        query.moveToFirst();
        while (!query.isAfterLast()) {
            yx yxVar = new yx();
            yxVar = b(query);
            query.moveToNext();
            arrayList.add(yxVar);
        }
        query.close();
        return arrayList;
    }

    public yx i(String str) {
        ArrayList arrayList = new ArrayList();
        Cursor query = this.a.query("GroupUser", this.d, "MobileNumber=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        query.moveToFirst();
        yx yxVar = new yx();
        if (!query.isAfterLast()) {
            yxVar = b(query);
            query.moveToNext();
        }
        query.close();
        return yxVar;
    }

    public int a(yx yxVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(2));
        return this.a.update("GroupUser", contentValues, "PK_GroupId=? and MobileNumber=?", new String[]{String.valueOf(yxVar.b()), String.valueOf(yxVar.a())});
    }

    private int c(yx yxVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(1));
        contentValues.put("NickName", yxVar.c());
        contentValues.put("Image", yxVar.d());
        return this.a.update("GroupUser", contentValues, "PK_GroupId=? and MobileNumber=?", new String[]{String.valueOf(yxVar.b()), String.valueOf(yxVar.a())});
    }

    public int a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NickName", str2);
        contentValues.put("Image", str3);
        return this.a.update("GroupUser", contentValues, "MobileNumber=?", new String[]{String.valueOf(str)});
    }

    public Long b(yx yxVar) {
        if (c(yxVar) > 0) {
            return Long.valueOf("1");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("PK_GroupId", yxVar.b());
        contentValues.put("MobileNumber", yxVar.a());
        contentValues.put("NickName", yxVar.c());
        contentValues.put("Image", yxVar.d());
        contentValues.put("status", Integer.valueOf(1));
        return Long.valueOf(this.a.insert("GroupUser", null, contentValues));
    }

    public int a(List list) {
        for (yx b : list) {
            b(b);
        }
        return 1;
    }
}
