FROM defsloc.azurecr.io/advisingbank/mymavenimage:latest

EXPOSE 8080

COPY ./target/java-maven-app-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar java-maven-app-*.jar
