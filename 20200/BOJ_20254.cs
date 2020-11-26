using System;
using System.Collections.Generic;

namespace Boj {
    class Ps {
        readonly static int[] CALC = { 56, 24, 14, 6 };

        static void Main(string[] args) {
            string[] input = Console.ReadLine().Split();
            int sum = 0;
            for (int i = 0; i < input.Length; i++) {
                sum += int.Parse(input[i]) * CALC[i];
            }
            Console.WriteLine(sum);
        }
    }
}
