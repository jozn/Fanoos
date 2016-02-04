import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class yu {
    public static List a(Context context) {
        String o = aeq.o(context);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Uri uri = Contacts.CONTENT_URI;
        String str = "_id";
        String str2 = "display_name";
        String str3 = "has_phone_number";
        Uri uri2 = Phone.CONTENT_URI;
        String str4 = "contact_id";
        String str5 = "data1";
        Uri uri3 = Email.CONTENT_URI;
        String str6 = "contact_id";
        str6 = "data1";
        StringBuffer stringBuffer = new StringBuffer();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query.getCount() > 0) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(str));
                String string2 = query.getString(query.getColumnIndex(str2));
                if (Integer.parseInt(query.getString(query.getColumnIndex(str3))) > 0) {
                    stringBuffer.append("\n First Name:" + string2);
                    Cursor query2 = contentResolver.query(uri2, null, str4 + " = ?", new String[]{string}, null);
                    string = o;
                    while (query2.moveToNext()) {
                        String string3 = query2.getString(query2.getColumnIndex(str5));
                        if (string3.contains("3021")) {
                            string = XmlPullParser.NO_NAMESPACE;
                        }
                        zg zgVar = new zg();
                        string3 = zg.g(string3);
                        if (!(string3.length() != 11 || arrayList2.contains(string3) || string3.equals(r2))) {
                            if (string2.length() > 2) {
                                zgVar.e(string2);
                            } else {
                                zgVar.e(string3);
                            }
                            zgVar.a(string3);
                            zgVar.b(Integer.valueOf(0));
                            arrayList.add(zgVar);
                            arrayList2.add(string3);
                        }
                    }
                    query2.close();
                } else {
                    string = o;
                }
                o = string;
            }
        }
        return arrayList;
    }
}
