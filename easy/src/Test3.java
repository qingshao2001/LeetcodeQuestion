/**
 * 題目描述:罗马数字转换为十进制阿拉伯数字
 * 官方解法和我的解法基本一致,直接用字符串，而我是将他变味了字符数组。速度和内存消耗没有多大区别。
 * 看到其他写法可以把HashMap改为Switch，可以大大提高速度。
 * 而提前做一个缓存也是可以提高速度的
 * 遍历字符串并将对应的值缓存起来
 *    int[] values = new int[len];
 *    for (int i = 0; i < len; i++) {
 *        values[i] = hashMap.get(s.charAt(i));
 *    }
 */

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public int romanToInt(String s) {
//        char[] charArray = s.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>(7);
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int num = 0;
        int len = s.length() - 1;
        for (int i = 0; i < len; i++) {
            if (hashMap.get(s.charAt(i)) >= hashMap.get(s.charAt(i + 1))) {
                num += hashMap.get(s.charAt(i));
            } else {
                num -= hashMap.get(s.charAt(i));

            }
        }
       /*
        int len = charArray.length - 1;
        for (int i = 0; i < len ; i++) {
            if (hashMap.get(charArray[i]) >= hashMap.get(charArray[i + 1])) {
                num = num + hashMap.get(charArray[i]);
            } else {
                num = num - hashMap.get(charArray[i]);
            }
        }
        */
        return num + hashMap.get(s.charAt(len));
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.romanToInt("III"));
    }
}
