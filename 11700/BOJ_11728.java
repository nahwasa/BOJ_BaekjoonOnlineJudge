import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+M];
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		while (N-->0) arr[idx++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (M-->0) arr[idx++] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int tmp : arr) { sb.append(tmp); sb.append(" "); }
		bw.write(sb.toString());
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();		
	}
}
