package android.support.v4.app;

import ae;
import af;
import ag;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;
import s;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList a;
    private Context b;
    private s c;
    private int d;
    private OnTabChangeListener e;
    private af f;
    private boolean g;

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        String a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
        }

        static {
            CREATOR = new ae();
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.e = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        ag agVar = null;
        for (int i = 0; i < this.a.size(); i++) {
            af afVar = (af) this.a.get(i);
            afVar.d = this.c.a(afVar.a);
            if (!(afVar.d == null || afVar.d.m())) {
                if (afVar.a.equals(currentTabTag)) {
                    this.f = afVar;
                } else {
                    if (agVar == null) {
                        agVar = this.c.a();
                    }
                    agVar.b(afVar.d);
                }
            }
        }
        this.g = true;
        ag a = a(currentTabTag, agVar);
        if (a != null) {
            a.b();
            this.c.b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.a);
    }

    public void onTabChanged(String str) {
        if (this.g) {
            ag a = a(str, null);
            if (a != null) {
                a.b();
            }
        }
        if (this.e != null) {
            this.e.onTabChanged(str);
        }
    }

    private ag a(String str, ag agVar) {
        af afVar = null;
        int i = 0;
        while (i < this.a.size()) {
            af afVar2 = (af) this.a.get(i);
            if (!afVar2.a.equals(str)) {
                afVar2 = afVar;
            }
            i++;
            afVar = afVar2;
        }
        if (afVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f != afVar) {
            if (agVar == null) {
                agVar = this.c.a();
            }
            if (!(this.f == null || this.f.d == null)) {
                agVar.b(this.f.d);
            }
            if (afVar != null) {
                if (afVar.d == null) {
                    afVar.d = Fragment.a(this.b, afVar.b.getName(), afVar.c);
                    agVar.a(this.d, afVar.d, afVar.a);
                } else {
                    agVar.c(afVar.d);
                }
            }
            this.f = afVar;
        }
        return agVar;
    }
}
