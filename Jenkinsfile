@Library('pipeline-utility-steps') _
def gv
def BRANCH_NAME = env.BRANCH_NAME

pipeline {
    parameters {
        string(name: 'branch', defaultValue: BRANCH_NAME)
    }
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
                    echo "Testing the application for $branch"

    
                }
            }

        }
        
        stage('build') {
            steps {
                script {
                    print("Branch: ${branch}")
                    gv.buildJar()   
                }
              
            }
            when {
                expression {
                    branch == 'feature/jenkins-jobs'
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    branch == 'feature/jenkins-jobs'
                }
            }
            steps {
                script {
                  
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            when {
                expression {
                    branch == 'feature/jenkins-jobs'
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
                    branch == 'feature/jenkins-jobs'
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


