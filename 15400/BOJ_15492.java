import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    class Pos{
        int from, idx;
        public Pos(int idx) {this.from = idx; this.idx=idx+1;}
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[n-i] = Integer.parseInt(st.nextToken());
            if (arr[n-i] < min)
                min = arr[n-i];
        }
        arr[0] = Integer.parseInt(st.nextToken());

        ArrayList<Pos> minPos = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] == min) {
                minPos.add(new Pos(i));
            }
        }
        if (minPos.size() == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(' ');
            }
            System.out.print(sb);
            return;
        }
        if (n%2 == 0) {
            boolean halfSame = true;
            for (int i = 0; i < n/2; i++) {
                if (arr[i] != arr[n/2+i]) {
                    halfSame = false;
                    break;
                }
            }
            if (halfSame) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(arr[i]).append(' ');
                }
                System.out.print(sb);
                return;
            }
        }

        int cnt = 0;
        while (minPos.size()!=1 && cnt<(n/minPos.size())+1) {
            cnt++;
            ArrayList<Pos> tmp = new ArrayList<>();
            min = Integer.MAX_VALUE;
            for (int i = 0; i < minPos.size(); i++) {
                Pos cur = minPos.get(i);
                int see = cur.idx % n;
                if (min > arr[see]) {
                    min = arr[see];
                }
            }
            for (int i = 0; i < minPos.size(); i++) {
                Pos cur = minPos.get(i);
                int see = cur.idx % n;
                if (min != arr[see]) continue;
                cur.idx++;
                tmp.add(cur);
            }
            minPos = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            min = arr[(minPos.get(0).from+i)%n];
            for (int m = 0; m < minPos.size(); m++) {
                int cur = arr[(minPos.get(m).from+i)%n];
                if (min > cur) {
                    ArrayList<Pos> tmp = new ArrayList<>();
                    tmp.add(minPos.get(m));
                    minPos = tmp;
                    break;
                } else if (min < cur) {
                    ArrayList<Pos> tmp = new ArrayList<>();
                    tmp.add(m+1>=minPos.size()?minPos.get(0):minPos.get(m+1));
                    minPos = tmp;
                    break;
                }
            }
            sb.append(min).append(' ');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
