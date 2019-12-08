package algorithm.leetcode;

/**
 * 【编辑距离】
 * <p>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 14:43
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];
        int last = 0;
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < m; i++) {
            last = dp[0];
            dp[0] = i + 1;
            for (int j = 1; j < n + 1; j++) {
                int tempLast = dp[j];
                if (word1.charAt(i) == word2.charAt(j-1)) {
                    dp[j] = Math.min(last, Math.min(dp[j], dp[j - 1]) + 1);
                } else {
                    dp[j] = Math.min(last + 1, Math.min(dp[j], dp[j - 1]) + 1);
                }
                last = tempLast;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode72 solution = new LeetCode72();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("intention", "execution"));
        System.out.println(solution.minDistance("intention", "intention"));
        System.out.println(solution.minDistance("", "intention"));
    }
}
