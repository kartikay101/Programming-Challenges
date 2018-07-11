/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-10T11:35:09+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-11T16:40:34+05:30
 */

// The input file is Input.txt present in res folder.

#include<iostream>
#include<fstream>

const std::string ifile_path="res/Input.txt";
const std::string ofile_path="res/base64.txt";
const std::string encode_decode="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

std::string toBase64(std::string binary){
  char ch;
  std::string res="This will be the result";
  int len=binary.length();
  int num=0;

  for(int i=0;i<len;i+=6){
    num=2;
  }

  return res;
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
    if(!input.eof())
    binary+=toBinary(ch);
  }
  output<<toBase64(binary);
  input.close();
  output.close();
  return 0;
}
