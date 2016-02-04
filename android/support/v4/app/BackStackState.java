package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import e;
import i;
import java.util.ArrayList;
import k;
import u;

public final class BackStackState implements Parcelable {
    public static final Creator CREATOR;
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList j;
    final ArrayList k;

    public BackStackState(u uVar, e eVar) {
        int i = 0;
        for (i iVar = eVar.b; iVar != null; iVar = iVar.a) {
            if (iVar.i != null) {
                i += iVar.i.size();
            }
        }
        this.a = new int[(i + (eVar.d * 7))];
        if (eVar.k) {
            i = 0;
            for (i iVar2 = eVar.b; iVar2 != null; iVar2 = iVar2.a) {
                int i2 = i + 1;
                this.a[i] = iVar2.c;
                int i3 = i2 + 1;
                this.a[i2] = iVar2.d != null ? iVar2.d.p : -1;
                int i4 = i3 + 1;
                this.a[i3] = iVar2.e;
                i2 = i4 + 1;
                this.a[i4] = iVar2.f;
                i4 = i2 + 1;
                this.a[i2] = iVar2.g;
                i2 = i4 + 1;
                this.a[i4] = iVar2.h;
                if (iVar2.i != null) {
                    int size = iVar2.i.size();
                    i4 = i2 + 1;
                    this.a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.a[i4] = ((Fragment) iVar2.i.get(i2)).p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.a[i2] = 0;
                }
            }
            this.b = eVar.i;
            this.c = eVar.j;
            this.d = eVar.m;
            this.e = eVar.o;
            this.f = eVar.p;
            this.g = eVar.q;
            this.h = eVar.r;
            this.i = eVar.s;
            this.j = eVar.t;
            this.k = eVar.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
    }

    public e a(u uVar) {
        e eVar = new e(uVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.a.length) {
            i iVar = new i();
            int i3 = i2 + 1;
            iVar.c = this.a[i2];
            if (u.a) {
                Log.v("FragmentManager", "Instantiate " + eVar + " op #" + i + " base fragment #" + this.a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.a[i3];
            if (i2 >= 0) {
                iVar.d = (Fragment) uVar.f.get(i2);
            } else {
                iVar.d = null;
            }
            i3 = i4 + 1;
            iVar.e = this.a[i4];
            i4 = i3 + 1;
            iVar.f = this.a[i3];
            i3 = i4 + 1;
            iVar.g = this.a[i4];
            int i5 = i3 + 1;
            iVar.h = this.a[i3];
            i4 = i5 + 1;
            int i6 = this.a[i5];
            if (i6 > 0) {
                iVar.i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (u.a) {
                        Log.v("FragmentManager", "Instantiate " + eVar + " set remove fragment #" + this.a[i4]);
                    }
                    i5 = i4 + 1;
                    iVar.i.add((Fragment) uVar.f.get(this.a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            eVar.a(iVar);
            i++;
            i2 = i4;
        }
        eVar.i = this.b;
        eVar.j = this.c;
        eVar.m = this.d;
        eVar.o = this.e;
        eVar.k = true;
        eVar.p = this.f;
        eVar.q = this.g;
        eVar.r = this.h;
        eVar.s = this.i;
        eVar.t = this.j;
        eVar.u = this.k;
        eVar.a(1);
        return eVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
    }

    static {
        CREATOR = new k();
    }
}
