import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = new String[] {
				"ABC","BABC","CCAABB"
		};
		int[] cnt = new int[3];
		int N = Integer.parseInt(br.readLine());
		String in = br.readLine();
		for (int i = 0; i < N; i++) {
			char tmp = in.charAt(i);
			if (str[0].charAt(i%str[0].length()) == tmp)	cnt[0]++;
			if (str[1].charAt(i%str[1].length()) == tmp)	cnt[1]++;
			if (str[2].charAt(i%str[2].length()) == tmp)	cnt[2]++;
		}
		int max = -1;
		String result = "";
		for (int i = 0; i < 3; i++) {
			if (cnt[i] >= max) {
				if (cnt[i] > max)
					result = "";
				result += getName(i);
				max = cnt[i];
			}
		}
		bw.write(String.format("%d\n%s\n", max, result));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static String getName(int idx) {
		switch (idx) {
		case 0 : return "Adrian\n";
		case 1 : return "Bruno\n";
		case 2 : return "Goran\n";
		}
		return null;
	}
}
