# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html
FROM docker:17.03-rc

RUN apk --update add openjdk8-jre git python3
RUN wget -O swarm-client.jar http://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.3/swarm-client-3.3.jar

CMD java -jar swarm-client.jar -labels=docker -executors=1 -fsroot=/tmp/jenkins -name=docker-$(hostname) $(cat /run/secrets/jenkinsSwarm)

