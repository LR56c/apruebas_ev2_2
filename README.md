Proyecto: Taller de Automatización y CI (taller-ci)
Este proyecto implementa un flujo de trabajo profesional de Integración Continua (CI) y Behavior-Driven Development (BDD) para una aplicación Java.

1. Objetivos del Proyecto
Gestionar el código fuente y las pruebas usando Git y GitHub.

Administrar dependencias y el ciclo de vida del build con Maven.

Implementar Pruebas Unitarias atómicas con JUnit 5.

Definir el comportamiento del sistema usando BDD (Gherkin y Cucumber).

Automatizar la compilación y ejecución de todas las pruebas usando GitHub Actions (CI).

Generar reportes navegables de resultados de pruebas (JUnit y BDD).

Integrar alertas automáticas (Slack) en caso de fallos.

2. Estructura del Proyecto
El proyecto sigue la estructura estándar de Maven :

taller-ci/
├── .github/
│   └── workflows/
│       └── ci.yml         # (Pipeline de CI)
├── .gitignore
├── pom.xml                # (Dependencias: JUnit, Cucumber)
└── src/
    ├── main/java/         # (Código fuente, ej: Calculator.java)
    └── test/
        ├── java/          # (Código de prueba)
        │   ├── com/iplacex/pruebas/
        │   │   ├── CalculatorTest.java  # (Pruebas Unitarias)
        │   │   └── org.iplacex.RunCucumberTest.java # (Runner BDD)
        │   └── steps/
        │       └── LoginSteps.java      # (Step Definitions BDD)
        └── resources/
            └── features/
                └── login.feature      # (Escenarios Gherkin BDD)
3. Archivos Clave y Configuración
pom.xml:

Gestiona junit-jupiter para pruebas unitarias.

Gestiona cucumber-java y cucumber-junit para BDD.

Utiliza maven-surefire-plugin para ejecutar las pruebas unitarias.

.github/workflows/ci.yml:

Define el pipeline de CI.

Se dispara en cada push y pull_request a main.

Stages:

Checkout: Descarga el código.

Set up JDK 11: Configura el entorno Java.

Build and run tests: Ejecuta mvn clean package. Este comando compila, ejecuta pruebas JUnit y pruebas Cucumber.


Upload test reports: Sube los reportes XML de Surefire.


Upload BDD HTML reports: Sube los reportes HTML de Cucumber.


Notify on failure: Envía una alerta a Slack si algún paso falla.

4. Cómo Ejecutar las Pruebas Localmente
Requisitos
JDK 11 (o superior)

Apache Maven

Comandos
Ejecutar todas las pruebas (Unitarias y BDD):

Bash

mvn clean package
Ver Reporte BDD:

Después de ejecutar el comando anterior, abre el siguiente archivo en tu navegador:

target/cucumber-html-reports/report.html

Ejecutar Pruebas de Performance (Requiere k6):

Bash

# (Asegúrate de tener k6 instalado)
k6 run login-test.js