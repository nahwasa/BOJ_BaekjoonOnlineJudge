import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Letter>[] arr = new PriorityQueue['z'-'a'+1];
        for (int i = 0; i < arr.length; i++) arr[i] = new PriorityQueue<>();

        while (k-->0) {
            String s = br.readLine();
            arr[s.charAt(0) - 'a'].add(new Letter(s));
        }

        StringBuilder answer = new StringBuilder();
        while (n-->0) {
            int idx = br.readLine().charAt(0) - 'a';
            Letter cur = arr[idx].poll();
            answer.append(cur.s).append('\n');
            arr[idx].add(new Letter(cur));
        }
        System.out.print(answer);
    }
}

class Letter implements Comparable<Letter> {
    final String s;
    final int cnt;

    public Letter(String s) {
        this.s = s;
        this.cnt = 0;
    }

    public Letter(Letter letter) {
        this.s = letter.s;
        this.cnt = letter.cnt+1;
    }

    @Override
    public int compareTo(final Letter o) {
        if (this.cnt == o.cnt)
            return this.s.compareTo(o.s);
        return this.cnt - o.cnt;
    }
}
