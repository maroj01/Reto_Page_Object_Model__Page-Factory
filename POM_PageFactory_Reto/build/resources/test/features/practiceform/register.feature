# language: es

Característica: Realizar registro en el sitio web
  Yo como nuevo usuario de ParaBank
  Quiero registrarme en el sitio web
  Para acceder en línea instantáneo y gratuito

#@Test
  Escenario: Registro a la plataforma datos obligatorios
    Dado que se ingreso al formulario de usuario nuevo
    Cuando me registro con los datos solicitados
    Entonces se creara el registro exitoso

  Escenario: Registro a la plataforma sin datos obligatorios
    Dado que deseo obtener una cuenta en el sitio web de ParaBank
    Cuando me registro con algunos datos solicitados
    Entonces se mostrara el mensaje del error