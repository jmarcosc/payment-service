# payment-service
Microservice payment-service

POST /payments/save HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 900dac4f-48b1-70ef-e82b-8caf592e0fc6

REQUEST
{
	"cardNumber" : "12345678912042",
	"expirationDate" : "12/2020",
	"totalPrice" : "2000.00",
	"flag" : "VISA"
}
----------------------------------------------------------------------------------------------------------------------------------
GET /payments/findById/817f374b-d9cd-4211-8eef-3977298d15c8 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 8d12105f-f5e5-b2ed-fa6b-3ed9446c80a5

RESPONSE
{
    "transactionId": "817f374b-d9cd-4211-8eef-3977298d15c8",
    "cardNumber": "12345678912042",
    "expirationDate": "12/2020",
    "totalPrice": 2000,
    "flag": "VISA"
}
----------------------------------------------------------------------------------------------------------------------------------
PUT /payments/update/817f374b-d9cd-4211-8eef-3977298d15c8 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 3d44de86-ca10-63e8-2a30-77056602b696

REQUEST
{	
	"transactionId" : "0c7143b2-9ea5-4c4b-9940-b1e7754e31e9",
	"cardNumber" : "12345678912042",
	"expirationDate" : "12/2023",
	"totalPrice" : "3000.00",
	"flag" : "VISA"
}

RESPONSE
{
    "transactionId": "0c7143b2-9ea5-4c4b-9940-b1e7754e31e9",
    "cardNumber": "12345678912042",
    "expirationDate": "12/2023",
    "totalPrice": 3000,
    "flag": "VISA"
}
----------------------------------------------------------------------------------------------------------------------------------
DELETE /payments/delete/817f374b-d9cd-4211-8eef-3977298d15c8 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 4fd14b37-fe81-c77e-2259-e225d00fc48c
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
