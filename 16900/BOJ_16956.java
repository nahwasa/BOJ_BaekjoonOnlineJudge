import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        answer.append('1').append('\n');
        ArrayList<Integer> wolf = new ArrayList<>();
        ArrayList<Integer> sheep = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            String cur = br.readLine();
            if (cur.indexOf("SW") != -1 || cur.indexOf("WS") != -1) {
                System.out.println(0);
                return;
            }
            for (int w : wolf) {
                if (cur.charAt(w) == 'S') {
                    System.out.println(0);
                    return;
                }
            }
            for (int s : sheep) {
                if (cur.charAt(s) == 'W') {
                    System.out.println(0);
                    return;
                }
            }
            wolf = new ArrayList<>();
            for (int j = 0; j < c; j++)
                if (cur.charAt(j) == 'W')
                    wolf.add(j);
            sheep = new ArrayList<>();
            for (int j = 0; j < c; j++)
                if (cur.charAt(j) == 'S')
                    sheep.add(j);
            answer.append(cur.replaceAll("\\.", "D")).append('\n');
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
