FROM openjdk:11
COPY /target /tmp
COPY /files /tmp
WORKDIR /tmp/classes
ENTRYPOINT ["java","App", "../source.txt", "../queries.txt"]