import slick.jdbc.JdbcBackend.Database
import slick.lifted.{TableQuery, Tag}
import slick.jdbc.SQLiteProfile.api._

import java.util.{Calendar, Date}
import scala.concurrent.ExecutionContext.Implicits.global

object MyDB extends App {
//  val now = Calendar.getInstance().getTime()
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