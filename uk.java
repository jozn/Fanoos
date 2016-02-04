import android.view.View;

public class uk {
    public static int a(uf ufVar, tk tkVar, View view, View view2, tv tvVar, boolean z, boolean z2) {
        if (tvVar.m() == 0 || ufVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (ufVar.e() - Math.max(tvVar.d(view), tvVar.d(view2))) - 1) : Math.max(0, Math.min(tvVar.d(view), tvVar.d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(tkVar.b(view2) - tkVar.a(view))) / ((float) (Math.abs(tvVar.d(view) - tvVar.d(view2)) + 1)))) + ((float) (tkVar.c() - tkVar.a(view))));
    }

    public static int a(uf ufVar, tk tkVar, View view, View view2, tv tvVar, boolean z) {
        if (tvVar.m() == 0 || ufVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(tvVar.d(view) - tvVar.d(view2)) + 1;
        }
        return Math.min(tkVar.f(), tkVar.b(view2) - tkVar.a(view));
    }

    public static int b(uf ufVar, tk tkVar, View view, View view2, tv tvVar, boolean z) {
        if (tvVar.m() == 0 || ufVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return ufVar.e();
        }
        return (int) ((((float) (tkVar.b(view2) - tkVar.a(view))) / ((float) (Math.abs(tvVar.d(view) - tvVar.d(view2)) + 1))) * ((float) ufVar.e()));
    }
}
