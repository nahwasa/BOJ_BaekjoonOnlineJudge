import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int n = 1 + 2 * Integer.parseInt(br.readLine());	// n에 대한 IOI 길이
		Integer.parseInt(br.readLine());	// 필요없음
		
		String s = br.readLine();
		LinkedList<Integer> ll = new LinkedList<Integer>();	// IOIOI.. 의 길이 저장 OIOIIOIIOIO면 6,3이 저장됨.
		
		for (int i = 0; i < s.length(); i++) {	// 입력받은걸 순회하며 IOI인 위치 검색
			if (s.charAt(i) == 'I') {				
				int j = 1;
				for (; i + j < s.length(); j++) {
					if (((j)%2 == 1 && s.charAt(i+j) != 'O') || ((j)%2 == 0 && s.charAt(i+j) != 'I'))
						break;
				}
				if (j > 2) {
					ll.add(j);
					i += (j-1);
				}
			}
		}		
		
		Iterator<Integer> it = ll.iterator();
		
		int cnt = 0;
		while(it.hasNext()) {
			int tmp = it.next();
			if (tmp < n)
				continue;
			
			cnt += ( (tmp - n) / 2 + 1);
		}
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
