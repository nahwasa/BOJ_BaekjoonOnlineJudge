import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
				
		int max = 0;
		char maxChar = 'A';
		boolean check = false;
		str = str.toUpperCase();
		
		for (char k = 'A'; k <= 'Z'; k++) {
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == k)
					cnt++;
			}
			if (cnt == max) {
				check = true;
			} else if (cnt > max) {
				check = false;
				max = cnt;
				maxChar = k;
			}
		}
		
		if (check)
			bw.write("?\n");
		else
			bw.write(maxChar + "\n");
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}
