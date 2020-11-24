using System;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            String[] input = Console.ReadLine().Split();
            int[] arr = new int[input.Length];
            for (int i = 0; i < input.Length; i++) {
                arr[i] = int.Parse(input[i]);
            }
            Array.Sort(arr);
            if (arr[0] == arr[2]) {
                Console.WriteLine("2");
                return;
            }
            if (arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]) {
                Console.WriteLine("1");
                return;
            }
            Console.WriteLine("0");
        }
    }
}
