FROM openjdk:11

COPY target/Sb_Docker_app.jar /usr/app

WORKDIR /usr/app

ENTRYPOINT [ "java","-jar","Sb_Docker_app.jar " ]