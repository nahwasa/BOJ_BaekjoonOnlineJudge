import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        new Main().solution();
    }

    private void solution() {
        List<Integer> pn = initPn(sc.nextInt());

        int s = 0;
        int e = pn.size()-1;

        while (s<=e) {
            int mid = (s+e)/2;
            if (question(pn.get(mid))) e = mid-1;
            else s = mid+1;
        }
        answer(pn.get(s));
    }

    private List<Integer> initPn(int limit) {
        List<Integer> pn = new ArrayList<>();
        boolean[] isPn = new boolean[limit + 1];
        int sqrtN = (int)Math.sqrt(limit);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= limit) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= limit; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
        return pn;
    }

    private boolean question(int num) {
        System.out.println("? " + num);
        System.out.flush();
        return sc.nextInt()==0;
    }

    private void answer(int num) {
        System.out.println("! " + num);
        System.out.flush();
    }
}
