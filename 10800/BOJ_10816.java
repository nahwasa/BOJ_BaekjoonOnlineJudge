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
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-->0) {
			String tmp = st.nextToken();
			if (hm.containsKey(tmp))
				hm.replace(tmp, hm.get(tmp)+1);
			else
				hm.put(tmp, 1);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (M-->0) {
			bw.write(hm.getOrDefault(st.nextToken(),0) + " ");
		}
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}	
}
