# Pull base image
FROM phusion/baseimage

# Install Java.
# Install JSON helper 'jq'
# Install gettext for envsubst
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  apt-get install -y jq && \
  apt-get install -y gettext && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Define environment
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV appdir /opt/backend
ENV jarfile backend-SNAPSHOT.jar

# Create the app directory
RUN mkdir $appdir
RUN mkdir $appdir/extensions

# Add jarfile to app directory
ADD ./build/libs/$jarfile $appdir/

# Define working directory.
WORKDIR $appdir

# Define default command.
CMD ["my_init"]

ENTRYPOINT exec java ${JAVA_OPTS} -jar $appdir/$jarfile server -Dspring.config.location=config/application.properties