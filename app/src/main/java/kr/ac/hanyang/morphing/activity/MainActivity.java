package kr.ac.hanyang.morphing.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.ac.hanyang.morphing.Config;
import kr.ac.hanyang.morphing.R;
import kr.ac.hanyang.morphing.dialog.AlertDialog;
import kr.ac.hanyang.morphing.dialog.InputDialog;
import kr.ac.hanyang.morphing.io.GeneratePlayList;

/**
 * InputDialog로부터 사용자의 이름을 받아 USER_NAME에 저장합니다.
 * SD Card에 데이터 폴더와 재생목록 파일들이 있는지 확인합니다.
 * 만약 데이터 폴더가 없을경우 생성하며, 재생목록 파일이 없다면 자동으로 생성합니다.
 */

public class MainActivity extends Activity implements OnDismissListener, OnKeyListener {
    @BindView(R.id.usernameTextView)
    TextView usernameTextView;

    private Intent startTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startTest = new Intent(this, PlayActivity.class);
        showUsernameInputDialog();
    }

    private void isPlayListFile() {
        ArrayList<String> playlistName = new ArrayList<String>();
        String msg = "";
        boolean isCreateFile = false;

        if (!new File(Config.DATA_PATH).exists())
            new File(Config.DATA_PATH).mkdir();

        if (!new File(Config.DATA_PATH + "/" + "Result").exists())
            new File(Config.DATA_PATH + "/" + "Result").mkdir();

        if (!new File(Config.DATA_PATH + "/" + "practice_list.txt").exists()) {
            playlistName.add(getString(R.string.practice).toString());
            new GeneratePlayList(this, "practice_list.txt");
            isCreateFile = true;
        }

        if (!new File(Config.DATA_PATH + "/" + "mainTrial_list1.txt").exists()) {
            playlistName.add(getString(R.string.mainTrial1).toString());
            new GeneratePlayList(this, "mainTrial_list1.txt");
            isCreateFile = true;
        }

        if (!new File(Config.DATA_PATH + "/" + "mainTrial_list2.txt").exists()) {
            playlistName.add(getString(R.string.mainTrial2).toString());
            new GeneratePlayList(this, "mainTrial_list2.txt");
            isCreateFile = true;
        }

        if (isCreateFile) {
            for (int i = 0; i < playlistName.size(); i++) {
                if (i != playlistName.size() - 1)
                    msg += "'" + playlistName.get(i) + "', ";
                else
                    msg += "'" + playlistName.get(i) + "'";
            }
            alert(msg + getString(R.string.create_playlist).toString());
        }
    }

    private void alert(String msg) {
        new AlertDialog(this, msg).show();
    }

    private void showUsernameInputDialog() {
        InputDialog usernameInputDialog = new InputDialog(this);
        usernameInputDialog.setOnDismissListener(this);
        usernameInputDialog.setOnKeyListener(this);
        usernameInputDialog.show();
    }

    private void saveUserName() {
        String startTestStr = getString(R.string.start_test_prefix).toString() + Config.USER_NAME + getString(R.string.start_test_suffix).toString();
        Toast.makeText(MainActivity.this, startTestStr, Toast.LENGTH_LONG).show();
        usernameTextView.setText(Config.USER_NAME);
        findViewById(R.id.sir).setVisibility(View.VISIBLE);
        isPlayListFile();
    }

    @OnClick(R.id.practice)
    void practice() {
        startTest.putExtra("mode", "practice");
        startActivity(startTest);
    }

    @OnClick(R.id.mainTrial1)
    void mainTrial1() {
        startTest.putExtra("mode", "mainTrial1");
        startActivity(startTest);
    }

    @OnClick(R.id.mainTrial2)
    void mainTrial2() {
        startTest.putExtra("mode", "mainTrial2");
        startActivity(startTest);
    }

    @Override
    public void onDismiss(DialogInterface inputDialog) {
        InputDialog dialog = (InputDialog) inputDialog;
        String name = dialog.getName();
        Config.USER_NAME = name;
        saveUserName();
    }

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(MainActivity.this, getString(R.string.need_your_name).toString(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, SplashActivity.class));
            finish();
            dialog.dismiss();
        }
        return false;
    }
}
