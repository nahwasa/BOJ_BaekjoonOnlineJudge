import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private int getPow3WithMod(int i, int mod) {
        int ans = i;
        ans*=i;
        ans%=mod;
        ans*=i;
        return ans%mod;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++) arr.add(i);
        int bf = 0;
        for (int i = 1; i < n; i++) {
            int removeNum = (bf + getPow3WithMod(i, arr.size()) - 1) % arr.size();
            if (removeNum < 0) removeNum+=arr.size();
            arr.remove(bf=removeNum);
        }
        System.out.println(arr.get(0));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
