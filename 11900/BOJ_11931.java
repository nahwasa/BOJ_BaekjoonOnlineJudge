import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		while (N-->0)
			arr[N] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		for (int i = arr.length-1; i>=0; i--)
			bw.write(String.format("%d\n", arr[i]));
		bw.flush();
		bw.close();
		br.close();
	}
}
