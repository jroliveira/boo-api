package com.jroliveira.boo.components

import com.jroliveira.boo.models.User

import scala.concurrent.Future

trait GetUserComponent extends Component {
  val getUser: GetUser

  class GetUser {
    def apply(name: String): Future[Option[User]] = Future {
      if (TogglesDataSource.toggles.contains(name)) Some(User(name)) else None
    }
  }

}
