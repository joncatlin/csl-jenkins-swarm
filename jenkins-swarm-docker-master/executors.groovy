#import hudson.model.*;
#import jenkins.model.*;
#
#println "--> disabling master executors"
#Jenkins.instance.setNumExecutors(0)

import jenkins.model.*
println "--> disabling master executors"
Jenkins.instance.setNumExecutors(0)
