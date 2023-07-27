/**
 * 题目描述:给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 方法一:当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
 * 方法二:采用了数组导致效率变低了，其实内存消耗并不大,是速度降低了百分之二十左右。
 * 这里我还知道了如果数组只是简单的相等，他们俩操作的其实是一块内存空间，必须要重新开辟内存空间，可以使用copeOf函数
 */
public class Test2 {
    public boolean isPalindrome01(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }


    public boolean isPalindrome02(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String numberStr = Integer.toString(x);
        char[] charArray = numberStr.toCharArray();
//      char[] flagArray = charArray;
//      char[] flagArray = Arrays.copyOf(charArray, charArray.length);
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
             return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.isPalindrome01(131));
        System.out.println(test2.isPalindrome02(131));
    }


}

















