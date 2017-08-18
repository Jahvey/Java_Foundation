#encoding:utf-8
import  math


def fun1():
    print "hello world王振华"
    for i in (1 , 10):
        print(i)


#  高阶函数
# 接受一个函数作为函数的参数
def add1(x,y,f):
    return f(x)+f(y)

def testAdd1():
    print(add1(-3,-11,abs))


def add2(x,y,f):
    return f(x)+f(y)
def testAdd2():
    print(add2(25, 9, math.sqrt))

fun1()
testAdd1()
testAdd2()


# 使用map函数
def format_name(s):
    return s.title()

print map(format_name, ['adam', 'LISA', 'barT'])

# 使用reduce函数
def prod(x, y):
    return  x * y

print reduce(prod, [2, 4, 5, 7, 12])
