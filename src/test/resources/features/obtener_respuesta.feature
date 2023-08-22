Feature: Obtener respuesta del servicio
  Yo como usuario
  Quiero realizar una peticion al servicio
  para obtener una respuesta correcta

  Scenario: Obtener Status code
    Given yo cuando envio una peticion al servicio
    When Recibo la respuesta del servicio
    Then podre validar que el estado es correcto