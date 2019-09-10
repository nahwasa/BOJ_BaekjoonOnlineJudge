import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[] arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)
			arr[i] = st.nextToken().charAt(0);
		Arrays.sort(arr);
		LinkedList<Character> ll = new LinkedList<Character>();
		completeSearch(arr, N, ll, -1);		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void completeSearch(char[] arr, int N, LinkedList<Character> ll, int idx) throws IOException {
		if (ll.size() == N) {
			StringBuilder sb = new StringBuilder();
			int mCnt = 0;
			int jCnt = 0;
			for (char c : ll) {
				switch (c) {
				case 'a' : case 'e' : case 'i' : case 'o' : case 'u' :
					mCnt++;
					break;
				default :
					jCnt++;
					break;
				}
				sb.append(c);
			}
			if (mCnt >= 1 && jCnt >= 2)
				bw.write(sb.toString() + "\n");
			return;
		}
		for (int i = idx+1; i < arr.length; i++) {
			ll.addLast(arr[i]);
			completeSearch(arr, N, ll, i);
			ll.removeLast();
		}
	}
}
