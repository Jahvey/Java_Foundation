/**
 1.统一空格个数
来源：正则匹配空格的问题
字符串内字符键有空格，但是空格的数量可能不一致，
通过正则将空格的个数统一变为一个。
例如：蓝色理想
变成：蓝色理想
aobert的正则：
<script>
var str="蓝        色   理  想 "
var reg=/\s+/g
str = str.replace(reg," ")
document.write(str)
</script>
 */
var str="    蓝       色      理             想"
var reg=/\s+/g
str = str.replace(reg," ")
document.write(str)
document.writeln("<br/>===================<br/>")
/**
2.匹配结尾的数字
来源：如何用JAVASCRIPT 正则表达式取出字符串最后一组数字，谢谢
如
30CAC0040 取出40
3SFASDF92 取出92
正则如下：/\d+$/g
 */
function getDetailNum(str)
{
var reg = /(\d+$)/g;

 var res=reg.exec(str)[0];
 return res;
}
var str = "30CAC0040";
document.write("<br/>30CAC0040:=>"+getDetailNum(str));
var str = "3SFASDF92";
document.write("<br/>3SFASDF92:=>"+getDetailNum(str));

document.writeln("<br/>===================<br/>")
/**
3.判断字符串是不是由数字组成
来源：有没有简单的方法判断字符串由数字组成？
这个正则比较简单，写了一个测试
<script type="text/javascript">
function isDigit(str)
{
var reg = /^\d*$/;
return reg.test(str);
}
var str = "7654321";
document.write(isDigit(str));
var str = "test";
 */
function isDigit(str)
{
var reg = /^\d*$/;
return reg.test(str);
}
var str = "7654321";
document.write("7654321 isDigit:=>"+isDigit(str));
var str = "test";
document.write("<br/>test isDigit:=>"+isDigit(str));


document.writeln("<br/>===================<br/>")
/**
4.电话号码正则
来源：想问一下关于电话号码的正则判断
：求一个验证电话号码的JS正则
/^\d{3,4}-\d{7,8}(-\d{3,4})?$/
区号必填为3-4位的数字，区号之后用“-”与电话号码连接
^\d{3,4}-
电话号码为7-8位的数字
\d{7,8}
分机号码为3-4位的数字，非必填，但若填写则以“-”与电话号码相连接
(-\d{3,4})?
 */


/**
5.手机号码正则表达式
正则验证手机号，忽略前面的0，支持130-139，150-159。
忽略前面0之后判断它是11位的。
cloeft的正则：
/^0*(13|15)\d{9}$/
^0*匹配掉开头任意数量的0。
由于手机号码是13任意数字9位，和15任意数字9位，所以可以用(13|15)\d{9}匹配。
测试代码如下：
function testReg(reg,str){
return reg.test(str);
}
var reg = /^0*(13|15)\d{9}$/;
var str = '13889294444';
var str2 = '12889293333';
var str3 = '23445567';
document.write(testReg(reg,str)+'<br />');
document.write(testReg(reg,str2)+'<br />');
document.write(testReg(reg,str3)+'<br />');
 */

function testReg(reg,str){
return reg.test(str);
}
var reg = /^0*(13|15)\d{9}$/;
var str = '13889294444';
var str2 = '12889293333';
var str3 = '00013234455671';
document.write(testReg(reg,str)+'<br />');
document.write(testReg(reg,str2)+'<br />');
document.write(testReg(reg,str3)+'<br />');


document.writeln("<br/>===================<br/>")
/**
 6.使用正则表达式实现删除字符串中的空格：
来源：请问JS中有没有去掉空格的函数
代码以及测试代码如下：
<script type="text/javascript">
//删除字符串两侧的空白字符。
function trim(str){
return str.replace(/^\s+|\s+$/g,'');
}
//删除字符串左侧的空白字符。
function ltrim(str){
return str.replace(/^\s+/g,'');
}
//删除字符串右侧的空白字符。
function rtrim(str){
return str.replace(/\s+$/g,'');
}
//以下为测试代码
var trimTest = " 123456789 ";//前后各有一个空格。
document.write('length:'+trimTest.length+'<br />');//使用前
document.write('ltrim length:'+ltrim(trimTest).length+'<br />');//使用ltrim后
document.write('rtrim length:'+rtrim(trimTest).length+'<br />');//使用rtrim后
document.write('trim length:'+trim(trimTest).length+'<br />');//使用trim后
</script>
测试的结果如下：
length:11
ltrim length:10
rtrim length:10
trim length:9
 */
//删除字符串两侧的空白字符。
function trim(str){
return str.replace(/^\s+|\s+$/g,'');
}
//删除字符串左侧的空白字符。
function ltrim(str){
return str.replace(/^\s+/g,'');
}
//删除字符串右侧的空白字符。
function rtrim(str){
return str.replace(/\s+$/g,'');
}
//以下为测试代码
var trimTest = "     123456789 ";//前后各有一个空格。
document.write('length:'+trimTest.length+'<br />');//使用前
document.write('ltrim length:'+ltrim(trimTest).length+'<br />');//使用ltrim后
document.write('rtrim length:'+rtrim(trimTest).length+'<br />');//使用rtrim后
document.write('trim length:'+trim(trimTest).length+'<br />');//使用trim后


document.writeln("<br/>===================<br/>")
/**
7. 限制文本框只能输入数字和小数点等等
来源：文本框输入限制的问题
只能输入数字和小数点
var reg = /^\d*\.?\d{0,2}$/
开头有若干个数字，中间有0个或者一个小数点，结尾有0到2个数字。
只能输入小写的英文字母和小数点，和冒号，正反斜杠(：./\)
var reg = /[a-z\.\/\\:]+/;
a-z包括了小写的英文字母，\.是小数点，\/和\\分别是左右反斜线，
最后是冒号。整个组成一个字符集和代码任一均可，最后在加上+，1或者多个。
 */


document.writeln("<br/>===================<br/>")

/**
  替换小数点前内容为指定内容
来源：求一正则表达式！
请问怎么把这个字符串的小数点前面的字符替换为我自定义的字符串啊？
例如：infomarket.php?id=197 替换为test.php?id=197
应该可以把第一个点“.”之前的所有单词字符替换为test就可以了。我写的正则如下：

var str = "infomarket.php?id=197";
var reg = /^\w+/ig;
匹配字符串开头的任意个单词字符
str = str.replace(reg,'test');
document.write(str);

**/
var str = "infomarket.php?id=197";
var reg = /^\w*/ig;
document.write("str:=>"+str+"<br/>");
str = str.replace(reg,'test');
document.write(str+"<br/>");


document.writeln("<br/>===================<br/>")
document.writeln("<br/>===================<br/>")
document.writeln("<br/>===================<br/>")
document.writeln("<br/>===================<br/>")