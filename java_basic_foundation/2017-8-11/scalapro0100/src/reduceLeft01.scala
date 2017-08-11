object reduceLeft01 {

  def reduceTest={
    val a=List(1,2,3,4,5,6)
    val res0=a.reduceLeft((x,y)=>x+y)
    val res1=a.reduce(_+_)
    println(s"res0 result is:=${res0},res1 result is :=${res1}")

  }



  def foldTest={
    val a=List(1,2,3,4,5,6,7,8,9)
    val res0=a.foldLeft(0)(_+_)
    val res1=a.foldLeft(1)(_+_)
    val res2=a.foldLeft(2)(_+_)
    println(s"res0 is:=${res0},res1 is:=${res2}")

  }


  def main(args: Array[String]): Unit = {
//reduceTest
    foldTest
  }

}
