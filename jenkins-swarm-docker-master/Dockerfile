#FROM jenkins
#
#COPY plugins.txt /usr/share/jenkins/plugins.txt
#RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

# remove executors in master
#COPY master-executors.groovy /usr/share/jenkins/ref/init.groovy.d/










# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html
FROM jenkins/jenkins:2.89.1-alpine

# ARG proxy
# ENV http_proxy=$proxy https_proxy=$proxy

#USER root
#RUN apk update && apk add python3
#COPY requirements.txt /tmp/requirements.txt
#RUN pip3 install -r /tmp/requirements.txt

USER jenkins

# ??? Does this need to be commented out
#COPY plugins.txt /plugins.txt

RUN /usr/local/bin/install-plugins.sh swarm:3.6 workflow-aggregator:2.5

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy
#COPY proxy.groovy /usr/share/jenkins/ref/init.groovy.d/proxy.groovy
COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/executors.groovy