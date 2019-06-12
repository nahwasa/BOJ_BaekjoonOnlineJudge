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
		int EGG = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int max = 0;
		int maxPrice = 0;
		for (int i = N-EGG<=0?0:N-EGG; i < arr.length; i++) {
			int tmp = arr[i] * (arr.length-i);
			if (tmp > max) {
				max = tmp;
				maxPrice = arr[i];
			}
		}
		bw.write(String.format("%d %d\n", maxPrice, max));
		bw.flush();
		br.close();
		bw.close();		
	}
}
