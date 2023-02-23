import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.PriorityQueue;

class Node {
    int p, q, room;
    public Node(int p, int q) {
        this.p = p;
        this.q = q;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Node> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            arr.add(new Node(p, q));
        }

        Collections.sort(arr, (o1, o2) -> o1.p-o2.p);

        PriorityQueue<Node> rooms = new PriorityQueue<>((o1, o2) -> o1.q-o2.q);
        PriorityQueue<Node> candidates = new PriorityQueue<>((o1, o2) -> o1.room-o2.room);
        int[] roomCnt = new int[n];

        int roomNo = 0;
        for (Node cur : arr) {
            while (!rooms.isEmpty() && rooms.peek().q < cur.p)
                candidates.add(rooms.poll());
            int selectedRoomNo = candidates.isEmpty() ? roomNo++ : candidates.poll().room;
            roomCnt[selectedRoomNo]++;
            cur.room = selectedRoomNo;
            rooms.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n && roomCnt[i] != 0; i++, cnt++) {
            sb.append(roomCnt[i]).append(' ');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}
