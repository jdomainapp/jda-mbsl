# JDA Module: MBSL (a.k.a AGL)
Implements the MBSL language.

***Version: 1.1-clean-initial***
- This version has been cleaned from `v1.0-bak` to streamline the Maven's module configuration and to remove all the unnecessary artifacts and resources.
- `jda-mbsl` has been retested to ensure that it still works as before
- The source code has not been changed in anyway. 
- This version is thus used as the starting point for any further development.


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