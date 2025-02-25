FROM openjdk
LABEL authors="Robert"

VOLUME /tmp
ADD target/D387_sample_code-0.0.2-SNAPSHOT.jar myapp.jar

RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java", "-jar", "myapp.jar"]