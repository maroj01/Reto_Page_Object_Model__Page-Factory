# language: es

Característica: Solicitar información por medio del sitio web
  Yo como usuario de ParaBank
  Quiero informacion sobre los servicios bancarios
  Para solicitar una cuenta bancaria


  Escenario: Realizar consulta con todos los datos
    Dado que deseo obtener informacion de los productos
    Cuando me contacto ingresando toda la informacion solicitada
    Entonces se mostrara mensaje de confirmacion

  Escenario: Realizar consulta con datos incompletos
    Dado que requiero solicitar atencion de una asesor
    Cuando me contacto sin ingresar toda la informacion solicitada
    Entonces se mostrara el mensaje de error

