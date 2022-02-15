import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Weight {
    char c;
    int w;
    public Weight(char c, int w) {
        this.c = c;
        this.w = w;
    }
}
public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        Weight[] weight = new Weight['Z'-'A'+1];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = new Weight((char)('A'+i), 0);
        }
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            arr[i] = cur;
            for (int j = 0; j < cur.length(); j++) {
                weight[cur.charAt(j)-'A'].w += Math.pow(10, cur.length()-j-1);
            }
        }

        Arrays.sort(weight, new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return o2.w - o1.w;
            }
        });

        int[] atoi = new int['Z'-'A'+1];
        int num = 9;
        for (Weight cur : weight)
            atoi[cur.c-'A'] = num--;

        int answer = 0;
        for (String str : arr) {
            for (int j = 0; j < str.length(); j++) {
                answer += atoi[str.charAt(j)-'A']*Math.pow(10, str.length()-j-1);
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
