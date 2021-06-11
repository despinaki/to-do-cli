package com.github.despinaki.model

object Setup extends MyDB {
  val setupFuture = db.run(setup) //returns a promise
  setupFuture.value
  db.close() //close connection to server otherwise it keeps waiting forever
}
