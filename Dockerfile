FROM tomcat:8.5.41-jdk11
RUN rm -r /usr/local/tomcat/webapps/*
COPY ./target/app.war /usr/local/tomcat/webapps/ROOT.war

ARG api_version_arg
ENV API_VERSION=$api_version_arg

ENV DB_HOST="db"
ENV DB_USER="postgres"
ENV DB_PASSWORD="12345"
ENV DB_NAME="postgres"

ENV JAVA_OPTS="-Ddbname=${DB_NAME} -Ddbhost=${DB_HOST} -Ddbuser=${DB_USER} -Ddbpassword=${DB_PASSWORD}"

RUN echo ${API_VERSION} > /version
EXPOSE 8080