package com.tsystems.jschool.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class IdInvalidException(msg: String) : RuntimeException(msg)