/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-18T14:11:52+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-18T14:25:54+05:30
 */

#define ll long long
#define loop(x,n) for(int x=0;x<n;x++)
#define ploop(x,a,n) for(int x=a;x<n;x++)
#define nloop(x,a,n) for(int x=a;x>n;x--)
#include <bits/stdc++.h>
#include <string>

using namespace std;

int main(int argc, char const *argv[]) {

  int T;

  cin>>T;

  loop(tc,T){

    int a,b,c;
    string res="";

    cin>>a>>b>>c;

    for(int i=1;i<=c;i++){
      if(i%a==0){
        res+="Fizz";
      }
      if(i%b==0){
        res+="Buzz";
      }
      if(res==""){


        res=to_string(i); // only works with c++ 11+ distributions

        /*
        stringstream ss;    // use it for std compiler output
        ss<<i;
        ss>>res;
        //*/

      }
      cout<<res<<endl;
      res="";
    }
  }

  return 0;
}
