import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Random rd = new Random(System.currentTimeMillis());
		if ((rd.nextInt()&1)==1)
			bw.write("Yonsei\n");
		else
			bw.write("Korea\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
