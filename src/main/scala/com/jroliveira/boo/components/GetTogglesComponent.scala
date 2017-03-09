package com.jroliveira.boo.components

import com.jroliveira.boo.models.Toggle

import scala.concurrent.Future

trait GetTogglesComponent extends Component {
  val getToggles: GetToggles

  class GetToggles {
    def apply(user: String,
              name: Option[String],
              tags: Option[Seq[String]]): Future[Option[Seq[Toggle]]] = Future {
      TogglesDataSource
        .toggles
        .get(user)
        .map(toggles => toggles
          .withFilter(toggle =>
            (name.isEmpty || name.get == toggle.name)
              && (tags.isEmpty || toggle.tags.containsSlice(tags.get)))
          .map(toggle => toggle)
        )
    }
  }

}
