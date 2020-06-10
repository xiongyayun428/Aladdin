FROM xiongyayun428/openjdk:8-jre-alpine
LABEL Author="熊亚运 <xiongyayun428@163.com>"
VOLUME /tmp
WORKDIR /athena

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

#ENV JAVA_OPTS="-Xms1024m -Xmx4096m -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8"
## 传入参数
#ENV PARAMS=""
#EXPOSE 9082
#ENTRYPOINT exec java $JAVA_OPTS $PARAMS -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.config.additional-location=/hljinke/config/

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

