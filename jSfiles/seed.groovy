base_path = "stranger"
job_path = "${base_path}/jsfiles"
folder("${base_path}")

pipelineJob(job_path) {
    description("This job cretes kubernetes")
    logRotator {
        daysToKeep(30)
    }
    
    definition {
        cps {
            script(readFileFromWorkspace("${job_path}/Jenkinsfile"))
            sandbox(false)
        }
    }
}
  
