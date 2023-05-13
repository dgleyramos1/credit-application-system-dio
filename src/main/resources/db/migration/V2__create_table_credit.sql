CREATE TABLE credits (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   credit_code UUID NOT NULL,
   credit_value DECIMAL NOT NULL,
   day_first_installment date NOT NULL,
   number_of_installment INT NOT NULL,
   status INT,
   customer_id BIGINT,
   CONSTRAINT pk_credits PRIMARY KEY (id)
);

ALTER TABLE credits ADD CONSTRAINT uc_credits_creditcode UNIQUE (credit_code);

ALTER TABLE credits ADD CONSTRAINT FK_CREDITS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);