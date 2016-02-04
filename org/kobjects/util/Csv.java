package org.kobjects.util;

public class Csv {
    public static String encode(String str, char c) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == c || charAt == '^') {
                stringBuffer.append(charAt);
                stringBuffer.append(charAt);
            } else if (charAt < ' ') {
                stringBuffer.append('^');
                stringBuffer.append((char) (charAt + 64));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String encode(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                stringBuffer.append(',');
            }
            Object obj = objArr[i];
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                stringBuffer.append(obj.toString());
            } else {
                stringBuffer.append('\"');
                stringBuffer.append(encode(obj.toString(), '\"'));
                stringBuffer.append('\"');
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] decode(java.lang.String r11) {
        /*
        r10 = 94;
        r9 = 44;
        r8 = 32;
        r3 = 0;
        r7 = 34;
        r4 = new java.util.Vector;
        r4.<init>();
        r5 = r11.length();
        r0 = r3;
    L_0x0013:
        if (r0 >= r5) goto L_0x001e;
    L_0x0015:
        r1 = r11.charAt(r0);
        if (r1 > r8) goto L_0x001e;
    L_0x001b:
        r0 = r0 + 1;
        goto L_0x0013;
    L_0x001e:
        if (r0 < r5) goto L_0x0036;
    L_0x0020:
        r0 = r4.size();
        r2 = new java.lang.String[r0];
        r1 = r3;
    L_0x0027:
        r0 = r2.length;
        if (r1 >= r0) goto L_0x00d2;
    L_0x002a:
        r0 = r4.elementAt(r1);
        r0 = (java.lang.String) r0;
        r2[r1] = r0;
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0027;
    L_0x0036:
        r1 = r11.charAt(r0);
        if (r1 != r7) goto L_0x00af;
    L_0x003c:
        r0 = r0 + 1;
        r6 = new java.lang.StringBuffer;
        r6.<init>();
    L_0x0043:
        r1 = r0 + 1;
        r2 = r11.charAt(r0);
        if (r2 != r10) goto L_0x005e;
    L_0x004b:
        if (r1 >= r5) goto L_0x005e;
    L_0x004d:
        r2 = r1 + 1;
        r0 = r11.charAt(r1);
        if (r0 != r10) goto L_0x005a;
    L_0x0055:
        r6.append(r0);
        r0 = r2;
        goto L_0x0043;
    L_0x005a:
        r0 = r0 + -64;
        r0 = (char) r0;
        goto L_0x0055;
    L_0x005e:
        if (r2 != r7) goto L_0x00d3;
    L_0x0060:
        if (r1 == r5) goto L_0x0068;
    L_0x0062:
        r0 = r11.charAt(r1);
        if (r0 == r7) goto L_0x007a;
    L_0x0068:
        r0 = r6.toString();
        r4.addElement(r0);
    L_0x006f:
        if (r1 >= r5) goto L_0x0080;
    L_0x0071:
        r0 = r11.charAt(r1);
        if (r0 > r8) goto L_0x0080;
    L_0x0077:
        r1 = r1 + 1;
        goto L_0x006f;
    L_0x007a:
        r0 = r1 + 1;
    L_0x007c:
        r6.append(r2);
        goto L_0x0043;
    L_0x0080:
        if (r1 >= r5) goto L_0x0020;
    L_0x0082:
        r0 = r11.charAt(r1);
        if (r0 == r9) goto L_0x00ab;
    L_0x0088:
        r0 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Comma expected at ";
        r2 = r2.append(r3);
        r1 = r2.append(r1);
        r2 = " line: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ab:
        r0 = r1 + 1;
        goto L_0x0013;
    L_0x00af:
        r1 = r11.indexOf(r9, r0);
        r2 = -1;
        if (r1 != r2) goto L_0x00c3;
    L_0x00b6:
        r0 = r11.substring(r0);
        r0 = r0.trim();
        r4.addElement(r0);
        goto L_0x0020;
    L_0x00c3:
        r0 = r11.substring(r0, r1);
        r0 = r0.trim();
        r4.addElement(r0);
        r0 = r1 + 1;
        goto L_0x0013;
    L_0x00d2:
        return r2;
    L_0x00d3:
        r0 = r1;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kobjects.util.Csv.decode(java.lang.String):java.lang.String[]");
    }
}
