package dao

import models.User
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class UsersDAO @Inject() (
    protected val dbConfigProvider: DatabaseConfigProvider
)(implicit executionContext: ExecutionContext)
    extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  private val Users = TableQuery[UsersTable]

  def all(): Future[Seq[User]] = db.run(Users.result)

  def insert(user: User): Future[User] = {
    val action = Users returning Users.map(_.userId) += user
    db.run(action).map(userId => user.copy(Some(userId)))
  }

  private class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def userId = column[Int]("user_id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def * = (userId.?, name).<>(User.tupled, User.unapply)
  }
}
