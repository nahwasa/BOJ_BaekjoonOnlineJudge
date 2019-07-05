import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] cnt = new int['Z'-'A'+1];
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i)-'A']++;
		int chk = -1;
		boolean odd = s.length()%2==1?true:false;
		for (int i = 0; i < cnt.length; i++) {					
			if ((odd&&chk!=-1&&cnt[i]%2!=0)||(!odd&&cnt[i]%2!=0)) {
				bw.write("I'm Sorry Hansoo\n");
				bw.flush();
				br.close();
				bw.close();
				return;
			}
			if (odd&&chk==-1&&cnt[i]%2!=0)
				chk=i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i]/2; j++) {
				sb.append((char)('A'+i));
			}
		}
		if (odd) sb.append((char)('A'+chk));
		for (int i = cnt.length-1; i >=0; i--) {
			for (int j = 0; j < cnt[i]/2; j++) {
				sb.append((char)('A'+i));
			}
		}
		bw.write(sb.toString()+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
