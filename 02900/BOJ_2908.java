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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String first = st.nextToken();
		String second = st.nextToken();
		String reverseFirst = "";
		String reverseSecond = "";
		
		for (int i = 0; i < 3; i++) {
			reverseFirst += first.charAt(3-i - 1);
			reverseSecond += second.charAt(3-i - 1);
		}
		
		if (Integer.parseInt(reverseFirst) > Integer.parseInt(reverseSecond))
			bw.write(reverseFirst);
		else
			bw.write(reverseSecond);
		
		bw.flush();
		br.close();
		bw.close();
		
	}

}
