import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.internal.widget.CompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class qz extends LinearLayoutCompat implements OnLongClickListener {
    final /* synthetic */ qv a;
    private final int[] b;
    private mx c;
    private TextView d;
    private ImageView e;
    private View f;

    public qz(qv qvVar, Context context, mx mxVar, boolean z) {
        this.a = qvVar;
        super(context, null, nl.actionBarTabStyle);
        this.b = new int[]{16842964};
        this.c = mxVar;
        rn a = rn.a(context, null, this.b, nl.actionBarTabStyle, 0);
        if (a.d(0)) {
            setBackgroundDrawable(a.a(0));
        }
        a.b();
        if (z) {
            setGravity(8388627);
        }
        a();
    }

    public void a(mx mxVar) {
        this.c = mxVar;
        a();
    }

    public void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(mx.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(mx.class.getName());
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a.b > 0 && getMeasuredWidth() > this.a.b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.a.b, 1073741824), i2);
        }
    }

    public void a() {
        mx mxVar = this.c;
        View d = mxVar.d();
        if (d != null) {
            qz parent = d.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(d);
                }
                addView(d);
            }
            this.f = d;
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
                return;
            }
            return;
        }
        boolean z;
        if (this.f != null) {
            removeView(this.f);
            this.f = null;
        }
        Drawable b = mxVar.b();
        CharSequence c = mxVar.c();
        if (b != null) {
            if (this.e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.h = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView, 0);
                this.e = imageView;
            }
            this.e.setImageDrawable(b);
            this.e.setVisibility(0);
        } else if (this.e != null) {
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
        }
        if (TextUtils.isEmpty(c)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.d == null) {
                imageView = new CompatTextView(getContext(), null, nl.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.h = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView);
                this.d = imageView;
            }
            this.d.setText(c);
            this.d.setVisibility(0);
        } else if (this.d != null) {
            this.d.setVisibility(8);
            this.d.setText(null);
        }
        if (this.e != null) {
            this.e.setContentDescription(mxVar.f());
        }
        if (z || TextUtils.isEmpty(mxVar.f())) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.c.f(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public mx b() {
        return this.c;
    }
}
