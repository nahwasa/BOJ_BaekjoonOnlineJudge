import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = new String[5];
		for (int i = 0; i < 5; i++)
			arr[i] = br.readLine();
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j].length() > i)
					bw.write(arr[j].charAt(i));
			}
		}
		bw.newLine();
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
