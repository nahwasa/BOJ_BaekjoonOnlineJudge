import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write((int)Math.pow(Math.pow(2, Integer.parseInt(br.readLine()))+1, 2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
