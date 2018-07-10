/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-10T11:35:09+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-10T11:55:12+05:30
 */

// The input file is Input.txt present in res folder

#include<iostream>
#include<fstream>

const static std::string file_path="res/Input.txt";

int main(int argc, char const *argv[]) {

  std::ifstream input;
  input.open(file_path.c_str());
  std::string s;
  while (getline(input,s)) {
    std::cout<<s<<"  ***"<<std::endl;
  }

  input.close();
  return 0;
}
