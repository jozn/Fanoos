import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class aat {
    private SQLiteDatabase a;
    private aaq b;
    private String[] c;

    public aat(Context context) {
        this.c = new String[]{"applicationName", "deviceSn", "createDate", "errorLocation", "errorMsg", "_id", "senT"};
        this.b = new aaq(context);
    }

    public void a() {
        this.a = this.b.getWritableDatabase();
    }

    public void b() {
        this.b.close();
        this.a.close();
    }

    public aas a(aas aas) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("applicationName", aas.a());
        contentValues.put("deviceSn", aas.e());
        contentValues.put("createDate", aas.d());
        contentValues.put("errorLocation", aas.c());
        contentValues.put("errorMsg", aas.b());
        contentValues.put("senT", aas.f());
        aas.a(Long.valueOf(this.a.insert("logError", null, contentValues)));
        return aas;
    }
}
