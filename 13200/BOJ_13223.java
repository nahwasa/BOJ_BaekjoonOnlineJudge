import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date st = simpleDateFormat.parse(br.readLine());
        Date ed = simpleDateFormat.parse(br.readLine());
        if (st.compareTo(ed) == 0) {
            System.out.println("24:00:00");
            return;
        }
        if (st.compareTo(ed) > 0)
            ed = Date.from(ed.toInstant().plus(Duration.ofHours(24)));
        Date base = simpleDateFormat.parse("00:00:00");
        Date gap = Date.from(base.toInstant().plus(Duration.ofSeconds((ed.getTime() - st.getTime())/1000)));
        System.out.println(simpleDateFormat.format(gap));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
