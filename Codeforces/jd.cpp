#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n, m, k;
        cin >> n >> m >> k;
        vector<vector<int>> a(n, vector<int>(m));
        int x = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = x;
                x = x % k + 1;
            }
            if (m % 2 == 0) {
                if (m % k == 0) x = x;
                else x = x % k + 1;
            } else {
                if (k % 2 == 0) x = x % k + 1;
                else x = x;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cout << a[i][j] << " ";
            }
            cout << "\n";
        }
    }
    return 0;
}



F