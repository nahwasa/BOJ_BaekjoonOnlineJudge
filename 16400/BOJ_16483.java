import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		double T = Double.parseDouble(br.readLine());
		T/=2;
		bw.write(Math.round(T*T) + "\n");
		bw.flush();
		br.close();
		bw.close();	
	}
}