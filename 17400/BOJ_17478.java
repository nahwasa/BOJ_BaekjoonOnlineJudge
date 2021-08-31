import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String STR1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    private static final String[] STR2 = {
        "\"재귀함수가 뭔가요?\"\n"
        ,"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
        ,"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
        ,"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
    };
    private static final String[] STR3 = {
        "\"재귀함수가 뭔가요?\"\n"
        ,"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"
    };
    private static final String STR4 = "라고 답변하였지.\n";

    private static StringBuilder sb;

    private static void f(int n, int cur) {
        if (cur > n)    return;

        String[] arr = cur==n ? STR3 : STR2;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < cur*4; k++) {
                sb.append('_');
            }
            for (int j = 0; j < arr[i].length(); j++) {
                sb.append(arr[i].charAt(j));
            }
        }

        f(n, cur+1);

        for (int k = 0; k < cur*4; k++) {
            sb.append('_');
        }
        for (int i = 0; i < STR4.length(); i++) {
            sb.append(STR4.charAt(i));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < STR1.length(); i++) {
            sb.append(STR1.charAt(i));
        }
        f(n, 0);
        System.out.println(sb);
    }
}
