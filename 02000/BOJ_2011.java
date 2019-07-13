import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {		
	private static final long MOD_VAL = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		long[] dp = new long[s.length()];
		if (s.length()==1) {
			bw.write(s.charAt(0)=='0'?"0\n":"1\n");
			bw.flush();
			return;
		} if (s.length()>1 && s.charAt(0)=='0') {
			bw.write("0\n");
			bw.flush();
			return;
		}
		dp[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i)=='0') {
				if (!isValid(s.charAt(i-1), s.charAt(i))) {
					bw.write("0\n");
					bw.flush();
					return;
				}
				if (i==1)
					dp[i]=1;
				else
					dp[i] = dp[i-2];
				continue;
			}
			dp[i] = dp[i-1];
			if (isValid(s.charAt(i-1), s.charAt(i))) {
				if (i==1) dp[i]=2;
				else dp[i] = (dp[i] + dp[i-2]) % MOD_VAL;
			}
		}		
		bw.write(dp[s.length()-1] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static boolean isValid(char c1, char c2) {
		int tmp = (c1-'0')*10;
		tmp += (c2-'0');
		if (tmp>=10&&tmp<=26) 
			return true;
		return false;
	}
}
