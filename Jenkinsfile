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
                sh 'ls -la'
                sh 'cd Filemei/demo;ls -la'
                sh 'mvn clean package'
                sh 'ls -la'
            }
        }
        stage('Build image') {
            steps{
                script {
                    dockerImage = docker.build("suppi147/filemei:latest")
                }
            }
        }
        stage('Push image') {
            steps{
                script{
                    withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}