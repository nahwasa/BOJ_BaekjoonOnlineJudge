import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int convert(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int sec = 0;
        sec += Integer.parseInt(st.nextToken()) * 60 * 60;
        sec += Integer.parseInt(st.nextToken()) * 60;
        sec += Integer.parseInt(st.nextToken());
        return sec;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String ed = br.readLine();
        if (st.equals(ed)) {
            System.out.println("24:00:00");
            return;
        }
        int gap = convert(ed) - convert(st);
        if (gap < 0) gap += 24*60*60;
        int hour = gap/(60*60);
        gap %= 60*60;
        int min = gap/60;
        gap %= 60;
        int sec = gap;
        System.out.println(String.format("%s:%s:%s", ""+(hour<10?"0"+hour:hour), ""+(min<10?"0"+min:min), ""+(sec<10?"0"+sec:sec)));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
