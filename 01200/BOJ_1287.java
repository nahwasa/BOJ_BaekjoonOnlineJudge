import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class ListNode {
	Object data;
	ListNode link;
	int type; // 저장된 자료의 타입을 나타냄. ListQueue에서 사용. 이 프로그램상에선 1:operator, 2:공백, 3:여는괄호, 4:닫는괄호, 5:숫자

	ListNode() {
		data = null;
		link = null;
	}

	ListNode(Object data) {
		this.data = data;
		link = null;
	}
}

class ListQueue {
	public ListNode front;
	public ListNode rear;
	public int count;

	public boolean isEmpty() {
		return (count == 0);
	}

	public void enqueue(Object x, int type) { // 큐에 자료를 넣음.
		ListNode newNode = new ListNode(x);
		newNode.type = type;
		newNode.link = null;
		if (count == 0)
			front = rear = newNode;
		else {
			rear.link = newNode;
			rear = newNode;
		}
		count++;
	}

	public Object dequeue() { // 큐에서 자료를 꺼내고 삭제. First In First Out.
		if (count == 0)
			return null;
		else {
			Object temp = front.data;
			front = front.link;
			if (front == null)
				rear = null;
			count--;
			return temp;
		}
	}
}

class ListStack implements Stack {
	public ListNode top; // 리스트로 Stack을 구현하기 위해 필요한 top 참조변수

	public boolean isEmpty() { // 스택이 비어있는지 검사
		return (top == null);
	}

	public void push(Object x, int type) { // 스택의 맨 위에 원소 x를 삽입
		ListNode newNode = new ListNode(x);
		newNode.link = top;
		newNode.type = type;
		top = newNode;
	}

	public Object pop() { // 스택의 원소를 반환하고 삭제.
		if (isEmpty())
			return null;
		else {
			Object temp = top.data;
			delete();
			return temp;
		}
	}

	public void delete() { // 맨위를 삭제만 함.
		if (isEmpty())
			return;
		else
			top = top.link;
	}

	public Object peek() { // 스택의 톱 원소를 알려줌.
		if (isEmpty())
			return null;
		else
			return top.data;
	}

	public int whatType() { // stack의 top원소의 type값 반환.
		return top.type;
	}

}

interface Stack {
	boolean isEmpty();
	void push(Object x, int type);
	Object pop();
	void delete();
	Object peek();
}

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(new Main().solution(br.readLine()));
		} catch (Exception e) {
			System.out.println("ROCK");
		}
	}

	public String solution(String str) {
		if (str.contains("()"))
			throw new RuntimeException();

		ListStack st = new ListStack(); // 계산을 위해 필요한 스택.
		ListNode pointer = postfix(str).front; // 자료를 읽기 위한 포인터.

		while (pointer != null) {
			if (pointer.type == 5) { // 피연산자일 경우 스택에 push.
				st.push(pointer.data, pointer.type);
				pointer = pointer.link;
			} else { // 이미 후위식에서 피연산자와 연산자만 남겼으므로 그냥 else.
				BigInteger result = BigInteger.ZERO; // 결과값을 저장해둘 변수
				BigInteger operand2 = new BigInteger(String.valueOf(st.pop()));
				BigInteger operand1 = new BigInteger(String.valueOf(st.pop()));

				if (pointer.data.toString().equals("+")) // 각 연산자에 따라 연산작업. 일항연산자는 infix에서 미리 계산해둠.
					result = operand1.add(operand2);
				else if (pointer.data.toString().equals("-"))
					result = operand1.subtract(operand2);
				else if (pointer.data.toString().equals("/"))
					result = operand1.divide(operand2);
				else if (pointer.data.toString().equals("*"))
					result = operand1.multiply(operand2);
				st.push(result.toString(), 5); // 연산자에 따라 연산한 결과값을 다시 push.
				pointer = pointer.link;
			}
		} // end while.
		String result = String.valueOf(st.pop()); // 최종 결과값은 스택에 남아있는 하나의 수 입니다.
		if (!st.isEmpty()) { // 연산이 끝났는데도 스택이 뭔가 남아있다면 에러.
			throw new NullPointerException();
		}
		return result; // 최종적으로 연산결과 result를 반환
	}

	public ListQueue infix(String str) {
		if (checkType(str.charAt(0)) == 1 || checkType(str.charAt(0)) == 4) { // 수식이 연산자나 닫는괄호로 시작하면 에러 출력.
			return null;
		}
		ListQueue infixQue = new ListQueue(); // String을 받아 토큰을 나누어 저장해 둘 큐.
		for (int i = 0; i < str.length();) { // String을 한 문자씩 검사.
			if (checkType(str.charAt(i)) == 5) { // 숫자일 경우, 다른 타입을 만나기 전까지를 연결된 토큰으로 나타냄.
				int cnt = 0;
				int k = i;
				while (checkType(str.charAt(i)) == 5) { // 숫자부분을 통채로 토큰으로 만들기 위한 검사문.
					i++;
					cnt++;
					if (i == str.length()) // String의 맨 끝에 도달하면 더이상 검사하지 않도록 함.(검사하면 오류 발생)
						break;
				}
				String temp = str.substring(k, k + cnt);
				infixQue.enqueue(temp, 5); // 이후 계산을 편하게 하기 위해 토큰을 나눌 때 미리 타입을 써두기로 함.
			} else if (checkType(str.charAt(i)) != 2) { // 공백이 아닌 모든 경우.
				infixQue.enqueue(str.charAt(i), checkType(str.charAt(i))); // 이후 계산을 편하게 하기 위해 토큰을 나눌 때 미리 타입을 써두기로 함.
				i++;
			} else // 공백일 경우는 검사할 str의 자리수만 증가시키고 공백은 버림.
				i++;
		}
		if (bracketTest(infixQue)) // 수식의 괄호쌍 검사결과가 옳다면 infixQue 반환.
			return infixQue;
		else { // 수식의 괄호쌍 검사결과 괄호를 올바르게 쓰지 않았다면 오류발생.
			return null;
		}
	}

	public boolean bracketTest(ListQueue infix) { // 괄호쌍 검사용
		ListStack bracketStack = new ListStack(); // 검사에 사용할 스택.
		ListNode pointer = infix.front; // 노드를 하나씩 검사할 포인터변수.
		while (pointer != null) { // 끝에 도달하기 전까지..
			if (pointer.type == 3) { // 여는괄호는 스택에 넣습니다.
				bracketStack.push(pointer.data, pointer.type);
				pointer = pointer.link;
			} else if (pointer.type == 4) { // 닫는 소괄호이면 스택에서 여는소괄호를 제거. 없다면 false반환.
				int typeTemp = bracketStack.top.type;
				if (bracketStack.isEmpty())
					return false;
				else if (typeTemp == 3)
					bracketStack.delete();
				else
					return false;
				pointer = pointer.link;
			} else
				pointer = pointer.link;
		}
		if (bracketStack.isEmpty()) // 검사를 끝내고 스택에 아무것도 남아있지 않다면 true입니다.
			return true;
		else // 스택에 무언가 남아있다면 쌍이 안맞는 것이므로 false.
			return false;
	}

	public int checkType(char ch) {
		if (ch == '+' || ch == '-') // operator +, -
			return 1;
		else if (ch == '/' || ch == '*') // operator *, /
			return 6;
		else if (ch == ' ') // 공백
			return 2;
		else if (ch == '(') // 여는 소괄호
			return 3;
		else if (ch == ')') // 닫는 소괄호
			return 4;
		else // 숫자
			return 5;
	}

	/**
	 * Priority In Stack
	 */
	public int pis(ListNode token) {
		if (token == null)
			return -1;
		if (token.type == 6) // *. /의 우선순위
			return 9;
		else if (token.type == 1) // +, -의 우선순위
			return 8;
		else if (token.type == 3) // 소괄호 우선순위
			return 3;
		else
			return 0;
	}
	
	/**
	 * Priority In Expression
	 */
	public int pie(ListNode token) {
		if (token == null)
			return -1;
		if (token.type == 6) // *, /의 우선순위
			return 9;
		else if (token.type == 1) // +, -의 우선순위
			return 8;
		else if (token.type == 3) // 소괄호 우선순위
			return 12;
		else
			return 0;
	}
	
	public ListQueue postfix(String str) {
		ListQueue infixQue = infix(str); // 입력받은 데이터를 토큰으로 나눈 중위식 표현을 infixQue참조변수로 가르킴.
		ListQueue postfixQue = new ListQueue(); // 중위식에서 바뀐 후위식을 저장.
		ListStack st = new ListStack(); // 중위식을 후위식으로 바꾸기 위해 사용할 스택.

		if (infixQue == null) // infix에서 null값이 왔을 경우 (잘못된 입력을 했을 경우)
			return null;

		ListNode pointer = infixQue.front; // 자료를 읽기 위한 포인터.
		while (pointer != null) {
			if (pointer.type == 5) { // 숫자타입의 토큰일 경우
				postfixQue.enqueue(pointer.data, 5); // 큐에 바로 넣음.
				pointer = pointer.link; // 한칸 전진.
			} else if (pointer.type == 4) { // 닫는 소괄호일 경우
				while (st.whatType() != 3) { // 여는 소괄호를 만날 때 까지 스택의 내용을 뺌.
					postfixQue.enqueue(st.peek(), st.whatType());
					st.delete(); // 바로 pop을 할 경우 자신의 type을 넘겨줄 수 없음.
				}
				st.delete(); // 여는 괄호는 그냥 제거
				pointer = pointer.link;
			} else { // operator 혹은 여는 괄호일 때.
				if (!st.isEmpty()) { // 스택이 빌 때 까지
					while (pis(st.top) >= pie(pointer)) { // 우선순위를 검사해서 스택안에 있는 것이 우선순위가 더 높으면 pop.
						postfixQue.enqueue(st.peek(), st.whatType());
						st.delete();
					}
				}
				st.push(pointer.data, pointer.type); // 우선순위 검사를 마치고 push.
				pointer = pointer.link;
			}
		}
		while (!st.isEmpty()) { // 남아있는 스택을 모두 뺌.
			postfixQue.enqueue(st.peek(), st.whatType());
			st.delete();
		}
		return postfixQue; // 최종적으로 후위식 토큰이 저장되어 있는 postfixQue 반환.
	}
}
