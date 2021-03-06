package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/29 9:19
 * <p>
 * 【换钱的方法数】
 * 题目描述
 * 给定数组arr，设数组长度为n，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim，代表要找的钱数，求换钱的方法数有多少种。由于方法的种数比较大，所以要求输出对10^9+7进行取模后的答案。
 * <p>
 * 输入描述:
 * 输出包括两行，第一行包括两个整数n(0≤n≤1000)和aim(0≤aim≤20000)。第二行包含n个整数，表示arr数组(1≤arri≤1e9)。
 * 输出描述:
 * 输出一个整数，表示换钱的方法数对10^9+7取模后的答案。
 * <p>
 * 示例1
 * 输入
 * 4 15
 * 5 10 25 1
 * 输出
 * 6
 * 说明
 * 5*3=15
 * <p>
 * 10*1+5*1=15
 * <p>
 * 10*1+1*5=15
 * <p>
 * 1*10+5*1=15
 * <p>
 * 5*2+1*5=15
 * <p>
 * 1*15=15
 * <p>
 * 示例2
 * 输入
 * 5 1000
 * 2 3 5 7 10
 * 输出
 * 20932712
 * 备注:
 * 时间复杂度O(N*aim),空间复杂度O(aim)。
 */
public class CodeInterviewGuide19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int aim = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] dp = new int[aim + 1];

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                if (nums[i] == j) {
                    dp[j] = (1 + dp[j]) % 1000000007;
                } else if (nums[i] < j) {
                    dp[j] = ((dp[j - nums[i]] + dp[j]) % 1000000007);
                }
            }
        }
        System.out.println(dp[aim]);

    }
}
