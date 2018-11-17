# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html and a lot of hacking
FROM docker:latest

RUN apk --update add openjdk8-jre git python3
RUN wget -O swarm-client.jar http://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client/3.14/swarm-client-3.14.jar

# Copy the ssh key files to be used to remote into other machines
COPY ./ssh /.ssh

# Create the directory for Jenkins to use
RUN mkdir -p /tmp/jenkins

# Start the Jenkins swarm client
CMD java -jar swarm-client.jar -labels=docker -executors=1 -fsroot=/tmp/jenkins -name=docker-$(hostname) $(cat /run/secrets/jenkinsSwarm)

