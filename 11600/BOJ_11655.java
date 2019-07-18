import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] arr = br.readLine().toCharArray();
		for (char c : arr) {
			if (c>='a'&&c<='z') {				
				char tmp = (char) (c+13);
				if (tmp > 'z') tmp-=26;
				bw.write(String.valueOf(tmp));
			} else if (c>='A'&&c<='Z') {
				char tmp = (char) (c+13);
				if (tmp > 'Z') tmp-=26;
				bw.write(String.valueOf(tmp));
			} else {
				bw.write(c + "");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
