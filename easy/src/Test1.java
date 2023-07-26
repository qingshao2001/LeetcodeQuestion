/**
 * 题目描述：给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
 *
 * 暴力枚举法运行时间，占用内存么有多大差别，理论上第一种应该比第二种慢，实际上却是第二种慢。复杂度O(n²)
 * 第二种方法以空间换时间，使用哈希表中值不能重复来计算，可以减少一层循环，复杂度O(n)。这个方法大大提高了速度，提高了四倍。
 * HashMap中键值相同时会更新，键值对。但是，题目的要求中，只需写出一个就行了。
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    /*
    我写的枚举算法:
    public int[] twoSum(int[] nums, int target) {

        int m = 0;
        int n = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    m=i;
                    n=j;
                    break;
                }
            }
        }
        int[] index = {m, n};
        return index;
    }
    */

    /*
    官方写的暴力枚举:
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
    */

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[]{hashMap.get(num), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] nums = {2, 2,7, 11, 15};
        System.out.println(Arrays.toString(test1.twoSum(nums, 9)));

    }
}
