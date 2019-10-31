package algorithm.realExam.Tecent2018Spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【安排机器】
 * <p>
 * 小Q的公司最近接到m个任务, 第i个任务需要xi的时间去完成, 难度等级为yi。
 * 小Q拥有n台机器, 每台机器最长工作时间zi, 机器等级wi。
 * 对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间, 则不能完成,如果完成这个任务将获得200 * xi + 3 * yi收益。
 * <p>
 * 对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。
 * <p>
 * 小Q想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括N + M + 1行,
 * 输入的第一行为两个正整数n和m(1 <= n, m <= 100000), 表示机器的数量和任务的数量。
 * 接下来n行,每行两个整数zi和wi(0 < zi < 1000, 0 <= wi <= 100), 表示每台机器的最大工作时间和机器等级。
 * 接下来的m行,每行两个整数xi和yi(0 < xi < 1000, 0 <= yi<= 100), 表示每个任务需要的完成时间和任务的难度等级。
 * <p>
 * 输出描述:
 * 输出两个整数, 分别表示最大能完成的任务数量和获取的收益。
 * <p>
 * 输入例子1:
 * 1 2
 * 100 3
 * 100 2
 * 100 1
 * <p>
 * 输出例子1:
 * 1 20006
 *
 * @author: 小栗旬
 * @Date: 2019/10/30 20:13
 */
public class Tecent2018SpringE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Machine[] machines = new Machine[n];
        Work[] works = new Work[m];
        for (int i = 0; i < n; i++) {
            machines[i] = new Machine(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            works[i] = new Work(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(works, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.level - o1.level;
            } else {
                return o2.time - o1.time;
            }
        });
        Arrays.sort(machines, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.level - o1.level;
            } else {
                return o2.time - o1.time;
            }
        });
        long res = 0;
        int workCount = 0;
        int machineIndex = 0;
        //dp存放当前满足time条件的level情况
        int[] dp = new int[101];
        for (int i = 0; i < m; i++) {
            Work work = works[i];
            // 将所有符合当前work的time要求放入dp当中，因为machines是按照时间排序的，所以machine从前往后遍历是否满足条件即可
            while (machineIndex < n && machines[machineIndex].time >= work.time) {
                dp[machines[machineIndex].level]++;
                machineIndex++;
            }
            for (int k = work.level; k < 101; k++) {
                if (dp[k] != 0) {
                    dp[k]--;
                    workCount++;
                    res+= work.value;
                    break;
                }
            }
        }
        System.out.println(workCount + " " + res);
    }
}

class Machine {
    int time;
    int level;
    boolean used;
    int value;

    public Machine(int time, int level) {
        this.time = time;
        this.level = level;
        this.value = 200 * time + 3 * level;
    }
}

class Work {
    int time;
    int level;
    boolean done;
    int value;

    public Work(int time, int level) {
        this.time = time;
        this.level = level;
        this.value = 200 * time + 3 * level;
    }
}