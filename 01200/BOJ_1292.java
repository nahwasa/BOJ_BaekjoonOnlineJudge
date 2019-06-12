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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[b+1];
		int idx = 1;
		for (int i = 1; ;i++) {
			for (int j = 0; j < i; j++) {
				arr[idx++] = i;
				if (idx == arr.length) break;
			}
			if (idx == arr.length) break;
		}
		int sum = 0;
		for (int i = a; i <= b; i++)
			sum += arr[i];
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
