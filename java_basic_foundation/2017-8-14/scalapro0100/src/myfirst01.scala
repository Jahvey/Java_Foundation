
object myfirst01 {

  def add(x:Int,y:Int)=x+y;
  def add2(x:Int,y:Int)=x*y;
//  addOne(2)

  def sum(f:Int=>Int)(a:Int)(b:Int):Int={

    @annotation.tailrec
    def loop(n:Int,acc:Int):Int={
      if (n>b)
        {
          println(s"n=${n},acc=${acc}")
          acc
        }
      else {
        println(s"n=${n},acc=${acc}")
        loop(n + 1, acc + f(n))
      }
    }
    loop(a,0)

  }




  //cal n!  显示调用伪递归
  @annotation.tailrec
  def factorial(n:Int,m:Int): Int ={

    if(n<=0)m
    else  factorial(n-1,m*n);
  }


  def main(args: Array[String]): Unit = {

    val x=3
    println(x.unary_-)
    def currienedAdd(a:Int)(b:Int)=a+b;
    val addOne=currienedAdd(1)_
    print(addOne(2))
 //val path= x.getClass.getClassLoader.getResource("my.xml").getPath
  //  print(path)
    println(factorial(10,1))

    sum(x=>x)(1)(5)
    println(s"==========")
    sum(x=>x*x)(1)(5)
    println(s"==========")
    sum(x=>x*x*x)(1)(5)
    println(s"==========")
    val sumSquare=sum(x=>x*x)_
    println(s"${sumSquare(1)(5)}")


  }

}
