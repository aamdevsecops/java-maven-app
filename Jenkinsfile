def gv
def BRANCH_NAME

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
                    echo "Testing the application for ${env.BRANCH_NAME}"
    
                }
            }

        }
        
        stage('build') {
            steps {
                script {
                    gv.buildJar()   
                }
              
            }
            when {
                expression {
                    ${env.BRANCH_NAME}  == 'feature/jenkins-jobs'
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    ${env.BRANCH_NAME}  == 'feature/jenkins-jobs'
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
                    ${env.BRANCH_NAME} == 'feature/jenkins-jobs'
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
                    ${env.BRANCH_NAME} == '*/feature/jenkins-jobs'
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