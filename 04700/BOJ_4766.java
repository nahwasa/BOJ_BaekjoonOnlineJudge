import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double t = Double.parseDouble(br.readLine());
		while (true) {
			String s = br.readLine();
			if (s.equals("999"))
				break;
			double t2 = Double.parseDouble(s);		
			bw.write(String.format("%.2f\n", t2-t));
			t = t2;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
