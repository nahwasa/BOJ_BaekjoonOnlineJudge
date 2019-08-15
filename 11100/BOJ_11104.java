import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			String s = br.readLine();
			bw.write(Integer.parseInt(s, 2) + "\n");			
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
