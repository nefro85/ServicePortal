package controllers

import domain.{Customer, Issue}
import play.api.libs.json._
import play.api.mvc._

import scala.collection.mutable

object Application extends Controller {

  implicit var issueWriter = new Writes[Issue] {
    def writes(issue: Issue) = Json.obj(
      "id" -> issue.getId(),
      "name" -> issue.getName()
    )

  }

  implicit var customerWriter = new Writes[Customer] {
    def writes(o: Customer) = Json.obj(
      "name" -> o.getName(),
      "issues" -> o.issue
    )
  }

  def index = Action {
    Ok(views.html.index("Nefro Your new application is ready."))
  }

  def test = Action {

    Ok(views.html.home(List(
      new Customer("customer 1",
        mutable.HashMap(
          "email" -> "cust1@mail.com",
        "phone" -> "554 354 534")), new Customer("customer 2"))))
  }


  def jsonTest = Action {


    val cust = new Customer("Customer Alpha");
    cust += new Issue(1, "issue 1")


    Ok(Json.toJson(cust))
  }

}