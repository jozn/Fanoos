import android.os.Bundle;

class cr {
    static Bundle a(cp cpVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", cpVar.a());
        bundle.putCharSequence("label", cpVar.b());
        bundle.putCharSequenceArray("choices", cpVar.c());
        bundle.putBoolean("allowFreeFormInput", cpVar.d());
        bundle.putBundle("extras", cpVar.e());
        return bundle;
    }

    static Bundle[] a(cp[] cpVarArr) {
        if (cpVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[cpVarArr.length];
        for (int i = 0; i < cpVarArr.length; i++) {
            bundleArr[i] = a(cpVarArr[i]);
        }
        return bundleArr;
    }
}
