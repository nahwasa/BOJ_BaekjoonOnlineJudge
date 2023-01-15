import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

interface Pedigree {
    public int maxScore(int[] arr);
}
class OneToSix {
    public int calc(int[] arr, int target) {
        int sum = target*2;
        for (int i = 0; i < 3; i++)
            if (arr[i] == target) sum+=target;
        return sum;
    }
}
class Ones extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 1);
    }
}
class Twos extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 2);
    }
}
class Threes extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 3);
    }
}
class Fours extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 4);
    }
}
class Fives extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 5);
    }
}
class Sixes extends OneToSix implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return calc(arr, 6);
    }
}
class FourOfAKind implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        if (arr[0]==arr[1] || arr[0]==arr[2])
            return arr[0]*4;
        if (arr[1]==arr[2])
            return arr[1]*4;
        return 0;
    }
}
class FullHouse implements Pedigree {
    private int calc(int couple, int solo) {
        return couple*3+solo*2;
    }

    @Override
    public int maxScore(int[] arr) {
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            if (arr[0] == 6)
                return 6*3+5*2;
            else
                return arr[0]*3+6*2;
        }
        if (arr[0] == arr[1] && arr[0] != arr[2]) {
            return Math.max(calc(arr[0], arr[2]), calc(arr[2], arr[0]));
        }
        if (arr[0] == arr[2] && arr[0] != arr[1] || arr[1] == arr[2] && arr[0] != arr[1]) {
            return Math.max(calc(arr[0], arr[1]), calc(arr[1], arr[0]));
        }
        return 0;
    }
}
class LittleStraight implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        if (arr[0] == 6 || arr[1] == 6 || arr[2] == 6)
            return 0;
        int[] cnt = new int[7];
        for (int i = 0; i < 3; i++)
            if (++cnt[arr[i]]==2) return 0;
        return 30;
    }
}
class BigStraight implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        if (arr[0] == 1 || arr[1] == 1 || arr[2] == 1)
            return 0;
        int[] cnt = new int[7];
        for (int i = 0; i < 3; i++)
            if (++cnt[arr[i]]==2) return 0;
        return 30;
    }
}
class Yacht implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            return 50;
        }
        return 0;
    }
}
class Choice implements Pedigree {
    @Override
    public int maxScore(int[] arr) {
        return arr[0]+arr[1]+arr[2]+6*2;
    }
}

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void solution() throws Exception {
        String str = br.readLine();
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Pedigree> pedigrees = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            if (str.charAt(i) == 'N') continue;
            switch (i) {
                case 0: pedigrees.add(new Ones()); break;
                case 1: pedigrees.add(new Twos()); break;
                case 2: pedigrees.add(new Threes()); break;
                case 3: pedigrees.add(new Fours()); break;
                case 4: pedigrees.add(new Fives()); break;
                case 5: pedigrees.add(new Sixes()); break;
                case 6: pedigrees.add(new FourOfAKind()); break;
                case 7: pedigrees.add(new FullHouse()); break;
                case 8: pedigrees.add(new LittleStraight()); break;
                case 9: pedigrees.add(new BigStraight()); break;
                case 10: pedigrees.add(new Yacht()); break;
                case 11: pedigrees.add(new Choice()); break;
            }
        }

        int max = 0;
        for (Pedigree cur : pedigrees) {
            max = Math.max(max, cur.maxScore(arr));
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
