import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class pa implements OnClickListener, OnDismissListener, OnKeyListener, pn {
    ov a;
    private ox b;
    private AlertDialog c;
    private pn d;

    public pa(ox oxVar) {
        this.b = oxVar;
    }

    public void a(IBinder iBinder) {
        ox oxVar = this.b;
        Builder builder = new Builder(oxVar.e());
        this.a = new ov(ns.abc_list_menu_item_layout, nu.Theme_AppCompat_CompactMenu);
        this.a.a((pn) this);
        this.b.a(this.a);
        builder.setAdapter(this.a.a(), this);
        View o = oxVar.o();
        if (o != null) {
            builder.setCustomTitle(o);
        } else {
            builder.setIcon(oxVar.n()).setTitle(oxVar.m());
        }
        builder.setOnKeyListener(this);
        this.c = builder.create();
        this.c.setOnDismissListener(this);
        LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.b.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    public void a(ox oxVar, boolean z) {
        if (z || oxVar == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.a(oxVar, z);
        }
    }

    public boolean a(ox oxVar) {
        if (this.d != null) {
            return this.d.a(oxVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((pb) this.a.a().getItem(i), 0);
    }
}
