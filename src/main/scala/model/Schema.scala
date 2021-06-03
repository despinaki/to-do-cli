package model

import slick.jdbc.SQLiteProfile.api._
import slick.lifted.Tag

class ToDos (tag: Tag) extends Table[(Int, String, String)](tag, "TODOS") { //todo: replace int with the appropriate datetime type
  def date = column[Int]("DATE", O.PrimaryKey) // This is the primary key column
  def project = column[String]("PROJECT")
  def item = column[String]("ITEM")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (date, project, item)
}