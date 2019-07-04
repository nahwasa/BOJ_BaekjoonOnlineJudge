import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		initScore(hm);
		int curScore = 0;
		int maxScore = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i))) curScore+=hm.get(s.charAt(i));
			else if (curScore>maxScore) maxScore=curScore;
		}
		bw.write(maxScore+"\n");	
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void initScore(HashMap<Character, Integer> hm) {
		hm.put('[', 3);
		hm.put('{', 2);
		hm.put('(', 1);
		hm.put(']', -3);
		hm.put('}', -2);
		hm.put(')', -1);
	}
}
