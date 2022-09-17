import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int LIMIT = 1000;
    StringBuilder sb = new StringBuilder();

    private void printType1(int c) {
        for (int i = 0; i < c-1; i++) sb.append('R');
        sb.append('D');
        for (int i = 0; i < c-1; i++) sb.append('L');
        sb.append('D');
    }

    private void printType2(int r) {
        for (int i = 0; i < r-1; i++) sb.append('D');
        sb.append('R');
        for (int i = 0; i < r-1; i++) sb.append('U');
        sb.append('R');
    }

    private void printType3(int c) {
        for (int i = 0; i < c-1; i++) sb.append('L');
        sb.append('D');
        for (int i = 0; i < c-1; i++) sb.append('R');
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (r%2==1) {
            for (int i = 0; i < r/2; i++) printType1(c);
            for (int i = 0; i < c-1; i++) sb.append('R');
            System.out.println(sb);
            return;
        }
        if (c%2==1) {
            for (int i = 0; i < c/2; i++) printType2(r);
            for (int i = 0; i < r-1; i++) sb.append('D');
            System.out.println(sb);
            return;
        }

        // both r and c are even
        int tr = 0, tc = 0;
        int min = LIMIT;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if ((i+j)%2==0 || min <= cur) continue;
                min = cur;
                tr = i+1;
                tc = j+1;
            }
        }

        // A
        for (int i = 0; i < (tr-1)/2; i++) printType1(c);

        // B
        for (int i = 0; i < (tc-1)/2; i++)
            sb.append('D').append('R').append('U').append('R');
        if (tr%2==1)
            sb.append('D').append('R');
        else
            sb.append('R').append('D');

        int len = (c-tc)/2;
        if (len != 0)
            sb.append('R');
        for (int i = 0; i < len; i++) {
            sb.append('U').append('R').append('D');
            if (i != len-1)
                sb.append('R');
        }

        // C
        len = (r-tr)/2;
        if (len != 0) {
            sb.append('D');
        }
        for (int i = 0; i < len; i++) {
            printType3(c);
            if (i != len-1)
                sb.append('D');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
