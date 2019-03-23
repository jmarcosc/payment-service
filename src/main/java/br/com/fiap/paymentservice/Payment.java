package br.com.fiap.paymentservice;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String transactionId;
    private String cardNumber;
    private String expirationDate;
    private BigDecimal totalPrice;
    private String flag;
}
