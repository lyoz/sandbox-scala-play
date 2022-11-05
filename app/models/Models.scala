package models

import play.api.libs.json.Json

case class User(userId: Int, name: String)

object User extends ((Int, String) => User) {
  implicit val userFormat = Json.format[User]
}
