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
		int i = 666;
		for (; N!=0; i++)
			if (String.valueOf(i).contains("666")) N--;
		bw.write((i-1) + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
