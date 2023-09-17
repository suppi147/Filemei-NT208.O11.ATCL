pipeline{
    
    agent any
    
    tools {
        maven 'my-maven'
    }
    
    stages{
        stage('Build with Maven') {
            steps {
            sh 'mvn --version'
            sh 'java --version'
            }
        }
    }
}