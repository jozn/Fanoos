import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class aaw {
    private SQLiteDatabase a;
    private aaq b;
    private String[] c;

    public aaw(Context context) {
        this.c = new String[]{"CreateDate", "status", "FullImageUrl", "_id", "NickName", "LastSeen", "LastImageUrl", "MobileNumber", "NumberOfUnread"};
        this.b = new aaq(context);
    }

    public void a() {
        this.a = this.b.getWritableDatabase();
    }

    public void b() {
        this.b.close();
        this.a.close();
    }

    public Long a(zg zgVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("CreateDate", zgVar.e());
        contentValues.put("status", zgVar.i());
        contentValues.put("FullImageUrl", zgVar.j());
        contentValues.put("NickName", zgVar.h());
        contentValues.put("LastSeen", zgVar.f());
        contentValues.put("LastImageUrl", zgVar.g());
        contentValues.put("MobileNumber", zgVar.d());
        contentValues.put("NumberOfUnread", zgVar.a());
        return Long.valueOf(this.a.insert("Users", null, contentValues));
    }

    public int a(List list) {
        ContentValues contentValues = new ContentValues();
        List c = c();
        List arrayList = new ArrayList();
        int i = 0;
        for (zg zgVar : list) {
            int i2;
            if (c.contains(zgVar.d())) {
                arrayList.add(zgVar);
                i2 = i;
            } else {
                contentValues.put("CreateDate", zgVar.e());
                contentValues.put("status", zgVar.i());
                contentValues.put("FullImageUrl", zgVar.j());
                contentValues.put("NickName", zgVar.h());
                contentValues.put("LastSeen", zgVar.f());
                contentValues.put("LastImageUrl", zgVar.g());
                contentValues.put("MobileNumber", zgVar.d());
                contentValues.put("NumberOfUnread", zgVar.a());
                long insert = this.a.insert("Users", null, contentValues);
                contentValues.clear();
                if (insert > 0) {
                    i++;
                    arrayList.add(zgVar);
                }
                i2 = i;
            }
            i = i2;
        }
        b(arrayList);
        return i;
    }

    public int b(List list) {
        ContentValues contentValues = new ContentValues();
        for (zg zgVar : list) {
            if (zgVar.e() != XmlPullParser.NO_NAMESPACE) {
                contentValues.put("CreateDate", zgVar.e());
            }
            if (zgVar.i().intValue() != -1) {
                contentValues.put("status", zgVar.i());
            }
            if (zgVar.j() != XmlPullParser.NO_NAMESPACE) {
                contentValues.put("FullImageUrl", zgVar.j());
            }
            if (zgVar.c().longValue() != -1) {
                contentValues.put("_id", zgVar.c());
            }
            if (zgVar.h() != XmlPullParser.NO_NAMESPACE) {
                contentValues.put("NickName", zgVar.h());
            }
            if (zgVar.f() != XmlPullParser.NO_NAMESPACE) {
                contentValues.put("LastSeen", zgVar.f());
            }
            if (zgVar.g() != XmlPullParser.NO_NAMESPACE) {
                contentValues.put("LastImageUrl", zgVar.g());
            }
            if (zgVar.a().intValue() != -1) {
                contentValues.put("NumberOfUnread", zgVar.a());
            }
            this.a.update("Users", contentValues, "MobileNumber=?", new String[]{String.valueOf(zgVar.d())});
        }
        return 1;
    }

    public zg a(String str) {
        Cursor query = this.a.query("Users", this.c, "MobileNumber=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        zg zgVar = new zg();
        if (query.getCount() > 0) {
            zgVar = a(query);
        } else {
            zgVar.a(Long.valueOf(-1));
        }
        query.close();
        return zgVar;
    }

    public Boolean b(String str) {
        Boolean valueOf;
        Cursor rawQuery = this.a.rawQuery("select _id from Users where MobileNumber like \"%" + str + "%\"", null);
        rawQuery.moveToFirst();
        if (rawQuery.getCount() > 0) {
            valueOf = Boolean.valueOf(true);
        } else {
            valueOf = Boolean.valueOf(false);
        }
        rawQuery.close();
        return valueOf;
    }

    public List a(int i) {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(i)};
        Cursor query = this.a.query("Users", this.c, "status =? ", strArr, null, null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            arrayList.add(a(query));
            query.moveToNext();
        }
        query.close();
        return arrayList;
    }

    public List a(String str, int i) {
        List arrayList = new ArrayList();
        Cursor rawQuery = this.a.rawQuery(" select * from Users where ( Users.NickName like '" + str + "%' OR Users.NickName like '% " + str + "%') and status=" + i, null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(a(rawQuery));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public List a(String str, int i, String str2) {
        List arrayList = new ArrayList();
        Cursor rawQuery = this.a.rawQuery(" select * from Users where MobileNumber not in(  \n\n select MobileNumber from GroupUser where PK_GroupId='" + str2 + "' and " + "status" + " = " + 1 + ")" + " and " + "( Users.NickName like" + " '" + str + "%' OR Users.NickName like '% " + str + "%') and status=" + i, null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(a(rawQuery));
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public List c() {
        List arrayList = new ArrayList();
        new String[1][0] = String.valueOf(1);
        Cursor query = this.a.query("Users", new String[]{"MobileNumber"}, null, null, null, null, null);
        query.moveToFirst();
        while (!query.isAfterLast()) {
            arrayList.add(query.getString(0));
            query.moveToNext();
        }
        query.close();
        return arrayList;
    }

    public int c(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NumberOfUnread", Integer.valueOf(0));
        return this.a.update("Users", contentValues, "MobileNumber=?", new String[]{String.valueOf(str)});
    }

    public int d(String str) {
        this.a.execSQL("UPDATE Users   SET NumberOfUnread = NumberOfUnread + 1 where MobileNumber like \"%" + str + "%\"");
        return 1;
    }

    public int e(String str) {
        Cursor query = this.a.query("Users", new String[]{String.valueOf("NumberOfUnread")}, "MobileNumber=?", new String[]{String.valueOf(str)}, null, null, null);
        query.moveToFirst();
        Integer valueOf = Integer.valueOf(-1);
        if (query.getCount() > 0) {
            valueOf = Integer.valueOf(query.getInt(0));
        }
        query.close();
        return valueOf.intValue();
    }

    public zg a(Cursor cursor) {
        zg zgVar = new zg();
        zgVar.b(cursor.getString(cursor.getColumnIndex("CreateDate")));
        zgVar.b(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("status"))));
        zgVar.f(cursor.getString(cursor.getColumnIndex("FullImageUrl")));
        zgVar.a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        zgVar.e(cursor.getString(cursor.getColumnIndex("NickName")));
        zgVar.c(cursor.getString(cursor.getColumnIndex("LastSeen")));
        zgVar.d(cursor.getString(cursor.getColumnIndex("LastImageUrl")));
        zgVar.a(cursor.getString(cursor.getColumnIndex("MobileNumber")));
        zgVar.a(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("NumberOfUnread"))));
        return zgVar;
    }
}
