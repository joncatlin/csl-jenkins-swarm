mkdir /tmp/jenkins
java -jar swarm-client.jar -labels=docker -executors=1 -fsroot=/tmp/jenkins -name=docker-$(hostname) $(cat /run/secrets/jenkinsSwarm)
