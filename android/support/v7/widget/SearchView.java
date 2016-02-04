package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.util.WeakHashMap;
import le;
import no;
import org.xmlpull.v1.XmlPullParser;
import rk;
import rn;
import rw;
import ul;
import um;
import un;
import uo;
import ut;
import ve;

public class SearchView extends LinearLayoutCompat implements rw {
    static final ul a;
    private static final boolean b;
    private boolean A;
    private int B;
    private boolean C;
    private CharSequence D;
    private boolean E;
    private int F;
    private SearchableInfo G;
    private Bundle H;
    private final rk I;
    private Runnable J;
    private final Runnable K;
    private Runnable L;
    private final WeakHashMap M;
    private final SearchAutoComplete c;
    private final View d;
    private final View e;
    private final ImageView f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final ImageView j;
    private final int k;
    private final int l;
    private final int m;
    private final Intent n;
    private final Intent o;
    private un p;
    private um q;
    private OnFocusChangeListener r;
    private uo s;
    private OnClickListener t;
    private boolean u;
    private boolean v;
    private le w;
    private boolean x;
    private CharSequence y;
    private boolean z;

    public class SearchAutoComplete extends AutoCompleteTextView {
        private final int[] a;
        private int b;
        private SearchView c;
        private final rk d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 16842859);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new int[]{16843126};
            this.b = getThreshold();
            rn a = rn.a(context, attributeSet, this.a, i, 0);
            if (a.d(0)) {
                setDropDownBackgroundDrawable(a.a(0));
            }
            a.b();
            this.d = a.c();
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }

        public void setDropDownBackgroundResource(int i) {
            setDropDownBackgroundDrawable(this.d.a(i));
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.a(getContext())) {
                    SearchView.a.a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.c.d();
        }

        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        this.c.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        b = z;
        a = new ul();
    }

    public int getSuggestionRowLayout() {
        return this.l;
    }

    public int getSuggestionCommitIconResId() {
        return this.m;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.G = searchableInfo;
        if (this.G != null) {
            if (b) {
                l();
            }
            k();
        }
        boolean z = b && e();
        this.C = z;
        if (this.C) {
            this.c.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setAppSearchData(Bundle bundle) {
        this.H = bundle;
    }

    public void setImeOptions(int i) {
        this.c.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.c.getImeOptions();
    }

    public void setInputType(int i) {
        this.c.setInputType(i);
    }

    public int getInputType() {
        return this.c.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.A || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.c.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.A = true;
        setImeVisibility(false);
        super.clearFocus();
        this.c.clearFocus();
        this.A = false;
    }

    public void setOnQueryTextListener(un unVar) {
        this.p = unVar;
    }

    public void setOnCloseListener(um umVar) {
        this.q = umVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.r = onFocusChangeListener;
    }

    public void setOnSuggestionListener(uo uoVar) {
        this.s = uoVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public CharSequence getQuery() {
        return this.c.getText();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.c.setText(charSequence);
        if (charSequence != null) {
            this.c.setSelection(this.c.length());
            this.D = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.y = charSequence;
        k();
    }

    public CharSequence getQueryHint() {
        if (this.y != null) {
            return this.y;
        }
        if (!b || this.G == null) {
            return null;
        }
        int hintId = this.G.getHintId();
        if (hintId != 0) {
            return getContext().getString(hintId);
        }
        return null;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.u != z) {
            this.u = z;
            a(z);
            k();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            o();
        } else {
            p();
        }
    }

    public boolean c() {
        return this.v;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.x = z;
        a(c());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.z = z;
        if (this.w instanceof ut) {
            ((ut) this.w).a(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(le leVar) {
        this.w = leVar;
        this.c.setAdapter(this.w);
    }

    public le getSuggestionsAdapter() {
        return this.w;
    }

    public void setMaxWidth(int i) {
        this.B = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.B;
    }

    protected void onMeasure(int i, int i2) {
        if (c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.B <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.B, size);
                    break;
                }
            case ve.CropImageView_guidelines /*0*/:
                if (this.B <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.B;
                    break;
                }
            case 1073741824:
                if (this.B > 0) {
                    size = Math.min(this.B, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(no.abc_search_view_preferred_width);
    }

    private void a(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.v = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.c.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f.setVisibility(i2);
        b(z2);
        View view = this.d;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        ImageView imageView = this.j;
        if (!this.u) {
            i = 0;
        }
        imageView.setVisibility(i);
        h();
        if (z2) {
            z3 = false;
        }
        c(z3);
        g();
    }

    @TargetApi(8)
    private boolean e() {
        if (this.G == null || !this.G.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.G.getVoiceSearchLaunchWebSearch()) {
            intent = this.n;
        } else if (this.G.getVoiceSearchLaunchRecognizer()) {
            intent = this.o;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private boolean f() {
        return (this.x || this.C) && !c();
    }

    private void b(boolean z) {
        int i = 8;
        if (this.x && f() && hasFocus() && (z || !this.C)) {
            i = 0;
        }
        this.g.setVisibility(i);
    }

    private void g() {
        int i = 8;
        if (f() && (this.g.getVisibility() == 0 || this.i.getVisibility() == 0)) {
            i = 0;
        }
        this.e.setVisibility(i);
    }

    private void h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.u || this.E)) {
            i = 0;
        }
        ImageView imageView = this.h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        this.h.getDrawable().setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    private void i() {
        post(this.K);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.K);
        post(this.L);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.J);
            return;
        }
        removeCallbacks(this.J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    public void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    private CharSequence b(CharSequence charSequence) {
        if (!this.u) {
            return charSequence;
        }
        Drawable a = this.I.a(this.k);
        int textSize = (int) (((double) this.c.getTextSize()) * 1.25d);
        a.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(new ImageSpan(a), 1, 2, 33);
        return spannableStringBuilder;
    }

    private void k() {
        if (this.y != null) {
            this.c.setHint(b(this.y));
        } else if (!b || this.G == null) {
            this.c.setHint(b(XmlPullParser.NO_NAMESPACE));
        } else {
            CharSequence charSequence = null;
            int hintId = this.G.getHintId();
            if (hintId != 0) {
                charSequence = getContext().getString(hintId);
            }
            if (charSequence != null) {
                this.c.setHint(b(charSequence));
            }
        }
    }

    @TargetApi(8)
    private void l() {
        int i = 1;
        this.c.setThreshold(this.G.getSuggestThreshold());
        this.c.setImeOptions(this.G.getImeOptions());
        int inputType = this.G.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.G.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.c.setInputType(inputType);
        if (this.w != null) {
            this.w.a(null);
        }
        if (this.G.getSuggestAuthority() != null) {
            this.w = new ut(getContext(), this, this.G, this.M);
            this.c.setAdapter(this.w);
            ut utVar = (ut) this.w;
            if (this.z) {
                i = 2;
            }
            utVar.a(i);
        }
    }

    private void c(boolean z) {
        int i;
        if (this.C && !c() && z) {
            i = 0;
            this.g.setVisibility(8);
        } else {
            i = 8;
        }
        this.i.setVisibility(i);
    }

    private void m() {
        CharSequence text = this.c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.p == null || !this.p.a(text.toString())) {
                if (this.G != null) {
                    a(0, null, text.toString());
                }
                setImeVisibility(false);
                n();
            }
        }
    }

    private void n() {
        this.c.dismissDropDown();
    }

    private void o() {
        if (!TextUtils.isEmpty(this.c.getText())) {
            this.c.setText(XmlPullParser.NO_NAMESPACE);
            this.c.requestFocus();
            setImeVisibility(true);
        } else if (!this.u) {
        } else {
            if (this.q == null || !this.q.a()) {
                clearFocus();
                a(true);
            }
        }
    }

    private void p() {
        a(false);
        this.c.requestFocus();
        setImeVisibility(true);
        if (this.t != null) {
            this.t.onClick(this);
        }
    }

    void d() {
        a(c());
        i();
        if (this.c.hasFocus()) {
            q();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        i();
    }

    public void b() {
        a(XmlPullParser.NO_NAMESPACE, false);
        clearFocus();
        a(true);
        this.c.setImeOptions(this.F);
        this.E = false;
    }

    public void a() {
        if (!this.E) {
            this.E = true;
            this.F = this.c.getImeOptions();
            this.c.setImeOptions(this.F | 33554432);
            this.c.setText(XmlPullParser.NO_NAMESPACE);
            setIconified(false);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.c.setText(charSequence);
        this.c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.D);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.H != null) {
            intent.putExtra("app_data", this.H);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (b) {
            intent.setComponent(this.G.getSearchActivity());
        }
        return intent;
    }

    private void q() {
        a.a(this.c);
        a.b(this.c);
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
