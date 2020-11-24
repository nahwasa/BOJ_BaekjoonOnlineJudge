using System;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            String[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int l = int.Parse(input[1]);
            int d = int.Parse(input[2]);
            bool[] arr = new bool[n * (l + 5) + 1];
            for (int i = 0; i < n; i++) {
                int s = i * (l + 5);
                for (int j = s; j < s + l; j++) {
                    arr[j] = true;
                }
            }

            int cnt = 0;
            for (; cnt < n * (l + 5) / d; cnt++) {
                if (!arr[(cnt+1) * d]) {
                    Console.WriteLine((cnt + 1) * d);
                    return;
                }
            }
            Console.WriteLine(cnt * d + d);
        }
    }
}
