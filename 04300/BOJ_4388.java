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
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (a.equals("0") && b.equals("0"))
				break;			
			if (a.length()<b.length()) {
				String tmp = "";
				for (int i = 0; i < b.length()-a.length(); i++)
					tmp += "0";
				a = tmp + a;
			} else if (b.length()<a.length()) {
				String tmp = "";
				for (int i = 0; i < a.length()-b.length(); i++)
					tmp += "0";
				b = tmp + b;
			}
			boolean carry = false;
			int carryCnt = 0;
			for (int i = a.length()-1; i >= 0; i--) {
				int sum = carry?1:0;
				sum += (a.charAt(i) - '0' + b.charAt(i) - '0');
				if (sum >= 10) {
					carry = true; 
					carryCnt++;}
				else
					carry = false;
			}			
			bw.write(carryCnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
