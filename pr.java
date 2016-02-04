import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class pr extends ot implements Menu {
    pr(Context context, dx dxVar) {
        super(context, dxVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(((dx) this.b).add(charSequence));
    }

    public MenuItem add(int i) {
        return a(((dx) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(((dx) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(((dx) this.b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((dx) this.b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(((dx) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((dx) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((dx) this.b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((dx) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        b(i);
        ((dx) this.b).removeItem(i);
    }

    public void removeGroup(int i) {
        a(i);
        ((dx) this.b).removeGroup(i);
    }

    public void clear() {
        a();
        ((dx) this.b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((dx) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((dx) this.b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((dx) this.b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((dx) this.b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return a(((dx) this.b).findItem(i));
    }

    public int size() {
        return ((dx) this.b).size();
    }

    public MenuItem getItem(int i) {
        return a(((dx) this.b).getItem(i));
    }

    public void close() {
        ((dx) this.b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((dx) this.b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((dx) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((dx) this.b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((dx) this.b).setQwertyMode(z);
    }
}
