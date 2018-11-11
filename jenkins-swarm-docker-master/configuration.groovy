// Setup the basic configuration parameters of the Jenkins installation
import jenkins.model.JenkinsLocationConfiguration

// Get the configuration object
jlc = JenkinsLocationConfiguration.get()

// Set the root URL to something meaningful
jlc.setUrl("http://jenkins-master:8080/") 

// Save the configuration
jlc.save()

// Print out the root url to show it was set and the value
println("Root URL =" + jlc.getUrl())
