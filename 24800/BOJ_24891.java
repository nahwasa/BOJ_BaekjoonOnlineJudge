import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private boolean isEnd = false;
    String[] words, choice;
    boolean[] v = new boolean[20];
    int n;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        words = new String[w];
        while (w-->0) words[w] = br.readLine();

        Arrays.sort(words);
        choice = new String[n];
        find(0);

        if (!isEnd) {
            System.out.println("NONE");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(choice[i]).append('\n');
        }
        System.out.print(sb);
    }

    private void find(final int choiceCnt) {
        if (choiceCnt == n) {
            if (isMagicSquare()) isEnd = true;
            return;
        }

        for (int i = 0; !isEnd && i < words.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            choice[choiceCnt] = words[i];
            find(choiceCnt+1);
            v[i] = false;
        }
    }

    private boolean isMagicSquare() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (choice[i].charAt(j) != choice[j].charAt(i)) return false;
            }
        }
        return true;
    }
}
