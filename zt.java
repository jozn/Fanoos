import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import ir.seraj.fanoos.communication.MyResultReceiver;
import ir.seraj.fanoos3.R;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class zt {
    public void a(String str, MyResultReceiver myResultReceiver, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_verify_phone_number, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_verify_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_verify_are_u_sure_edit_button);
        ((TextView) inflate.findViewById(R.id.dialog_verify_phone_number_textView)).setText(str);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new zu(this, context, myResultReceiver, create));
        textView2.setOnClickListener(new aad(this, create));
        create.show();
    }

    public void a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_not_invited, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_error_server_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aaj(this, create));
        create.show();
    }

    public void b(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_error_server, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_error_server_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aak(this, create));
        create.show();
    }

    public void a(String str, String str2, MyResultReceiver myResultReceiver, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert_are_u_sure, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_cancel_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aal(this, context, myResultReceiver, str2, str, create));
        textView2.setOnClickListener(new aam(this, create));
        create.show();
    }

    public void a(String str, String str2, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_edite_group_name, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_edit_group_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_edit_group_are_u_sure_cancel_button);
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit_group_name_editView);
        editText.setText(str);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aan(this, editText, str, context, str2, create));
        textView2.setOnClickListener(new aao(this, create));
        create.show();
    }

    public void a(String str, afo afo, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_edite_group_name, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_edit_group_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_edit_group_are_u_sure_cancel_button);
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit_group_name_editView);
        editText.setText(str);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aap(this, editText, str, context, afo, create));
        textView2.setOnClickListener(new zv(this, create));
        create.show();
    }

    public void a(String str, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert_are_u_sure, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_cancel_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new zw(this, context, str, create));
        textView2.setOnClickListener(new zx(this, create));
        create.show();
    }

    public void a(List list, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert_are_u_sure, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_title_textView);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.dialog_are_u_sure_option_RadioGroup);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_ok_button);
        TextView textView3 = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_cancel_button);
        textView2.setText("\u0627\u0631\u0633\u0627\u0644");
        textView3.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
        if (list.size() == 1) {
            textView.setText("\u0622\u06cc\u0627 \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u0628\u0647 \u0634\u0645\u0627\u0631\u0647 \u0632\u06cc\u0631 \u062f\u0639\u0648\u062a \u0646\u0627\u0645\u0647 \u0627\u0631\u0633\u0627\u0644 \u0634\u0648\u062f\u061f");
        } else {
            textView.setText("\u0628\u0647 \u06a9\u062f\u0627\u0645 \u06cc\u06a9 \u0627\u0632 \u0634\u0645\u0627\u0631\u0647 \u0647\u0627\u06cc \u0632\u06cc\u0631 \u0645\u06cc \u062e\u0648\u0627\u0647\u06cc\u062f \u062f\u0639\u0648\u062a \u0646\u0627\u0645\u0647 \u0627\u0631\u0633\u0627\u0644 \u0646\u0645\u0627\u06cc\u06cc\u062f\u061f");
        }
        String str = XmlPullParser.NO_NAMESPACE;
        for (int i = 0; i < list.size(); i++) {
            View radioButton = new RadioButton(context);
            radioButton.setText((CharSequence) list.get(i));
            radioButton.setTextSize(1, 22.0f);
            radioButton.setId(i);
            if (i == 0) {
                try {
                    radioButton.setChecked(true);
                } catch (Exception e) {
                }
            }
            radioButton.setOnClickListener(new zy(this));
            radioGroup.addView(radioButton);
        }
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView2.setOnClickListener(new zz(this, context, list, radioGroup, create));
        textView3.setOnClickListener(new aaa(this, create));
        create.show();
    }

    public void b(String str, String str2, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert_are_u_sure, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_are_u_sure_cancel_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aab(this, str2, context, str, create));
        textView2.setOnClickListener(new aac(this, create));
        create.show();
    }

    public void c(String str, String str2, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_new_update, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_verify_are_u_sure_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_verify_are_u_sure_edit_button);
        ((TextView) inflate.findViewById(R.id.dialog_verify_phone_number_textView)).setText(str2);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aae(this, str, context, create));
        textView2.setOnClickListener(new aaf(this, create));
        create.show();
    }

    public void c(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_security_code_error, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_error_server_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aag(this, create));
        create.show();
    }

    public void a(LinearLayout linearLayout, Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.dialog_alert_call_me, null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_call_ok_button);
        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_call_cancel_button);
        Builder builder = new Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        textView.setOnClickListener(new aah(this, context, create, linearLayout));
        textView2.setOnClickListener(new aai(this, create));
        create.show();
    }
}
