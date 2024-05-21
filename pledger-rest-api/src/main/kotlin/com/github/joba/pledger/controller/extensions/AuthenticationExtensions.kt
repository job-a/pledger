package com.github.joba.pledger.controller.extensions

import com.github.joba.pledger.entity.exception.InvalidUserException
import com.github.joba.pledger.entity.user.User
import org.springframework.security.oauth2.core.oidc.user.OidcUser

fun OidcUser.toUser(): User {
    return User(this.idToken?.subject?: throw InvalidUserException(), this.idToken?.givenName?: throw InvalidUserException())
}