package org.kobjects.xmlrpc;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.kobjects.base64.Base64;
import org.kobjects.isodate.IsoDate;
import org.kobjects.xml.XmlReader;
import org.xmlpull.v1.XmlPullParser;

public class XmlRpcParser {
    private XmlReader parser;

    public XmlRpcParser(XmlReader xmlReader) {
        this.parser = null;
        this.parser = xmlReader;
    }

    private final Hashtable parseStruct() {
        Hashtable hashtable = new Hashtable();
        int nextTag = nextTag();
        while (nextTag != 3) {
            nextTag();
            String nextText = nextText();
            nextTag();
            hashtable.put(nextText, parseValue());
            nextTag = nextTag();
        }
        nextTag();
        return hashtable;
    }

    private final Object parseValue() {
        Object obj;
        int next;
        int next2 = this.parser.next();
        if (next2 == 4) {
            String text = this.parser.getText();
            obj = text;
            next = this.parser.next();
        } else {
            int i = next2;
            obj = null;
            next = i;
        }
        if (next == 2) {
            text = this.parser.getName();
            if (text.equals("array")) {
                obj = parseArray();
            } else if (text.equals("struct")) {
                obj = parseStruct();
            } else {
                if (text.equals("string")) {
                    obj = nextText();
                } else if (text.equals("i4") || text.equals("int")) {
                    obj = new Integer(Integer.parseInt(nextText().trim()));
                } else if (text.equals("boolean")) {
                    obj = new Boolean(nextText().trim().equals("1"));
                } else if (text.equals("dateTime.iso8601")) {
                    obj = IsoDate.stringToDate(nextText(), 3);
                } else if (text.equals("base64")) {
                    obj = Base64.decode(nextText());
                } else if (text.equals("double")) {
                    obj = nextText();
                }
                nextTag();
            }
        }
        nextTag();
        return obj;
    }

    private final Vector parseArray() {
        nextTag();
        int nextTag = nextTag();
        Vector vector = new Vector();
        while (nextTag != 3) {
            vector.addElement(parseValue());
            nextTag = this.parser.getType();
        }
        nextTag();
        nextTag();
        return vector;
    }

    private final Object parseFault() {
        nextTag();
        Object parseValue = parseValue();
        nextTag();
        return parseValue;
    }

    private final Object parseParams() {
        Vector vector = new Vector();
        int nextTag = nextTag();
        while (nextTag != 3) {
            nextTag();
            vector.addElement(parseValue());
            nextTag = nextTag();
        }
        nextTag();
        return vector;
    }

    public final Object parseResponse() {
        nextTag();
        if (nextTag() != 2) {
            return null;
        }
        if ("fault".equals(this.parser.getName())) {
            return parseFault();
        }
        if ("params".equals(this.parser.getName())) {
            return parseParams();
        }
        return null;
    }

    private final int nextTag() {
        this.parser.getType();
        int next = this.parser.next();
        if (next == 4 && this.parser.isWhitespace()) {
            next = this.parser.next();
        }
        if (next == 3 || next == 2) {
            return next;
        }
        throw new IOException("unexpected type: " + next);
    }

    private final String nextText() {
        if (this.parser.getType() != 2) {
            throw new IOException("precondition: START_TAG");
        }
        String text;
        int next = this.parser.next();
        if (next == 4) {
            text = this.parser.getText();
            next = this.parser.next();
        } else {
            text = XmlPullParser.NO_NAMESPACE;
        }
        if (next == 3) {
            return text;
        }
        throw new IOException("END_TAG expected");
    }
}
