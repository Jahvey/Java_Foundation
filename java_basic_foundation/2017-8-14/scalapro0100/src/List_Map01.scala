object List_Map01 {

  def list_map()={
    val c=List('x','Y','Z','w')
  val smallcase=c.map(x=>x.toLower)

    println(s"c=${c}")
println(s"全部转换成小写字母：smllcase is=${smallcase}")

    val uppercase=c.map(x=>x.toUpper)
    println(s"全部转换成大写字母:uppercase is=${uppercase}")


    val uppercase1=c.map(_.toUpper)//使用匿名函数的简写方式
    println(s"第二种全部转换成为大写字母的第二种方式:${uppercase1}")


    //过滤函数的第二种写法
    val a=List(1,2,3,4,5,6,7)
    println(s"a is:${a}")
    val b=a.filter(_%2==1).map(_+10)
    println(s"将a数组的元素每一个进行过滤是否是奇数，${a.filter(_%2==1)}" +
      s"然后对每一个元素加10.b=${b}")
//List元素内部的嵌套
    val res1=List(a,List(4,5,6,7,8,9))
    println(s"res1 is:=${res1}")
    //对每一个list中每个元素进行如下的操作：
    //取出每一个List中的检验是否为奇数，否
    //则返回相应的过滤结果
    val res2=res1.map(x=>x.filter(_%2==1))
    println(s"res2过滤出来的结果：${res2}")
    //下面的写法跟上面的写法得到的结果是一致性的
    val res3=res1.map(_.filter(_%2==1))
    println(s"res3 过滤出来的结果和res2过滤出来的结果是一样的：${res3}")
    val res4=res1.flatMap(_.filter(_%2==1))
    println(s"res4过滤出来的结果和res2过滤出来的结果表现形式不一样,flatmap会将数据打散${res4}")





  }



  def main(args: Array[String]): Unit = {
    list_map
  }
}
