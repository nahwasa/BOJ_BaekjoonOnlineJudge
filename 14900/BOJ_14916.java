import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] cnt = new int[100001];
		int N = Integer.parseInt(br.readLine());
		cnt[2]=1;
		cnt[4]=2;
		cnt[5]=1;
		for (int i = 6; i <= 100000; i++) {
			int tmp1 = cnt[i-2];
			int tmp2 = cnt[i-5];
			if (tmp1==0 && tmp2==0)
				continue;
			else if (tmp1==0)
				cnt[i] = tmp2+1;
			else if (tmp2==0)
				cnt[i] = tmp1+1;
			else
				cnt[i] = Math.min(tmp1, tmp2) + 1;
		}
		bw.write(cnt[N]==0?"-1\n":cnt[N]+"\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
