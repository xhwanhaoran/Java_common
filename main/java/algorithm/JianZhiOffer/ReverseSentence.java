package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/7 22:33
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
	public String ReverseSentence(String str) {
		if ("".equals(str.trim())){
			return str;
		}
		String[] strings = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = strings.length-1;i>=0;i--){
			sb.append(strings[i]);
			if (i!=0){
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		ReverseSentence solution = new ReverseSentence();
		System.out.println(solution.ReverseSentence(" "));
	}
}
