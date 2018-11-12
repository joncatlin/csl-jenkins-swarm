# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html and a lot of hacking
FROM jenkins/jenkins:lts-alpine

USER 1000:1000

RUN /usr/local/bin/install-plugins.sh swarm:3.14 workflow-aggregator:2.6 github:1.29.3

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
COPY configuration.groovy /usr/share/jenkins/ref/init.groovy.d/configuration.groovy
# COPY create-credentials.groovy /usr/share/jenkins/ref/init.groovy.d/create-credentials.groovy
COPY configure-csrf-protection.groovy /usr/share/jenkins/ref/init.groovy.d/configure-csrf-protection.groovy
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy