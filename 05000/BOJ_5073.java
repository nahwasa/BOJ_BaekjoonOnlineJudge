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
			String s = br.readLine();
			if (s.equals("0 0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.parallelSort(arr);
			if(arr[2] >= arr[0] + arr[1]) {
				bw.write("Invalid\n");
				continue;
			}
			if(arr[2]==arr[1] && arr[1]==arr[0]) {
				bw.write("Equilateral\n");
				continue;
			}
			if(arr[2]==arr[1] || arr[1]==arr[0] || arr[0]==arr[2]) {
				bw.write("Isosceles\n");
				continue;
			}
			bw.write("Scalene\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}	
}
