object CollecctionTest01 {

  def getList={
   val a=List(1,2,3,4)
    println(s"a=${a}")
    val b=0::a
    println(b)
    val c="x"::"y"::"z"::Nil
    println(c)
    val d=a:::c
    println(s"a:::c=${a:::c}")
    println(s"d=${d}")
    println(s"d.head=${d.head}")
    println(s"d.tail=${d.tail}")
    println(s"d.isEmpty=${d.isEmpty}")
    println(s"Nil.isEmpty=${Nil.isEmpty}")
    print(s"list a is=${walkthru(a)}")



  }

  def advanceFun1()={
    //filter函数
    val a=List(1,2,3,4,5)
    val b=a.filter(x=>x%2==1)
    println(s"b=${b}")
    val cs="999 Red Balloon".toList

    val digitals=cs.filter(x=>Character.isDigit(x))
    println(digitals)

    println(s"=============")
    println(s"Not a Number is:${cs.filterNot(x=>Character.isDigit(x))}")

    val isNotB=cs.takeWhile(x=>x!='B')
    println(s"takeWhile(x!='B') is:${isNotB}")
  }



  /***
    * 遍历集合的元素
    */

  def walkthru(l:List[Int]):String={

    var s=""
    if(l.isEmpty)""
    else  s=l.head.toString+" "+walkthru(l.tail)

    s
  }
  def main(args: Array[String]): Unit = {
    //getList
    advanceFun1()

  }

}
