#!/usr/bin/env groovy

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
                    echo "Testing the application for $BRANCH_NAME"
    
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
                    env.BRANCH_NAME == '*/feature/jenkins-jobs'
                    echo "since $BRANCH_NAME conditioned by when condition, we are not building anything on gv.buildJar()"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    env.BRANCH_NAME == 'feature/jenkins-jobs'
                    echo "since $BRANCH_NAME conditioned by when condition, we are not building anything on gv.buildJar()"
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
                    BRANCH_NAME == '*/feature/jenkins-jobs'
                    echo "since $BRANCH_NAME conditioned by when condition, we are not building anything on gv.buildImage()"
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
                    BRANCH_NAME == '*/feature/jenkins-jobs'
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