import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[53];
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
			
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if (c == ' ')
				arr[0]--;
			else if (c>='A' && c<='Z')
				arr[c-'A'+1]--;
			else if (c>='a' && c<='z')
				arr[c-'a'+27]--;
		}
		boolean chk = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				chk = false;
				break;
			}
		}		
		if (chk)
			bw.write("y\n");
		else
			bw.write("n\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
