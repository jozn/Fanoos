import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

public class acn implements TextWatcher {
    private final EditText a;
    private final ArrayList b;

    public acn(EditText editText) {
        this.b = new ArrayList();
        this.a = editText;
        this.a.addTextChangedListener(this);
    }

    public void a(String str, int i) {
        Drawable drawable = this.a.getResources().getDrawable(i);
        drawable.setBounds(0, 0, 45, 45);
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        int selectionStart = this.a.getSelectionStart();
        int selectionEnd = this.a.getSelectionEnd();
        Editable editableText = this.a.getEditableText();
        editableText.replace(selectionStart, selectionEnd, str);
        editableText.setSpan(imageSpan, selectionStart, str.length() + selectionStart, 33);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = i + i2;
            Editable editableText = this.a.getEditableText();
            for (Object obj : (ImageSpan[]) editableText.getSpans(i, i4, ImageSpan.class)) {
                int spanStart = editableText.getSpanStart(obj);
                int spanEnd = editableText.getSpanEnd(obj);
                if (spanStart < i4 && spanEnd > i) {
                    this.b.add(obj);
                }
            }
        }
    }

    public void afterTextChanged(Editable editable) {
        Editable editableText = this.a.getEditableText();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ImageSpan imageSpan = (ImageSpan) it.next();
            int spanStart = editableText.getSpanStart(imageSpan);
            int spanEnd = editableText.getSpanEnd(imageSpan);
            editableText.removeSpan(imageSpan);
            if (spanStart != spanEnd) {
                editableText.delete(spanStart, spanEnd);
            }
        }
        this.b.clear();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
