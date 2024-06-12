pipeline{
  agent any

  tools{
    maven 'maven-3'
  }
  stages{
    stage('build jar'){
      steps{
        script{
          echo 'building application artifact'
          sh 'mvn package'
        }
      }


    stage('build image'){
      steps{
        script{
          echo 'building application into docker image'
          sh 'docker build -t nanaot/java-app:5.0 .'
          withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',usernameVariable:'USER',passwordVariable:'PASSWORD')]){
            sh "echo $PASSWORD |docker login -u $PASSWORD --password-stdin"
            sh 'docker push nanaot/java-app:5.0'
          }
        }
      }
    }
  }
}