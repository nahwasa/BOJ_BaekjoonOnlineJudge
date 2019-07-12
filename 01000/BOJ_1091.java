import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	private static final int MAX_TRY = 150000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dst = new int[N];		
		int[] shuffle = new int[N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dst[i] = Integer.parseInt(st.nextToken());
			arr[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			shuffle[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		if (isValidDeck(arr, dst)) {
			bw.write("0\n");
			bw.flush();
			return;
		}
		int tryCnt = MAX_TRY;
		while(tryCnt-->0) {			
			int[] tmp = new int[N];
			for (int i = 0; i < N; i++) {
				tmp[shuffle[i]]=arr[i];
			}						
			cnt++;
			if (isValidDeck(tmp, dst)) {
				bw.write(cnt +"\n");
				bw.flush();
				return;
			}
			arr = tmp;			
		}
		bw.write("-1\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static boolean isValidDeck(int[] card, int[] dst) {
		for (int i = 0; i < card.length; i++)
			if (i%3!=dst[card[i]]) return false;
		return true;
	}
}
