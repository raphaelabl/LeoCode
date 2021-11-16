FROM jenkins/jenkinsfile-runner
RUN ls -l
COPY jenkins.war /app/jenkins/jenkins.war
RUN cd /app/jenkins && ls -l
RUN cd /app/bin && ls -l
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN java -jar /app/bin/jenkins-plugin-manager.jar --war /app/jenkins/jenkins.war --plugin-file /usr/share/jenkins/ref/plugins.txt && rm /app/jenkins/jenkins.war
