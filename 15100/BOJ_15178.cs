using System;

namespace Prac {
    class Program {
        private const int VALID_ANGLE_SUM = 180;
        private const string VALID_MSG = "Seems OK";
        private const string INVALID_MSG = "Check";

        static void Main(string[] args) {
            int n = int.Parse(Console.ReadLine());

            while (n-- > 0) {
                string input = Console.ReadLine();
                string[] tokens = input.Split();
                int sum = 0;
                foreach (string s in tokens) {
                    sum += int.Parse(s);
                }
                Console.WriteLine(input + " " + (sum == VALID_ANGLE_SUM ? VALID_MSG : INVALID_MSG));
            }
        }
    }
}
