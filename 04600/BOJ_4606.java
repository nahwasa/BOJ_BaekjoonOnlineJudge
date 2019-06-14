import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("#"))
				break;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case ' ' : sb.append("%20"); break;
				case '!' : sb.append("%21"); break;
				case '$' : sb.append("%24"); break;
				case '%' : sb.append("%25"); break;
				case '(' : sb.append("%28"); break;
				case ')' : sb.append("%29"); break;
				case '*' : sb.append("%2a"); break;
				default : sb.append(s.charAt(i)); break;				
				}
			}
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
