import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int[] arr = new int[50];
		int num = 3;
		arr[0] = 1;
		for (int i = 1; i < 50; i++) {
			arr[i] = arr[i-1] + num;
			num+=2;
		}
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			bw.write(arr[Integer.parseInt(br.readLine())/2] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
