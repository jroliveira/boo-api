package com.jroliveira.boo.components

import com.jroliveira.boo.models.User

import scala.concurrent.Future

trait GetUsersComponent extends Component {
  val getUsers: GetUsers

  class GetUsers {
    def apply(): Future[Seq[User]] = Future {
      TogglesDataSource
        .toggles
        .keys
        .map(key => User(key))
        .toSeq
    }
  }

}
