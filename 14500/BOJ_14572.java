import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    int power;
    ArrayList<Integer> algo;
    public Student(int power, ArrayList<Integer> algo) {
        this.power = power;
        this.algo = algo;
    }

    @Override
    public int compareTo(Student o) {
        return this.power - o.power;
    }
}
public class Main {
    private int getE(int[] arr, int s, int e) {
        int cnt1 = 0;
        int cnt2 = 0;
        int n = e-s+1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) cnt1++;
            if (arr[i] == n) cnt2++;
        }
        return (cnt1-cnt2)*n;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());
            ArrayList<Integer> algo = new ArrayList<>(m);
            st = new StringTokenizer(br.readLine());
            while (m-->0) algo.add(Integer.parseInt(st.nextToken()));
            students[i] = new Student(power, algo);
        }
        Arrays.sort(students);

        int[] arr = new int[k+1];
        int max = 0;
        int s = 0;
        int e = 0;
        for (int a : students[0].algo)
            arr[a]++;

        while (true) {
            int gap = students[e].power - students[s].power;
            if (gap <= d) {
                max = Math.max(max, getE(arr, s, e));
                e++;
                if (e >= n)
                    break;

                for (int a : students[e].algo)
                    arr[a]++;
                continue;
            }
            for (int a : students[s].algo)
                arr[a]--;
            s++;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
