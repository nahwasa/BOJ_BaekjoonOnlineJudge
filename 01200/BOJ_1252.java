import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String b1 = st.nextToken();
		String b2 = st.nextToken();
		int longer = b1.length()>b2.length()?b1.length():b2.length();
		int shorter = b1.length()<b2.length()?b1.length():b2.length();
		LinkedList<Character> ll = new LinkedList<Character>();
		char carry = '0';
		for (int i = 0; i < longer; i++) {
			char c1 = (b1.length()==shorter&&i>=shorter)?'0':b1.charAt(b1.length()-1-i);
			char c2 = (b2.length()==shorter&&i>=shorter)?'0':b2.charAt(b2.length()-1-i);
			switch(c1+c2+carry) {
			case '0'+'1'+'1' : carry='1'; ll.add('0'); break;	
			case '0'+'0'+'0' : carry='0'; ll.add('0'); break;
			case '1'+'1'+'1' : carry='1'; ll.add('1'); break;
			case '0'+'0'+'1' : carry='0'; ll.add('1'); break;			
			}			
		}
		if (carry=='1') ll.add(carry);
		Iterator<Character> it = ll.descendingIterator();
		boolean firstZeroChk = false;		
		while (it.hasNext()) {
			char tmp = it.next();
			if (tmp == '1') firstZeroChk=true;
			if (firstZeroChk) bw.write(tmp);
		}
		if (!firstZeroChk) bw.write("0");
		bw.newLine();
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
