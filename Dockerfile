FROM fengshuaiju/tomcat7:v9

MAINTAINER shuaijufeng "1179694483@qq.com"

WORKDIR /code

RUN echo "Asia/Shanghai" > /etc/timezone && \
        dpkg-reconfigure -f noninteractive tzdata

RUN rm -r /usr/local/tomcat/webapps/*

ADD pom.xml /code/pom.xml 
RUN mvn dependency:resolve 

ADD . /code
RUN mvn package && cp -r target/ROOT.war /usr/local/tomcat/webapps/

# Start Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]