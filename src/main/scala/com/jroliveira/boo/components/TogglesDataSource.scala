package com.jroliveira.boo.components

import com.jroliveira.boo.models.Toggle

import scala.collection.mutable

object TogglesDataSource {
  var toggles: mutable.HashMap[String, List[Toggle]] = mutable.HashMap()
}
