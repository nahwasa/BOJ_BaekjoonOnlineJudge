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
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] arrTmp = arr.clone();
		
		StringBuilder sb = new StringBuilder();
		arr = searchForwardAndSwap(searchForwardAndSwap(arr, N, sb), N, sb);
		boolean chk = true;
		for (int i = 1; i <= N; i++) {
			if (arr[i] != i) {
				chk = false;
				break;
			}
		}
		if (chk) {
			bw.write(sb.toString());
			bw.flush();
			return;
		}
		
		sb = new StringBuilder();
		searchForwardAndSwap(searchBackwardAndSwap(arrTmp, N, sb), N, sb);		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int[] searchForwardAndSwap(int[] arr, int N, StringBuilder sb) throws IOException {
		// search range
		int s = -1, e = -1;
		for (int i = 1; i <= N; i++) {
			if (s==-1 && arr[i]!=i) {
				s = i;
				continue;
			}
			if (s!=-1 && arr[i]==s) {
				e = i;
				break;
			}
		}
		if (s == -1) {	// 이미 정렬 완료상태
			sb.append("1 1\n");
			return arr;
		}
		// print
		sb.append(String.format("%d %d\n", s, e));
		// swap
		int[] tmp = arr.clone();		
		int m = (e-s)/2;
		for (int i = 0; i <= m; i++) {
			tmp[s+i] = arr[e-i];
			tmp[e-i] = arr[s+i];
		}
		return tmp;		
	}
	
	private static int[] searchBackwardAndSwap(int[] arr, int N, StringBuilder sb) throws IOException {
		// search range
		int s = -1, e = -1;
		for (int i = N; i >= 1; i--) {
			if (e==-1 && arr[i]!=i) {
				e = i;
				continue;
			}
			if (e!=-1 && arr[i]==e) {
				s = i;
				break;
			}
		}
		if (e == -1) {	// 이미 정렬 완료상태
			sb.append("1 1\n");
			return arr;
		}
		// print
		sb.append(String.format("%d %d\n", s, e));
		// swap
		int[] tmp = arr.clone();		
		int m = (e-s)/2;
		for (int i = 0; i <= m; i++) {
			tmp[s+i] = arr[e-i];
			tmp[e-i] = arr[s+i];
		}
		return tmp;		
	}
}
