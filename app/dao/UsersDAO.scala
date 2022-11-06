package dao

import javax.inject.Inject
import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import scala.concurrent.{ExecutionContext, Future}
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape

class UsersDAO @Inject() (
    protected val dbConfigProvider: DatabaseConfigProvider
)(implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  private val Users = TableQuery[UsersTable]

  def all(): Future[Seq[User]] = db.run(Users.result)

  def insert(user: User): Future[User] = {
    db.run(
      Users returning Users.map(_.userId) += user
    ).map(userId => user.copy(Some(userId)))
  }

  def update(userId: Int, user: User): Future[User] = {
    val updatedUser = user.copy(Some(userId))
    db.run(
      Users.filter(_.userId === userId).update(updatedUser)
    ).map(_ => updatedUser)
  }

  private class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def userId = column[Int]("user_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def * : ProvenShape[User] = (userId.?, name).<>(User.tupled, User.unapply)
  }
}
