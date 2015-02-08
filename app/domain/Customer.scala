package domain

import scala.collection.mutable

class Customer(
                val name: String,
                val data : mutable.Map[String, String] = mutable.HashMap.empty,
                val issue : mutable.ListBuffer[Issue] = mutable.ListBuffer.empty) {


  def getId(): Long =  {
    hashCode()
  }

  def getName() = name

  def issueCount(): Int = {
    issue.size
  }

  def +=(i: Issue): Issue = {
    issue += i
    i
  }


}
