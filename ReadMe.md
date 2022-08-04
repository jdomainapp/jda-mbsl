# JDA project structure
   
JDA (formerly known as `JDomainApp`) is a [multi-module Maven project](https://books.sonatype.com/mvnex-book/reference/multimodule.html). 

In Maven's terminology, a **module** is implemented as an **artifact project**.

JDA has a root (top-level) project whose structure is as follows:

```
jda:root	-> the root project
  common  -> module-common: (base) module used by other modules
  jda:main -> contains the core components of JDA
  	:mbsl    -> implements MBSL language
   - ...
```

# How to...

**REMEMBER:** Always perform commands on a module project **from the JDA root** directory:

## Install a project

From the root folder of the project, type this command:

`mvn clean install -DskipTests=true`

## Work with an artifact project in Eclipse

1. Use the "Import existing Maven project" to import the artifact project you want to work with
   - browse to the artifact folder and select it's pom on the dialog


# JDA Module: MBSL
Implements the MBSL language.
Run:
# 1. PostgreSQL:
## - Create User: admin; Pass: password
## - Create a database name: domainds
# 2. import maven MBSL -> running a pattern form: Decisional, forked, joined, merged, sequential (in jda\modules\mbsl\src\test\java\org\jda\example\courseman\software)
'' Note:
config built path: Postgresql (https://mvnrepository.com/artifact/org.postgresql/postgresql)'
# Code:
## Unified model:
![Conceptual Model: CM](

