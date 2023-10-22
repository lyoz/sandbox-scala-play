package models

import play.api.libs.json.{Json, OFormat}

case class User(userId: Option[Int], name: String)

object User extends ((Option[Int], String) => User) {
  implicit val userFormat: OFormat[User] = Json.format[User]
}
