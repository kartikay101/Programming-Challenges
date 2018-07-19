# @Author: Kartikay Shandil <kartikay101>
# @Date:   2018-07-19T22:53:10+05:30
# @Last modified by:   kartikay101
# @Last modified time: 2018-07-19T23:47:57+05:30

import math

name1=input("Enter First Name :\n")
name2=input("Enter Second Name : \n")

name1=name1.upper()
name2=name2.upper()

freq1=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
freq2=[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

for i in range(0,len(name1)):
    if name1[i] == " " :
        freq1[26]+=1
    else :
        freq1[ord(name1[i])-65]+=1


for i in range(0,len(name2)):
    if name2[i] == " " :
        freq2[26]+=1
    else :
        freq2[ord(name2[i])-65]+=1

cnt=0

for i in range(0,27):
    if freq1[i]>0 and freq2[i]==0 :
        cnt+=1
    elif freq1[i]==0 and freq2[i]>0 :
        cnt+=1

str='FLAMES'

cntr=0;
while len(str)>1 :
    cntr=cnt%len(str)
    str=str[:cntr]+str[cntr+1:]

res=[['F','FRIENDS','60%'],['L','In LOVE','80%'],['A','AFFECTIONATE Towards Each Other','70%'],['M','Perfect for MARRIAGE','100%'],['E','Arch ENEMIES','0%'],['S',' Loving SIBLINGS','100%']]

for i in range(0,6):
    if res[i][0]==str:
        print(name1+" and "+name2+" are "+res[i][1]+" with a Love Percentage of "+res[i][2])
        break
