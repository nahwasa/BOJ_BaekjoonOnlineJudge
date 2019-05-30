import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		boolean chk = true;
		for (int i = 0; i < input.length()/2; i++) {
			if (input.charAt(i) != input.charAt(input.length()-1-i)) {
				chk = false;
				break;
			}			
		}
		
		if(chk)
			bw.write("1\n");
		else
			bw.write("0\n");
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
}
