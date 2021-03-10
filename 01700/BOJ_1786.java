import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringBuilder sb = new StringBuilder();
	private static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		String base = br.readLine();
		String target = br.readLine();
		kmp(base, target);
		bw.write(String.format("%d\n%s", cnt, sb.toString()));
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int[] getPi(String target) {
		int j = 0;
		int[] pi = new int[target.length()];
		for (int i = 1; i < target.length(); i++) {
			while (j > 0 && target.charAt(i) != target.charAt(j))
				j = pi[j-1];
			
			if (target.charAt(i) == target.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
	
	private static void kmp(String base, String target) {
		int[] pi = getPi(target);
		int j = 0;
		for (int i = 0; i < base.length(); i++) {
			while (j > 0 && base.charAt(i) != target.charAt(j))
				j = pi[j-1];
			
			if (base.charAt(i) == target.charAt(j)) {
				if (j != target.length()-1) {
					j++;
					continue;
				}
				
				sb.append(i-target.length()+1+1);
				sb.append(" ");
				cnt++;
				j = pi[j];
			}
		}
	}
}
