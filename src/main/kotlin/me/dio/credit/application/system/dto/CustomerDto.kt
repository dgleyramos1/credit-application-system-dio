package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid input")
    val firstName: String,
    @field:NotEmpty(message = "Invalid input")
    val lastName : String,
    @field:NotEmpty(message = "Invalid input")
    @field:CPF(message = "This invalid CPF")
    val cpf: String,
    @field:NotNull(message = "Invalid input")
    val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input")
    @field:Email(message = "This invalid E-mail")
    val email: String,
    @field:NotEmpty(message = "Invalid input")
    val password: String,
    @field:NotEmpty(message = "Invalid input")
    val zipCode: String,
    @field:NotEmpty(message = "Invalid input")
    val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        income = this.income,
        cpf = this.cpf,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
