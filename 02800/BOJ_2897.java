import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		String[] arr = new String[x];
		int[] cnt = new int[5];
		
		for (int i = 0; i < x; i++) {	// input
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < x-1; i++) {
			for (int j = 0; j < y-1; j++) {				
				int tmp = checkForP(new char[] {arr[i].charAt(j), arr[i].charAt(j+1), arr[i+1].charAt(j), arr[i+1].charAt(j+1)});
				if (tmp != -1)
					cnt[tmp]++;				
			}
		}
		
		for (int i = 0; i < cnt.length; i++)
			bw.write(cnt[i] + "\n");
		
		
		bw.flush();		
		bw.close();
		br.close();
	}

	private static int checkForP(char[] cs) {
		int cnt = 0;
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '#')
				return -1;
			if (cs[i] == 'X')
				cnt++;
		}
		return cnt;
	}
}	
