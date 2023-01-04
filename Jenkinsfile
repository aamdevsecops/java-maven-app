
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
                script {BRANCH_NAME_NAME
                    echo "Testing the application for $BRANCH_NAME"

    
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
                    env.BRANCH_NAME_NAME == 'feature/jenkins-jobs'
                }
            }
        }
        
        stage("build image") {
            when {
                expression {
                    env.BRANCH_NAME == 'feature/jenkins-jobs'
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
                    env.BRANCH_NAME == 'feature/jenkins-jobs'
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


