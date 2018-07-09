# @Author: Kartikay Shandil <kartikay101>
# @Date:   2018-07-08T13:41:57+05:30
# @Last modified by:   kartikay101
# @Last modified time: 2018-07-08T14:38:22+05:30

from bs4 import BeautifulSoup
import os
import requests

def database_populate(url,fname):

    res  = requests.get(url)
    data = res.text

    filepath=os.path.realpath(__file__)
    filepath=filepath.replace('/getter.py','/res/'+fname+'.txt')
    file=open(filepath,'w+')
    soup = BeautifulSoup(data,'lxml')

    tables=soup.find('div',{'class':'datatable'})
    trs=tables.findAll('tr')
    for tr in trs:
        th=tr.find('td')
        th=str(th)
        th=th.replace('<td>','')
        th=th.replace('</td>','')
        if th!='None':
            file.write(th+'\n')
    file.close()
database_populate("https://names.mongabay.com/most_common_surnames.htm","eng_surnames")
database_populate("https://names.mongabay.com/male_names_alpha.htm","eng_mnames")
database_populate("https://names.mongabay.com/female_names_alpha.htm","eng_fnames")
