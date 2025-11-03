# Taller de Automatización CI
Este proyecto implementa Integración Continua (CI) y Behavior-Driven Development (BDD) para una aplicación Java con SpringBoot y Cucumber

## Objetivos del Proyecto

Realizar pruebas BDD usando Gherkin y Cucumber.
Automatizar la compilación y ejecución de todas las pruebas usando GitHub Actions (CI).
Generar reportes de resultados de pruebas.
Integrar alertas automáticas en caso de fallos.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven, separando el código de la aplicación del código de pruebas

## Archivos Clave y Configuración
- pom.xml:
- .github/workflows/ci.yml:
    - Define el pipeline de CI.
        - Configura ejecución con Java 17.
        - Ejecuta el comando mvn clean package. Este comando compila el código y ejecuta automáticamente las pruebas.
        - Sube los reportes de Surefire.
        - Sube los reportes de Cucumber.
        - Configura ejecución de k6.
        - Ejecuta Springboot y test de performance con k6
        - Genera dashboard de resultado de test de performance
        - Simula una alerta en caso si algún paso falla.

## Ejecucion Local
Requisitos
- JDK 17 (o superior)
- Apache Maven

Comandos de Ejecuccion
```bash
mvn clean package
```

Ejecutar Pruebas de Performance (Requiere k6):
```bash
k6 run login-test.js
```
