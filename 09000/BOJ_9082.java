import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		while (tc-->0) {
			br.readLine();	// throw
			cntMine(br.readLine());
			br.readLine();	// throw
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void cntMine(String str) throws Exception {
		int len = str.length();
		if (len <= 2) {
			bw.write(getInt(str, 0));
			return;
		}
		int cnt = 0;
		switch (len % 3) {
		case 0 :
			for (int i = 0; i < len/3; i++)
				cnt += getInt(str, 3*i+1);
			break;
		case 1 :
			cnt += getInt(str, str.length()-1);
		case 2 :
			for (int i = 0; i < (len-2)/3; i++)
				cnt += getInt(str, 3*(i+1));
			cnt += getInt(str, 0);
			break;
		}
		bw.write(cnt + "\n");
	}
	
	private static int getInt(String str, int idx) {
		return str.charAt(idx) - '0';
	}
}
