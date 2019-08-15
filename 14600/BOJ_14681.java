import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		if (a>0&&b>0)
			bw.write("1\n");
		else if (a>0&&b<0)
			bw.write("4\n");
		else if (a<0&&b<0)
			bw.write("3\n");
		else
			bw.write("2\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
