package com.jroliveira.boo.components

import com.jroliveira.boo.models.Toggle

import scala.concurrent.Future

trait CreateToggleComponent extends Component {
  val createToggle: CreateToggle

  class CreateToggle {
    def apply(user: String, model: Toggle): Future[Option[Toggle]] = Future {
      TogglesDataSource
        .toggles
        .get(user)
        .map(toggles => {
          TogglesDataSource.toggles.put(user, model :: toggles)
          model
        })
    }
  }

}
