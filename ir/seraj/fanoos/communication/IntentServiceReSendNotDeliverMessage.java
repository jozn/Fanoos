package ir.seraj.fanoos.communication;

import android.app.IntentService;

public class IntentServiceReSendNotDeliverMessage extends IntentService {
    public IntentServiceReSendNotDeliverMessage() {
        super("IntentServiceReSendNotDeliverMessage");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onHandleIntent(android.content.Intent r9) {
        /*
        r8 = this;
        r0 = "resend";
        r1 = "start1";
        android.util.Log.i(r0, r1);
        r0 = ys.k(r8);
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = yz.i;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        ys.j(r8);
    L_0x001d:
        r1 = new aav;
        r1.<init>(r8);
        r2 = new za;
        r2.<init>(r8);
        r0 = "resend";
        r3 = "start2";
        android.util.Log.i(r0, r3);
        r3 = aeq.o(r8);	 Catch:{ Exception -> 0x00b9 }
        r0 = "";
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00b9 }
        r0.<init>();	 Catch:{ Exception -> 0x00b9 }
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00b9 }
        r0.<init>();	 Catch:{ Exception -> 0x00b9 }
        r1.a();	 Catch:{ Exception -> 0x00b9 }
        r0 = r1.c();	 Catch:{ Exception -> 0x00b9 }
        r2.a();	 Catch:{ Exception -> 0x00b9 }
        r4 = r0.size();	 Catch:{ Exception -> 0x00b9 }
        if (r4 <= 0) goto L_0x0108;
    L_0x004e:
        r4 = "resend";
        r5 = "start3";
        android.util.Log.i(r4, r5);	 Catch:{ Exception -> 0x00b9 }
        r4 = r0.iterator();	 Catch:{ Exception -> 0x00b9 }
    L_0x0059:
        r0 = r4.hasNext();	 Catch:{ Exception -> 0x00b9 }
        if (r0 == 0) goto L_0x0112;
    L_0x005f:
        r0 = r4.next();	 Catch:{ Exception -> 0x00b9 }
        r0 = (ze) r0;	 Catch:{ Exception -> 0x00b9 }
        r5 = r0.d();	 Catch:{ Exception -> 0x00b9 }
        r5 = r2.a(r5);	 Catch:{ Exception -> 0x00b9 }
        r6 = r5.c();	 Catch:{ Exception -> 0x00b9 }
        if (r6 == 0) goto L_0x00f4;
    L_0x0073:
        r6 = r5.c();	 Catch:{ Exception -> 0x00b9 }
        r6 = r6.length();	 Catch:{ Exception -> 0x00b9 }
        r7 = 3;
        if (r6 <= r7) goto L_0x00f4;
    L_0x007e:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b9 }
        r6.<init>();	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.c();	 Catch:{ Exception -> 0x00b9 }
        r5 = r6.append(r5);	 Catch:{ Exception -> 0x00b9 }
        r6 = zh.b;	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00b9 }
        r6 = r0.f();	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00b9 }
        r6 = zh.b;	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00b9 }
        r6 = r0.h();	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00b9 }
        r6 = zh.b;	 Catch:{ Exception -> 0x00b9 }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x00b9 }
        r0 = r0.a();	 Catch:{ Exception -> 0x00b9 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x00b9 }
        r0.toString();	 Catch:{ Exception -> 0x00b9 }
        goto L_0x0059;
    L_0x00b9:
        r0 = move-exception;
        r3 = new aas;	 Catch:{ all -> 0x00fd }
        r3.<init>();	 Catch:{ all -> 0x00fd }
        r4 = "ir.seraj.fanoos";
        r3.a(r4);	 Catch:{ all -> 0x00fd }
        r4 = ys.a(r8);	 Catch:{ all -> 0x00fd }
        r3.e(r4);	 Catch:{ all -> 0x00fd }
        r4 = zn.a();	 Catch:{ all -> 0x00fd }
        r3.d(r4);	 Catch:{ all -> 0x00fd }
        r4 = "IntentServiceReSendNotDeliverMessage";
        r3.c(r4);	 Catch:{ all -> 0x00fd }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00fd }
        r3.b(r0);	 Catch:{ all -> 0x00fd }
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00fd }
        r3.a(r0);	 Catch:{ all -> 0x00fd }
        r3.a(r8);	 Catch:{ all -> 0x00fd }
        r1.b();
        r2.b();
        ys.j(r8);
        goto L_0x0011;
    L_0x00f4:
        r0 = zj.a(r3, r5, r0, r8);	 Catch:{ Exception -> 0x00b9 }
        aer.a(r0);	 Catch:{ Exception -> 0x00b9 }
        goto L_0x0059;
    L_0x00fd:
        r0 = move-exception;
        r1.b();
        r2.b();
        ys.j(r8);
        throw r0;
    L_0x0108:
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00b9 }
        ze.w = r0;	 Catch:{ Exception -> 0x00b9 }
        ys.j(r8);	 Catch:{ Exception -> 0x00b9 }
    L_0x0112:
        r1.b();
        r2.b();
        ys.j(r8);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.seraj.fanoos.communication.IntentServiceReSendNotDeliverMessage.onHandleIntent(android.content.Intent):void");
    }
}
