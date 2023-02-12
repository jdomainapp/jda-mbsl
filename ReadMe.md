# MBSL a.k.a AGL

A repository for tool AGL: Incorporating Behavioral Aspects into Domain-Driven Design.

***Version: 1.1-clean-initial***
- This version has been cleaned from `v1.0-bak` to streamline the Maven's module configuration and to remove all the unnecessary artifacts and resources.
- `jda-mbsl` has been retested to ensure that it still works as before
- The source code has not been changed in anyway. 
- This version is thus used as the starting point for any further development.

# Project structure   

```
jda:root	-> the root project
  common  -> module-common: (base) module used by other modules
  jda:main -> contains the core components of JDA
  modules:mbsl    -> implements MBSL language
   - ...
```

# Using the deployed module MBSL
GitHub repository: https://github.com/jdomainapp/jda-mbsl
1. Download the deployed module MBSL: jda-mbsl into the Jdomainapp folder
2. Unzip it into the Jdomainapp folder
The content of Jdomainapp folder needs to look like this:
```
  - common
  - main
  - modules
      - MBSL
   - ...
```
# How to run the tool in a Java software framework
The tool can be executed within an Integrated evelopment Environment (IDE), such as Eclipse; PostgreSQL Database
1. Use the "Import existing Maven project" to import the artifact project
2. PostgreSQL:
   - Create User: admin; Pass: password
   - Create a database name: domainds
## running a pattern form: Decisional, forked, joined, merged, sequential (in jda\modules\mbsl\src\test\java\org\jda\example\courseman\software):
![running a pattern form](docs/images/sourses.png)
# Code:
## Unified model:
![Conceptual Model: CM](docs/images/agl_cm.PNG)
``private void genGraph()`` 
### in class: ActivityModel transform CMT
![ Abstract Syntax Model: ASM](docs/images/agl_cmt.PNG)
### Result: Concrete Syntax Model (CSM) in the class: EnrolmentMgmt
![Concrete Syntax Model: CSM](docs/images/agl_csm.PNG)

