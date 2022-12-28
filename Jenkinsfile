def gv

pipeline { 
    agent any
        // environment {
           parameters {
           // string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
            choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
            booleanParam(name: 'executeTests', defaultValue: true, description: '')
           }
           // tools { // you would want to run something like mvn install, gradle build, jvk.. etc 
           //   maven 'maven-3.8'
           // }
            // SERVER_CREDENTIALS = credentials('server-credentials') // you can also use wrapper syntax and use withCredentials() to the stage that you want
        

    stages {
        
        
        stage("init") {
            steps {
                script [
                    gv load = "script.groovy"
                    
                ]
            }
            
        }
            
        stage("build") {

            steps {
                script {
                 
                    gv.buildApp()
                }
                // here goes the script that actually executes some command in the Jenkins agent
            }
        }
        stage("test") {
            when {
                // define conditionals for each stage. you only want to run the test on the development branch build, instead of feature, or main
                expression {
                    params.executeTests
                    // here the boolean expression. the current active branch name is always available in Jenkinsfile through an environment variable
                    // env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main' // available out of the box.  This stage will only execute if the current branch is dev. If not, it's going to skip to other steps

                }
            }
            steps {
                script {

                    gv.testApp()
                }

            }
        }
        stage ("deploy") {
            steps {
                expression {
                    env.BRANCH_NAME == 'feature/jenkins-jobs'
                }
                  script {
                gv.deployApp()
                
                }

            }
          
        }
    }
}
