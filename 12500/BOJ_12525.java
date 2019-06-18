import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			String s = br.readLine();
			char c = s.charAt(s.length()-1);
			String postfix = "";
			switch(c) {
			case 'y' :
			case 'Y' :
				postfix = "nobody";
				break;
			case 'a':
			case 'A':
			case 'i':
			case 'I':
			case 'e':
			case 'E':
			case 'o':
			case 'O':
			case 'u':
			case 'U':
				postfix = "a queen";
				break;
			default :
				postfix = "a king";
				break;
			}
			bw.write(String.format("Case #%d: %s is ruled by %s.\n", i+1, s, postfix));
		}	
		
		bw.flush();
		bw.close();
		br.close();
	}
}
