package org.kobjects.pim;

public class VCard extends PimItem {
    public VCard(VCard vCard) {
        super(vCard);
    }

    public String getType() {
        return "vcard";
    }

    public int getArraySize(String str) {
        if (str.equals("n")) {
            return 5;
        }
        if (str.equals("adr")) {
            return 6;
        }
        return -1;
    }
}
