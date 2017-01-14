package kr.ac.hanyang.morphing.activity;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.ac.hanyang.morphing.R;
import kr.ac.hanyang.morphing.data.ImageData;
import kr.ac.hanyang.morphing.dialog.AlertDialog;
import kr.ac.hanyang.morphing.dialog.FinishDialog;
import kr.ac.hanyang.morphing.io.PlayList;
import kr.ac.hanyang.morphing.io.Result;

public class PlayActivity extends Activity {
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.ImageView)
    ImageView imageView;
    @BindView(R.id.ready)
    ImageView readyImage;
    @BindView(R.id.play)
    ImageButton playButton;
    @BindView(R.id.happy)
    Button happyButton;
    @BindView(R.id.sad)
    Button sadButton;
    @BindView(R.id.angry)
    Button angryButton;
    @BindView(R.id.fear)
    Button fearButton;
    @BindView(R.id.disgust)
    Button disgustButton;
    @BindView(R.id.surprise)
    Button surpriseButton;

    private ImageData imageData;
    private Result resultData;
    private double startTime;
    private int playIndex = 0;
    private PlayList playList;
    private boolean isBreakTime = false;
    private int[] readyTimeSet = {500, 1000, 1500};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        imageData = new ImageData();
        String mode = getIntent().getExtras().getString("mode");
        playList = new PlayList(mode);
        resultData = new Result();
    }

    private void play() {
        if (playIndex == (playList.getPlayList().size()) && isBreakTime) {
            resultData.saveResultFile();
            message.setText("");
            new FinishDialog(this).show();
            imageView.setVisibility(View.GONE);
            playButton.setVisibility(View.VISIBLE);
            return;
        }

        if (playIndex == (playList.getPlayList().size() / 2) && !isBreakTime) {
            message.setText(getString(R.string.press_play_button).toString());
            new AlertDialog(this, getString(R.string.breaktime).toString()).show();
            isBreakTime = true;
            imageView.setVisibility(View.GONE);
            playButton.setVisibility(View.VISIBLE);
            return;
        }

        if (playIndex != playList.getPlayList().size()) {
            happyButton.setEnabled(false);
            sadButton.setEnabled(false);
            angryButton.setEnabled(false);
            fearButton.setEnabled(false);
            disgustButton.setEnabled(false);
            surpriseButton.setEnabled(false);

            message.setText(getString(R.string.how_to_test).toString());
            imageView.setVisibility(View.INVISIBLE);
            readyImage.setVisibility(View.VISIBLE);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    happyButton.setEnabled(true);
                    sadButton.setEnabled(true);
                    angryButton.setEnabled(true);
                    fearButton.setEnabled(true);
                    disgustButton.setEnabled(true);
                    surpriseButton.setEnabled(true);
                    readyImage.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    Drawable image = (BitmapDrawable) getResources().getDrawable(imageData.get(playList.getPlayList().get(playIndex)));
                    imageView.setImageDrawable(image);
                    resultData.addInfo(playIndex + 1, playList.getPlayList().get(playIndex));
                    playIndex++;
                    startTime = System.nanoTime();
                }
            }, readyTimeSet[new Random().nextInt(2)]);
        }
    }


    @OnClick(R.id.play)
    void start() {
        playButton.setVisibility(View.GONE);
        happyButton.setEnabled(true);
        sadButton.setEnabled(true);
        angryButton.setEnabled(true);
        fearButton.setEnabled(true);
        disgustButton.setEnabled(true);
        surpriseButton.setEnabled(true);
        play();
    }

    @OnClick(R.id.happy)
    void happy() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("HAPPY", time);
        play();
    }

    @OnClick(R.id.sad)
    void sad() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("SAD", time);
        play();
    }

    @OnClick(R.id.angry)
    void angry() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("ANGRY", time);
        play();
    }

    @OnClick(R.id.fear)
    void fear() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("FEAR", time);
        play();
    }

    @OnClick(R.id.disgust)
    void disgust() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("DISGUST", time);
        play();
    }

    @OnClick(R.id.surprise)
    void surprise() {
        double time = (System.nanoTime() - startTime) / 1E9;
        resultData.addData("SURPRISE", time);
        play();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, getString(R.string.give_up).toString(), Toast.LENGTH_LONG).show();
        resultData.saveResultFile();
        finish();
    }
}

