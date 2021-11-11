FROM jenkins/jenkinsfile-runner
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY jenkins.war /app/jenkins/jenkins.war
RUN cd /app/jenkins && jar -cvf jenkins.war *
RUN java -jar /app/bin/jenkins-plugin-manager.jar --war /app/jenkins/jenkins.war --plugin-file /usr/share/jenkins/ref/plugins.txt && rm /app/jenkins/jenkins.war
