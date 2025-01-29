#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;

        vector<int> a(n);
        for (auto &it : a) cin >> it;
        sort(a.begin(), a.end());

        // Compute prefix sum
        vector<int> pre(n + 1, 0); // Prefix sum array
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + a[i - 1];
        }

        // Calculate the result for each m = 1, 2, ..., n
        for (int i = 1; i <= n; i++) {
            int chances = i / (k + 1); // Number of free items
            int ans = pre[i]; // Total cost without free items
            ans -= pre[chances]; // Subtract the cost of the cheapest 'chances' items
            cout << ans << " ";
        }
        cout << endl;
    }

    return 0;
}
