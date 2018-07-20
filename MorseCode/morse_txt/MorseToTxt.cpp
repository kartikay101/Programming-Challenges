/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-19T18:04:23+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-21T00:02:26+05:30
 */



#define ll long long
#define loop(x,n) for(int x=0;x<n;x++)
#define ploop(x,a,n) for(int x=a;x<n;x++)
#define nloop(x,a,n) for(int x=a;x>n;x--)
#include <bits/stdc++.h>
#include <fstream>
using namespace std;

std::map<string, string> morseMap={{".-","A"},{"-...","B"},{"-.-.","C"},{"-..","D"},{".","E"},{"..-.","F"},
{"--.","G"},{"....","H"},{"..","I"},{".---","J"},{"-.-","K"},{".-..","L"},{"--","M"},{"-.","N"},{"---","O"},
{".--.","P"},{"--.-","Q"},{".-.","R"},{"...","S"},{"-","T"},{"..-","U"},{"...-","V"},{".--","W"},{"-..-","X"},
{"-.--","Y"},{"--..","Z"},{"-----","0"},{".----","1"},{"..---","2"},{"...--","3"},{"....-","4"},{".....","5"},
{"-....","6"},{"--...","7"},{"---..","8"},{"----.","9"},{".-.-.-","."},{"--..--",","},{"..--..","?"},
{".----.","'"},{"-.-.--","!"},{"-..-.","/"},{"-.--.","("},{"-.--.-",")"},{".-...","&"},{"---...",":"},
{"-.-.-.",";"},{"-...-","="},{".-.-.","+"},{"-....-","-"},{"..--.-","_"},{".-..-.","\""},{".--.-.","@"}};
// I didn't write this by hand, that would be dumb
int main(){


  fstream reader,writer;

  reader.open("input.txt");
  writer.open("output.txt",fstream::out);

  string s;
  while(getline(reader,s)){
    int len=s.length();
    string ss="";
    string res="";
    loop(i,len){
        char ch=s[i];
        if((int)ch==32){
          char ch2=s[i+1];
          if((int)ch2==32){
            res+=morseMap[ss]+" ";
            i+=1;
            ss="";
          }
          else{
            res+=morseMap[ss];
            ss="";
          }
        }
        else{
          ss+=s[i];
        }
    }
    res+=morseMap[ss];
    writer<<res<<endl;
  }
  reader.close();
  writer.close();
  return 0;
}
