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
		int num = Integer.parseInt(input);
		int cnt = 0;
		for (int i=(int)Math.pow(10, input.length()-1),j=input.length(); i>0; i/=10, j--) {
			cnt += (num/i-1)*i*j + (num%i+1)*j;
			num = i-1;
		}
		bw.write(cnt+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}
