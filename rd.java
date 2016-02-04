import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.internal.widget.SpinnerCompat;
import android.widget.ListAdapter;

public class rd implements OnClickListener, ri {
    final /* synthetic */ SpinnerCompat a;
    private AlertDialog b;
    private ListAdapter c;
    private CharSequence d;

    private rd(SpinnerCompat spinnerCompat) {
        this.a = spinnerCompat;
    }

    public void a() {
        if (this.b != null) {
            this.b.dismiss();
            this.b = null;
        }
    }

    public boolean b() {
        return this.b != null ? this.b.isShowing() : false;
    }

    public void a(ListAdapter listAdapter) {
        this.c = listAdapter;
    }

    public void a(CharSequence charSequence) {
        this.d = charSequence;
    }

    public void c() {
        if (this.c != null) {
            Builder builder = new Builder(this.a.getContext());
            if (this.d != null) {
                builder.setTitle(this.d);
            }
            this.b = builder.setSingleChoiceItems(this.c, this.a.getSelectedItemPosition(), this).create();
            this.b.show();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.setSelection(i);
        if (this.a.s != null) {
            this.a.a(null, i, this.c.getItemId(i));
        }
        a();
    }
}
