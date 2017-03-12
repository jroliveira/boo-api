package com.jroliveira.boo.infra.data

import com.jroliveira.boo.models.Toggle

import scala.collection.mutable

trait DataSourceComponent {
  val dataSource: DataSource

  trait DataSource {
    var toggles: mutable.HashMap[String, List[Toggle]]
  }

}

trait DataSourceInMemoryComponent extends DataSourceComponent {

  class DataSourceInMemory extends DataSource {
    override var toggles: mutable.HashMap[String, List[Toggle]] = mutable.HashMap()
  }

}
