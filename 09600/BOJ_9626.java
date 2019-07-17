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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N+U+D][M+L+R];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (((i+j)&1)==0) arr[i][j] = '#';
				else arr[i][j] = '.';
			}
		}
		for (int i = U; i < N+U; i++) {
			String s = br.readLine();
			for (int j = L; j < M+L; j++) {
				arr[i][j] = s.charAt(j-L);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			String tmp = "";
			for (int j = 0; j < arr[0].length; j++) {
				tmp += arr[i][j];
			}
			bw.write(tmp + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
