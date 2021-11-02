import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    private int find(String a, String b) {
        LinkedList<Integer> lla = new LinkedList<>();
        LinkedList<Integer> llb = new LinkedList<>();
        for (int i = 0; i < a.length(); i++)
            lla.addLast(a.charAt(i)-'0');
        for (int i = 0; i < b.length(); i++)
            llb.addLast(b.charAt(i)-'0');

        int tmp = b.length()-1;
        while(tmp-->0) lla.addFirst(0);
        tmp = a.length()-1;
        while(tmp-->0) llb.addLast(0);

        tmp = b.length()-1;
        int min = a.length() + b.length();
        for (int i = 0; i < a.length(); i++) {
            int cnt = 0;
            Iterator<Integer> ita = lla.iterator();
            Iterator<Integer> itb = llb.iterator();
            boolean chk = true;
            while (ita.hasNext()) {
                cnt++;
                if (ita.next() + itb.next() == 4) {
                    chk = false;
                    break;
                }
            }
            if (chk && cnt < min)
                min = cnt;

            if (--tmp>=0)
                lla.removeFirst();
            llb.removeLast();
            if (llb.size() < lla.size())
                llb.addFirst(0);
        }
        return min;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(Math.min(find(a,b), find(b,a)));
    }

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
