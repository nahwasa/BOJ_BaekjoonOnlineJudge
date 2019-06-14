import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(Character.toUpperCase(s.charAt(0)));
			sb.append(s.substring(1));
			bw.write(sb.toString()+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
