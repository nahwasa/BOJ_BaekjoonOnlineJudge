import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		char[][] arr = new char[5][100000];
		for (int i = 0; i < 100000; i++) {
			int cnt = (a.charAt(i)=='1'?1:0) + (b.charAt(i)=='1'?1:0);
			arr[3][i] = a.charAt(i)=='1'?'0':'1';
			arr[4][i] = b.charAt(i)=='1'?'0':'1';
			if (cnt == 0) arr[0][i]=arr[1][i]=arr[2][i]='0';
			else if (cnt == 1) {arr[0][i]='0'; arr[1][i]='1'; arr[2][i]='1';}
			else {arr[0][i]=arr[1][i]='1'; arr[2][i]='0';}
		}
		for (int i = 0; i < 5; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 100000; j++) {
				sb.append(arr[i][j]);
			}
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
