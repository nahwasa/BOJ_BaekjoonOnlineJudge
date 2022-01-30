import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int cs=0, cnt=0;
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            if (tmp.indexOf('#') == -1) continue;

            cs = tmp.indexOf('#');
            cnt = 1;
            for (int j = cs+1; j < c; j++) {
                if (tmp.charAt(j) == '.') break;
                cnt++;
            }

            if (cnt != tmp.lastIndexOf('#')-tmp.indexOf('#')+1) {
                System.out.println("UP");
                return;
            }
            break;
        }

        for (int i = 0; i < (cnt-2)/2; i++) {
            br.readLine();
        }

        String tmp = br.readLine();
        if (tmp.charAt(cs) == '#' && tmp.charAt(cs+cnt-1) == '#') {
            System.out.println("DOWN");
        } else if (tmp.charAt(cs) == '#') {
            System.out.println("RIGHT");
        } else {
            System.out.println("LEFT");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
