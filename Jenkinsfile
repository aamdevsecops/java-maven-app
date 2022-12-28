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
                    echo "Testing the application..."
                    echo "Executing pipeline for $BRANCH_NAME"
                }
            }

        }
        
        stage('build') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                  
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                   
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                BRANCH_NAME == main {
                   
                }
            }
        }
    }   
}