import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String[] strArr = new String[] {
			"Re","Pt","Cc","Ea","Tb","Cm","Ex"
		};
		for (int i = 0; i < strArr.length; i++)
			hm.put(strArr[i], 0);
		String tmp = "";
		int cnt = 0;
		while ((tmp = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(tmp);
			while (st.hasMoreTokens()) {
				cnt++;
				String s = st.nextToken();
				if (!hm.containsKey(s)) continue;
				hm.replace(s, hm.get(s)+1);
			}
		}
		for (String s : strArr)
			bw.write(String.format("%s %d %.2f\n", s, hm.get(s), (double)hm.get(s)/cnt));
		bw.write(String.format("Total %d 1.00\n", cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}
