package android.support.v7.app;

import a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import au;
import cu;
import cv;
import mz;
import ru;

public class ActionBarActivity extends FragmentActivity implements cv {
    private mz n;

    public ActionBar g() {
        return j().b();
    }

    public MenuInflater getMenuInflater() {
        return j().d();
    }

    public void setContentView(int i) {
        j().a(i);
    }

    public void setContentView(View view) {
        j().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        j().a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        j().b(view, layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j().a(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
    }

    protected void onStop() {
        super.onStop();
        j().e();
    }

    protected void onPostResume() {
        super.onPostResume();
        j().f();
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            return j().b(i);
        }
        return super.onCreatePanelView(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar g = g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.a() & 4) == 0) {
            return false;
        }
        return h();
    }

    protected void onDestroy() {
        super.onDestroy();
        j().l();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().a(charSequence);
    }

    public void d() {
        j().g();
    }

    public void invalidateOptionsMenu() {
        j().g();
    }

    public void a(ru ruVar) {
    }

    public void b(ru ruVar) {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return j().c(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return j().a(i, view, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        j().a(i, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return j().b(i, menu);
    }

    protected boolean a(View view, Menu menu) {
        return j().a(view, menu);
    }

    void a(View view) {
        super.setContentView(view);
    }

    public boolean a(int i, Menu menu) {
        return super.onCreatePanelMenu(i, menu);
    }

    public boolean a(int i, View view, Menu menu) {
        return super.onPreparePanel(i, view, menu);
    }

    public boolean b(View view, Menu menu) {
        return super.a(view, menu);
    }

    void b(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    boolean c(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onBackPressed() {
        if (!j().h()) {
            super.onBackPressed();
        }
    }

    public void a(cu cuVar) {
        cuVar.a((Activity) this);
    }

    public void b(cu cuVar) {
    }

    public boolean h() {
        Intent a = a();
        if (a == null) {
            return false;
        }
        if (a(a)) {
            cu a2 = cu.a((Context) this);
            a(a2);
            b(a2);
            a2.a();
            try {
                a.a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            b(a);
        }
        return true;
    }

    public Intent a() {
        return au.a(this);
    }

    public boolean a(Intent intent) {
        return au.a((Activity) this, intent);
    }

    public void b(Intent intent) {
        au.b((Activity) this, intent);
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return j().b(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        return j().a(i, keyEvent);
    }

    public final void onContentChanged() {
        j().i();
    }

    public void i() {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = super.onCreateView(str, context, attributeSet);
        return onCreateView != null ? onCreateView : j().a(str, context, attributeSet);
    }

    private mz j() {
        if (this.n == null) {
            this.n = mz.a(this);
        }
        return this.n;
    }
}
