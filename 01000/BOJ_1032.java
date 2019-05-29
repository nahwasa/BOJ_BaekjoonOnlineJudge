import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr[0].length(); i++) {
			char tmp = arr[0].charAt(i);
			boolean swt = true;
			for (int j = 1; j < n; j++) {
				if (tmp != arr[j].charAt(i)) {
					sb.append("?");
					swt = false;
					break;
				}
			}
			if (swt)
				sb.append(tmp);
		}
		
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
