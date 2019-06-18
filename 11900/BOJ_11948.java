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
		int[] arr = new int[] {
				Integer.parseInt(br.readLine())
				,Integer.parseInt(br.readLine())
				,Integer.parseInt(br.readLine())
				,Integer.parseInt(br.readLine())
		};
		int E = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int sum = arr[1]+arr[2]+arr[3]+(E>F?E:F);
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
