import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String[]> team = new HashMap<String, String[]>();
		HashMap<String, String> girl = new HashMap<String, String>();
		while (N-->0) {
			String tName = br.readLine();
			int K = Integer.parseInt(br.readLine());
			String[] arr = new String[K];
			while (K-->0) {
				String gName = br.readLine();
				girl.put(gName, tName);
				arr[K] = gName;
			}
			Arrays.sort(arr);
			team.put(tName, arr);
		}
		while (M-->0) {
			String tmp = br.readLine();
			int pr = Integer.parseInt(br.readLine());
			switch (pr) {
			case 0 :
				for (String s : team.get(tmp))
					bw.write(s + "\n");
				break;
			case 1 :
				bw.write(girl.get(tmp) + "\n");
			}
		}
		bw.flush();		
		bw.close();
		br.close();
	}
}
