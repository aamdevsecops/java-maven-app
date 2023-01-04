def BRANCH_NAME

def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 
def buildImage() {
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t aamdevsecops/devops-bootcamp:jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push aamdevsecops/devops-bootcamp:jma-2.0'
                    }
    
    }
def deployApp() {
    echo "deploying the application"
} 
return this