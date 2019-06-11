import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		while(N-->0)
			arr[N]=Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		long max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[arr.length-1-i]*(i+1) > max)
				max = arr[arr.length-1-i]*(i+1);
		}
		bw.write(max+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
