#include<bits/stdc++.h>
using namespace std;
const int max=110000;const int q=1e5;
int main(){
    vector<bool> prime(max+1,true);
    prime[0]=prime[1]=false;
    for(int i=2;i*i<=max;i++)if(prime[i])for(int j=i*i;j<=max;j+=i)prime[j]=false;
    vector<int> v;
    for(int i=2;i<=max;i++)if(prime[i])v.push_back(i);
    vector<int> a(q+1);
    int i(0);
    for(int j=1;j<=q;j++){
      while(i<v.size()&&v[i]<j)i++;
        a[j]=v[i];
    }
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        cout<<a[n]<<endl;
    }
}