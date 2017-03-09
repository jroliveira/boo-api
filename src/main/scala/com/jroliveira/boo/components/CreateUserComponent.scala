package com.jroliveira.boo.components

import com.jroliveira.boo.models.{Toggle, User}

import scala.concurrent.Future

trait CreateUserComponent extends Component {
  val createUser: CreateUser

  class CreateUser {
    def apply(user: User): Future[User] = Future {
      TogglesDataSource.toggles += (user.name -> List[Toggle]())
      user
    }
  }

}
