#include "bits/stdc++.h"
using namespace std;
int main(){
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        vector<int> vc(n, 0);
        vector<int> diff(n + 1, 0); 
        vector<pair<int, int>> intervals(k);

        for (int i = 0; i < k; i++) {
            int l, r, m;
            cin >> l >> r >> m;
            l--; r--;
            diff[l] += m;
            diff[r + 1] -= m;
        }
        vector<int> active(n, 0);
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            active[i] = current;
        }

        // Build the result array with gap checking
        vector<int> ans(n, 0);
        int f = 1;
        set<int> used_numbers;
        for (int i = 0; i < n; i++) {
            // Find the smallest number not in the `used_numbers` set
            int a = 1;
            while (used_numbers.count(a)) {
                a++;
            }

            // Check if the smallest valid number exceeds the constraint
            if (a > active[i]) {
                f = 0;
                break;
            }

            ans[i] = a;
            used_numbers.insert(a);
        }

        if (!f) {
            cout << "-1" << endl;
        } else {
            for (int x : ans) cout << x << " ";
            cout << endl;
        }
    }
    return 0;
}
