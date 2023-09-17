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
        stage('Pushing image'){
            steps {
                withDockerRegistry(credentialsId: 'dockerhub', url: '') {
                    sh 'docker build -t suppi147/filemei .'
                    sh 'docker push suppi147/filemei'
                }
            }
        }
    }
}