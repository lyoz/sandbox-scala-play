package controllers

import dao.UsersDAO
import models.User
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (
    usersDao: UsersDAO,
    val controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext)
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be
    * called when the application receives a `GET` request with a path of `/`.
    */
  def index() = Action {
    Ok(views.html.index())
  }

  def getUsers() = Action.async {
    usersDao.all().map(users => Ok(Json.toJson(users)))
  }

  def insertUser() = Action(parse.json).async { implicit request =>
    request.body.validate[User] match {
      case JsError(errors) =>
        Future.successful(BadRequest(JsError.toJson(errors)))
      case JsSuccess(user, _) =>
        usersDao.insert(user).map(user => Ok(Json.toJson(user)))
    }
  }

  def updateUser(userId: Int) = Action(parse.json).async { implicit request =>
    request.body.validate[User] match {
      case JsError(errors) =>
        Future.successful(BadRequest(JsError.toJson(errors)))
      case JsSuccess(user, _) =>
        usersDao.update(userId, user).map(user => Ok(Json.toJson(user)))
    }
  }
}
