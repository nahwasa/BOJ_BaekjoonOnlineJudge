import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String s = br.readLine();
		char[] arr = s.toCharArray();		
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		boolean chk = false;
		
		for (int i = arr.length-1; i >=0 ; i--) {
			if (!chk && arr[i] == '0') {
				continue;
			} else if (!chk && arr[i] != '0'){
				chk = true;
			}
			
			sb.append(arr[i]);			
		}
		
		bw.write(sb.toString() + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
