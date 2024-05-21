package com.github.joba.pledger.controller.userimport com.github.joba.pledger.controller.extensions.toUserimport com.github.joba.pledger.entity.exception.InvalidUserExceptionimport com.github.joba.pledger.entity.user.Userimport com.github.joba.pledger.service.user.UserServiceimport org.springframework.http.MediaType.APPLICATION_JSON_VALUEimport org.springframework.security.core.annotation.AuthenticationPrincipalimport org.springframework.security.oauth2.core.oidc.user.OidcUserimport org.springframework.web.bind.annotation.GetMappingimport org.springframework.web.bind.annotation.RequestMappingimport org.springframework.web.bind.annotation.RestController@RestController@RequestMapping("/api/user")class UserController(private val userService: UserService) {    @GetMapping(produces = [APPLICATION_JSON_VALUE])    fun findUser(@AuthenticationPrincipal principal: OidcUser?): User {        return userService.verifyOrCreateUser(principal?.toUser()?: throw InvalidUserException())    }}