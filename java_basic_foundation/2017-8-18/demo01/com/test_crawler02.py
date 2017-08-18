#coding:utf8

import re,os
import urllib

from time import sleep

url='https://list.jd.com/list.html?cat=1713,3287,3797'
'''

<img width="200" height="200" data-img="1" data-lazy-img="done" title="" src="//img13.360buyimg.com/n7/jfs/t2725/230/173868818/289288/7ba63f78/5706731bNe3c6623d.jpg">
'''

def craw(url,page):
    html = urllib.request.urlopen(url).read().decode()
    pat = '<img width="200" height="200" .*>'
    result = re.compile(pat).findall(html)

    pat1 = 'data-lazy-img="//(.+?\.jpg)">'

    img = re.compile(pat1).findall(str(result))

    k = 0
    for i in img:
        k += 1

        imgname = "d:/Users/img/"  +str(page)+ '/' + str(k) + ".jpg"
        urllib.request.urlretrieve("http://" + i, filename=imgname)
        sleep(1)
        print(k)

    pat2 = 'src="//(.+?\.jpg)">'
    img2 = re.compile(pat2).findall(str(result))

    for i in img2:
        k *= 10
        imgname= "d:/Users/img/" + str(page) + '/' +str(k) + ".jpg"
        urllib.request.urlretrieve("http://" +i,filename=imgname)
        sleep(1)
        print(k)






if __name__ == '__main__':

     for i in range(3,100):
        os.mkdir('d:/Users/img/' + str(i))
        url = 'https://list.jd.com/list.html?cat=1713,3287,3797&page='+str(i)
        print(url)
        craw(url,i)
        sleep(1)
