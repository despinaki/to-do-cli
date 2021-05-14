import slick.jdbc.JdbcBackend.Database
import slick.lifted.{TableQuery, Tag}
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global

class ToDos (tag: Tag) extends Table[(Int, String, String)](tag, "TODOS") { //todo: replace int with the appropriate datetime type
  def date = column[Int]("DATE", O.PrimaryKey) // This is the primary key column
  def project = column[String]("PROJECT")
  def item = column[String]("ITEM")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (date, project, item)
}

object MyDB extends App {
  val db = Database.forConfig("todos")
  val todosTable = TableQuery[ToDos]
  val setup = DBIO.seq(
    // Create the table, including primary and foreign keys
    todosTable.schema.create,

    // Insert some vlues into the table (using JDBC's batch insert feature, if supported by the DB)
    todosTable ++= Seq(
      (1, "homework", "study for math test"),
      (2, "chores"  , "do laundry"),
      (3, "homework", "finish essay")
    )
  )

  val setupFuture = db.run(setup) //returns a promise
  setupFuture.value
  db.close() //close connection to server otherwise it keeps waiting forever
}


