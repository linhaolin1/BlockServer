FROM openjdk
RUN mkdir -p /home/brick
RUN mkdir -p /home/brick/plugins
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
COPY blockServer-0.0.1-SNAPSHOT.jar /home/brick/blockServer-0.0.1-SNAPSHOT.jar
COPY plugins/* /home/brick/plugins/
COPY test.js /home/brick/
ENV LANG C.UTF-8

ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","/home/brick/blockServer-0.0.1-SNAPSHOT.jar"]

