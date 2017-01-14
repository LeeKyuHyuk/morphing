package kr.ac.hanyang.morphing.io;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kr.ac.hanyang.morphing.Config;

/**
 * 재생목록을 읽어옵니다.
 */
public class PlayList {
    private String playListFile;
    private ArrayList<String> playList;

    public PlayList(String mode) {
        playList = new ArrayList<String>();

        if (mode.equals("practice"))
            playListFile = "practice_list.txt";
        if (mode.equals("mainTrial1"))
            playListFile = "mainTrial_list1.txt";
        if (mode.equals("mainTrial2"))
            playListFile = "mainTrial_list2.txt";

        try {
            FileInputStream playListPath;
            playListPath = new FileInputStream(Config.DATA_PATH + "/" + playListFile);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(playListPath));
            String playFileName;
            while ((playFileName = bufferReader.readLine()) != null)
                playList.add(playFileName);
        } catch (FileNotFoundException e) {
            Log.d("TEST", playListFile + "을 찾지 못했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPlayList() {
        return playList;
    }

}
