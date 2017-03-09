package com.jroliveira.boo.models

final case class Toggle(name: String,
                        value: Boolean,
                        tags: Seq[String])