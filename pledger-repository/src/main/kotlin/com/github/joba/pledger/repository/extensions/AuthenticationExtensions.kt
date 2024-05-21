package com.github.joba.pledger.repository.extensions

import com.github.joba.pledger.entity.exception.InvalidUserException
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken

fun OAuth2AuthenticationToken.getSubject(): String {
    return this.principal.attributes.getValue("sub") as? String?: throw InvalidUserException()
}
