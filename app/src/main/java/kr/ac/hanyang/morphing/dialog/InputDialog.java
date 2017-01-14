package kr.ac.hanyang.morphing.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.ac.hanyang.morphing.R;

/**
 * 사용자의 이름을 받는 Dialog 입니다.
 */

public class InputDialog extends Dialog {
    @BindView(R.id.userName)
    EditText username;

    private Context context;
    private OnDismissListener listener;

    public InputDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_username_alert);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @OnClick(R.id.done)
    void close() {
        if (username.getText().toString().length() == 0)
            Toast.makeText(context, context.getString(R.string.enter_name).toString(), Toast.LENGTH_LONG).show();
        else {
            if (this.listener == null) {
            } else {
                this.listener.onDismiss(InputDialog.this);
            }
            dismiss();
        }
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.listener = listener;
    }

    public String getName() {
        return username.getText().toString();
    }

}