import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (o1, o2) -> o2[0]-o1[0]);

        TreeSet<Integer> exist = new TreeSet<>();
        int[] group = new int[n+1];
        group[0] = n;
        for (int[] cur : list) {
            Integer find = exist.lower(cur[1]);
            find = find==null?0:find;
            if (--group[find] == 0) {
                exist.remove(find);
            }
            ++group[find+1];
            exist.add(find+1);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) answer += group[i];
        System.out.println(answer);
    }
}
