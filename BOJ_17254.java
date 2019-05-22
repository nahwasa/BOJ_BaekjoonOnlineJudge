import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<InputInfo> l = new LinkedList<InputInfo>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();	// 키보드 번호 필요없음
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			l.add(new InputInfo(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					st.nextToken().charAt(0)));
		}		
		
		Collections.sort(l);
		
		Iterator<InputInfo> it = l.iterator();
		StringBuffer sb = new StringBuffer();
		while (it.hasNext()) {
			sb.append(it.next().getKey());
		}
		sb.append("\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class InputInfo implements Comparable<InputInfo> {
	private int kNum;
	private int sec;	
	private char key;		
	
	public InputInfo(int kNum, int sec, char key) {		
		this.kNum = kNum;
		this.sec = sec;
		this.key = key;
	}
	
	@Override
	public int compareTo(InputInfo info) {
		if (getSec() > info.getSec())
			return 1;
		else if (getSec() < info.getSec())
			return -1;
		else { // same sec
			if (getkNum() > info.getkNum())
				return 1;
			else
				return -1;
		}			
	}
	
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public int getkNum() {
		return kNum;
	}
	public void setkNum(int kNum) {
		this.kNum = kNum;
	}
	public char getKey() {
		return key;
	}
	public void setKey(char key) {
		this.key = key;
	}

	
	
	
}
