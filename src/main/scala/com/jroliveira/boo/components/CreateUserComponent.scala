package com.jroliveira.boo.components

import com.jroliveira.boo.infra.data.DataSourceComponent
import com.jroliveira.boo.models.{Toggle, User}

import scala.concurrent.Future

trait CreateUserComponent extends Component {
  this: DataSourceComponent =>
  val createUser: CreateUser

  class CreateUser {
    def apply(user: User): Future[User] = Future {
      dataSource.toggles += (user.name -> List[Toggle]())
      user
    }
  }

}
