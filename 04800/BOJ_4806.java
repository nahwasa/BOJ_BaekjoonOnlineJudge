import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = null;
		int cnt = 0;
		while ((s = br.readLine())!=null) cnt++;
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
