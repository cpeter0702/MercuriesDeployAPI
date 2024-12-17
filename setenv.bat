@echo off
set CATALINA_OPTS=%CATALINA_OPTS% -Djavax.net.ssl.trustStore=C:\path\to\tomcat-truststore.jks
set CATALINA_OPTS=%CATALINA_OPTS% -Djavax.net.ssl.trustStorePassword=changeit