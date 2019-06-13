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
		
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			bw.write(String.valueOf(arr[7]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
