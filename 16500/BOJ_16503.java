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
		int[] num = new int[3];
		char[] op = new char[2];
		num[0] = Integer.parseInt(st.nextToken());
		op[0] = st.nextToken().charAt(0);
		num[1] = Integer.parseInt(st.nextToken());
		op[1] = st.nextToken().charAt(0);
		num[2] = Integer.parseInt(st.nextToken());
		int res1 = calc(calc(num[0], num[1], op[0]), num[2], op[1]);
		int res2 = calc(num[0], calc(num[1], num[2], op[1]), op[0]);
		bw.write(Math.min(res1, res2) + "\n");	
		bw.write(Math.max(res1, res2) + "\n");	
		
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static int calc(int num1, int num2, char op) {
		switch (op) {
		case '*' :
			return num1 * num2;
		case '+' :
			return num1 + num2;
		case '-' :
			return num1 - num2;
		case '/' :
			return num1 / num2;
		}
		return 0;
	}
}
