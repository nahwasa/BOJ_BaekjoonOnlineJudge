import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = "0" + br.readLine();
		String s2 = "0" + br.readLine();
		String s3 = "0" + br.readLine();
		
		int[][][] arr = new int[s1.length()][s2.length()][s3.length()];
		
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				for (int k = 1; k < s3.length(); k++) {
					if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
						arr[i][j][k] = arr[i-1][j-1][k-1] + 1;
					}  else {						
						arr[i][j][k] = arr[i-1][j][k] > arr[i][j-1][k] ? arr[i-1][j][k] : arr[i][j-1][k];
						arr[i][j][k] = arr[i][j][k-1] > arr[i][j][k] ? arr[i][j][k-1] : arr[i][j][k];
					}
				}
			}
		}
		
		bw.write(arr[s1.length()-1][s2.length()-1][s3.length()-1] + "\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}

}
