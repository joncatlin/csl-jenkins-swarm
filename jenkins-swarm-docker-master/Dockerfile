# Came from article http://szborows.blogspot.com/2018/01/preconfigured-jenkins-cluster-in-docker.html and a lot of hacking
FROM jenkins/jenkins:lts-alpine

# set the user and group ids
USER 1000:1000

# Copy the ssh key files to be used to remote into other machines
COPY ./ssh /.ssh

# Install the jenkins plugins and all their dependencies
RUN /usr/local/bin/install-plugins.sh swarm:3.14 workflow-aggregator:2.6 github:1.29.3 publish-over-ssh:1.20.1

# Set the option to not run the setup wizard as all setup is done through the groovy initialization scrips below
ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

# Copy various initialization groovy scripts that will be run on startup of the container
COPY jenkins-swarm-docker-master/*.groovy /usr/share/jenkins/ref/init.groovy.d/

# Copy files to set up the whitelisted commands and files. These are copied to the ref directory which will be copied by Jenkins on startup, 
# if they do not exit in the JENKINS_HOME directory
COPY jenkins-swarm-docker-master/master-access-control-command-filters.conf /usr/share/jenkins/ref/secrets/whitelisted-callables.d/gui.conf
COPY jenkins-swarm-docker-master/master-access-control-file-filters.conf /usr/share/jenkins/ref/secrets/filepath-filters.d/50-gui.conf


# COPY jenkins-swarm-docker-master/master-access-control-command-filters.conf /var/jenkins_home/secrets/whitelisted-callables.d/gui.conf
# COPY jenkins-swarm-docker-master/master-access-control-file-filters.conf /var/jenkins_home/secrets/filepath-filters.d/50-gui.conf

