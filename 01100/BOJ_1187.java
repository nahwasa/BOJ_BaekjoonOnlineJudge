import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Num {
    int num;
    int[] ingredients;
    public Num(int num, int idx) {
        this.num = num;
        ingredients = new int[64];  // 2*2^10/sizeof(int)
        ingredients[idx/32] = 1<<idx%32;
    }
    public Num(Num a, Num b) {
        num = a.num + b.num;
        ingredients = new int[64];
        for (int i = 0; i < 64; i++) {
            this.ingredients[i] = a.ingredients[i] | b.ingredients[i];
        }
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2*n-1];
        Deque<Num> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*n-1; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            dq.add(new Num(cur, i));
        }
        int k = 1;
        int tmp = n;
        while((tmp>>=1) != 1) {
            k++;
        }
        for (int i = 1; i <= k; i++) {
            int limit = dq.size() / 2;
            for (int j = 0; j < limit; j++) {
                Num[] sel = {dq.pollFirst(), dq.pollFirst(), dq.pollFirst()};

                boolean chk = false;
                for (int y = 0; y < 2 && !chk; y++) {
                    for (int z = y+1; z < 3; z++) {
                        if ((sel[y].num + sel[z].num) % (1<<i) == 0) {
                            dq.addLast(new Num(sel[y], sel[z]));
                            if (j != limit-1) dq.addFirst(sel[3-y-z]);
                            chk = true;
                            break;
                        }
                    }
                }

            }
        }
        int[] answer = dq.poll().ingredients;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            int idx = i*32;
            for (int j = 0; j < 32; j++) {
                if ((answer[i] & 1<<j) != 0) {
                    sb.append(arr[idx + j]).append(' ');
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
