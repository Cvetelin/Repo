set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Djetty.port=9090 -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=n -XX:PermSize=128M -XX:MaxPermSize=264M
mvn jetty:run