#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> arr;
    int n, m, tmp;
    cin >> n >> m;
    arr.push_back(0);
    while (n--) {
        cin >> tmp;
        tmp += arr.back();
        arr.push_back(tmp);
    }
    int a, b;
    while (m--) {
        cin >> a >> b;
        cout << arr[b]-arr[a-1] << '\n';
    }
}
