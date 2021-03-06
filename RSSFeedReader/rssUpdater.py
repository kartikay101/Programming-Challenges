import os
import requests
from lxml import etree

import re
writer=open('final.html','w')
class color:
   PURPLE = '\033[95m'
   CYAN = '\033[96m'
   DARKCYAN = '\033[36m'
   BLUE = '\033[94m'
   GREEN = '\033[92m'
   YELLOW = '\033[93m'
   RED = '\033[91m'
   BOLD = '\033[1m'
   UNDERLINE = '\033[4m'
   END = '\033[0m'

def feedGetter(feedurl):
    raw_feed=requests.get(feedurl[:-1])
    file=open('results.html','w')
    utf8_parser = etree.XMLParser(encoding='utf-8')
    xml =etree.fromstring((raw_feed.text).encode('utf-8'),parser=utf8_parser)
    rss=xml.getchildren()
    channel=rss[0].getchildren()
   # writer=open('final.html','w')
    try:
        print(channel[0].text+"\n\n")
        #print(channel[1].text+"\n\n")
        print(channel[2].text+"\n\n")
    except Exception as e:
        print(False)
    for nodes in channel:
        if nodes.tag=='item':
            sub=nodes.getchildren()
            for data in sub:
                if data.tag=='title':
                    print(color.GREEN+data.text.upper()+color.END)
                  #  writer.write('<h3>'+data.text.upper()+'</h3>\n')   
                    break
           # writer.write('<br/>\n')    
            for data in sub:
                if data.tag=='description':
                    description=data.text
                    if description is not None:
                         description=re.sub('<a.*/a>','',description)
                         description=re.sub('</cite>','',description)
                         description=re.sub('<cite>','',description)
                         print(color.RED+description+color.END)
            #             writer.write('<span>'+description+'</span>\n')
                    break
          #:  print(sub.findtext('link').text)


    #print(etree.tostring(xml,pretty_print=True))

def feedUpdate():

    file=open("feeds.txt","r")
    allfeeds=[]
    for line in file:
        allfeeds.append(line)
        pass

    for feeds in allfeeds:
        feedGetter(feeds)

feedUpdate()
writer.close()
