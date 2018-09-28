package algorithm;

/**
 * Created by andy on 2018/9/26.
 * <p>
 * 观察下面的规律，写一个函数accum
 * accum(“abcd”);    // “A-Bb-Ccc-Dddd”
 * accum(“RqaEzty”); // “R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy”
 * accum(“cwAt”);    // “C-Ww-Aaa-Tttt”
 */
public class Accum {
    public static void main(String[] args) {
        System.out.println(Accum("aBcd"));
        System.out.println(Accum("aBddd333cd"));
        System.out.println(Accum("RqaEzty"));
        System.out.println(Accum("cwAt"));
    }

    public static String Accum(String str) {
        char[] strs = str.toCharArray();
        String Accum = "";
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= i; j++) {
                char a;
                if (isUppercase(strs[i])) {
                    if (j == 0) {
                        Accum = Accum + strs[i];
                        continue;
                    }else {
                        strs[i] = (char) (strs[i] + 32);
                        Accum = Accum + strs[i];
                        continue;
                    }
                } else {
                    if (islowercase(strs[i])) {
                        if(j==0){
                            strs[i] = (char) (strs[i] - 32);
                            Accum = Accum + strs[i];
                            continue;
                        }else {
                            Accum = Accum + strs[i];
                            continue;
                        }
                    } else {
                        return "字符串中有非字母的字符";
                    }
                }
            }
            if(i==strs.length-1){
                return Accum;
            }
            Accum = Accum + "-";
        }
        return Accum;

    }
    private static boolean isUppercase(char c) {
        if ((c >= 'A') && (c <= 'Z')) {
            return true;
        }
        return false;
    }
    private static boolean islowercase(char c) {
        if ((c >= 'a') && (c <= 'z')) {
            return true;
        }
        return false;
    }

}
