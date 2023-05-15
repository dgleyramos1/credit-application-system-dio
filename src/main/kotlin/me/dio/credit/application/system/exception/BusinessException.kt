package me.dio.credit.application.system.exception

import java.lang.RuntimeException

data class BusinessException(override val message: String?): RuntimeException(message)
