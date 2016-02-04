import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

@TargetApi(14)
public class pd extends ot implements MenuItem {
    private Method c;

    pd(Context context, dy dyVar) {
        super(context, dyVar);
    }

    public int getItemId() {
        return ((dy) this.b).getItemId();
    }

    public int getGroupId() {
        return ((dy) this.b).getGroupId();
    }

    public int getOrder() {
        return ((dy) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((dy) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((dy) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((dy) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((dy) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((dy) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((dy) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((dy) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((dy) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((dy) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((dy) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((dy) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((dy) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((dy) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((dy) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((dy) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((dy) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((dy) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((dy) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((dy) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((dy) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((dy) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((dy) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((dy) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((dy) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return a(((dy) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((dy) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new ph(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((dy) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((dy) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((dy) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new pf(view);
        }
        ((dy) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((dy) this.b).setActionView(i);
        View actionView = ((dy) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((dy) this.b).setActionView(new pf(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((dy) this.b).getActionView();
        if (actionView instanceof pf) {
            return ((pf) actionView).c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((dy) this.b).a(actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        fs a = ((dy) this.b).a();
        if (a instanceof pe) {
            return ((pe) a).a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((dy) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((dy) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((dy) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((dy) this.b).a(onActionExpandListener != null ? new pg(this, onActionExpandListener) : null);
        return this;
    }

    public void a(boolean z) {
        try {
            if (this.c == null) {
                this.c = ((dy) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    pe a(ActionProvider actionProvider) {
        return new pe(this, this.a, actionProvider);
    }
}
