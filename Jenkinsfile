
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.8'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage('test') {
            steps {
                script {
                    echo "Testing the application for $GIT_BRANCH"

    
                }
            }

        }
        
        stage('build') {
            steps {
                script {
                    print("BRANCH_NAME: ${BRANCH_NAME}")
                    gv.buildJar()   
                }
              
            }
            when {
                expression {
                    env.GIT_BRANCH == 'feature/jenkins-jobs'
                }
            }
        }
        
        stage("build image") {
            when {
                expression {
                    env.GIT_BRANCH == 'feature/jenkins-jobs'
                }
            }
            steps {
                script {
                   
                    gv.buildImage()
                }
            }
        }
        stage('deploy') {
            when {
                expression {
                    env.GIT_BRANCH == 'feature/jenkins-jobs'
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}


