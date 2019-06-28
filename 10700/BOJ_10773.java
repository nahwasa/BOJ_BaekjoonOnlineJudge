import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int idx = 0;
		while (N-->0) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) idx--;
			else arr[idx++]=tmp;
		}
		int sum = 0;
		for(int i = 0; i < idx; i++)
			sum+=arr[i];
		bw.write(sum+"\n");
		bw.flush();		
		bw.close();
		br.close();
	}
}
