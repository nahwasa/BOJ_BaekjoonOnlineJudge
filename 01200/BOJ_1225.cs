using System;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            string[] input = Console.ReadLine().Split(' ');
            long sum = 0;
            for (int i = 0; i < input[0].Length; i++) {
                for (int j = 0; j < input[1].Length; j++) {
                    sum += charToInt(input[0][i]) * charToInt(input[1][j]);
                }
            }
            Console.Write(sum);
        }

        static int charToInt(char c) {
            return c - '0';
        }
    }
}
