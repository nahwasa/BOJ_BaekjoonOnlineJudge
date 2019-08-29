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
		double a = Double.parseDouble(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double b = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		double tmp = (b-c)/2;		
		bw.write((a*a-tmp*tmp) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
