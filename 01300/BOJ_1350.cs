using System;
using static System.Console;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            ReadLine();
            String[] arr = ReadLine().Split(' ');
            int cluster = int.Parse(ReadLine());
            long sum = 0;
            foreach (String s in arr) {
                int tmp = int.Parse(s);
                if (tmp == 0)
                    continue;
                sum += cluster * (tmp / cluster);
                sum += (tmp % cluster == 0 ? 0 : cluster);
            }
            Write(sum);
        }
    }
}
