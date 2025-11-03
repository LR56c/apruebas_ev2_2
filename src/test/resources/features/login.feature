Feature: Autenticacion de Usuario
  Como usuario del sistema
  Quiero autenticarme
  Para acceder a mi cuenta

  Scenario: Inicio de sesion exitoso
    Given un usuario registrado con usuario "admin" y contrasena "admin123"
    When el usuario ingresa sus credenciales
    Then debe ver el mensaje de bienvenida "Bienvenido admin"

  Scenario Outline: Inicio de sesion fallido
    Given un usuario no autenticado
    When el usuario intenta iniciar sesion con <usuario> y <contrasena>
    Then debe ver el mensaje de error <mensaje_error>

    Examples:
      | usuario | contrasena | mensaje_error                             |
      | "user"  | "pass"     | "Error: Usuario o contrasena incorrecta"  |
      | ""      | "pass"     | "Error: Los campos no pueden estar vacios" |



