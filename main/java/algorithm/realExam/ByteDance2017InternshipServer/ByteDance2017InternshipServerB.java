package algorithm.realExam.ByteDance2017InternshipServer;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 【木棒拼图】
 * <p>
 * 有一个由很多木棒构成的集合，每个木棒有对应的长度，请问能否用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0 的简单多边形且所有木棒都要用上，简单多边形即不会自交的多边形。
 * <p>
 * 初始集合是空的，有两种操作，要么给集合添加一个长度为 L 的木棒，要么删去集合中已经有的某个木棒。每次操作结束后你都需要告知是否能用集合中的这些木棒构成一个简单多边形。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n 表示操作的数量(1 ≤ n ≤ 50000) ， 接下来有n行，每行第一个整数为操作类型 i (i ∈ {1,2})，第二个整数为一个长度 L(1 ≤ L ≤ 1,000,000,000)。如果 i=1 代表在集合内插入一个长度为 L 的木棒，如果 i=2 代表删去在集合内的一根长度为 L 的木棒。输入数据保证删除时集合中必定存在长度为 L 的木棒，且任意操作后集合都是非空的。
 * <p>
 * <p>
 * 输出描述:
 * 对于每一次操作结束有一次输出，如果集合内的木棒可以构成简单多边形，输出 "Yes" ，否则输出 "No"。
 * <p>
 * <p>
 * 输入例子1:
 * 5
 * 1 1
 * 1 1
 * 1 1
 * 2 1
 * 1 2
 * <p>
 * 输出例子1:
 * No
 * No
 * Yes
 * No
 * No
 *
 * @author: 小栗旬
 * @Date: 2019/10/29 10:22
 */
public class ByteDance2017InternshipServerB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ops = new int[n][2];
        for (int i = 0; i < n; i++) {
            ops[i][0] = scanner.nextInt();
            ops[i][1] = scanner.nextInt();
        }

        int maxLength = 0;
        int restLength = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);


        for (int i = 0; i < n; i++) {
            if (ops[i][0] == 1) {
                queue.add(ops[i][1]);
                if (ops[i][1] > maxLength) {
                    restLength += maxLength;
                    maxLength = ops[i][1];
                } else {
                    restLength += ops[i][1];
                }
            } else {
                queue.remove(ops[i][1]);
                if (ops[i][1] == maxLength) {
                    maxLength = queue.peek();
                    restLength -= maxLength;
                } else {
                    restLength -= ops[i][1];
                }
            }
            if (restLength > maxLength) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
