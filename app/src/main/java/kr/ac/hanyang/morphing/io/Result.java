package kr.ac.hanyang.morphing.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.hanyang.morphing.Config;

public class Result {
    private int number;
    private String filename;
    private String result = "";

    public void addInfo(int number, String filename) {
        this.number = number;
        this.filename = filename;
    }

    public void addData(String type, double time) {
        result += "(" + number + ") " + filename + "\t" + type + " " + time + "\t\n";
    }

    public void saveResultFile() {
        String path = Config.DATA_PATH + "/Result/";
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        String fileName = Config.USER_NAME + "_" + time + ".txt";
        File file = new File(path + fileName);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write((result).getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
