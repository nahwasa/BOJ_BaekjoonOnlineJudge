#include <iostream>
using namespace std;

int arr[50001] = {0,};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    int a = 0;
    int b = 1;
    int sumA = arr[0];
    int sumB = sum-arr[0];
    int answer = 0;
    while (a<n) {
        answer = max(answer, min(sumA, sumB));
        if (sumA >= sumB) {
            sumA-=arr[a];
            sumB+=arr[a];
            a++;
            continue;
        }
        sumA+=arr[b];
        sumB-=arr[b];
        b++;
        b%=n;
    }
    cout << answer;
    return 0;
}
