/**
 * @Author: Kartikay Shandil <hunter>
 * @Date:   2018-10-16T19:41:12+05:30
 * @Last modified by:   hunter
 * @Last modified time: 2018-10-16T19:55:07+05:30
 */


#include "iostream"
#include "fstream"

using namespace std;

int main(int argc, char const *argv[]) {
  fstream gg;
  gg.open("somevideo.mp4");
  std::string res;
  while(getline(gg,res)){
    std::cout << res << '\n';
  }
  return 0;
}
