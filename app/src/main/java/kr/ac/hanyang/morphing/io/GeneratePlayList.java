package kr.ac.hanyang.morphing.io;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.hanyang.morphing.Config;
import kr.ac.hanyang.morphing.R;

/**
 * 재생목록 파일을 생성합니다.
 */

public class GeneratePlayList {
    public GeneratePlayList(Context context, String filename) {
        File playlistFile = new File(Config.DATA_PATH + "/" + filename);
        FileOutputStream fos;
        String[] data;

        if (filename.equals("practice_list.txt"))
            data = context.getResources().getStringArray(R.array.practice_list);
        else if (filename.equals("mainTrial_list1.txt"))
            data = context.getResources().getStringArray(R.array.mainTrial_list1);
        else
            data = context.getResources().getStringArray(R.array.mainTrial_list2);

        try {
            fos = new FileOutputStream(playlistFile);
            for (int i = 0; i < data.length; i++)
                fos.write((data[i] + "\n").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
