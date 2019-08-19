import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		String s = br.readLine();
		boolean isLeft = s.charAt(0)=='('?true:false;
		int sum = 10;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)=='('?isLeft:!isLeft) {
				sum+=5;
			} else { 
				isLeft=!isLeft; 
				sum+=10;
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
