import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ps extends ox implements SubMenu {
    private ox d;
    private pb e;

    public ps(Context context, ox oxVar, pb pbVar) {
        super(context);
        this.d = oxVar;
        this.e = pbVar;
    }

    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    public boolean b() {
        return this.d.b();
    }

    public boolean c() {
        return this.d.c();
    }

    public Menu s() {
        return this.d;
    }

    public MenuItem getItem() {
        return this.e;
    }

    public void a(oy oyVar) {
        this.d.a(oyVar);
    }

    public ox p() {
        return this.d;
    }

    boolean a(ox oxVar, MenuItem menuItem) {
        return super.a(oxVar, menuItem) || this.d.a(oxVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.a(da.a(e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.a(e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    public boolean c(pb pbVar) {
        return this.d.c(pbVar);
    }

    public boolean d(pb pbVar) {
        return this.d.d(pbVar);
    }

    public String a() {
        int itemId = this.e != null ? this.e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.a() + ":" + itemId;
    }
}
