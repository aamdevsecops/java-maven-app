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
            steps {
                script {
                    gv.buildJar()   
                }
              
            }
            when {
                expression {
                    BRANCH_NAME == 'main'
                    echo "since $BRANCH_NAME conditioned by when condition, we are not building anything on gv.buildJar()"
                }
            }
        }
        stage("build jar") {
            when {
                expression {
                    BRANCH_NAME == 'main'
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
                    BRANCH_NAME == 'main'
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
                    BRANCH_NAME == ['main', 'feature/jenkins-jobs']
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