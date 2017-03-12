package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.DataSourceComponent
import com.jroliveira.boo.models.User

import scala.concurrent.Future

trait GetUsersComponent extends Component {
  this: DataSourceComponent =>
  val getUsers: GetUsers

  class GetUsers {
    def apply(): Future[Seq[User]] = Future {
      dataSource
        .toggles
        .keys
        .map(key => User(key))
        .toSeq
    }
  }

}
