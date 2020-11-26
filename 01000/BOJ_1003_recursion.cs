using System;
using System.Linq;
using System.Text;

namespace Boj {
    class Ps {
        const int MAX = 40;
        static int[,] arr;

        static void Main(string[] args) {
            int tc = nextInt();
            arr = new int[2, MAX+1];
            arr[0, 0] = 1;
            arr[1, 1] = 1;

            fibo(40);

            StringBuilder sb = new StringBuilder();
            while (tc-->0) {
                int tmp = nextInt();
                sb.Append(string.Format("{0} {1}\n", arr[0, tmp], arr[1, tmp]));
            }
            Console.WriteLine(sb.ToString());
        }

        private static void fibo(int n) {
            if (n <= 1) return;
            if (arr[0, n] * arr[1, n] > 0) return;
            fibo(n - 1);
            arr[0, n] = arr[0, n - 2] + arr[0, n - 1];
            arr[1, n] = arr[1, n - 2] + arr[1, n - 1];
        }

        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }
    }
}
