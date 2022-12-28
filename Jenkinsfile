def gv

pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: '1.1', description: 'version to deploy on prod')
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying $VERSION"
                    gv.deployApp()
                }
            }
        }
    }   
}