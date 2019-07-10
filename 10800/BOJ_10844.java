import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	private static final int MOD_VAL = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		long[] cnt = new long[10];
		for (int i = 1; i < 10; i++)
			cnt[i] = 1;
		for (int i = 2; i <= N; i++) {
			long[] tmp = new long[10];
			for (int j = 0; j < cnt.length; j++) {
				switch (j) {
				case 0 : tmp[1]=(tmp[1]+cnt[0]) % MOD_VAL; break;
				case 9 : tmp[8]=(tmp[8]+cnt[9]) % MOD_VAL; break;
				default : tmp[j-1]=(tmp[j-1]+cnt[j]) % MOD_VAL;
					      tmp[j+1]=(tmp[j+1]+cnt[j]) % MOD_VAL;
				}
			}
			cnt = tmp;
		}
		long sum = 0;
		for(int i = 0; i < 10; i++)		
			sum=(sum+cnt[i])%MOD_VAL;			
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
