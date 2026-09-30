# Money Calculator

Aplicación desarrollada en Java para realizar conversiones entre diferentes monedas utilizando información obtenida desde servicios externos de tipos de cambio.

El proyecto consulta APIs externas para obtener las tasas de cambio necesarias para realizar las conversiones.

## Tecnologías utilizadas

- Java
- Maven
- APIs REST
- Currencylayer
- ExchangeRatesAPI
- IntelliJ IDEA
- Git
- GitHub

## APIs utilizadas

La aplicación puede obtener información de tipos de cambio utilizando los siguientes servicios:

- Currencylayer
- ExchangeRatesAPI

Para utilizar estos servicios es necesario disponer de una API Key propia.

## Configuración de las API Keys

Por seguridad, las claves de las APIs no se almacenan directamente en el código fuente.

La aplicación utiliza las siguientes variables de entorno:

```text
CURRENCYLAYER_API_KEY
EXCHANGERATES_API_KEY
```

### Configuración temporal en PowerShell

```powershell
$env:CURRENCYLAYER_API_KEY="TU_API_KEY"
$env:EXCHANGERATES_API_KEY="TU_API_KEY"
```

Estas variables permanecerán disponibles mientras la terminal de PowerShell siga abierta.

### Configuración permanente en Windows

1. Buscar:

```text
Editar las variables de entorno del sistema
```

2. Abrir:

```text
Variables de entorno
```

3. Crear las siguientes variables de usuario:

```text
CURRENCYLAYER_API_KEY
```

y:

```text
EXCHANGERATES_API_KEY
```

4. Introducir como valor la API Key correspondiente.

## Obtener las API Keys

Puedes obtener tus claves registrándote en:

Currencylayer:

```text
https://currencylayer.com/
```

ExchangeRatesAPI:

```text
https://exchangeratesapi.io/
```

Una vez creada la cuenta, cada servicio proporciona una API Key desde su panel de usuario.

## Requisitos

Para ejecutar el proyecto necesitas:

- Java JDK
- Maven
- Conexión a Internet
- Una API Key válida para el servicio utilizado

Puedes comprobar Java y Maven con:

```bash
java --version
mvn --version
```

## Instalación

Clona el repositorio:

```bash
git clone https://github.com/panchomalilloss/money-calculator.git
```

Accede a la carpeta:

```bash
cd money-calculator
```

Compila el proyecto:

```bash
mvn clean package
```

## Ejecución

Una vez configuradas las API Keys, puedes ejecutar la aplicación directamente desde IntelliJ IDEA ejecutando la clase principal.

También puedes compilar el proyecto utilizando:

```bash
mvn clean package
```

## Funcionamiento

De forma general, la aplicación sigue este flujo:

```text
Moneda de origen
       ↓
Cantidad
       ↓
Moneda de destino
       ↓
Consulta del tipo de cambio
       ↓
Conversión
       ↓
Resultado
```

La aplicación obtiene los tipos de cambio desde servicios externos y utiliza esos datos para realizar la conversión solicitada.

## Seguridad

Las API Keys no deben añadirse directamente al repositorio.

Por este motivo, el proyecto obtiene las claves mediante variables de entorno utilizando:

```java
System.getenv(...)
```

Esto permite mantener las credenciales fuera del código fuente y evita subir información sensible a GitHub.

## Objetivo del proyecto

El objetivo del proyecto es practicar el desarrollo de aplicaciones Java que consumen servicios externos mediante APIs, aplicando separación de responsabilidades y evitando almacenar información sensible directamente en el código.

## Autor

Desarrollado por [panchomalilloss](https://github.com/panchomalilloss)
