import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Jewely {
    int m, v;
    public Jewely(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // sort jewely by m
        Jewely[] arr1 = new Jewely[n];
        while (--n>=0) {
            st = new StringTokenizer(br.readLine());
            arr1[n] = new Jewely(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr1, new Comparator<Jewely>() {
            @Override
            public int compare(Jewely o1, Jewely o2) {
                return o1.m - o2.m;
            }
        });

        // sort bag by c
        int[] arr2 = new int[k];
        while (--k>=0) {
            arr2[k] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr2);

        // solve using pq
        int arr1Iter = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int c : arr2) {
            while (arr1Iter < arr1.length && arr1[arr1Iter].m <= c) {
                pq.add(arr1[arr1Iter].v);
                arr1Iter++;
            }
            sum += pq.isEmpty() ? 0 : pq.poll();
        }
        System.out.println(sum);
    }
}
