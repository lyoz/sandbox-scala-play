package models

import play.api.libs.json.Json

case class User(userId: Option[Int], name: String)

object User extends ((Option[Int], String) => User) {
  implicit val userFormat = Json.format[User]
}
