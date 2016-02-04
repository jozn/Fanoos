package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer implements XmlSerializer {
    private int auto;
    private int depth;
    private String[] elementStack;
    private String encoding;
    private boolean[] indent;
    private int[] nspCounts;
    private String[] nspStack;
    private boolean pending;
    private boolean unicode;
    private Writer writer;

    public KXmlSerializer() {
        this.elementStack = new String[12];
        this.nspCounts = new int[4];
        this.nspStack = new String[8];
        this.indent = new boolean[4];
    }

    private final void check(boolean z) {
        if (this.pending) {
            Object obj;
            this.depth++;
            this.pending = false;
            if (this.indent.length <= this.depth) {
                obj = new boolean[(this.depth + 4)];
                System.arraycopy(this.indent, 0, obj, 0, this.depth);
                this.indent = obj;
            }
            this.indent[this.depth] = this.indent[this.depth - 1];
            int i = this.nspCounts[this.depth - 1];
            while (i < this.nspCounts[this.depth]) {
                this.writer.write(32);
                this.writer.write("xmlns");
                if (!XmlPullParser.NO_NAMESPACE.equals(this.nspStack[i * 2])) {
                    this.writer.write(58);
                    this.writer.write(this.nspStack[i * 2]);
                } else if (XmlPullParser.NO_NAMESPACE.equals(getNamespace()) && !XmlPullParser.NO_NAMESPACE.equals(this.nspStack[(i * 2) + 1])) {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
                this.writer.write("=\"");
                writeEscaped(this.nspStack[(i * 2) + 1], 34);
                this.writer.write(34);
                i++;
            }
            if (this.nspCounts.length <= this.depth + 1) {
                obj = new int[(this.depth + 8)];
                System.arraycopy(this.nspCounts, 0, obj, 0, this.depth + 1);
                this.nspCounts = obj;
            }
            this.nspCounts[this.depth + 1] = this.nspCounts[this.depth];
            this.writer.write(z ? " />" : ">");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void writeEscaped(java.lang.String r6, int r7) {
        /*
        r5 = this;
        r0 = 0;
    L_0x0001:
        r1 = r6.length();
        if (r0 >= r1) goto L_0x0096;
    L_0x0007:
        r1 = r6.charAt(r0);
        switch(r1) {
            case 9: goto L_0x0026;
            case 10: goto L_0x0026;
            case 13: goto L_0x0026;
            case 34: goto L_0x0066;
            case 38: goto L_0x004e;
            case 39: goto L_0x0066;
            case 60: goto L_0x005e;
            case 62: goto L_0x0056;
            default: goto L_0x000e;
        };
    L_0x000e:
        r2 = 32;
        if (r1 < r2) goto L_0x0077;
    L_0x0012:
        r2 = 64;
        if (r1 == r2) goto L_0x0077;
    L_0x0016:
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r1 < r2) goto L_0x001e;
    L_0x001a:
        r2 = r5.unicode;
        if (r2 == 0) goto L_0x0077;
    L_0x001e:
        r2 = r5.writer;
        r2.write(r1);
    L_0x0023:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0026:
        r2 = -1;
        if (r7 != r2) goto L_0x002f;
    L_0x0029:
        r2 = r5.writer;
        r2.write(r1);
        goto L_0x0023;
    L_0x002f:
        r2 = r5.writer;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "&#";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r3 = 59;
        r1 = r1.append(r3);
        r1 = r1.toString();
        r2.write(r1);
        goto L_0x0023;
    L_0x004e:
        r1 = r5.writer;
        r2 = "&amp;";
        r1.write(r2);
        goto L_0x0023;
    L_0x0056:
        r1 = r5.writer;
        r2 = "&gt;";
        r1.write(r2);
        goto L_0x0023;
    L_0x005e:
        r1 = r5.writer;
        r2 = "&lt;";
        r1.write(r2);
        goto L_0x0023;
    L_0x0066:
        if (r1 != r7) goto L_0x000e;
    L_0x0068:
        r2 = r5.writer;
        r3 = 34;
        if (r1 != r3) goto L_0x0074;
    L_0x006e:
        r1 = "&quot;";
    L_0x0070:
        r2.write(r1);
        goto L_0x0023;
    L_0x0074:
        r1 = "&apos;";
        goto L_0x0070;
    L_0x0077:
        r2 = r5.writer;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "&#";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r3 = ";";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r2.write(r1);
        goto L_0x0023;
    L_0x0096:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlSerializer.writeEscaped(java.lang.String, int):void");
    }

    public void docdecl(String str) {
        this.writer.write("<!DOCTYPE");
        this.writer.write(str);
        this.writer.write(">");
    }

    public void endDocument() {
        while (this.depth > 0) {
            endTag(this.elementStack[(this.depth * 3) - 3], this.elementStack[(this.depth * 3) - 1]);
        }
        flush();
    }

    public void entityRef(String str) {
        check(false);
        this.writer.write(38);
        this.writer.write(str);
        this.writer.write(59);
    }

    public boolean getFeature(String str) {
        return "http://xmlpull.org/v1/doc/features.html#indent-output".equals(str) ? this.indent[this.depth] : false;
    }

    public String getPrefix(String str, boolean z) {
        try {
            return getPrefix(str, false, z);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private final String getPrefix(String str, boolean z, boolean z2) {
        String str2;
        int i = (this.nspCounts[this.depth + 1] * 2) - 2;
        while (i >= 0) {
            if (this.nspStack[i + 1].equals(str) && (z || !this.nspStack[i].equals(XmlPullParser.NO_NAMESPACE))) {
                String str3 = this.nspStack[i];
                for (int i2 = i + 2; i2 < this.nspCounts[this.depth + 1] * 2; i2++) {
                    if (this.nspStack[i2].equals(str3)) {
                        str2 = null;
                        break;
                    }
                }
                str2 = str3;
                if (str2 != null) {
                    return str2;
                }
            }
            i -= 2;
        }
        if (!z2) {
            return null;
        }
        if (XmlPullParser.NO_NAMESPACE.equals(str)) {
            str2 = XmlPullParser.NO_NAMESPACE;
        } else {
            do {
                StringBuilder append = new StringBuilder().append("n");
                int i3 = this.auto;
                this.auto = i3 + 1;
                str2 = append.append(i3).toString();
                i3 = (this.nspCounts[this.depth + 1] * 2) - 2;
                while (i3 >= 0) {
                    if (str2.equals(this.nspStack[i3])) {
                        str2 = null;
                        break;
                        continue;
                    } else {
                        i3 -= 2;
                    }
                }
            } while (str2 == null);
        }
        boolean z3 = this.pending;
        this.pending = false;
        setPrefix(str2, str);
        this.pending = z3;
        return str2;
    }

    public Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    public void ignorableWhitespace(String str) {
        text(str);
    }

    public void setFeature(String str, boolean z) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            this.indent[this.depth] = z;
            return;
        }
        throw new RuntimeException("Unsupported Feature");
    }

    public void setProperty(String str, Object obj) {
        throw new RuntimeException("Unsupported Property:" + obj);
    }

    public void setPrefix(String str, String str2) {
        check(false);
        if (str == null) {
            str = XmlPullParser.NO_NAMESPACE;
        }
        if (str2 == null) {
            str2 = XmlPullParser.NO_NAMESPACE;
        }
        if (!str.equals(getPrefix(str2, true, false))) {
            int[] iArr = this.nspCounts;
            int i = this.depth + 1;
            int i2 = iArr[i];
            iArr[i] = i2 + 1;
            int i3 = i2 << 1;
            if (this.nspStack.length < i3 + 1) {
                Object obj = new String[(this.nspStack.length + 16)];
                System.arraycopy(this.nspStack, 0, obj, 0, i3);
                this.nspStack = obj;
            }
            i2 = i3 + 1;
            this.nspStack[i3] = str;
            this.nspStack[i2] = str2;
        }
    }

    public void setOutput(Writer writer) {
        this.writer = writer;
        this.nspCounts[0] = 2;
        this.nspCounts[1] = 2;
        this.nspStack[0] = XmlPullParser.NO_NAMESPACE;
        this.nspStack[1] = XmlPullParser.NO_NAMESPACE;
        this.nspStack[2] = "xml";
        this.nspStack[3] = "http://www.w3.org/XML/1998/namespace";
        this.pending = false;
        this.auto = 0;
        this.depth = 0;
        this.unicode = false;
    }

    public void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        setOutput(str == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, str));
        this.encoding = str;
        if (str != null && str.toLowerCase().startsWith("utf")) {
            this.unicode = true;
        }
    }

    public void startDocument(String str, Boolean bool) {
        this.writer.write("<?xml version='1.0' ");
        if (str != null) {
            this.encoding = str;
            if (str.toLowerCase().startsWith("utf")) {
                this.unicode = true;
            }
        }
        if (this.encoding != null) {
            this.writer.write("encoding='");
            this.writer.write(this.encoding);
            this.writer.write("' ");
        }
        if (bool != null) {
            this.writer.write("standalone='");
            this.writer.write(bool.booleanValue() ? "yes" : "no");
            this.writer.write("' ");
        }
        this.writer.write("?>");
    }

    public XmlSerializer startTag(String str, String str2) {
        check(false);
        if (this.indent[this.depth]) {
            this.writer.write("\r\n");
            for (int i = 0; i < this.depth; i++) {
                this.writer.write("  ");
            }
        }
        int i2 = this.depth * 3;
        if (this.elementStack.length < i2 + 3) {
            Object obj = new String[(this.elementStack.length + 12)];
            System.arraycopy(this.elementStack, 0, obj, 0, i2);
            this.elementStack = obj;
        }
        String prefix = str == null ? XmlPullParser.NO_NAMESPACE : getPrefix(str, true, true);
        if (XmlPullParser.NO_NAMESPACE.equals(str)) {
            int i3 = this.nspCounts[this.depth];
            while (i3 < this.nspCounts[this.depth + 1]) {
                if (!XmlPullParser.NO_NAMESPACE.equals(this.nspStack[i3 * 2]) || XmlPullParser.NO_NAMESPACE.equals(this.nspStack[(i3 * 2) + 1])) {
                    i3++;
                } else {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        int i4 = i2 + 1;
        this.elementStack[i2] = str;
        i2 = i4 + 1;
        this.elementStack[i4] = prefix;
        this.elementStack[i2] = str2;
        this.writer.write(60);
        if (!XmlPullParser.NO_NAMESPACE.equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(str2);
        this.pending = true;
        return this;
    }

    public XmlSerializer attribute(String str, String str2, String str3) {
        if (this.pending) {
            String str4;
            if (str == null) {
                str = XmlPullParser.NO_NAMESPACE;
            }
            if (XmlPullParser.NO_NAMESPACE.equals(str)) {
                str4 = XmlPullParser.NO_NAMESPACE;
            } else {
                str4 = getPrefix(str, false, true);
            }
            this.writer.write(32);
            if (!XmlPullParser.NO_NAMESPACE.equals(str4)) {
                this.writer.write(str4);
                this.writer.write(58);
            }
            this.writer.write(str2);
            this.writer.write(61);
            int i = str3.indexOf(34) == -1 ? 34 : 39;
            this.writer.write(i);
            writeEscaped(str3, i);
            this.writer.write(i);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    public void flush() {
        check(false);
        this.writer.flush();
    }

    public XmlSerializer endTag(String str, String str2) {
        if (!this.pending) {
            this.depth--;
        }
        if ((str != null || this.elementStack[this.depth * 3] == null) && ((str == null || str.equals(this.elementStack[this.depth * 3])) && this.elementStack[(this.depth * 3) + 2].equals(str2))) {
            if (this.pending) {
                check(true);
                this.depth--;
            } else {
                if (this.indent[this.depth + 1]) {
                    this.writer.write("\r\n");
                    for (int i = 0; i < this.depth; i++) {
                        this.writer.write("  ");
                    }
                }
                this.writer.write("</");
                String str3 = this.elementStack[(this.depth * 3) + 1];
                if (!XmlPullParser.NO_NAMESPACE.equals(str3)) {
                    this.writer.write(str3);
                    this.writer.write(58);
                }
                this.writer.write(str2);
                this.writer.write(62);
            }
            this.nspCounts[this.depth + 1] = this.nspCounts[this.depth];
            return this;
        }
        throw new IllegalArgumentException("</{" + str + "}" + str2 + "> does not match start");
    }

    public String getNamespace() {
        return getDepth() == 0 ? null : this.elementStack[(getDepth() * 3) - 3];
    }

    public String getName() {
        return getDepth() == 0 ? null : this.elementStack[(getDepth() * 3) - 1];
    }

    public int getDepth() {
        return this.pending ? this.depth + 1 : this.depth;
    }

    public XmlSerializer text(String str) {
        check(false);
        this.indent[this.depth] = false;
        writeEscaped(str, -1);
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) {
        text(new String(cArr, i, i2));
        return this;
    }

    public void cdsect(String str) {
        check(false);
        this.writer.write("<![CDATA[");
        this.writer.write(str);
        this.writer.write("]]>");
    }

    public void comment(String str) {
        check(false);
        this.writer.write("<!--");
        this.writer.write(str);
        this.writer.write("-->");
    }

    public void processingInstruction(String str) {
        check(false);
        this.writer.write("<?");
        this.writer.write(str);
        this.writer.write("?>");
    }
}
