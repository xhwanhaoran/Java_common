package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/19 18:01
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 */
public class Fibonacci {
	public int Fibonacci(int n) {
		if (n==0){
			return 0;
		}
		if (n==1){
			return 1;
		}
		return Fibonacci(n-2)+Fibonacci(n-1);
	}

	public static void main(String[] args) {
		Fibonacci solution = new Fibonacci();
		System.out.println(solution.Fibonacci(4));
	}
}
