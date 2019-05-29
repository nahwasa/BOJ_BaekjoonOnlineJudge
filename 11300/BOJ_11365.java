import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringBuffer sb = new StringBuffer(br.readLine());
			if (sb.indexOf("END") != -1)	//found END
				break;
			sb.reverse();
			bw.write(sb.toString() + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
