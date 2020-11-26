using System;
using System.Linq;
using System.Text;

namespace Boj {
    class Ps {
        static void Main(string[] args) {
            int tc = nextInt();
            int[] num = new int[tc];
            for (int i = 0; i < tc; i++) {
                num[i] = nextInt();
            }
            int max = num.Max();
            max = Math.Max(1, max);

            int[,] arr = new int[2, max+1];
            arr[0, 0] = 1;
            arr[1, 1] = 1;
            for (int i = 2; i <= max; i++) {
                arr[0, i] = arr[0, i - 1] + arr[0, i - 2];
                arr[1, i] = arr[1, i - 1] + arr[1, i - 2];
            }

            StringBuilder sb = new StringBuilder();
            foreach (int tmp in num) {
                sb.Append(string.Format("{0} {1}\n", arr[0, tmp], arr[1, tmp]));
            }
            Console.WriteLine(sb.ToString());
        }

        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }
    }
}
