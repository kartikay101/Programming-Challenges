/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-06T19:19:12+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-21T00:09:04+05:30
 */

#define ll long long
#define loop(x,n) for(int x=0;x<n;x++)
#define ploop(x,a,n) for(int x=a;x<n;x++)
#define nloop(x,a,n) for(int x=a;x>n;x--)
#include <bits/stdc++.h>
#include <fstream>
using namespace std;

std::map<string, string> morseMap={{"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},{"E","."},
{"F","..-."},{"G","--."},{"H","...."},{"I",".."},{"J",".---"},{"K","-.-"},
{"L",".-.."},{"M","--"},{"N","-."},{"O","---"},{"P",".--."},{"Q","--.-"},
{"R",".-."},{"S","..."},{"T","-"},{"U","..-"},{"V","...-"},{"W",".--"},
{"X","-..-"},{"Y","-.--"},{"Z","--.."},{"0","-----"},{"1",".----"},{"2","..---"},
{"3","...--"},{"4","....-"},{"5","....."},{"6","-...."},{"7","--..."},
{"8","---.."},{"9","----."},{".",".-.-.-"},{",","--..--"},{"?","..--.."},
{"’",".----."},{"!","-.-.--"},{"/","-..-."},{"(","-.--."},{")","-.--.-"},
{"&",".-..."},{":","---..."},{";","-.-.-."},{"=","-...-"},{"+",".-.-."},
{"-","-....-"},{"_","..--.-"},{"\"",".-..-."},{"@",".--.-."}};

int main(){

  fstream reader,writer;
  reader.open("input.txt");
  writer.open("output.txt",fstream::out);
  string s;
  string find="";
  while(getline(reader,s)){
    int length=s.length();
    string res="";
    std::transform(s.begin(), s.end(),s.begin(), ::toupper);
    for(int i=0;i<length;i++){
      if((int)s[i]==32){
        res+=" ";
      }
      else{
        find=s[i];
        res+=morseMap[find]+" ";
      }
    }
    writer<<res.substr(0,res.length()-1)<<endl;
  }
  reader.close();
  writer.close();
return 0;
}
