pipeline {

agent any

stages {


stage('Build Artifact - Maven') {
steps {
sh "mvn clean package -DskipTests=true"
archive 'target/*.jar'

}
}

	
	

	
	
              stage('Unit test - Junit and jacoco') {
            steps {
              sh "mvn test"
            }

	      }
	
       stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "Docker-Hub-SeyfCHERNI", url: ""]) {
           sh 'printenv'
           sh 'sudo docker build -t seyf89/ci:latest .'
           sh 'docker push seyf89/ci:latest '
         }
       }
     }



	
  
}                   


}  


