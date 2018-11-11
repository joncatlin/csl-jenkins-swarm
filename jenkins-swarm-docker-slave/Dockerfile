# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html and a lot of hacking
FROM docker:latest

RUN apk --update add openjdk8-jre git python3
RUN wget -O swarm-client.jar http://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.14/swarm-client-3.14.jar

COPY entrypoint.sh /
RUN chmod +x /entrypoint.sh

RUN mkdir -p /tmp/jenkins

# This does not work as it gets stuck trying to make a connection to the master
#CMD ["/entrypoint.sh"]

# This also does not seem to work for same reason
#CMD sh ./entrypoint.sh

# This works!
CMD java -jar swarm-client.jar -labels=docker -executors=1 -fsroot=/tmp/jenkins -name=docker-$(hostname) $(cat /run/secrets/jenkinsSwarm)

