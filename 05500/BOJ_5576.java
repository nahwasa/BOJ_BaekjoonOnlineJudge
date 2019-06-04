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

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		bw.write((arr[7] + arr[8] + arr[9]) + "");
		
		arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		bw.write(" " + (arr[7] + arr[8] + arr[9]) + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
