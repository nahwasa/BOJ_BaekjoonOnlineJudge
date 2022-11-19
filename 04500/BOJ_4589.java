import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private boolean isEqualArrayList(ArrayList<Integer> arr, ArrayList<Integer> sortedArr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != sortedArr.get(i))
                return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("Gnomes:\n");
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> sortedArr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int cur = Integer.parseInt(st.nextToken());
                arr.add(cur);
                sortedArr.add(cur);
            }
            Collections.sort(sortedArr);
            boolean chk = isEqualArrayList(arr, sortedArr);
            Collections.sort(sortedArr, Collections.reverseOrder());
            chk = chk || isEqualArrayList(arr, sortedArr);
            sb.append(chk ? "Ordered" : "Unordered").append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
