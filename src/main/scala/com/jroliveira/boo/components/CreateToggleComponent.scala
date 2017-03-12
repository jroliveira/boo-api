package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.DataSourceComponent
import com.jroliveira.boo.models.Toggle

import scala.concurrent.Future

trait CreateToggleComponent extends Component {
  this: DataSourceComponent =>
  val createToggle: CreateToggle

  class CreateToggle {
    def apply(user: String, toggle: Toggle): Future[Option[Toggle]] = Future {
      dataSource
        .toggles
        .get(user)
        .map(toggles => {
          dataSource.toggles.put(user, toggle :: toggles)
          toggle
        })
    }
  }

}
