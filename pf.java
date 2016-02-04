import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class pf extends FrameLayout implements rw {
    final CollapsibleActionView a;

    pf(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView) view;
        addView(view);
    }

    public void a() {
        this.a.onActionViewExpanded();
    }

    public void b() {
        this.a.onActionViewCollapsed();
    }

    View c() {
        return (View) this.a;
    }
}
