using System;

namespace Prac {
    class Program {
        private static readonly char[] TG = new char[] { '2', '0', '2', '0'};

        static void Main(string[] args) {
            while (true) {
                int n = nextInt();
                int cnt = 0;
                if (n == 0)
                    return;
                char[] arr = Console.ReadLine().ToCharArray();
                for (int i = 0; i < arr.Length; i += 2) {
                    if (arr[i] != TG[0])
                        continue;
                    for (int j = 0; j < TG.Length; j++) {
                        if (i + 2 * j >= arr.Length) break;
                        if (arr[i + 2 * j] != TG[j]) break;
                        if (j == TG.Length - 1) cnt++;
                    }
                }
                Console.WriteLine(cnt);
            }
        }

        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }
    }
}
