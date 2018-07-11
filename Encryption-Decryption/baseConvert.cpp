/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-10T11:35:09+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-11T21:49:55+05:30
 */

// The input file is Input.txt present in res folder.

#include<iostream>
#include<fstream>

const std::string ifile_path="res/Input.txt";
const std::string ofile_path="res/base64.txt";
const std::string encode_decode="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

std::string toBase64(std::string binary){

  int len=binary.length();
  binary.substr(0,len-8); // removing last unintended newline character 00001010
  len-=8;
  char ch;
  std::string res="";
  std::string padding="";
  int pad=len%6;

  for(int i=0;i<pad;i++){
    binary+='0';
  }
  while (pad%8!=0) {
    pad=pad+6;
    padding+='=';
  }

  int num=0,cnt=0,x=32,byte;

  for(int i=0;i<len;i++){
    cnt++;
    byte=binary[i]=='1'?1:0;
    num+=x*byte;
    x/=2;
    if(cnt==6){
      res+=encode_decode[num];
      x=32;
      num=0;
      cnt=0;
    }
  }

  return res+padding;
}

std::string toBinary(char ch){

      int ascii=(int)ch;
      std::string res="";
      int cnt=0;
      int bit;

      while(ascii>0){
        bit=ascii%2;
        ch=(bit==1)?'1':'0';
        ascii/=2;
        res=ch+res;
        cnt++;
      }

      for(int i=cnt;i<8;i++){
        res='0'+res;
      }

      return res;
}

int main(int argc, char const *argv[]) {

  std::ifstream input;
  std::ofstream output;
  input.open(ifile_path.c_str());
  output.open(ofile_path.c_str());

  char ch;
  std::string binary="";

  while (input.get(ch)){
    binary+=toBinary(ch);
  }
  output<<toBase64(binary);
  input.close();
  output.close();
  return 0;
}
