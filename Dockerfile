FROM tomcat:9.0
COPY /var/jenkins_home/workspace/filemei_setup-environment/Filemei/demo/target/demo.war /usr/local/tomcat/webapps/
