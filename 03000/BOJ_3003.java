import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] correct = new int[] {1,1,2,2,2,8};
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < correct.length; i++) {
			bw.write(String.valueOf(correct[i] - Integer.parseInt(input[i])) + " ");
		}
		bw.newLine();
				
		bw.flush();
		bw.close();
		br.close();
	}	
}
