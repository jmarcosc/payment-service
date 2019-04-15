package br.com.fiap.paymentservice.Controller;

import br.com.fiap.paymentservice.Payment;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/payments", produces = "application/hal+json")
@Api(value = "Payment", description = "payments management")
public class ServiceController {

    List<Payment> payments = new ArrayList<>();

    @GetMapping("/findById/{transactionId}")
    public ResponseEntity<Payment> getPayment(@PathVariable("transactionId") String transactionId){

        Payment payment = null;

        try {
            for (Payment p: payments) {
                if(p.getTransactionId().equals(transactionId)) {
                    payment = p;
                }
            }
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Payment> postOrder(@RequestBody Payment payment){

        try {
            payment.setTransactionId(UUID.randomUUID().toString());
            payments.add(payment);

            URI location = ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/{transactionId}").
                    buildAndExpand(payment.getTransactionId()).toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{transactionId}")
    public ResponseEntity<Payment> updateOrder(@PathVariable("transactionId") String transactionId, @RequestBody Payment payment){

        try {
            for (Payment o: payments) {
                if(o.getTransactionId().equals(transactionId)) {
                    payments.remove(o);
                    payments.add(payment);
                }
            }
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{transactionId}")
    public ResponseEntity deleteOrder(@PathVariable("transactionId") String transactionId){

        try {
            payments.removeIf(order -> order.getTransactionId().equals(transactionId));
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
