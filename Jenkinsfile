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
         gv.buildJar()
        }
      }
    }


    stage('build image'){
      steps{
        script{
          gv.buildImage()
        }
      }
    }
  }
}