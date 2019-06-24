import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			int num = getNum(br.readLine());
			if (sb.length() == 0 && num == 0) continue;
			sb.append(String.valueOf(num));
		}
		int num = getNum(br.readLine());
		for (int i = 0; i < num; i++)
			if (sb.length()!=0)
				sb.append("0");
		bw.write(sb.length()==0?"0":sb.toString() + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static int getNum(String s) {
		String[] res = new String[] {
				"black",
				"brown",
				"red",
				"orange",
				"yellow",
				"green",
				"blue",
				"violet",
				"grey",
				"white"
		};
		for (int i = 0; i < res.length; i++)
			if (s.equals(res[i])) return i;
		return -1;
	}
}
