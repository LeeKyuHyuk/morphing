package kr.ac.hanyang.morphing;

import android.os.Environment;

/**
 * 설정값들을 저장하는 클래스:
 * Morphing의 데이터가 저장되는 위치와 사용자 이름을 저장합니다.
 */

public class Config {
    public static String DATA_PATH = Environment.getExternalStorageDirectory() + "/Morphing";
    public static String USER_NAME;
}
