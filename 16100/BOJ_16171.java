import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i)>'9') sb.append(s.charAt(i));
		bw.write(sb.indexOf(br.readLine())==-1?"0\n":"1\n");
		bw.flush();		
		bw.close();
		br.close();
	}
}
