#include <bits/stdc++.h>
using namespace std;

#define int long long 
#define mp make_pair
#define pb push_back
#define ull unsigned long long
#define double long double
int M = 1e9 + 7;
int INF = 1e18;

ull power(ull x,int y, int p){
  ull res = 1; 
  x = x % p; 
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1; 
    x = (x * x) % p;
  }
  return res;
}
 
ull modInverse(ull n,int p){
  return power(n, p - 2, p);
}
 
ull nCr(ull n, int r, int p){
  if (n < r) return 0;
  if (r == 0) return 1;
  ull fac[n + 1];
  fac[0] = 1;
  for (int i = 1; i <= n; i++)
    fac[i] = (fac[i - 1] * i) % p;
  return ((fac[n] * modInverse(fac[r], p) % p) * (modInverse(fac[n - r], p) % p ))% p;
}

int modDivide(int a, int b , int M){
    return ((a%M) * modInverse(b,M))%M;
}

int ceilDiv(int a, int b){
    if (a == 0) return 0;
    return (a - 1)/b + 1;
}


signed main(){ 
    int t;
    cin>>t;
    while(t--){
        int n,d,l;
        cin>>n>>d>>l;
        int leaves = l-2;
        int nodes = n - (d+1);
        if(leaves > nodes){
            cout<<"-1"<<endl;
            continue;
        }
        if(n == l && n!= 1){
            cout<<"-1"<<endl;
            continue;
        }
        if((ceilDiv((n-d-1),(l-2)) > (d+1)/2)){
            cout<<"-1"<<endl;
            continue;
        }

        int h1 = (d)/2;
        int h2 = (d) - (d)/2;
        int h3 = ceilDiv((n-d-1),l-2);
        int h4 = n-d-1/l-2;
        int h4Num = (n-d-1)%(l-2);
        int h3Num = (l-2) - h4Num;

        for(int i = 1 ;i <= h1 ;i++){
            cout<<i<<" "<<(i+1)<<endl;
        }

        cout<<1<<" "<<(h1+2)<<endl;

        for(int i = (h1+2) ; i <= (h1 + 2 + h2 - 2) ;i++){
            cout<<i<<" "<<(i+1)<<endl;
        }

        int node = h1+h2+2;
        for(int j = 0 ;j < h3Num ;j++){
            cout<<1<<" "<<node<<endl;
            for(int i = node ;i <= (node + h3 -2) ;i++){
                cout<<i<<" "<<(i+1)<<endl;
            }
            node = node + h3;
        }

        for(int j = 0 ;j < h4Num ;j++){
            cout<<1<<" "<<node<<endl;
            for(int i = node ;i<= (node + h4 -2) ;i++){
                cout<<i<<" "<<(i+1)<<endl;
            }
            node = node + h4;
        }


    }   

} 





 












