import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {	
	private static final int ROUND_BRACKET	 = -1;	// '('
	private static final int SQUEARE_BRACKET = -2;	// '['
	private static final int SCORE_OF_ROUND_BRACKET		 = 2;
	private static final int SCORE_OF_SQUEARE_BRACKET	 = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<Integer> st = new Stack<Integer>();
		
		for (int i = 0; i < s.length(); i++) {			
			switch(s.charAt(i)) {
			case '(' :
				st.push(ROUND_BRACKET);
				break;
			case '[' :
				st.push(SQUEARE_BRACKET);
				break;
			case ')' :
				if (!calcSubScore(st, ROUND_BRACKET)) {	// 정상적이지 않은 입력이면 바로 종료
					bw.write("0\n");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				break;
			case ']' :
				if (!calcSubScore(st, SQUEARE_BRACKET)) {	// 정상적이지 않은 입력이면 바로 종료
					bw.write("0\n");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				break;
				
			}
		}
		
		int resultTmp = getResult(st);
		if (resultTmp < 0)	// 정상적이지 않은 입력
			bw.write("0\n");
		else
			bw.write(resultTmp + "\n");
			
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean calcSubScore(Stack<Integer> st, int type) {
		int sumTmp = 0;
		
		if (st.isEmpty())
			return false;
		
		switch(type) {
		case ROUND_BRACKET :
			while (true) {
				if (st.isEmpty())	// 괄호 만나기전에 비어있다면 괄호 짝이 안맞는것
					return false;
				
				if (st.peek() < 0)	// 괄호일 경우 일단 멈춤
					break;				
				
				sumTmp += st.pop();
			}
			
			if (!st.pop().equals(ROUND_BRACKET))	// 괄호라 멈췄더니 동일한 괄호가 아닐경우
				return false;
			
			st.push((sumTmp==0?1:sumTmp) * SCORE_OF_ROUND_BRACKET);
			break;
			
		case SQUEARE_BRACKET :
			while (true) {
				if (st.isEmpty())	// 괄호 만나기전에 비어있다면 괄호 짝이 안맞는것
					return false;
				
				if (st.peek() < 0)	// 괄호일 경우 일단 멈춤
					break;				
				
				sumTmp += st.pop();
			}
			
			if (!st.pop().equals(SQUEARE_BRACKET))	// 괄호라 멈췄더니 동일한 괄호가 아닐경우
				return false;
			
			st.push((sumTmp==0?1:sumTmp) * SCORE_OF_SQUEARE_BRACKET);
			break;
		}		
		return true;
	}	
	
	private static int getResult(Stack<Integer> st) {
		int sum = 0;
		while (!st.isEmpty()) {
			int tmp = st.pop();
			if (tmp < 0)	// 숫자만 있어야하는데 괄호가 있으면 안됨.
				return -1;	// 오류로 종료
			
			sum += tmp;
		}		
		return sum;
	}

}
