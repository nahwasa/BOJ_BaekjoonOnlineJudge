import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;
			int size = 1;	// 맨앞
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case '1' :
					size += 3;
					break;
				case '0' :
					size += 5;
					break;
				default :
					size += 4;
					break;
				}
			}
			bw.write(size + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
