class sn {
    int a;
    int b;
    int c;

    sn(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    String a() {
        switch (this.a) {
            case ve.CropImageView_guidelines /*0*/:
                return "add";
            case ve.CropImageView_fixAspectRatio /*1*/:
                return "rm";
            case ve.CropImageView_aspectRatioX /*2*/:
                return "up";
            case ve.CropImageView_aspectRatioY /*3*/:
                return "mv";
            default:
                return "??";
        }
    }

    public String toString() {
        return "[" + a() + ",s:" + this.b + "c:" + this.c + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        sn snVar = (sn) obj;
        if (this.a != snVar.a) {
            return false;
        }
        if (this.a == 3 && Math.abs(this.c - this.b) == 1 && this.c == snVar.b && this.b == snVar.c) {
            return true;
        }
        if (this.c != snVar.c) {
            return false;
        }
        if (this.b != snVar.b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }
}
