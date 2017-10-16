FROM openjdk:8

ADD target/scala-2.12/prime-calculator-assembly-0.0.1.jar /usr/local/bin/target/scala-2.12/prime-calculator-assembly-0.0.1.jar

CMD ["java", "-jar", "/usr/local/bin/target/scala-2.12/prime-calculator-assembly-0.0.1.jar"]
