package kr.ac.hanyang.morphing.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.ac.hanyang.morphing.R;

/**
 * 알림형태의 Dialog 입니다.
 */

public class AlertDialog extends Dialog {
    @BindView(R.id.alertMessage)
    TextView message;

    public AlertDialog(Context context, String msg) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_alert);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        message.setText(msg);
    }

    @OnClick(R.id.alertDone)
    void close() {
        dismiss();
    }
}
