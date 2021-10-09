import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = "1995: ITMO\n" +
                "1996: SPbSU\n" +
                "1997: SPbSU\n" +
                "1998: ITMO\n" +
                "1999: ITMO\n" +
                "2000: SPbSU\n" +
                "2001: ITMO\n" +
                "2002: ITMO\n" +
                "2003: ITMO\n" +
                "2004: ITMO\n" +
                "2005: ITMO\n" +
                "2006: PetrSU, ITMO\n" +
                "2007: SPbSU\n" +
                "2008: SPbSU\n" +
                "2009: ITMO\n" +
                "2010: ITMO\n" +
                "2011: ITMO\n" +
                "2012: ITMO\n" +
                "2013: SPbSU\n" +
                "2014: ITMO\n" +
                "2015: ITMO\n" +
                "2016: ITMO\n" +
                "2017: ITMO\n" +
                "2018: SPbSU\n" +
                "2019: ITMO";
        StringTokenizer st = new StringTokenizer(data, ":\n");
        String y = br.readLine();
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals(y)) {
                System.out.println(st.nextToken().trim());
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
