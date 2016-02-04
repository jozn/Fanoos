package org.kobjects.io;

import java.io.Reader;
import org.kxml2.wap.Wbxml;

public class LookAheadReader extends Reader {
    char[] buf;
    int bufPos;
    int bufValid;
    Reader reader;

    public LookAheadReader(Reader reader) {
        this.buf = new char[(Runtime.getRuntime().freeMemory() > 1000000 ? 16384 : Wbxml.EXT_T_0)];
        this.bufPos = 0;
        this.bufValid = 0;
        this.reader = reader;
    }

    public int read(char[] cArr, int i, int i2) {
        if (this.bufValid == 0 && peek(0) == -1) {
            return -1;
        }
        if (i2 > this.bufValid) {
            i2 = this.bufValid;
        }
        if (i2 > this.buf.length - this.bufPos) {
            i2 = this.buf.length - this.bufPos;
        }
        System.arraycopy(this.buf, this.bufPos, cArr, i, i2);
        this.bufValid -= i2;
        this.bufPos += i2;
        if (this.bufPos <= this.buf.length) {
            return i2;
        }
        this.bufPos -= this.buf.length;
        return i2;
    }

    public String readTo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (peek(0) != -1 && str.indexOf((char) peek(0)) == -1) {
            stringBuffer.append((char) read());
        }
        return stringBuffer.toString();
    }

    public String readTo(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        while (peek(0) != -1 && peek(0) != c) {
            stringBuffer.append((char) read());
        }
        return stringBuffer.toString();
    }

    public void close() {
        this.reader.close();
    }

    public int read() {
        int peek = peek(0);
        if (peek != -1) {
            int i = this.bufPos + 1;
            this.bufPos = i;
            if (i == this.buf.length) {
                this.bufPos = 0;
            }
            this.bufValid--;
        }
        return peek;
    }

    public int peek(int i) {
        if (i > 127) {
            throw new RuntimeException("peek > 127 not supported!");
        }
        while (i >= this.bufValid) {
            int length = (this.bufPos + this.bufValid) % this.buf.length;
            length = this.reader.read(this.buf, length, Math.min(this.buf.length - length, this.buf.length - this.bufValid));
            if (length == -1) {
                return -1;
            }
            this.bufValid = length + this.bufValid;
        }
        return this.buf[this.bufPos + (i % this.buf.length)];
    }

    public String readLine() {
        if (peek(0) == -1) {
            return null;
        }
        String readTo = readTo("\r\n");
        if (read() != 13 || peek(0) != 10) {
            return readTo;
        }
        read();
        return readTo;
    }

    public String readWhile(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (peek(0) != -1 && str.indexOf((char) peek(0)) != -1) {
            stringBuffer.append((char) read());
        }
        return stringBuffer.toString();
    }

    public void skip(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (peek(0) != -1 && str.indexOf((char) peek(0)) != -1) {
            read();
        }
    }
}
