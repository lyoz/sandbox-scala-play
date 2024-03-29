package controllers

import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be
    * called when the application receives a `GET` request with a path of `/`.
    */
  def index() = Action {
    Ok(views.html.index())
  }
}
