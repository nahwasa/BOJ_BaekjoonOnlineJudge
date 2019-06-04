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

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[0] == 0)
				break;
			
			Arrays.sort(arr);
			
			if ((double)arr[2] == Math.sqrt(arr[0]*arr[0] + arr[1]*arr[1]))
				bw.write("right\n");
			else
				bw.write("wrong\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
