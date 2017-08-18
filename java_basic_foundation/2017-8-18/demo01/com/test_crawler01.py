#coding:utf8

import os#创建文件
from HTMLParser import HTMLParser#用于解析html的库，有坑：如果2.6的python，可能悲剧
import httplib,re#发起http请求
import sys,json,datetime,bisect#使用了二分快速查找
from urlparse import urlparse#解析url，分析出url的各部分功能
from threading import Thread#使用多线程
import socket #设置httplib超时时间
#定义一个ListPageParser，用于解析ListPage，如http://list.jd.com/list.html?cat=737,794,870


#htmlparser的使用简介
#定义intt方法：需要使用到得属性
#定义handle_starttag，处理你想分析的tag的具体操作
#定义handle_data，遇到你定义的情况，获取相应标签的data
#定义你获取最终返回的各种数据
class ListPageParser(HTMLParser):
	def __init__(self):
		self.handledtags=['a']
		self.processing=None
		self.flag=''
		self.link=''
		self.setlinks=set()##该list页面中包含的每个商品的url，定义为set，主要是为了使用其特性：去重
		self.pageNo=1
		self.alldata=[]
		self.lasturl=""#指的最后一页的url如<a href="http://list.jd.com/list.html?cat=737%2C794%2C798&page=10&JL=6_0_0">10</a>
		HTMLParser.__init__(self)
	def handle_starttag(self, tag, attrs):
		pattern = re.compile(r'^[0-9]{2,}')
		pattern2=re.compile(r'^http:\/\/item.jd.com\/\d{1,10}.html$')#取出link
		pattern3=re.compile(r'^http:\/\/list.jd.com\/list.html\?cat=\d{0,9}%2C\d{0,9}%2C\d{0,9}&page=*')#取出link
		#attrs是属性的list，每个属性（包含key，value）又是一个元组
		#<a target="_blank" href="http://item.jd.com/1258277.html" onclick="log("search","list",window.location.href,798,5,1258277,2,1,1,2,A)">创维酷开(coocaa) K50J 50英寸八核智能wifi网络安卓平板液晶电视(黑色)<font style="color: #ff0000;" name="1258277" class="adwords"></font></a>
		#已上为例子：判断了该list的长度为3（其他的a标签就被过滤了）
		if tag in self.handledtags and len(attrs)==3 :#非常关键的是，找出你想的url和不想要的url的区别
			#print "debug:attrs",attrs
			self.flag=''
			self.data=''
			self.processing=tag
			for target,href in attrs:#非常关键的是，找出你想的url和不想要的url的区别
				if pattern2.match(href):#再加一层判断，如果匹配上pattern2，说明是我们想要的url
					self.setlinks.add(href)
				else:
					pass
		#怎样获取list中最后一页的url？分析吧：<a href="http://list.jd.com/list.html?cat=737%2C794%2C798&page=10&JL=6_0_0">10</a>
		#1、长度为1
		#2，href是由规则的：cat=737%2C794%2C798&page=10&JL=6_0_0，所以，以下代码就出来了
		if tag in self.handledtags and len(attrs)==1 :
			self.flag=''
			self.data=''
			self.processing=tag
			for href,url in attrs:#非常关键的是，找出你想的url和不想要的url的区别
				#print 'debug:attrs',attrs
				if pattern3.match(url):
					#print 'debug:url',url
					self.lasturl=url
				else:
					pass
	def handle_data(self, data):
		if self.processing:#去掉空格
			pass#其实这里我们根本没使用获取到得data，就pass把
		else:
			pass
	def handle_endtag(self, tag):
		if tag==self.processing:
			self.processing=None
	def getlinks(self):
		return self.setlinks
	def getlasturl(self):
		return self.lasturl


#定义一个FinallPageParser，用于解析最终的html页面，如http://item.jd.com/1258277.html
#FinallPageParser的定义过程参考上个parser，关键是怎样分析页面，最终写出代码，并且验证，这里就不详细说了
class FinallPageParser(HTMLParser):
	def __init__(self):
		self.handledtags=['div','h1','strong','a','del','div','img','li','span','tbody','tr','th','td','i']
		self.processing=None
		self.title=''
		self.jdprice=''
		self.refprice=''
		self.partimgs_show=set()#展示图片
		self.partimgs=set()#详情图片
		self.partdetail={}#商品详情，参数等
		self.specification=[]#规格参数
		self.typeOrsize=set()#尺码和类型
		self.div=''
		self.flag={}
		self.flag['refprice']=''
		self.flag['title']=''
		self.flag['jdprice']=''
		self.flag['typeOrsize']=''
		self.flag['partimgs']=''
		self.flag['partdetail']=''
		self.flag['specification']=''
		self.flag['typeOrsize']=''
		self.link=''
		self.partslinks={}
		HTMLParser.__init__(self)
	def handle_starttag(self, tag, attrs):
		self.titleflag=''
		self.flag['refprice']=''
		self.flag['title']=''
		self.flag['jdprice']=''
		self.flag['typeOrsize']=''
		self.flag['partimgs']=''
		self.flag['partdetail']=''
		self.flag['specification']=''
		self.flag['typeOrsize']=''
		if tag in self.handledtags:
			self.data=''
			self.processing=tag
			if tag=='div':
				for key,value in attrs:
					self.div=value# 取出div的name，判断是否是所需要的图片等元素
			if tag=='i':
				self.flag['typeOrsize']='match'
			if tag=='a' and len(attrs)==2:
				tmpflag=""
				for key,value in attrs:
					if key=='href' and re.search(r'^http:\/\/item.jd.com\/[0-9]{1,10}.html$',value):
						tmpflag="first"
					if key=='title' and value!="":
						tmpflag=tmpflag+"second"
				if tmpflag== "firstsecond":
					self.flag['typeOrsize']='match'
			if tag=='h1':
				self.flag['title']='match'
			if tag=='strong' and len(attrs)==2:
				for tmpclass,id in attrs:
					if id=='jd-price':
						self.flag['jdprice']='match'
			if tag=='del':
				self.flag['refprice']='match'
			if tag=='li':
				self.flag['partdetail']='match'
			if tag=='th' or tag=='tr' or tag=='td' :#++++++++############################################879498.html td中有br的只取到第一个,需要把<br/>喜欢为“”
				self.flag['specification']='match'
			if tag=='img' :
				imgtmp_flag=''
				imgtmp=''
				for key,value in attrs:
					if re.search(r'^http://img.*jpg|^http://img.*gif|^http://img.*png',str(value)) and (key=='src' or key=='data-lazyload'):
						imgtmp=value
					if key== 'width':############可能还有logo
						if re.search(r'^\d{1,9}$',value):
							if int(value)<=160:
								imgtmp_flag='no'
								break
				if self.div=="spec-items" and imgtmp!='':
					imgtmp=re.compile("/n5/").sub("/n1/",imgtmp)
					self.partimgs_show.add(imgtmp)
				elif imgtmp_flag!='no' and imgtmp!='':
					self.partimgs.add(imgtmp)#
	def handle_data(self, data):
		if self.processing:
			self.data+=data
			if self.flag['title']=='match':#获取成功
				self.title=data
			if self.flag['jdprice']=='match':
				self.jdprice=data.strip()
			if self.flag['typeOrsize']=='match':
				self.typeOrsize.add(data.strip())
			if self.flag['refprice']=='match':
				self.refprice=data.strip()
			if self.flag['partdetail']=='match' and re.search(r'：',data):#获取成功
				keytmp=data.split("：")[0].strip()
				valuetmp=data.split("：")[1].strip()
				self.partdetail[keytmp]=valuetmp
			if self.flag['specification']=='match' and data.strip() != '' and data.strip()!='主体':
				self.specification.append(data.strip())
		else:
			pass
	def handle_endtag(self, tag):
		if tag==self.processing:
			self.processing=None
	def getdata(self):
		return {'title':self.title,'partimgs_show':self.partimgs_show,'jdprice':self.jdprice,'refprice':self.refprice,'partimgs':self.partimgs,'partdetail':self.partdetail,'specification':self.specification,'typeOrsize':self.typeOrsize}
#定义方法httpread，用于发起http的get请求，返回http的获取内容
#这也是代码抽象的结果，如若不抽象这块代码出来，后续你回发现很多重复的写这块代码
def httpread(host,url,headers):
	httprestmp=''
	try:
		conn = httplib.HTTPConnection(host)
		conn.request('GET',url,None,headers)
		httpres = conn.getresponse()
		httprestmp=httpres.read()
	except Exception,e:
		conn = httplib.HTTPConnection(host)
		conn.request('GET',url,None,headers)
		httpres = conn.getresponse()
		httprestmp=httpres.read()
		print e
	finally:
		if conn:
			conn.close()
	return httprestmp
#定义方法sendhttp，调用httpread，获取结果并替换编码（gbk换为utf-8），并保存到文件中（以免下次再去下载页面，这样就节省了时间）
#
def sendhttp(url,host,savefile):
	#定义http头部，很多网站对于你不携带User-Agent及Referer等情况，是不允许你爬取。
	#具体的http的头部有些啥信息，你可以看chrome，右键审查元素，点击network，点击其中一个链接，查看request header
	headers = {"Host":host,
			   "Origin":"http://www.jd.com/",
			   "Referer":"http://www.jd.com/",
				"Content-type": "application/x-www-form-urlencoded; charset=UTF-8",
				"Accept": "text/html;q=0.9,image/webp,*/*;q=0.8",
			   "User-Agent":"Mozilla/3.0 AppleWebKit/537.36 (KHTML,Gecko) Chrome/3.0.w4.",
			   "Cookie":"__utmz=qwer2434.1403499.1.1.utmcsr=www.jd.com|utmccn=(refrral)|utmcmd=rferral|utmcct=/order/getnfo.action; _pst=xx89; pin=x9; unick=jaa; cshi3.com=D6045EA24A6FB9; _tp=sdyuew8r9e7r9oxr3245%3D%3D; user-key=1754; cn=0; ipLocation=%u7F0C; ipLoc97; areaId=1; mt_ext2%3a%27d; aview=6770.106|68|5479.665|675.735|6767.100|6757.13730|6ee.9ty711|1649.10440; atw=65.15.325.24353.-4|188.3424.-10|22; __j34|72.2234; __jdc=2343423; __jdve|-; __jdu=3434"
	}
	httprestmp=''
	try:
		httprestmp=httpread(host,url,headers)
		if httprestmp=='':#
			httprestmp=httpread(host,url,headers)
			if  httprestmp=='':#重试2次
				httprestmp=httpread(host,url,headers)
	except Exception,e:
		try:
			httprestmp=httpread(host,url,headers)
			if httprestmp=='':#
				httprestmp=httpread(host,url,headers)
				if  httprestmp=='':#重试2次
					httprestmp=httpread(host,url,headers)
		except Exception,e:
			print e
		print e
	if  re.search(r'charset=gb2312',httprestmp):#如果是gb2312得编码，就要转码为utf-8（因为全局都使用了utf-8）
		httprestmp.replace("charset=gb2312",'charset=utf-8')
		try:
			httprestmp=httprestmp.decode('gbk').encode('utf-8')#有可能转码失败，所以要加上try
		except Exception,e:#如果html编码本来就是utf8或者转换编码出错的时候，就啥都不做，就用原始内容
			print e
	try:
		with  open(savefile, 'w') as file_object:
			file_object.write(httprestmp)
			file_object.flush()
	except Exception,e:
		print e
	return httprestmp
#list的页面的解析方法
def parseListpageurl(listpageurl):
		urlobj=urlparse(listpageurl)
		if urlobj.query:
			geturl=urlobj.path+"?"+urlobj.query
		else:
			geturl=urlobj.path
		htmlfile="html/list"+geturl
		if not os.path.exists(htmlfile):
			httpresult=sendhttp(geturl,urlobj.hostname,htmlfile)
		with  open(htmlfile) as file:
			htmlcontent=file.read()
		parser= ListPageParser()#声明一个解析对象
		#http://list.jd.com/list.html?cat=737%2C794%2C870&page=11&JL=6_0_0,所以这里需要把'amp;'去掉
		parser.feed(htmlcontent.replace('amp;',''))#将html的内容feed进去
		#print 'debug:htmlcontent',htmlcontent
		finalparseurl=parser.getlinks()#然后get数据即可
		lastpageurl=parser.getlasturl()
		urlobj_lastpageurl=urlparse(lastpageurl)
		#print 'debug:urlobj_lastpageurl',urlobj_lastpageurl
		totalPageNo='0'
		#print urlobj
		if re.search(r'&',urlobj_lastpageurl.query):
			try:
				totalPageNo=urlobj_lastpageurl.query.split("&")[1].split("=")[1]#获得总共有多少页
			except Exception,e:
				print "lastpageurl:"+str(lastpageurl)
				print e
		parseListpageurl_rult={'finalparseurls':finalparseurl,'totalPageNo':totalPageNo}
		if parseListpageurl_rult['finalparseurls'] !="" and parseListpageurl_rult['totalPageNo']!='':
			print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",parse listpageurl succ:"+listpageurl
		else:
			print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",parse listpageurl fail:"+listpageurl
		return parseListpageurl_rult
#最终的html页面的解析方法：会使用到html得解析器FinallPageParser
def parseFinallyurl(finallyurl):
		urlobj=urlparse(finallyurl)
		geturl=urlobj.path
		htmlfiledir="html/finally/"+geturl.split('/')[1][0:2]
		if not os.path.exists(htmlfiledir):
			try:
				os.makedirs(htmlfiledir)
			except Exception,e:
				print e
		htmlfile=htmlfiledir+geturl
		if not os.path.exists(htmlfile):
			httpresult=sendhttp(geturl,urlobj.hostname,htmlfile)
			if httpresult:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request succ,Finallyurl:"+finallyurl
			else:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request fail,Finallyurl:"+finallyurl
		with  open(htmlfile) as file:
			htmlcontent=file.read()
		parser= FinallPageParser()
		##htmmparser遇到/>就表示tag结尾，所以必须替换，遇到<br/>替换为BRBR，否则会解析失败
		htmlcontent=re.compile('<br/>').sub('BRBR',htmlcontent)
		parser.feed(htmlcontent)
		finalparseurl=parser.getdata()
		if finalparseurl:
			print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",parse finalparseurl succ:"+finallyurl
		else:
			print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",parse finalparseurl fail:"+finallyurl
		return finalparseurl
#获取图片的方法
def getimg(imgdir,imgurl):
		imgobj=urlparse(imgurl)
		getimgurl=imgobj.path
		imgtmppathlist=getimgurl.split('/')
		imgname=imgtmppathlist[len(imgtmppathlist)-1]
		if not os.path.exists(imgdir):
			try:
				os.makedirs(imgdir)
			except Exception,e:
				print e
		savefile=imgdir+"/"+imgname
		if not os.path.exists(savefile):
			sendhttp_rult=sendhttp(getimgurl,imgobj.hostname,savefile)
			if sendhttp_rult:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request succ,getimg:"+imgurl
			else:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request fail,getimg:"+imgurl
		else:
			pass
#获取价格
def getprice(pricedir,priceurl):
		priceobj=urlparse(priceurl)
		getpriceurl=priceobj.path+"?"+priceobj.query
		pricename="price"
		if not os.path.exists(pricedir):
			try:
				os.makedirs(pricedir)
			except Exception,e:
				print e
		savefile=pricedir+"/"+pricename
		if not os.path.exists(savefile):
			sendhttp_rult=sendhttp(getpriceurl,priceobj.hostname,savefile)
			if sendhttp_rult:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request succ,getprice:"+priceurl
			else:
				print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+",sent http request fail,getprice:"+priceurl
		else:
			pass
		with open(savefile) as file:
			price_content=file.read()
		price_content=re.compile('cnp\\(\\[|\\]\\);').sub('',price_content)
		price_dic={"id":"0","p":"0","m":"0"}
		if re.search(r':',price_content):
			try:
				price_dic=json.loads(price_content)#以免数据格式不对悲剧
			except Exception,e:
				print e
		return  {"jdprice":price_dic['p'],'refprice':price_dic['m']}
#获取最后页面的具体内容
def getfinalurl_content(partlists,listpageurl,finalparseurl):
		parseFinallyurl_rult=parseFinallyurl(finalparseurl)
		htmlname_tmp=urlparse(finalparseurl).path
		imgtopdir_tmp="img/"+htmlname_tmp.split('/')[1][0:2]
		imgdir=imgtopdir_tmp+htmlname_tmp+"/introduction"
		imgshowdir=imgtopdir_tmp+htmlname_tmp+"/show"
		partdetail_tmp=""
		for imgurl in parseFinallyurl_rult['partimgs']:#获取商品介绍的图片
			getimg(imgdir,imgurl)
		for imgshowurl in parseFinallyurl_rult['partimgs_show']:#获取展示图片
			getimg(imgshowdir,imgshowurl)
		for key in parseFinallyurl_rult['partdetail'].keys():
			partdetail_tmp=partdetail_tmp+key+"$$"+parseFinallyurl_rult['partdetail'][key]+","#商品介绍
		specification_tmp=""
		i=0
		for specification_var in  parseFinallyurl_rult["specification"]:#规格参数
			if i==0:
				str_slip=""
			elif(i%2==0  and i!=0 ):
				str_slip=","
			else:
				str_slip="$$"
			specification_tmp=specification_tmp+str_slip+specification_var
			i=i+1
		typeOrsize_tmp=""
		for typeOrsize_var in parseFinallyurl_rult['typeOrsize']:
			typeOrsize_tmp=typeOrsize_tmp+","+typeOrsize_var
		priceurl="http://p.3.cn/prices/get?skuid=J_"+htmlname_tmp.split('/')[1].split('.')[0]+"&type=1&area=6_309_312&callback=cnp"
		pricedir="price/"+htmlname_tmp.split('/')[1][0:2]+htmlname_tmp
		getprice_dic=getprice(pricedir,priceurl)
		parseFinallyurl_rult["jdprice"]=getprice_dic['jdprice']
		parseFinallyurl_rult["refprice"]=getprice_dic['refprice']
		#partlists[listpageurl])：商品分类
		#finalparseurl，页面的url
		#parseFinallyurl_rult["title"])：标题
		#parseFinallyurl_rult["jdprice"]：京东的价格
		#parseFinallyurl_rult["refprice"]：市场参考价格
		#imgshowdir：商品展示的图片保存位置
		#imgdir：商品说明的图片保存位置：jd的商品说明也是用图片的
		#partdetail_tmp:商品的详细信息
		#specification_tmp:商品的规则参数
		#typeOrsize_tmp:商品的类型和尺寸
		return str(partlists[listpageurl]).strip()+"\t"+finalparseurl.strip()+"\t"+str(parseFinallyurl_rult["title"]).strip()+"\t"+str(parseFinallyurl_rult["jdprice"]).strip()\
			   +"\t"+str(parseFinallyurl_rult["refprice"]).strip()+"\t"+imgshowdir.strip()+"\t"+imgdir.strip()+"\t"+partdetail_tmp.strip()+"\t"+specification_tmp.strip()+"\t"+\
			   typeOrsize_tmp.strip()


#判断最后的页面（商品详情页）是否被爬取了
def judgeurl(url):#优化后，使用二分法查找url(查找快了，同时也不用反复读取文件了)。第一次加载judgeurl_all_lines之后，维护好此list，同时新增的url也保存到judgeurl.txt中
	url=url+"\n"
	global judgeurl_all_lines
	find_url_flag=False
	url_point=bisect.bisect(judgeurl_all_lines,url)#这里使用二分法快速查找（前提：list是排序好的）
	find_url_flag = judgeurl_all_lines and judgeurl_all_lines[url_point-1] == url
	return find_url_flag




#判断list页面是否已经爬取完毕了
#这里的逻辑是：第一个list中的所有url、最后list的所有url都爬取完毕了，那么久说明list的所有page爬取完毕了（实际上是一种弱校验）。
#调用了judgeurl得方法
def judgelist(listpageurl,finallylistpageurl):#判断第一个、最后一个的list页面的所有的html是否下载完毕，以此判断该类型是否处理完毕
	judgelist_flag=True
	parseListpageurl_rult_finally=parseListpageurl(finallylistpageurl)
	finalparseurls_deep_finally=list(parseListpageurl_rult_finally['finalparseurls'])#获取到最后的需要解析的url的列表
	parseListpageurl_rult_first=parseListpageurl(listpageurl)
	finalparseurls_deep_first=list(parseListpageurl_rult_first['finalparseurls'])#获取到最后的需要解析的url的列表
	for finalparseurl in finalparseurls_deep_finally:
		#print finalparseurl
		if judgeurl(finalparseurl):
			pass
		else:
			judgelist_flag=False
			break
	if judgelist_flag==True:
		for finalparseurl_first in finalparseurls_deep_first:
			#print finalparseurl
			if judgeurl(finalparseurl_first):
				pass
			else:
				judgelist_flag=False
				break
	return judgelist_flag
#整体控制的run方法
def run():
	partlists={'http://list.jd.com/list.html?cat=737,794,870':'空调'}
	partlistskeys=partlists.keys()
	for listpageurl in partlistskeys:
		parseListpageurl_rult=parseListpageurl(listpageurl)#开始解析list页面，如：http://list.jd.com/list.html?cat=737,794,870
		totalPageNo=parseListpageurl_rult['totalPageNo']#获取该list总共有多少页
		#print 'debug:totalPageNo',totalPageNo
		finallylistpageurl=listpageurl+'&page='+str(int(totalPageNo)+1)+'&JL=6_0_0'#拼接出最后一个list页面（list页面有1、2、3。。。n页）
		#print 'debug:finallylistpageurl ',finallylistpageurl
		if judgelist(listpageurl,finallylistpageurl):#如果该list已经爬取完毕了。那么，就跳过这个list
			print datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")+',All html done for '+str(listpageurl)+":"+str(partlists[listpageurl])+"【Done Done】,【^_^】"
			continue
		else:#否则就逐个沿着list，从其第1页，开始往下爬取
			for i in range(1,int(totalPageNo)+2):
				finalparseurl=''
				listpageurl_next=listpageurl+'&page='+str(i)+'&JL=6_0_0'
				#print "debug:listpageurl_next",listpageurl_next
				parseListpageurl_rult=parseListpageurl(listpageurl_next)
				totalPageNo=parseListpageurl_rult['totalPageNo']#需要更行总的页面数量，以免数据陈旧
				finalparseurls_deep=list(parseListpageurl_rult['finalparseurls'])
				for finalparseurl in finalparseurls_deep:
					if judgeurl(finalparseurl):#判断该具体的url是否已经爬取
						print 'finalparseurl pass yet:'+finalparseurl
						pass
					else:
						finalurl_content=getfinalurl_content(partlists,listpageurl,finalparseurl)
						finalparseurl_tmp=finalparseurl+"\n"
						with open("data.txt","a") as datafile:#将爬取完毕好的url写入data.txt
							datafile.writelines(finalurl_content+"\n")
						with open("judgeurl.txt","a") as judgefile:#将已经爬取好的url写入judgeurl.txt
							judgefile.writelines(finalparseurl+"\n")
						bisect.insort_right(judgeurl_all_lines,finalparseurl+"\n")
#主方法
if __name__ == '__main__':
	reload(sys)
	sys.setdefaultencoding('utf8')#设置系统默认编码是utf8
	socket.setdefaulttimeout(5)#设置全局超时时间
	global judgeurl_all_lines#设置全局变量
	#不存在文件就创建文件,该文件用于记录哪些url是爬取过的，如果临时中断了，可以直接重启脚本即可
	if not os.path.exists("judgeurl.txt"):
		with open("judgeurl.txt",'w') as judgefile:
			judgefile.close()
	#每次运行只在开始的时候读取一次，新产生的数据（已怕去过的url）也会保存到judgeurl.txt
	with open("judgeurl.txt","r") as judgefile:
		judgeurl_all_lines=judgefile.readlines()
	judgeurl_all_lines.sort()#排序，因为后面需要使用到二分查找，必须先排序
	#启多个线程去爬取
	Thread(target=run(),args=()).start()
	Thread(target=run(),args=()).start()
	#Thread(target=run(),args=()).start()


