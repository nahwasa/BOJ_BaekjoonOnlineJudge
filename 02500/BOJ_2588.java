import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		bw.write((a * (b.charAt(2)-'0')) + "\n");
		bw.write((a * (b.charAt(1)-'0')) + "\n");
		bw.write((a * (b.charAt(0)-'0')) + "\n");
		bw.write((a * Integer.parseInt(b)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
