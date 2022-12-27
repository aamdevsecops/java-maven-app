#!/usr/bin/env groovy

def buildApp() {
    echo "building the application..."
    sh 'mvn package'
} 

def testApp() {
    echo "testing the application"
    
    }

def deployApp() {
    echo "deploying the ${params.VERSION}"
} 

return this