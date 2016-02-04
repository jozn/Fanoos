import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

class cn {
    static RemoteInput[] a(cp[] cpVarArr) {
        if (cpVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[cpVarArr.length];
        for (int i = 0; i < cpVarArr.length; i++) {
            cp cpVar = cpVarArr[i];
            remoteInputArr[i] = new Builder(cpVar.a()).setLabel(cpVar.b()).setChoices(cpVar.c()).setAllowFreeFormInput(cpVar.d()).addExtras(cpVar.e()).build();
        }
        return remoteInputArr;
    }
}
