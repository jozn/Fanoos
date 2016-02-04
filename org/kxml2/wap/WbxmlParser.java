package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import ve;

public class WbxmlParser implements XmlPullParser {
    static final String HEX_DIGITS = "0123456789abcdef";
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    public static final int WAP_EXTENSION = 64;
    private int ATTR_START_TABLE;
    private int ATTR_VALUE_TABLE;
    private int TAG_TABLE;
    private String[] attrStartTable;
    private String[] attrValueTable;
    private int attributeCount;
    private String[] attributes;
    private Hashtable cacheStringTable;
    private boolean degenerated;
    private int depth;
    private String[] elementStack;
    private String encoding;
    private InputStream in;
    private boolean isWhitespace;
    private String name;
    private String namespace;
    private int nextId;
    private int[] nspCounts;
    private String[] nspStack;
    private String prefix;
    private boolean processNsp;
    private int publicIdentifierId;
    private byte[] stringTable;
    private Vector tables;
    private String[] tagTable;
    private String text;
    private int type;
    private int version;
    private int wapCode;
    private Object wapExtensionData;

    public WbxmlParser() {
        this.TAG_TABLE = 0;
        this.ATTR_START_TABLE = 1;
        this.ATTR_VALUE_TABLE = 2;
        this.cacheStringTable = null;
        this.elementStack = new String[16];
        this.nspStack = new String[8];
        this.nspCounts = new int[4];
        this.attributes = new String[16];
        this.nextId = -2;
        this.tables = new Vector();
    }

    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        return false;
    }

    public String getInputEncoding() {
        return this.encoding;
    }

    public void defineEntityReplacementText(String str, String str2) {
    }

    public Object getProperty(String str) {
        return null;
    }

    public int getNamespaceCount(int i) {
        if (i <= this.depth) {
            return this.nspCounts[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getNamespacePrefix(int i) {
        return this.nspStack[i << 1];
    }

    public String getNamespaceUri(int i) {
        return this.nspStack[(i << 1) + 1];
    }

    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.depth) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            if (str == null) {
                if (this.nspStack[namespaceCount] == null) {
                    return this.nspStack[namespaceCount + 1];
                }
            } else if (str.equals(this.nspStack[namespaceCount])) {
                return this.nspStack[namespaceCount + 1];
            }
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    public String getPositionDescription() {
        StringBuffer stringBuffer = new StringBuffer(this.type < TYPES.length ? TYPES[this.type] : "unknown");
        stringBuffer.append(' ');
        if (this.type == 2 || this.type == 3) {
            if (this.degenerated) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.type == 3) {
                stringBuffer.append('/');
            }
            if (this.prefix != null) {
                stringBuffer.append("{" + this.namespace + "}" + this.prefix + ":");
            }
            stringBuffer.append(this.name);
            int i = this.attributeCount << 2;
            for (int i2 = 0; i2 < i; i2 += 4) {
                stringBuffer.append(' ');
                if (this.attributes[i2 + 1] != null) {
                    stringBuffer.append("{" + this.attributes[i2] + "}" + this.attributes[i2 + 1] + ":");
                }
                stringBuffer.append(this.attributes[i2 + 2] + "='" + this.attributes[i2 + 3] + "'");
            }
            stringBuffer.append('>');
        } else if (this.type != 7) {
            if (this.type != 4) {
                stringBuffer.append(getText());
            } else if (this.isWhitespace) {
                stringBuffer.append("(whitespace)");
            } else {
                String text = getText();
                if (text.length() > 16) {
                    text = text.substring(0, 16) + "...";
                }
                stringBuffer.append(text);
            }
        }
        return stringBuffer.toString();
    }

    public int getLineNumber() {
        return -1;
    }

    public int getColumnNumber() {
        return -1;
    }

    public boolean isWhitespace() {
        if (!(this.type == 4 || this.type == 7 || this.type == 5)) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    public String getText() {
        return this.text;
    }

    public char[] getTextCharacters(int[] iArr) {
        if (this.type >= 4) {
            iArr[0] = 0;
            iArr[1] = this.text.length();
            char[] cArr = new char[this.text.length()];
            this.text.getChars(0, this.text.length(), cArr, 0);
            return cArr;
        }
        iArr[0] = -1;
        iArr[1] = -1;
        return null;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isEmptyElementTag() {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    public int getAttributeCount() {
        return this.attributeCount;
    }

    public String getAttributeType(int i) {
        return "CDATA";
    }

    public boolean isAttributeDefault(int i) {
        return false;
    }

    public String getAttributeNamespace(int i) {
        if (i < this.attributeCount) {
            return this.attributes[i << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeName(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributePrefix(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(String str, String str2) {
        int i = (this.attributeCount << 2) - 4;
        while (i >= 0) {
            if (this.attributes[i + 2].equals(str2) && (str == null || this.attributes[i].equals(str))) {
                return this.attributes[i + 3];
            }
            i -= 4;
        }
        return null;
    }

    public int getEventType() {
        return this.type;
    }

    public int next() {
        this.isWhitespace = true;
        int i = 9999;
        while (true) {
            String str = this.text;
            nextImpl();
            if (this.type < i) {
                i = this.type;
            }
            if (i <= 5) {
                if (i >= 4) {
                    if (str != null) {
                        if (this.text != null) {
                            str = str + this.text;
                        }
                        this.text = str;
                    }
                    switch (peekId()) {
                        case ve.CropImageView_aspectRatioX /*2*/:
                        case ve.CropImageView_aspectRatioY /*3*/:
                        case ve.CropImageView_imageResource /*4*/:
                        case Wbxml.LITERAL_C /*68*/:
                        case Wbxml.STR_T /*131*/:
                        case Wbxml.LITERAL_A /*132*/:
                        case Wbxml.LITERAL_AC /*196*/:
                            break;
                        default:
                            break;
                    }
                }
                this.type = i;
                if (this.type > 4) {
                    this.type = 4;
                }
                return this.type;
            }
        }
    }

    public int nextToken() {
        this.isWhitespace = true;
        nextImpl();
        return this.type;
    }

    public int nextTag() {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        if (!(this.type == 3 || this.type == 2)) {
            exception("unexpected type");
        }
        return this.type;
    }

    public String nextText() {
        String text;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            text = getText();
            next();
        } else {
            text = XmlPullParser.NO_NAMESPACE;
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return text;
    }

    public void require(int i, String str, String str2) {
        if (i != this.type || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            exception("expected: " + (i == WAP_EXTENSION ? "WAP Ext." : TYPES[i] + " {" + str + "}" + str2));
        }
    }

    public void setInput(Reader reader) {
        exception("InputStream required");
    }

    public void setInput(InputStream inputStream, String str) {
        int i = 0;
        this.in = inputStream;
        try {
            this.version = readByte();
            this.publicIdentifierId = readInt();
            if (this.publicIdentifierId == 0) {
                readInt();
            }
            int readInt = readInt();
            if (str == null) {
                switch (readInt) {
                    case ve.CropImageView_imageResource /*4*/:
                        this.encoding = "ISO-8859-1";
                        break;
                    case 106:
                        this.encoding = "UTF-8";
                        break;
                    default:
                        throw new UnsupportedEncodingException(XmlPullParser.NO_NAMESPACE + readInt);
                }
            }
            this.encoding = str;
            readInt = readInt();
            this.stringTable = new byte[readInt];
            while (i < readInt) {
                int read = inputStream.read(this.stringTable, i, readInt - i);
                if (read <= 0) {
                    selectPage(0, true);
                    selectPage(0, false);
                }
                i += read;
            }
            selectPage(0, true);
            selectPage(0, false);
        } catch (IOException e) {
            exception("Illegal input format");
        }
    }

    public void setFeature(String str, boolean z) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else {
            exception("unsupported feature: " + str);
        }
    }

    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException("unsupported property: " + str);
    }

    private final boolean adjustNsp() {
        int i = 0;
        boolean z = false;
        while (i < (this.attributeCount << 2)) {
            String substring;
            String str = this.attributes[i + 2];
            int indexOf = str.indexOf(58);
            if (indexOf != -1) {
                substring = str.substring(0, indexOf);
                str = str.substring(indexOf + 1);
            } else if (str.equals("xmlns")) {
                String str2 = str;
                str = null;
                substring = str2;
            } else {
                i += 4;
            }
            if (substring.equals("xmlns")) {
                int[] iArr = this.nspCounts;
                indexOf = this.depth;
                int i2 = iArr[indexOf];
                iArr[indexOf] = i2 + 1;
                int i3 = i2 << 1;
                this.nspStack = ensureCapacity(this.nspStack, i3 + 2);
                this.nspStack[i3] = str;
                this.nspStack[i3 + 1] = this.attributes[i + 3];
                if (str != null && this.attributes[i + 3].equals(XmlPullParser.NO_NAMESPACE)) {
                    exception("illegal empty namespace");
                }
                Object obj = this.attributes;
                int i4 = i + 4;
                Object obj2 = this.attributes;
                i2 = this.attributeCount - 1;
                this.attributeCount = i2;
                System.arraycopy(obj, i4, obj2, i, (i2 << 2) - i);
                i -= 4;
            } else {
                z = true;
            }
            i += 4;
        }
        if (z) {
            for (i3 = (this.attributeCount << 2) - 4; i3 >= 0; i3 -= 4) {
                String str3 = this.attributes[i3 + 2];
                i4 = str3.indexOf(58);
                if (i4 == 0) {
                    throw new RuntimeException("illegal attribute name: " + str3 + " at " + this);
                }
                if (i4 != -1) {
                    String substring2 = str3.substring(0, i4);
                    str = str3.substring(i4 + 1);
                    String namespace = getNamespace(substring2);
                    if (namespace == null) {
                        throw new RuntimeException("Undefined Prefix: " + substring2 + " in " + this);
                    }
                    this.attributes[i3] = namespace;
                    this.attributes[i3 + 1] = substring2;
                    this.attributes[i3 + 2] = str;
                    i = (this.attributeCount << 2) - 4;
                    while (i > i3) {
                        if (str.equals(this.attributes[i + 2]) && namespace.equals(this.attributes[i])) {
                            exception("Duplicate Attribute: {" + namespace + "}" + str);
                        }
                        i -= 4;
                    }
                }
            }
        }
        i = this.name.indexOf(58);
        if (i == 0) {
            exception("illegal tag name: " + this.name);
        } else if (i != -1) {
            this.prefix = this.name.substring(0, i);
            this.name = this.name.substring(i + 1);
        }
        this.namespace = getNamespace(this.prefix);
        if (this.namespace == null) {
            if (this.prefix != null) {
                exception("undefined prefix: " + this.prefix);
            }
            this.namespace = XmlPullParser.NO_NAMESPACE;
        }
        return z;
    }

    private final void setTable(int i, int i2, String[] strArr) {
        if (this.stringTable != null) {
            throw new RuntimeException("setXxxTable must be called before setInput!");
        }
        while (this.tables.size() < (i * 3) + 3) {
            this.tables.addElement(null);
        }
        this.tables.setElementAt(strArr, (i * 3) + i2);
    }

    private final void exception(String str) {
        throw new XmlPullParserException(str, this, null);
    }

    private void selectPage(int i, boolean z) {
        if (this.tables.size() != 0 || i != 0) {
            if (i * 3 > this.tables.size()) {
                exception("Code Page " + i + " undefined!");
            }
            if (z) {
                this.tagTable = (String[]) this.tables.elementAt((i * 3) + this.TAG_TABLE);
                return;
            }
            this.attrStartTable = (String[]) this.tables.elementAt((i * 3) + this.ATTR_START_TABLE);
            this.attrValueTable = (String[]) this.tables.elementAt((i * 3) + this.ATTR_VALUE_TABLE);
        }
    }

    private final void nextImpl() {
        if (this.type == 3) {
            this.depth--;
        }
        if (this.degenerated) {
            this.type = 3;
            this.degenerated = false;
            return;
        }
        this.text = null;
        this.prefix = null;
        this.name = null;
        int peekId = peekId();
        while (peekId == 0) {
            this.nextId = -2;
            selectPage(readByte(), true);
            peekId = peekId();
        }
        this.nextId = -2;
        switch (peekId) {
            case -1:
                this.type = 1;
            case ve.CropImageView_fixAspectRatio /*1*/:
                peekId = (this.depth - 1) << 2;
                this.type = 3;
                this.namespace = this.elementStack[peekId];
                this.prefix = this.elementStack[peekId + 1];
                this.name = this.elementStack[peekId + 2];
            case ve.CropImageView_aspectRatioX /*2*/:
                this.type = 6;
                char readInt = (char) readInt();
                this.text = XmlPullParser.NO_NAMESPACE + readInt;
                this.name = "#" + readInt;
            case ve.CropImageView_aspectRatioY /*3*/:
                this.type = 4;
                this.text = readStrI();
            case WAP_EXTENSION /*64*/:
            case Wbxml.EXT_I_1 /*65*/:
            case Wbxml.EXT_I_2 /*66*/:
            case Wbxml.EXT_T_0 /*128*/:
            case Wbxml.EXT_T_1 /*129*/:
            case Wbxml.EXT_T_2 /*130*/:
            case Wbxml.EXT_0 /*192*/:
            case Wbxml.EXT_1 /*193*/:
            case Wbxml.EXT_2 /*194*/:
            case Wbxml.OPAQUE /*195*/:
                this.type = WAP_EXTENSION;
                this.wapCode = peekId;
                this.wapExtensionData = parseWapExtension(peekId);
            case Wbxml.PI /*67*/:
                throw new RuntimeException("PI curr. not supp.");
            case Wbxml.STR_T /*131*/:
                this.type = 4;
                this.text = readStrT();
            default:
                parseElement(peekId);
        }
    }

    public Object parseWapExtension(int i) {
        switch (i) {
            case WAP_EXTENSION /*64*/:
            case Wbxml.EXT_I_1 /*65*/:
            case Wbxml.EXT_I_2 /*66*/:
                return readStrI();
            case Wbxml.EXT_T_0 /*128*/:
            case Wbxml.EXT_T_1 /*129*/:
            case Wbxml.EXT_T_2 /*130*/:
                return new Integer(readInt());
            case Wbxml.EXT_0 /*192*/:
            case Wbxml.EXT_1 /*193*/:
            case Wbxml.EXT_2 /*194*/:
                return null;
            case Wbxml.OPAQUE /*195*/:
                int readInt = readInt();
                Object obj = new byte[readInt];
                while (readInt > 0) {
                    readInt -= this.in.read(obj, obj.length - readInt, readInt);
                }
                return obj;
            default:
                exception("illegal id: " + i);
                return null;
        }
    }

    public void readAttr() {
        int readByte = readByte();
        int i = 0;
        while (readByte != 1) {
            StringBuffer stringBuffer;
            while (readByte == 0) {
                selectPage(readByte(), false);
                readByte = readByte();
            }
            String resolveId = resolveId(this.attrStartTable, readByte);
            int indexOf = resolveId.indexOf(61);
            if (indexOf == -1) {
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer = new StringBuffer(resolveId.substring(indexOf + 1));
                resolveId = resolveId.substring(0, indexOf);
            }
            indexOf = readByte();
            while (true) {
                if (indexOf > Wbxml.EXT_T_0 || indexOf == 0 || indexOf == 2 || indexOf == 3 || indexOf == Wbxml.STR_T || ((indexOf >= WAP_EXTENSION && indexOf <= 66) || (indexOf >= Wbxml.EXT_T_0 && indexOf <= Wbxml.EXT_T_2))) {
                    switch (indexOf) {
                        case ve.CropImageView_guidelines /*0*/:
                            selectPage(readByte(), false);
                            break;
                        case ve.CropImageView_aspectRatioX /*2*/:
                            stringBuffer.append((char) readInt());
                            break;
                        case ve.CropImageView_aspectRatioY /*3*/:
                            stringBuffer.append(readStrI());
                            break;
                        case WAP_EXTENSION /*64*/:
                        case Wbxml.EXT_I_1 /*65*/:
                        case Wbxml.EXT_I_2 /*66*/:
                        case Wbxml.EXT_T_0 /*128*/:
                        case Wbxml.EXT_T_1 /*129*/:
                        case Wbxml.EXT_T_2 /*130*/:
                        case Wbxml.EXT_0 /*192*/:
                        case Wbxml.EXT_1 /*193*/:
                        case Wbxml.EXT_2 /*194*/:
                        case Wbxml.OPAQUE /*195*/:
                            stringBuffer.append(resolveWapExtension(indexOf, parseWapExtension(indexOf)));
                            break;
                        case Wbxml.STR_T /*131*/:
                            stringBuffer.append(readStrT());
                            break;
                        default:
                            stringBuffer.append(resolveId(this.attrValueTable, indexOf));
                            break;
                    }
                    indexOf = readByte();
                } else {
                    this.attributes = ensureCapacity(this.attributes, i + 4);
                    int i2 = i + 1;
                    this.attributes[i] = XmlPullParser.NO_NAMESPACE;
                    int i3 = i2 + 1;
                    this.attributes[i2] = null;
                    i2 = i3 + 1;
                    this.attributes[i3] = resolveId;
                    int i4 = i2 + 1;
                    this.attributes[i2] = stringBuffer.toString();
                    this.attributeCount++;
                    i = i4;
                    readByte = indexOf;
                }
            }
        }
    }

    private int peekId() {
        if (this.nextId == -2) {
            this.nextId = this.in.read();
        }
        return this.nextId;
    }

    protected String resolveWapExtension(int i, Object obj) {
        if (!(obj instanceof byte[])) {
            return "$(" + obj + ")";
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = (byte[]) obj;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append(HEX_DIGITS.charAt((bArr[i2] >> 4) & 15));
            stringBuffer.append(HEX_DIGITS.charAt(bArr[i2] & 15));
        }
        return stringBuffer.toString();
    }

    String resolveId(String[] strArr, int i) {
        int i2 = (i & 127) - 5;
        if (i2 == -1) {
            this.wapCode = -1;
            return readStrT();
        } else if (i2 < 0 || strArr == null || i2 >= strArr.length || strArr[i2] == null) {
            throw new IOException("id " + i + " undef.");
        } else {
            this.wapCode = i2 + 5;
            return strArr[i2];
        }
    }

    void parseElement(int i) {
        this.type = 2;
        this.name = resolveId(this.tagTable, i & 63);
        this.attributeCount = 0;
        if ((i & Wbxml.EXT_T_0) != 0) {
            readAttr();
        }
        this.degenerated = (i & WAP_EXTENSION) == 0;
        int i2 = this.depth;
        this.depth = i2 + 1;
        int i3 = i2 << 2;
        this.elementStack = ensureCapacity(this.elementStack, i3 + 4);
        this.elementStack[i3 + 3] = this.name;
        if (this.depth >= this.nspCounts.length) {
            Object obj = new int[(this.depth + 4)];
            System.arraycopy(this.nspCounts, 0, obj, 0, this.nspCounts.length);
            this.nspCounts = obj;
        }
        this.nspCounts[this.depth] = this.nspCounts[this.depth - 1];
        for (int i4 = this.attributeCount - 1; i4 > 0; i4--) {
            for (i2 = 0; i2 < i4; i2++) {
                if (getAttributeName(i4).equals(getAttributeName(i2))) {
                    exception("Duplicate Attribute: " + getAttributeName(i4));
                }
            }
        }
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = XmlPullParser.NO_NAMESPACE;
        }
        this.elementStack[i3] = this.namespace;
        this.elementStack[i3 + 1] = this.prefix;
        this.elementStack[i3 + 2] = this.name;
    }

    private final String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        Object obj = new String[(i + 16)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        return obj;
    }

    int readByte() {
        int read = this.in.read();
        if (read != -1) {
            return read;
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    int readInt() {
        int i = 0;
        int readByte;
        do {
            readByte = readByte();
            i = (i << 7) | (readByte & 127);
        } while ((readByte & Wbxml.EXT_T_0) != 0);
        return i;
    }

    String readStrI() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        while (true) {
            int read = this.in.read();
            if (read == 0) {
                this.isWhitespace = z;
                String str = new String(byteArrayOutputStream.toByteArray(), this.encoding);
                byteArrayOutputStream.close();
                return str;
            } else if (read == -1) {
                break;
            } else {
                if (read > 32) {
                    z = false;
                }
                byteArrayOutputStream.write(read);
            }
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    String readStrT() {
        int readInt = readInt();
        if (this.cacheStringTable == null) {
            this.cacheStringTable = new Hashtable();
        }
        String str = (String) this.cacheStringTable.get(new Integer(readInt));
        if (str != null) {
            return str;
        }
        int i = readInt;
        while (i < this.stringTable.length && this.stringTable[i] != null) {
            i++;
        }
        String str2 = new String(this.stringTable, readInt, i - readInt, this.encoding);
        this.cacheStringTable.put(new Integer(readInt), str2);
        return str2;
    }

    public void setTagTable(int i, String[] strArr) {
        setTable(i, this.TAG_TABLE, strArr);
    }

    public void setAttrStartTable(int i, String[] strArr) {
        setTable(i, this.ATTR_START_TABLE, strArr);
    }

    public void setAttrValueTable(int i, String[] strArr) {
        setTable(i, this.ATTR_VALUE_TABLE, strArr);
    }

    public int getWapCode() {
        return this.wapCode;
    }

    public Object getWapExtensionData() {
        return this.wapExtensionData;
    }
}
