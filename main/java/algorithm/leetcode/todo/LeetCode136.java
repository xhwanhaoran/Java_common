package algorithm.leetcode.todo;

/**
 * 【只出现一次的数字】
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/single-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 小栗旬
 * @Date: 2020/1/4 19:49
 */
public class LeetCode136 {
    /* 所有的数字除了我们要找的那个 都出现了两次 两个相同的数字有什么性质 */

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num:nums){
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode136 solution = new LeetCode136();
        System.out.println(solution.singleNumber(new int[]{1, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
        System.out.println(solution.singleNumber(new int[]{1}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
