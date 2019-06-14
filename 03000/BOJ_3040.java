import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				
				int sum = 0;
				for (int k = 0; k < 9; k++)
					if (k!=i&&k!=j) sum+=arr[k];
				if (sum == 100) {
					for (int k = 0; k < 9; k++)
						if (k!=i&&k!=j) bw.write(arr[k] + "\n");;
					break;
				}
				
			}
		}
				
		bw.flush();
		bw.close();
		br.close();
	}	
}	
