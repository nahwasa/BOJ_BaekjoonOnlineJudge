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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Integer.parseInt(st.nextToken());
		double b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double c = Integer.parseInt(st.nextToken());
		double d = Integer.parseInt(st.nextToken());
		
		int rot = 0;
		double max = 0;
		int result = 0;
		
		while (rot < 4) {
			double tmp = 0;
			switch (rot) {
			case 0 : 
				tmp = a/c + b/d;
				break;
			case 1 :
				tmp = c/d + a/b;
				break;
			case 2 :
				tmp = d/b + c/a;
				break;
			case 3 :
				tmp = b/a + d/c;
				break;
			}
			
			if (tmp > max) {
				max = tmp;
				result = rot;
			}
			
			rot++;
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
