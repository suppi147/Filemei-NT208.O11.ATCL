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
                sh 'cd Filemei/demo;mvn clean package;cp /var/jenkins_home/workspace/filemei_setup-environment/Filemei/demo/target/demo.war /var/jenkins_home/workspace/filemei_setup-environment'
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
        stage('Deploy demo to DEV') {
            steps {
                echo 'Deploying and cleaning'
                sh 'docker stop filemei || echo "this container does not exist" '
                sh 'docker rm filemei'
                sh 'docker image pull suppi147/filemei:latest'
                sh 'docker run --name filemei -d -p 50000:50001 suppi147/filemei:latest'
            }
        }
    }
}