import java.util.List;

class ti {
    final tj a;

    void a(List list) {
        while (true) {
            int b = b(list);
            if (b != -1) {
                a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    private void a(List list, int i, int i2) {
        sn snVar = (sn) list.get(i);
        sn snVar2 = (sn) list.get(i2);
        switch (snVar2.a) {
            case ve.CropImageView_guidelines /*0*/:
                c(list, i, snVar, i2, snVar2);
            case ve.CropImageView_fixAspectRatio /*1*/:
                a(list, i, snVar, i2, snVar2);
            case ve.CropImageView_aspectRatioX /*2*/:
                b(list, i, snVar, i2, snVar2);
            default:
        }
    }

    void a(List list, int i, sn snVar, int i2, sn snVar2) {
        int i3;
        sn snVar3;
        int i4 = 0;
        if (snVar.b < snVar.c) {
            i3 = (snVar2.b == snVar.b && snVar2.c == snVar.c - snVar.b) ? 1 : 0;
        } else if (snVar2.b == snVar.c + 1 && snVar2.c == snVar.b - snVar.c) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (snVar.c < snVar2.b) {
            snVar2.b--;
        } else if (snVar.c < snVar2.b + snVar2.c) {
            snVar2.c--;
            snVar.a = 1;
            snVar.c = 1;
            if (snVar2.c == 0) {
                list.remove(i2);
                this.a.a(snVar2);
                return;
            }
            return;
        }
        if (snVar.b <= snVar2.b) {
            snVar2.b++;
            snVar3 = null;
        } else if (snVar.b < snVar2.b + snVar2.c) {
            snVar3 = this.a.a(1, snVar.b + 1, (snVar2.b + snVar2.c) - snVar.b);
            snVar2.c = snVar.b - snVar2.b;
        } else {
            snVar3 = null;
        }
        if (i3 != 0) {
            list.set(i, snVar2);
            list.remove(i2);
            this.a.a(snVar);
            return;
        }
        if (i4 != 0) {
            if (snVar3 != null) {
                if (snVar.b > snVar3.b) {
                    snVar.b -= snVar3.c;
                }
                if (snVar.c > snVar3.b) {
                    snVar.c -= snVar3.c;
                }
            }
            if (snVar.b > snVar2.b) {
                snVar.b -= snVar2.c;
            }
            if (snVar.c > snVar2.b) {
                snVar.c -= snVar2.c;
            }
        } else {
            if (snVar3 != null) {
                if (snVar.b >= snVar3.b) {
                    snVar.b -= snVar3.c;
                }
                if (snVar.c >= snVar3.b) {
                    snVar.c -= snVar3.c;
                }
            }
            if (snVar.b >= snVar2.b) {
                snVar.b -= snVar2.c;
            }
            if (snVar.c >= snVar2.b) {
                snVar.c -= snVar2.c;
            }
        }
        list.set(i, snVar2);
        if (snVar.b != snVar.c) {
            list.set(i2, snVar);
        } else {
            list.remove(i2);
        }
        if (snVar3 != null) {
            list.add(i, snVar3);
        }
    }

    private void c(List list, int i, sn snVar, int i2, sn snVar2) {
        int i3 = 0;
        if (snVar.c < snVar2.b) {
            i3 = -1;
        }
        if (snVar.b < snVar2.b) {
            i3++;
        }
        if (snVar2.b <= snVar.b) {
            snVar.b += snVar2.c;
        }
        if (snVar2.b <= snVar.c) {
            snVar.c += snVar2.c;
        }
        snVar2.b = i3 + snVar2.b;
        list.set(i, snVar2);
        list.set(i2, snVar);
    }

    void b(List list, int i, sn snVar, int i2, sn snVar2) {
        Object obj;
        Object obj2 = null;
        if (snVar.c < snVar2.b) {
            snVar2.b--;
            obj = null;
        } else if (snVar.c < snVar2.b + snVar2.c) {
            snVar2.c--;
            obj = this.a.a(2, snVar.b, 1);
        } else {
            obj = null;
        }
        if (snVar.b <= snVar2.b) {
            snVar2.b++;
        } else if (snVar.b < snVar2.b + snVar2.c) {
            int i3 = (snVar2.b + snVar2.c) - snVar.b;
            obj2 = this.a.a(2, snVar.b + 1, i3);
            snVar2.c -= i3;
        }
        list.set(i2, snVar);
        if (snVar2.c > 0) {
            list.set(i, snVar2);
        } else {
            list.remove(i);
            this.a.a(snVar2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int b(List list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((sn) list.get(size)).a != 3) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
