Feature: Realizar registro
  Yo como usuario
  Quiero enviar una peticion
  para realizar el registro

  Scenario: Realizar registro exitoso
    Given Envio la peticion POST
    |eve.holt@reqres.in|pistol|
    When Recibo la respuesta del servicio
    Then podre recibir el token


  Scenario: Realizar registro fallido
    Given Envio la peticion POST
    |sydney@fife||
    When Recibo la respuesta del servicio
    Then podre ver el mensaje de error
