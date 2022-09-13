#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n = 10, tmp;
    int arr[42] = {0,};
    while (n--) {
        cin >> tmp;
        arr[tmp%42]++;
    }
    int cnt = 0;
    for (int i = 0; i < 42; i++) {
        cnt += arr[i]?1:0;
    }
    cout << cnt;
}
