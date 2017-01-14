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
import kr.ac.hanyang.morphing.activity.PlayActivity;

/**
 * 모든 검사를 마치고 PlayVideoActivity를 종료하는 알림 Dialog 입니다.
 */

public class FinishDialog extends Dialog {
    private Context context;

    @BindView(R.id.alertMessage)
    TextView message;

    public FinishDialog(Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_alert);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        message.setText(context.getString(R.string.thank_you).toString());
    }

    @OnClick(R.id.alertDone)
    void close() {
        ((PlayActivity) context).finish();
        dismiss();
    }
}
