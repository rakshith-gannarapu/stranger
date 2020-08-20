base_path = "stranger"
job_path = "${base_path}/jSfiles"
folder("${base_path}")

pipelineJob(job_path) {
    description("This job cretes kubernetes")
    logRotator {
        daysToKeep(50)
    }
    
    definition {
        cps {
            script(readFileFromWorkspace("${job_path}/Jenkinsfile"))
            sandbox(false)
        }
    }
}
  
