// Pre approve signatures that are needed for the demo application to run. Without this running the scripts will
// fail and the administrator will have to manually approve them.

import org.jenkinsci.plugins.scriptsecurity.scripts.*

ScriptApproval sa = ScriptApproval.get();

//Add signatures to the pending approval list
// signature = "staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getText java.net.URL"
def signature1 = "method hudson.plugins.git.GitSCM getUserRemoteConfigs"
def signature2 = "method hudson.plugins.git.UserRemoteConfig getUrl"

ScriptApproval.PendingSignature s1 = new ScriptApproval.PendingSignature(signature1, false, ApprovalContext.create())
sa.getPendingSignatures().add(s1)
ScriptApproval.PendingSignature s2 = new ScriptApproval.PendingSignature(signature2, false, ApprovalContext.create())
sa.getPendingSignatures().add(s2)

// Get a second instance so the loop does not throw java.util.ConcurrentModificationException
ScriptApproval sa2 = ScriptApproval.get();

// Approve signatures. Only do one at a time because of the java.util.ConcurrentModificationException
for (ScriptApproval.PendingSignature pending : sa.getPendingSignatures()) {
     	sa2.approveSignature(pending.signature);
     	println "---> Approved : " + pending.signature
      break
}
for (ScriptApproval.PendingSignature pending : sa.getPendingSignatures()) {
     	sa2.approveSignature(pending.signature);
     	println "---> Approved : " + pending.signature
      break
}