package com.jroliveira.boo.infra.data

import com.jroliveira.boo.infra.Config
import com.mongodb.casbah.Imports._

trait MongoDbComponent {
  val mongoDb: MongoDb

  trait MongoDb {
    def collection(collectionName: String): MongoCollection
  }

}

trait MongoDbComponentImpl extends MongoDbComponent {

  class Casbah extends MongoDb with Config {
    val db: MongoDB = MongoClient(mongoHost, mongoPort)(mongoDatabase)

    def collection(collectionName: String): MongoCollection = db(collectionName)
  }

}