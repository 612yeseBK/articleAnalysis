package template.util;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class NumberConverter {
    public NumberConverter() {
    }

//    public static void main(String[] args) {
//        System.out.println(convertFromChinese("四千五百元"));
//    }

    public static int convertFromChinese(String chineseNumber) {
        int result = 0;
//        int temp = 1;
//        int count = 0;
//        char[] cnArr = new char[]{'一', '二', '三', '四', '五', '六', '七', '八', '九'};
//        char[] chArr = new char[]{'十', '百', '千', '万', '亿'};
//
//        for(int i = 0; i < chineseNumber.length(); ++i) {
//            boolean b = true;
//            char c = chineseNumber.charAt(i);
//
//            int j;
//            for(j = 0; j < cnArr.length; ++j) {
//                if (c == cnArr[j]) {
//                    if (0 != count) {
//                        result += temp;
//                        int temp = true;
//                        count = 0;
//                    }
//
//                    temp = j + 1;
//                    b = false;
//                    break;
//                }
//            }
//
//            if (b) {
//                for(j = 0; j < chArr.length; ++j) {
//                    if (c == chArr[j]) {
//                        switch(j) {
//                            case 0:
//                                temp *= 10;
//                                break;
//                            case 1:
//                                temp *= 100;
//                                break;
//                            case 2:
//                                temp *= 1000;
//                                break;
//                            case 3:
//                                temp *= 10000;
//                                break;
//                            case 4:
//                                temp *= 100000000;
//                        }
//
//                        ++count;
//                    }
//                }
//            }
//
//            if (i == chineseNumber.length() - 1) {
//                result += temp;
//            }
//        }

        return result;
    }
}

