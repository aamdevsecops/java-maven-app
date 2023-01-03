#!/usr/bin/ env groovy

@Library('jenkins-shared-library') // the name of the library that we created in Jenkins
def gv  

// if we don't have a variable definition, we should put an _ after (jenkins-shared-library_)

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

        
        stage('build jar') {
            steps {
                script {
                    buildJar()

                }
              
            }

        }
        stage("build image") {

            steps {
                script {
                  buildImage 'aamdevsecops/aamdevsecops-bootcamp:jma-4.0'

                }
            }
        }
        

        stage('deploy') {

            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}