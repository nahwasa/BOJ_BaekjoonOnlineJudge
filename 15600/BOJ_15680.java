import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		switch(br.readLine()) {
		case "0" : bw.write("YONSEI\n"); break;
		case "1" : bw.write("Leading the Way to the Future\n"); break;
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
