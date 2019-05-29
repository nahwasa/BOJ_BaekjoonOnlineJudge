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
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (isGroupWord(br.readLine()))
				cnt++;					
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();
		
	}

	private static boolean isGroupWord(String str) {
		boolean[] check = new boolean['z' - 'a' + 1];
		
		String changedStr = "";
		
		char tmp = ' ';		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != tmp) {
				tmp = str.charAt(i);
				changedStr += str.charAt(i);
			}				
		}
				
		for (int i = 0; i < changedStr.length(); i++) {
			if (check[changedStr.charAt(i) - 'a'])
				return false;
			else
				check[changedStr.charAt(i) - 'a'] = true;
		}		
		return true;
	}
}
