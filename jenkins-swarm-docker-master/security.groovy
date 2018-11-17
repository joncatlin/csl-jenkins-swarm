#!groovy

import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule

def instance = Jenkins.getInstance()

def user = new File("/run/secrets/jenkinsUser").text.trim()
def pass = new File("/run/secrets/jenkinsPassword").text.trim()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(user, pass)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

// Enable the Agent → Master Access Control. The files and command are configured in seperate files
// See the Dockerfile that moves files to /secrets/filepath-filters.d & /secrets/whitelisted-callables.d
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

instance.save()

