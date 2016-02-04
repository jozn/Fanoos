import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;

class adh implements OnClickListener {
    final /* synthetic */ adg a;

    adh(adg adg) {
        this.a = adg;
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        new Intent("android.intent.action.GET_CONTENT").setType("vnd.android.cursor.item/phone_v2");
        this.a.a.a(intent, 1888);
    }
}
