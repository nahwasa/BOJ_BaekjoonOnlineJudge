import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Number {
    String original, reverse;
    int len = 0;

    public Number(String str) {
        original = str;

        StringBuilder sb = new StringBuilder();

        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            switch (c) {
                case '6': c = '9'; break;
                case '9': c = '6'; break;
            }
            sb.append(c);
        }
        reverse = sb.toString();

        len = sb.length();
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<13);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Number[] arr = new Number[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = new Number(st.nextToken());

        StringBuilder answer = new StringBuilder();

        Arrays.sort(arr, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if (o2.len == o1.len)
                    return o2.reverse.compareTo(o1.reverse);
                return o2.len - o1.len;
            }
        });
        Number dup = arr[0];

        Arrays.sort(arr, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return (o2.reverse+o1.reverse).compareTo(o1.reverse+o2.reverse);
            }
        });
        for (int i = n-1; i >= 0; i--) {
            answer.append(arr[i].original);
            if (arr[i] == dup)
                answer.append(arr[i].original);
        }


        System.out.println(answer);
    }
}
