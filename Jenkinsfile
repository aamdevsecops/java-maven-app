pipeline {
    agent any

    stages {
        stage("build") {
            steps {
                // here goes the script that actually executes some command in the Jenkins agent
                echo 'building the application...'
            }
        }
        stage("test") {
            steps {
                echo 'testing the application...'
            }
        }
        stage {"deploy"} {
            steps {
                echo 'deploying the application...'
            }
        }
    }
}