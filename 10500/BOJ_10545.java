import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		HashMap<Character, Integer[]> hm = new HashMap<Character, Integer[]>();
		int tmp = 2;
		int cnt = 1;
		for (int i = 'a'; i <= 'z'; i++) {	// 직접 넣기 귀찮아서
			if (i == 'z' || i == 's') {
				hm.put((char)i, new Integer[] {tmp-1, 4});
				cnt = 1;
			} else {
				hm.put((char)i, new Integer[] {tmp, cnt});
				cnt++;
				if (cnt == 4) {
					cnt = 1;
					tmp++;
				}
			}			
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[10];
		tmp = 1;
		while (st.hasMoreTokens()) {
			arr[Integer.parseInt(st.nextToken())] = tmp++; 
		}
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			Integer[] t = hm.get(s.charAt(i));
			
			if(sb.length() > 0 && sb.charAt(sb.length()-1)-'0' == arr[t[0]])
				sb.append("#");
			
			for (int j = 0; j < t[1]; j++)
				sb.append(arr[t[0]]);
		}
		
		bw.write(sb.toString() + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}
