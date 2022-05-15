import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    class Student implements Comparable<Student> {
        int score, idx;
        public Student(int score, int idx) {
            this.score = score;
            this.idx = idx;
        }
        @Override
        public int compareTo(Student o) {
            return o.score-this.score;
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Student[] arr = new Student[n+1];
        arr[0] = new Student(200, 0);
        for (int i = 1; i <= n; i++) arr[i] = new Student(Integer.parseInt(br.readLine()), i-1);
        Arrays.sort(arr);
        for (int i = 1, ranking = 1; i <= n; i++) {
            if (arr[i-1].score!=arr[i].score) {
                ranking = i;
            }
            answer[arr[i].idx] = ranking;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
