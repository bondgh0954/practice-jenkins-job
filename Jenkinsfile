#!/user/bin/env groovy
@Library('shared')
def gv
pipeline{
  agent any

  tools{
    maven ('maven-3')
  }
  stages{

    stage('init'){
      steps{
        script{
          gv = load 'script.groovy'
        }
      }
    }
    stage('build jar'){
      steps{
        script{
         buildJar()
        }
      }
    }


    stage('build image'){
      steps{
        script{
          buildImage()
          dockerLogin()
          pushImage()
        }
      }
    }
  }
}
