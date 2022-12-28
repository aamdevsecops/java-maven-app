
pipeline {
    agent any
    tools {
        maven 'maven-3.8'

    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
           
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t aamdevsecops/devops-bootcamp:jma-1.3 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push aamdevsecops/devops-bootcamp:jma-2.0'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                }
            }
        }
    }   
}