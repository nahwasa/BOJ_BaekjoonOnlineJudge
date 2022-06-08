import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Food implements Comparable<Food> {
    String key;
    ArrayList<Food> edge;
    public Food(String key) {
        this.key = key;
        edge = new ArrayList<>();
    }

    @Override
    public int compareTo(Food o) {
        return this.key.compareTo(o.key);
    }
}
public class Main {
    StringBuilder ans = new StringBuilder();
    private void dfs(Food food, int depth) {
        Collections.sort(food.edge);
        for (Food next : food.edge) {
            for (int i = 0; i < depth; i++) ans.append('-').append('-');
            ans.append(next.key).append('\n');
            dfs(next, depth+1);
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Food root = new Food(null);
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Food pt = root;
            for (int i = 0; i < k; i++) {
                String cur = st.nextToken();
                boolean isMatched = false;
                for (Food next : pt.edge) {
                    if (next.key.equals(cur)) {
                        pt = next;
                        isMatched = true;
                        break;
                    }
                }
                if (!isMatched) {
                    Food newFood = new Food(cur);
                    pt.edge.add(newFood);
                    pt = newFood;
                }
            }
        }
        dfs(root,0);
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
