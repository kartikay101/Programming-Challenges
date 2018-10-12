/**
 * @Author: Kartikay Shandil <hunter>
 * @Date:   2018-10-12T11:26:12+05:30
 * @Last modified by:   hunter
 * @Last modified time: 2018-10-12T16:07:05+05:30
 */

#include <usb.h>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <unordered_set>
#include "stdlib.h"
#include "stdio.h"
#include "string.h"
// defines for better visuals

#define PURPLE  "\033[95m"
#define CYAN "\033[96m"
#define DARKCYAN  "\033[36m"
#define BLUE  "\033[94m"
#define GREEN  "\033[92m"
#define YELLOW  "\033[93m"
#define RED  "\033[91m"
#define BOLD  "\033[1m"
#define UNDERLINE  "\033[4m"
#define END  "\033[0m"

// defines end
// to clear the screen
void clearscr(){
  std::cout <<std::flush<< '\n';
  system("clear");
}

// generates a random name for a file, to prevent symlink attacks
std::string filename(){
  static const char text[]="aAbBcCdDe9Ef0FGgHh5Ii6jJk4K3LlMm2NnOo1PpQqRrSsT7tUuV9vWwXxyYZz";
  std::string fname="";
  for (int i = 0; i <12; i++) {
    fname+=text[rand()%61];
  }
  fname+=".txt";
  return fname;
}

// check identical files
std::string identical(std::string file1,std::string file2){
  std::fstream f1,f2;
  f1.open(file1,std::ios::in);
  f2.open(file2,std::ios::in);

  std::unordered_set<std::string> data;
  std::unordered_set<std::string> data2;
  std::string value;
  while(std::getline(f1,value)){
    data.insert(value);
  }
  while(std::getline(f2,value)){
    data2.insert(value);
  }
  bool flag=false;
  for (const auto& elem: data2) {
      auto pos=data.find(elem);
      if(pos==data.end()){
        return elem;
      }
  }
  return "devicenotfound";
}


// detect current and added usb devices.
void detect(){

  std::string file1=filename(); //prevents symlink attacks;
  std::string file2=filename();
  std::string command="lsusb >"+file1; // get usb details

  system(command.c_str());
  command="lsusb >"+file2;
  bool flag=true;
  std::cout << "Insert the USB device you want to use as the Key" << '\n';
  std::string device;
  while(flag){
    sleep(15);
    system(command.c_str());
    device=identical(file1,file2);
    if(device.compare("devicenotfound")==0){
      std::cout << "Device Not Detected, reinsert the device, or press Ctrl+C to cancel" << '\n';
    }
    else{
      std::cout << "The Device detected is :\n\n"<<RED<<UNDERLINE<<device<<END<<END<<'\n';
      std::cout << "\n\nIf this is not the correct device Press \"r\" to try again or any other key to continue" << '\n';
      char ch;
      ch=getchar();
      if(ch!='r'){
        flag=false;
      }
      else{
        std::cout << "Insert the USB device you want to use as the Key" << '\n';
      }
    }
  }
  std::cout << "The Chosen Device Is:\n"<<BLUE<<BOLD<<device<<END<<END<< '\n';
  // removing created files
  command="rm "+file1+" "+file2;
  system(command.c_str());
}

void init(){
  clearscr();
  std::cout <<RED<< "Welcome To The USB Locker setup"<<END<< '\n';
  sleep(1);
  std::cout << "Press Any Key To Continue..." << '\n';
  getchar();
  clearscr();
  detect();
}

int main(int argc, char const *argv[]) {
  srand(time(0));
  init();
  return 0;
}
