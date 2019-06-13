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
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int idx = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] tmp = new int[N];
			while (st.hasMoreTokens()) {
				int t = Integer.parseInt(st.nextToken());
				
				if (idx==0) tmp[idx] = arr[idx] + t;
				else tmp[idx] = (arr[idx-1]>arr[idx]?arr[idx-1]:arr[idx]) + t;
				idx++;
			}			
			arr = tmp;
		}
		int max = -1;
		for(int i : arr) {
			if (i > max)
				max = i;
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
