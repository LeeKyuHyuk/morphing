# Morphing
### Summary

정서 판단 속도 테스트를 위해 만들어진 안드로이드 애플리케이션입니다.

10.1인치 태블릿에서 정상 작동합니다.

[한양대학교 HCI 연구실](http://kennylab.hanyang.ac.kr/)

### Usage
- /sdcard/Morphing : Morphing에서 생성된 데이터가 저장되는 폴더입니다.
- /sdcard/Morphing/Result : Morphing 실험을 한 사람의 데이터가 파일로 저장됩니다.

`(순번)   (이미지명)  (선택한 정서)    (판단 시간)`

```
(1) m12h        HAPPY 11.46607806
(2) f4sa        ANGRY 6.14014099
(3) m11a        SAD 1.28239427
(4) f2f ANGRY 0.54563963
(5) f8d HAPPY 0.40451792
(6) m8su        DISGUST 0.38693746
```
- /sdcard/Morphing/mainTrial_list1.txt : 검사1의 재생목록 파일입니다.
- /sdcard/Morphing/mainTrial_list2.txt : 검사2의 재생목록 파일입니다.
- /sdcard/Morphing/practice_list.txt : 연습 검사의 재생목록 파일입니다.
삭제버튼 재생 목록 파일은 정서 이미지 파일명을 입력해 놓으면 됩니다.

> 정서 이미지는 [app/src/main/res/drawable](https://github.com/LeeKyuHyuk/morphing/tree/master/app/src/main/res/drawable)에 있습니다.

```
m12h
f4sa
m11a
f2f
f8d
m8su
```

### Screenshot

![Screenshot 1](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_1.png)

![Screenshot 2](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_2.png)

![Screenshot 3](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_3.png)

![Screenshot 4](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_4.png)

![Screenshot 5](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_5.png)

![Screenshot 6](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_6.png)

![Screenshot 7](https://raw.github.com/LeeKyuHyuk/morphing/master/screenshot/screenshot_7.png)
