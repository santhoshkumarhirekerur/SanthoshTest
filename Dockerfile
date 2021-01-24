FROM openjdk:jre-alpine
VOLUME /tmp
ARG JAR_FILE

ENV _JAVA_OPTIONS "-Xms256m -Xmx512m -Djava.awt.headless=true"

COPY settings.xml ~/.m2/settings.xml
COPY ${JAR_FILE} /opt/app.jar
COPY .git /opt/.git

RUN addgroup bootapp && \
    adduser -D -S -h /var/cache/bootapp -s /sbin/nologin -G bootapp bootapp
WORKSDIR /opt
USER bootapp
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app.jar"]