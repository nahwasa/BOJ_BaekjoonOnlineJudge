import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    public static void main(String[] args) throws Exception {new Main().solution();}

    private void solution() throws Exception {
        int g = Integer.parseInt(br.readLine());
        List<Integer> square = init(g);
        
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int cur : square) {
            set.add(cur*cur);
            if (!set.contains(cur*cur-g)) continue;
            sb.append(cur).append('\n');
            cnt++;
        }
        System.out.print(cnt==0?-1:sb);
    }

    private List<Integer> init(final int g) {
        List<Integer> sq = new ArrayList<>();
        int bf = 0;
        for (int i = 1; i*i-bf*bf <= g; i++) sq.add(bf = i);
        return sq;
    }
}
