package com.tsystems.jschool.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class EmailInvalidException(msg: String) : RuntimeException(msg)