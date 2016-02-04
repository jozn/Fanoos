package org.kobjects.util;

import org.kxml2.wap.Wbxml;

public class Strings {
    public static String replace(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
        while (true) {
            stringBuffer.append(str3);
            int length = str2.length() + indexOf;
            indexOf = str.indexOf(str2, length);
            if (indexOf == -1) {
                stringBuffer.append(str.substring(length));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(length, indexOf));
        }
    }

    public static String toAscii(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > ' ') {
                if (charAt >= '\u007f') {
                    switch (charAt) {
                        case Wbxml.LITERAL_AC /*196*/:
                            stringBuffer.append("Ae");
                            break;
                        case '\u00d6':
                            stringBuffer.append("Oe");
                            break;
                        case '\u00dc':
                            stringBuffer.append("Ue");
                            break;
                        case '\u00df':
                            stringBuffer.append("ss");
                            break;
                        case '\u00e4':
                            stringBuffer.append("ae");
                            break;
                        case '\u00f6':
                            stringBuffer.append("oe");
                            break;
                        case '\u00fc':
                            stringBuffer.append("ue");
                            break;
                        default:
                            stringBuffer.append('?');
                            break;
                    }
                }
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }

    public static String fill(String str, int i, char c) {
        Object obj = i < 0 ? 1 : null;
        int abs = Math.abs(i);
        if (str.length() >= abs) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (abs -= str.length(); abs > 0; abs--) {
            stringBuffer.append(c);
        }
        if (obj == null) {
            return str + stringBuffer.toString();
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static String beautify(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() > 0) {
            stringBuffer.append(Character.toUpperCase(str.charAt(0)));
            int i = 1;
            while (i < str.length() - 1) {
                char charAt = str.charAt(i);
                if (Character.isUpperCase(charAt) && Character.isLowerCase(str.charAt(i - 1)) && Character.isLowerCase(str.charAt(i + 1))) {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(charAt);
                i++;
            }
            if (str.length() > 1) {
                stringBuffer.append(str.charAt(str.length() - 1));
            }
        }
        return stringBuffer.toString();
    }

    public static String lTrim(String str, String str2) {
        int i = 0;
        int length = str.length();
        while (i < length) {
            if (str2 == null) {
                if (str.charAt(i) > ' ') {
                    break;
                }
            } else if (str2.indexOf(str.charAt(i)) == -1) {
                break;
            }
            i++;
        }
        return i == 0 ? str : str.substring(i);
    }

    public static String rTrim(String str, String str2) {
        int length = str.length() - 1;
        while (length >= 0) {
            if (str2 == null) {
                if (str.charAt(length) > ' ') {
                    break;
                }
            } else if (str2.indexOf(str.charAt(length)) == -1) {
                break;
            }
            length--;
        }
        return length == str.length() + -1 ? str : str.substring(0, length + 1);
    }
}
