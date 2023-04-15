import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        double gradeSum = 0;
        double sum = 0;
        int line = 20;

        while (line-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            Double rating = getRating(st.nextToken());
            if (rating == null) continue;
            sum += grade * rating;
            gradeSum += grade;
        }

        System.out.printf("%.5f\n", sum / gradeSum);
    }

    private Double getRating(final String s) {
        switch (s) {
            case "A+" : return 4.5;
            case "A0" : return 4.0;
            case "B+" : return 3.5;
            case "B0" : return 3.0;
            case "C+" : return 2.5;
            case "C0" : return 2.0;
            case "D+" : return 1.5;
            case "D0" : return 1.0;
            case "F" : return 0.0;
        }
        return null;
    }
}
