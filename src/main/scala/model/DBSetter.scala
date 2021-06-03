package model

import model.Add.{db, setup}
import slick.jdbc.JdbcBackend.Database
import slick.jdbc.SQLiteProfile.api._
import slick.lifted.TableQuery

class MyDB {
  //  val now = Calendar.getInstance().getTime()
  val db = Database.forConfig("todos")
  val todosTable = TableQuery[ToDos]
  val setup = DBIO.seq(
    // Create the table, including primary and foreign keys
    todosTable.schema.create,
    // Insert some values into the table
    todosTable ++= Seq(
      (1, "homework", "study for math test"),
      (2, "chores", "do laundry"),
      (3, "homework", "finish essay")
    )
  )
}

object Add extends MyDB {
  def addToTable(date: Int, project: String, item: String): Unit = {
    todosTable += (date, project, item)
  }
}

object Setup extends MyDB {
  val setupFuture = db.run(setup) //returns a promise
  setupFuture.value
  db.close() //close connection to server otherwise it keeps waiting forever
}