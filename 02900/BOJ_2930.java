import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int round = Integer.parseInt(br.readLine());
        String sg = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        int max = 0;
        int sum = 0;
        for (int i = 0; i < round; i++) {
            char me = sg.charAt(i);

            int s = 0;
            int p = 0;
            int r = 0;
            for (int j = 0; j < n; j++) {
                char o = arr[j].charAt(i);
                s += score('S', o);
                p += score('P', o);
                r += score('R', o);
            }

            max += Math.max(s, Math.max(p, r));
            sum += me=='S'?s:me=='P'?p:r;
        }

        System.out.println(sum);
        System.out.println(max);
    }

    private int score(char me, char o) {
        if (me == o) return 1;
        if (me == 'S' && o == 'P') return 2;
        if (me == 'P' && o == 'R') return 2;
        if (me == 'R' && o == 'S') return 2;
        return 0;
    }
}
