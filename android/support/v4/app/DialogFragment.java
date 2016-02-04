package android.support.v4.app;

import ag;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import ve;

public class DialogFragment extends Fragment implements OnCancelListener, OnDismissListener {
    int a;
    int b;
    boolean c;
    boolean d;
    int e;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public DialogFragment() {
        this.a = 0;
        this.b = 0;
        this.c = true;
        this.d = true;
        this.e = -1;
    }

    void a(boolean z) {
        if (!this.h) {
            this.h = true;
            this.i = false;
            if (this.f != null) {
                this.f.dismiss();
                this.f = null;
            }
            this.g = true;
            if (this.e >= 0) {
                j().a(this.e, 1);
                this.e = -1;
                return;
            }
            ag a = j().a();
            a.a((Fragment) this);
            if (z) {
                a.c();
            } else {
                a.b();
            }
        }
    }

    public int a() {
        return this.b;
    }

    public void a(Activity activity) {
        super.a(activity);
        if (!this.i) {
            this.h = false;
        }
    }

    public void b() {
        super.b();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.H == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        switch (this.a) {
            case ve.CropImageView_fixAspectRatio /*1*/:
            case ve.CropImageView_aspectRatioX /*2*/:
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                this.f.getWindow().addFlags(24);
                break;
        }
        this.f.requestWindowFeature(1);
        if (this.f != null) {
            return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.D.getSystemService("layout_inflater");
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(h(), a());
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        if (this.d) {
            View p = p();
            if (p != null) {
                if (p.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(p);
            }
            this.f.setOwnerActivity(h());
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void c() {
        super.c();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.f != null) {
            Bundle onSaveInstanceState = this.f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }

    public void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
