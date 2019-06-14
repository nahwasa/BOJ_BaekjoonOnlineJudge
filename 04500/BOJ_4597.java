import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("#"))
				break;
			char[] arr = s.toCharArray();
			int cnt = 0;
			for (char c : arr)
				if (c == '1') cnt++;
			if (arr[arr.length-1] == 'e' && cnt%2==0)
				arr[arr.length-1] = '0';
			else if (arr[arr.length-1] == 'e' && cnt%2==1)
				arr[arr.length-1] = '1';
			else if (arr[arr.length-1] == 'o' && cnt%2==0)
				arr[arr.length-1] = '1';
			else if (arr[arr.length-1] == 'o' && cnt%2==1)
				arr[arr.length-1] = '0';
			bw.write(String.valueOf(arr) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
