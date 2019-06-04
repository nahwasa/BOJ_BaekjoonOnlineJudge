import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		String op = br.readLine();
		String b = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		switch (op) {
		case "+" :
			if (a.length() == b.length()) {
				sb.append(a);
				sb.setCharAt(0, '2');
				break;
			}
			
			int bLength = a.length()>b.length()?a.length():b.length();
			for (int i = 0; i < bLength; i++)
				sb.append('0');
			sb.setCharAt(bLength-a.length(), '1');
			sb.setCharAt(bLength-b.length(), '1');			
			break;
		case "*" :
			sb.append(a);
			for (int i = 0; i < b.length()-1; i++)
				sb.append('0');
			
			break;
		}
		
		bw.write(sb.toString() + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
