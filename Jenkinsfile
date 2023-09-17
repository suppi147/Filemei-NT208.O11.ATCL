pipeline{
    agent any
    tools {
        maven 'my-maven'
    }
    stages{
        stage('Build with Maven') {
            steps {
                script {
                    def workspace = pwd()
                    sh 'mvn --version'
                    sh 'java --version'
                    sh 'cd Filemei/demo;mvn clean package;cp ${workspace}/target/demo.war ${workspace}'
                }
                
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