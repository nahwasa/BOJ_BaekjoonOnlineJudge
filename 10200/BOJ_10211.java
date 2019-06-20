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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if (arr[i] <= 0) {max=max<arr[i]?arr[i]:max;  continue;}
				int sum = arr[i];
				max=max<arr[i]?arr[i]:max;
				for (int j = i+1; j < N; j++) {					
					sum += arr[j];
					if (sum < 0) {i = j; break;}
					max=sum>max?sum:max;
				}
			}
			bw.write(max + "\n");
		}	
		bw.flush();
		br.close();
		bw.close();		
	}
}
