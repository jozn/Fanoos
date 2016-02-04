package android.support.v4.app;

import ab;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import u;

public final class FragmentState implements Parcelable {
    public static final Creator CREATOR;
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    public Bundle j;
    public Fragment k;

    public FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.p;
        this.c = fragment.y;
        this.d = fragment.G;
        this.e = fragment.H;
        this.f = fragment.I;
        this.g = fragment.L;
        this.h = fragment.K;
        this.i = fragment.r;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.g = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.h = z2;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }

    public Fragment a(FragmentActivity fragmentActivity, Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.k = Fragment.a((Context) fragmentActivity, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(fragmentActivity.getClassLoader());
            this.k.n = this.j;
        }
        this.k.a(this.b, fragment);
        this.k.y = this.c;
        this.k.A = true;
        this.k.G = this.d;
        this.k.H = this.e;
        this.k.I = this.f;
        this.k.L = this.g;
        this.k.K = this.h;
        this.k.C = fragmentActivity.b;
        if (u.a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.k);
        }
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        if (this.g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.h) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }

    static {
        CREATOR = new ab();
    }
}
