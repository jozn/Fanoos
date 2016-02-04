import java.util.ArrayList;
import java.util.List;

public class sl implements tj {
    final ArrayList a;
    final ArrayList b;
    final sm c;
    Runnable d;
    final boolean e;
    final ti f;
    private fc g;

    public void a() {
        a(this.a);
        a(this.b);
    }

    public void b() {
        this.f.a(this.a);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sn snVar = (sn) this.a.get(i);
            switch (snVar.a) {
                case ve.CropImageView_guidelines /*0*/:
                    f(snVar);
                    break;
                case ve.CropImageView_fixAspectRatio /*1*/:
                    c(snVar);
                    break;
                case ve.CropImageView_aspectRatioX /*2*/:
                    d(snVar);
                    break;
                case ve.CropImageView_aspectRatioY /*3*/:
                    b(snVar);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.a.clear();
    }

    public void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b((sn) this.b.get(i));
        }
        a(this.b);
    }

    private void b(sn snVar) {
        g(snVar);
    }

    private void c(sn snVar) {
        int i = snVar.b;
        int i2 = snVar.b + snVar.c;
        int i3 = -1;
        int i4 = snVar.b;
        int i5 = 0;
        while (i4 < i2) {
            int i6;
            if (this.c.a(i4) != null || b(i4)) {
                if (i3 == 0) {
                    e(a(1, i, i5));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 1;
            } else {
                if (i3 == 1) {
                    g(a(1, i, i5));
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                i3 = 0;
            }
            if (i6 != 0) {
                i6 = i4 - i5;
                i4 = i2 - i5;
                i2 = 1;
            } else {
                int i7 = i4;
                i4 = i2;
                i2 = i5 + 1;
                i6 = i7;
            }
            i5 = i2;
            i2 = i4;
            i4 = i6 + 1;
        }
        if (i5 != snVar.c) {
            a(snVar);
            snVar = a(1, i, i5);
        }
        if (i3 == 0) {
            e(snVar);
        } else {
            g(snVar);
        }
    }

    private void d(sn snVar) {
        int i = snVar.b;
        int i2 = snVar.b + snVar.c;
        int i3 = snVar.b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.c.a(i3) != null || b(i3)) {
                if (obj == null) {
                    e(a(2, i, i4));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    g(a(2, i, i4));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != snVar.c) {
            a(snVar);
            snVar = a(2, i, i4);
        }
        if (obj == null) {
            e(snVar);
        } else {
            g(snVar);
        }
    }

    private void e(sn snVar) {
        if (snVar.a == 0 || snVar.a == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = b(snVar.b, snVar.a);
        int i2 = snVar.b;
        switch (snVar.a) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                i = 0;
                break;
            case ve.CropImageView_aspectRatioX /*2*/:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + snVar);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < snVar.c; i2++) {
            Object obj;
            int b2 = b(snVar.b + (i * i2), snVar.a);
            int i5;
            switch (snVar.a) {
                case ve.CropImageView_fixAspectRatio /*1*/:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case ve.CropImageView_aspectRatioX /*2*/:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                sn a = a(snVar.a, i4, i3);
                a(a, b);
                a(a);
                if (snVar.a == 2) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        a(snVar);
        if (i3 > 0) {
            sn a2 = a(snVar.a, i4, i3);
            a(a2, b);
            a(a2);
        }
    }

    void a(sn snVar, int i) {
        this.c.a(snVar);
        switch (snVar.a) {
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.c.a(i, snVar.c);
            case ve.CropImageView_aspectRatioX /*2*/:
                this.c.c(i, snVar.c);
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int b(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            sn snVar = (sn) this.b.get(size);
            if (snVar.a == 3) {
                int i5;
                int i6;
                if (snVar.b < snVar.c) {
                    i5 = snVar.b;
                    i3 = snVar.c;
                } else {
                    i5 = snVar.c;
                    i3 = snVar.b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < snVar.b) {
                        if (i2 == 0) {
                            snVar.b++;
                            snVar.c++;
                            i6 = i4;
                        } else if (i2 == 1) {
                            snVar.b--;
                            snVar.c--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == snVar.b) {
                    if (i2 == 0) {
                        snVar.c++;
                    } else if (i2 == 1) {
                        snVar.c--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 0) {
                        snVar.b++;
                    } else if (i2 == 1) {
                        snVar.b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (snVar.b <= i4) {
                if (snVar.a == 0) {
                    i4 -= snVar.c;
                } else if (snVar.a == 1) {
                    i4 += snVar.c;
                }
            } else if (i2 == 0) {
                snVar.b++;
            } else if (i2 == 1) {
                snVar.b--;
            }
        }
        for (i3 = this.b.size() - 1; i3 >= 0; i3--) {
            snVar = (sn) this.b.get(i3);
            if (snVar.a == 3) {
                if (snVar.c == snVar.b || snVar.c < 0) {
                    this.b.remove(i3);
                    a(snVar);
                }
            } else if (snVar.c <= 0) {
                this.b.remove(i3);
                a(snVar);
            }
        }
        return i4;
    }

    private boolean b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            sn snVar = (sn) this.b.get(i2);
            if (snVar.a == 3) {
                if (a(snVar.c, i2 + 1) == i) {
                    return true;
                }
            } else if (snVar.a == 0) {
                int i3 = snVar.b + snVar.c;
                for (int i4 = snVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void f(sn snVar) {
        g(snVar);
    }

    private void g(sn snVar) {
        this.b.add(snVar);
        switch (snVar.a) {
            case ve.CropImageView_guidelines /*0*/:
                this.c.d(snVar.b, snVar.c);
            case ve.CropImageView_fixAspectRatio /*1*/:
                this.c.b(snVar.b, snVar.c);
            case ve.CropImageView_aspectRatioX /*2*/:
                this.c.c(snVar.b, snVar.c);
            case ve.CropImageView_aspectRatioY /*3*/:
                this.c.e(snVar.b, snVar.c);
            default:
                throw new IllegalArgumentException("Unknown update op type for " + snVar);
        }
    }

    int a(int i) {
        return a(i, 0);
    }

    int a(int i, int i2) {
        int size = this.b.size();
        int i3 = i;
        while (i2 < size) {
            sn snVar = (sn) this.b.get(i2);
            if (snVar.a == 3) {
                if (snVar.b == i3) {
                    i3 = snVar.c;
                } else {
                    if (snVar.b < i3) {
                        i3--;
                    }
                    if (snVar.c <= i3) {
                        i3++;
                    }
                }
            } else if (snVar.b > i3) {
                continue;
            } else if (snVar.a == 1) {
                if (i3 < snVar.b + snVar.c) {
                    return -1;
                }
                i3 -= snVar.c;
            } else if (snVar.a == 0) {
                i3 += snVar.c;
            }
            i2++;
        }
        return i3;
    }

    public void d() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            sn snVar = (sn) this.a.get(i);
            switch (snVar.a) {
                case ve.CropImageView_guidelines /*0*/:
                    this.c.b(snVar);
                    this.c.d(snVar.b, snVar.c);
                    break;
                case ve.CropImageView_fixAspectRatio /*1*/:
                    this.c.b(snVar);
                    this.c.a(snVar.b, snVar.c);
                    break;
                case ve.CropImageView_aspectRatioX /*2*/:
                    this.c.b(snVar);
                    this.c.c(snVar.b, snVar.c);
                    break;
                case ve.CropImageView_aspectRatioY /*3*/:
                    this.c.b(snVar);
                    this.c.e(snVar.b, snVar.c);
                    break;
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
    }

    public sn a(int i, int i2, int i3) {
        sn snVar = (sn) this.g.a();
        if (snVar == null) {
            return new sn(i, i2, i3);
        }
        snVar.a = i;
        snVar.b = i2;
        snVar.c = i3;
        return snVar;
    }

    public void a(sn snVar) {
        if (!this.e) {
            this.g.a(snVar);
        }
    }

    void a(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a((sn) list.get(i));
        }
        list.clear();
    }
}
