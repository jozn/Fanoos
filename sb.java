import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.TintImageView;
import android.support.v7.widget.ActionMenuPresenter;

public class sb extends TintImageView implements sh {
    final /* synthetic */ ActionMenuPresenter a;
    private final float[] b;

    public sb(ActionMenuPresenter actionMenuPresenter, Context context) {
        this.a = actionMenuPresenter;
        super(context, null, nl.actionOverflowButtonStyle);
        this.b = new float[2];
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new sc(this, this, actionMenuPresenter));
    }

    public boolean performClick() {
        if (!super.performClick()) {
            playSoundEffect(0);
            this.a.c();
        }
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (!(drawable == null || background == null)) {
            float[] fArr = this.b;
            fArr[0] = (float) drawable.getBounds().centerX();
            getImageMatrix().mapPoints(fArr);
            int width = ((int) fArr[0]) - (getWidth() / 2);
            do.a(background, width, 0, getWidth() + width, getHeight());
        }
        return frame;
    }
}
