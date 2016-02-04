import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public class bc {
    private static final bj a;

    private static void b(ba baVar, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            baVar.a((bd) it.next());
        }
    }

    private static void b(bb bbVar, bs bsVar) {
        if (bsVar == null) {
            return;
        }
        if (bsVar instanceof bg) {
            bg bgVar = (bg) bsVar;
            cd.a(bbVar, bgVar.d, bgVar.f, bgVar.e, bgVar.a);
        } else if (bsVar instanceof bi) {
            bi biVar = (bi) bsVar;
            cd.a(bbVar, biVar.d, biVar.f, biVar.e, biVar.a);
        } else if (bsVar instanceof bf) {
            bf bfVar = (bf) bsVar;
            cd.a(bbVar, bfVar.d, bfVar.f, bfVar.e, bfVar.a, bfVar.b, bfVar.c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            a = new bl();
        } else if (VERSION.SDK_INT >= 20) {
            a = new bk();
        } else if (VERSION.SDK_INT >= 19) {
            a = new br();
        } else if (VERSION.SDK_INT >= 16) {
            a = new bq();
        } else if (VERSION.SDK_INT >= 14) {
            a = new bp();
        } else if (VERSION.SDK_INT >= 11) {
            a = new bo();
        } else if (VERSION.SDK_INT >= 9) {
            a = new bn();
        } else {
            a = new bm();
        }
    }
}
