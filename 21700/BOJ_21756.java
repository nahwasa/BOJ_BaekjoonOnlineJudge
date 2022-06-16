import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) arr.add(i);
        while (arr.size() != 1) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 1; i < arr.size(); i+=2) tmp.add(arr.get(i));
            arr = tmp;
        }
        System.out.println(arr.get(0));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
