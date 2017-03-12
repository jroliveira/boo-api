package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.DataSourceComponent
import com.jroliveira.boo.models.User

import scala.concurrent.Future

trait GetUserComponent extends Component {
  this: DataSourceComponent =>
  val getUser: GetUser

  class GetUser {
    def apply(name: String): Future[Option[User]] = Future {
      if (dataSource.toggles.contains(name)) Some(User(name)) else None
    }
  }

}
