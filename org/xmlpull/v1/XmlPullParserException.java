package org.xmlpull.v1;

public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    public XmlPullParserException(String str) {
        super(str);
        this.row = -1;
        this.column = -1;
    }

    public XmlPullParserException(String str, XmlPullParser xmlPullParser, Throwable th) {
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str2 = XmlPullParser.NO_NAMESPACE;
        } else {
            str2 = str + " ";
        }
        stringBuilder = stringBuilder.append(str2);
        if (xmlPullParser == null) {
            str2 = XmlPullParser.NO_NAMESPACE;
        } else {
            str2 = "(position:" + xmlPullParser.getPositionDescription() + ") ";
        }
        stringBuilder = stringBuilder.append(str2);
        if (th == null) {
            str2 = XmlPullParser.NO_NAMESPACE;
        } else {
            str2 = "caused by: " + th;
        }
        super(stringBuilder.append(str2).toString());
        this.row = -1;
        this.column = -1;
        if (xmlPullParser != null) {
            this.row = xmlPullParser.getLineNumber();
            this.column = xmlPullParser.getColumnNumber();
        }
        this.detail = th;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.detail.printStackTrace();
        }
    }
}
