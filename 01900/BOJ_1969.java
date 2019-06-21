import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[M][4];	// 각 자리수에 대한 A,C,G,T 카운트 (사전순으로 앞서는 순으로)
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				switch(s.charAt(j)) {
				case'A':arr[j][0]++; break;
				case'C':arr[j][1]++; break;
				case'G':arr[j][2]++; break;
				case'T':arr[j][3]++; break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int sum = N * M;
		for (int i = 0; i < M; i++) {	// 각 자리수에 대해
			int max = 0;
			int maxChar = 0;
			for (int j = 0; j < 4; j++) {	// ACGT중 제일 많은문자를 고름(동일하다면 사전순으로 앞서는것)
				if (arr[i][j] > max) {
					max = arr[i][j];
					maxChar = j;
				}
			}
			sum -= max;
			switch(maxChar) {
			case 0:sb.append('A');break;
			case 1:sb.append('C');break;
			case 2:sb.append('G');break;
			case 3:sb.append('T');break;
			}
		}
		bw.write(sb.toString() + "\n");
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
