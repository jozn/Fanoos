package org.kobjects.util;

import java.io.InputStream;
import java.io.OutputStream;
import org.kxml2.wap.Wbxml;

public final class Util {
    public static OutputStream streamcopy(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[(Runtime.getRuntime().freeMemory() >= 1048576 ? 16384 : Wbxml.EXT_T_0)];
        while (true) {
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read == -1) {
                inputStream.close();
                return outputStream;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static String buildUrl(String str, String str2) {
        int indexOf = str2.indexOf(58);
        if (str2.startsWith("/") || indexOf == 1) {
            return "file:///" + str2;
        }
        if (indexOf > 2 && indexOf < 6) {
            return str2;
        }
        if (str == null) {
            str = "file:///";
        } else {
            if (str.indexOf(58) == -1) {
                str = "file:///" + str;
            }
            if (!str.endsWith("/")) {
                str = str + "/";
            }
        }
        return str + str2;
    }

    public static void sort(Object[] objArr, int i, int i2) {
        if (i2 - i <= 2) {
            if (i2 - i == 2 && objArr[i].toString().compareTo(objArr[i + 1].toString()) > 0) {
                Object obj = objArr[i];
                objArr[i] = objArr[i + 1];
                objArr[i + 1] = obj;
            }
        } else if (i2 - i == 3) {
            sort(objArr, i, i + 2);
            sort(objArr, i + 1, i + 3);
            sort(objArr, i, i + 2);
        } else {
            int i3 = (i + i2) / 2;
            sort(objArr, i, i3);
            sort(objArr, i3, i2);
            Object obj2 = new Object[(i2 - i)];
            int i4 = i3;
            int i5 = i;
            for (int i6 = 0; i6 < obj2.length; i6++) {
                int i7;
                if (i5 == i3) {
                    i7 = i4 + 1;
                    obj2[i6] = objArr[i4];
                    i4 = i7;
                } else if (i4 == i2 || objArr[i5].toString().compareTo(objArr[i4].toString()) < 0) {
                    i7 = i5 + 1;
                    obj2[i6] = objArr[i5];
                    i5 = i7;
                } else {
                    i7 = i4 + 1;
                    obj2[i6] = objArr[i4];
                    i4 = i7;
                }
            }
            System.arraycopy(obj2, 0, objArr, i, obj2.length);
        }
    }
}
