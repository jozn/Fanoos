import java.util.Date;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;

public class aeu {
    public String a;
    public String b;
    int c;
    int d;
    int e;
    final /* synthetic */ aet f;

    public aeu(aet aet, Date date) {
        this.f = aet;
        this.a = XmlPullParser.NO_NAMESPACE;
        this.b = XmlPullParser.NO_NAMESPACE;
        a(date);
    }

    private void a(Date date) {
        int i = 10;
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        int day = date.getDay();
        r5 = new int[12];
        int[] iArr = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        iArr[0] = 0;
        iArr[1] = 31;
        iArr[2] = 60;
        iArr[3] = 91;
        iArr[4] = 121;
        iArr[5] = 152;
        iArr[6] = 182;
        iArr[7] = 213;
        iArr[8] = 244;
        iArr[9] = 274;
        iArr[10] = 305;
        iArr[11] = 335;
        if (year % 4 != 0) {
            this.c = r5[month - 1] + date2;
            if (this.c > 79) {
                this.c -= 79;
                if (this.c <= 186) {
                    switch (this.c % 31) {
                        case ve.CropImageView_guidelines /*0*/:
                            this.d = this.c / 31;
                            this.c = 31;
                            break;
                        default:
                            this.d = (this.c / 31) + 1;
                            this.c %= 31;
                            break;
                    }
                    this.e = year - 621;
                } else {
                    this.c -= 186;
                    switch (this.c % 30) {
                        case ve.CropImageView_guidelines /*0*/:
                            this.d = (this.c / 30) + 6;
                            this.c = 30;
                            break;
                        default:
                            this.d = (this.c / 30) + 7;
                            this.c %= 30;
                            break;
                    }
                    this.e = year - 621;
                }
            } else {
                if (year > 1996 && year % 4 == 1) {
                    i = 11;
                }
                this.c = i + this.c;
                switch (this.c % 30) {
                    case ve.CropImageView_guidelines /*0*/:
                        this.d = (this.c / 30) + 9;
                        this.c = 30;
                        break;
                    default:
                        this.d = (this.c / 30) + 10;
                        this.c %= 30;
                        break;
                }
                this.e = year - 622;
            }
        } else {
            this.c = iArr[month - 1] + date2;
            if (year >= 1996) {
                i = 79;
            } else {
                i = 80;
            }
            if (this.c > i) {
                this.c -= i;
                if (this.c <= 186) {
                    switch (this.c % 31) {
                        case ve.CropImageView_guidelines /*0*/:
                            this.d = this.c / 31;
                            this.c = 31;
                            break;
                        default:
                            this.d = (this.c / 31) + 1;
                            this.c %= 31;
                            break;
                    }
                    this.e = year - 621;
                } else {
                    this.c -= 186;
                    switch (this.c % 30) {
                        case ve.CropImageView_guidelines /*0*/:
                            this.d = (this.c / 30) + 6;
                            this.c = 30;
                            break;
                        default:
                            this.d = (this.c / 30) + 7;
                            this.c %= 30;
                            break;
                    }
                    this.e = year - 621;
                }
            } else {
                this.c += 10;
                switch (this.c % 30) {
                    case ve.CropImageView_guidelines /*0*/:
                        this.d = (this.c / 30) + 9;
                        this.c = 30;
                        break;
                    default:
                        this.d = (this.c / 30) + 10;
                        this.c %= 30;
                        break;
                }
                this.e = year - 622;
            }
        }
        switch (this.d) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.b = "\u00d9\ufffd\u00d8\u00b1\u00d9\u02c6\u00d8\u00b1\u00d8\u00af\u00d9\u0160\u00d9\u2020";
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                this.b = "\u00d8\u00a7\u00d8\u00b1\u00d8\u00af\u00d9\u0160\u00d8\u00a8\u00d9\u2021\u00d8\u00b4\u00d8\u00aa";
                break;
            case ve.CropImageView_aspectRatioY /*3*/:
                this.b = "\u00d8\u00ae\u00d8\u00b1\u00d8\u00af\u00d8\u00a7\u00d8\u00af";
                break;
            case ve.CropImageView_imageResource /*4*/:
                this.b = "\u00d8\u00aa\u00d9\u0160\u00d8\u00b1";
                break;
            case Node.CDSECT /*5*/:
                this.b = "\u00d9\u2026\u00d8\u00b1\u00d8\u00af\u00d8\u00a7\u00d8\u00af";
                break;
            case Node.ENTITY_REF /*6*/:
                this.b = "\u00d8\u00b4\u00d9\u2021\u00d8\u00b1\u00d9\u0160\u00d9\u02c6\u00d8\u00b1";
                break;
            case Node.IGNORABLE_WHITESPACE /*7*/:
                this.b = "\u00d9\u2026\u00d9\u2021\u00d8\u00b1";
                break;
            case Node.PROCESSING_INSTRUCTION /*8*/:
                this.b = "\u00d8\u00a2\u00d8\u00a8\u00d8\u00a7\u00d9\u2020";
                break;
            case Node.COMMENT /*9*/:
                this.b = "\u00d8\u00a2\u00d8\u00b0\u00d8\u00b1";
                break;
            case Node.DOCDECL /*10*/:
                this.b = "\u00d8\u00af\u00d9\u0160";
                break;
            case nv.Toolbar_titleMargins /*11*/:
                this.b = "\u00d8\u00a8\u00d9\u2021\u00d9\u2026\u00d9\u2020";
                break;
            case nv.Toolbar_titleMarginStart /*12*/:
                this.b = "\u00d8\u00a7\u00d8\u00b3\u00d9\ufffd\u00d9\u2020\u00d8\u00af";
                break;
        }
        switch (day) {
            case ve.CropImageView_guidelines /*0*/:
                this.a = "\u00d9\u0160\u00da\u00a9\u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.a = "\u00d8\u00af\u00d9\u02c6\u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            case ve.CropImageView_aspectRatioX /*2*/:
                this.a = "\u00d8\u00b3\u00d9\u2021 \u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            case ve.CropImageView_aspectRatioY /*3*/:
                this.a = "\u00da\u2020\u00d9\u2021\u00d8\u00a7\u00d8\u00b1\u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            case ve.CropImageView_imageResource /*4*/:
                this.a = "\u00d9\u00be\u00d9\u2020\u00d8\u00ac \u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            case Node.CDSECT /*5*/:
                this.a = "\u00d8\u00ac\u00d9\u2026\u00d8\u00b9\u00d9\u2021";
            case Node.ENTITY_REF /*6*/:
                this.a = "\u00d8\u00b4\u00d9\u2020\u00d8\u00a8\u00d9\u2021";
            default:
        }
    }
}
