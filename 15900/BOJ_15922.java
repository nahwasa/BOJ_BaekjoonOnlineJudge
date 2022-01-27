import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pos implements Comparable<Pos> {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Pos> arr = new ArrayList<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);

        int s = arr.get(0).x;
        int e = arr.get(0).y;
        int answer = 0;
        for (int i = 1; i < arr.size(); i++) {
            Pos cur = arr.get(i);
            if (e >= cur.x) {
                e = Math.max(e, cur.y);
            } else {
                answer += e-s;
                s = cur.x;
                e = cur.y;
            }
        }
        answer += e-s;

        System.out.println(answer);
    }
}
