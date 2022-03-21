# language: es

Característica: Realizar autenticación en el sitio web
  Yo como usuario de ParaBank
  Quiero autenticarme en el sitio web
  Para gestionar mis productos bancarios

#@Test
  Escenario: Login a la plataforma con datos válidos
    Dado que se ingreso al home de ParaBank
    Cuando me autentico con el username y password
    Entonces se mostrara el resumen de la cuenta

  Esquema del escenario: Login a la plataforma con datos faltantes
    Dado que necesito ingresar a mi cuenta de ParaBank
    Cuando me autentico con username '<Username>' y password '<Password>' faltantes
    Entonces se mostrara el mensaje de advertencia

    Ejemplos:
      | Username | Password |
      | mroja    |          |
      |          | 123456   |



