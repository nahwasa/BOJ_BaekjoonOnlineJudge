import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = new String[14];
		String original = "baby sukhwan tururu turu\n" + 
				"very cute tururu turu\n" + 
				"in bed tururu turu\n" + 
				"baby sukhwan";
		StringTokenizer st = new StringTokenizer(original, " \n");
		for (int i = 0; i < 14; i++) arr[i] = st.nextToken();
		int N = Integer.parseInt(br.readLine()) - 1;		
		int cnt = N/14;
		int idx = N%14;
		switch(arr[idx]) {
		case "tururu" :
			if (cnt<3) {
				bw.write(arr[idx]);
				for(int i = 0; i < cnt; i++)
					bw.write("ru");
			} else {
				bw.write(String.format("tu+ru*%d", cnt+2));
			}
			bw.newLine();
			break;
		case "turu" :
			if (cnt<4) {
				bw.write(arr[idx]);
				for(int i = 0; i < cnt; i++)
					bw.write("ru");
			} else {
				bw.write(String.format("tu+ru*%d", cnt+1));
			}
			bw.newLine();
			break;
		default : 
			bw.write(arr[idx] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
