import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class tt {
    public void a(Canvas canvas, RecyclerView recyclerView, uf ufVar) {
        a(canvas, recyclerView);
    }

    @Deprecated
    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void b(Canvas canvas, RecyclerView recyclerView, uf ufVar) {
        b(canvas, recyclerView);
    }

    @Deprecated
    public void b(Canvas canvas, RecyclerView recyclerView) {
    }

    @Deprecated
    public void a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, uf ufVar) {
        a(rect, ((LayoutParams) view.getLayoutParams()).c(), recyclerView);
    }
}
