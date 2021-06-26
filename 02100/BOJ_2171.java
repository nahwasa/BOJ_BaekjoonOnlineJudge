import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int coordCompIdxR = -1;
        int coordCompIdxC = -1;
        HashMap<Integer, Integer> rMap = new HashMap<>();
        HashMap<Integer, Integer> cMap = new HashMap<>();

        int[][] map = new int[5000][5000];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (rMap.containsKey(r)) r = rMap.get(r);
            else rMap.put(r, (r = ++coordCompIdxR));
            if (cMap.containsKey(c)) c = cMap.get(c);
            else cMap.put(c, (c = ++coordCompIdxC));

            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(r);
            tmp.add(c);
            list.add(tmp);

            map[r][c] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int r1 = list.get(i).get(0);
                int c1 = list.get(i).get(1);
                int r2 = list.get(j).get(0);
                int c2 = list.get(j).get(1);
                if (r1 == r2 || c1 == c2) continue;
                if (map[r1][c2] == 0 || map[r2][c1] == 0)   continue;
                cnt++;
            }
        }
        System.out.println(cnt / 2);
    }
}
