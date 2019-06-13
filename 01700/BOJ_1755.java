import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		LinkedList<Num> ll = new LinkedList<Num>();
		for (int i = a; i <= b; i++) {
			ll.add(new Num(String.valueOf(i)));
		}
		Collections.sort(ll);
		int idx = 1;
		for(Num n : ll) {
			bw.write(n.num + " ");
			if (idx++%10 == 0)
				bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

class Num implements Comparable<Num>{
	String num;
	String str;
	
	public Num(String num) {
		this.num = num;
		if (num.length()==1)
			str = getNumStr(num.charAt(0));
		else
			str = getNumStr(num.charAt(0)) + " " + getNumStr(num.charAt(1));
	}
	
	String getNumStr(char c) {
		switch (c) {
		case '0' :
			return "zero";
		case '1' :
			return "one";
		case '2' :
			return "two";
		case '3' :
			return "three";
		case'4' :
			return "four";
		case '5' :
			return "five";
		case'6':
			return "six";
		case'7' :
			return "seven";
		case'8':
			return "eight";
		case'9':
			return "nine";
		
		}
		return null;
	}

	@Override
	public int compareTo(Num o) {
		return this.str.compareTo(o.str);
	}
}
