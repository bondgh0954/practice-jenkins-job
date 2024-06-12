def buildJar(){
    echo 'building application artifact'
    sh 'mvn package'
}

def buildImage(){
    echo 'building application into docker image'
    sh 'docker build -t nanaot/java-app:5.0 .'
    withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',usernameVariable:'USER',passwordVariable:'PASSWORD')]){
        sh "echo $PASSWORD |docker login -u $USER --password-stdin"
        sh 'docker push nanaot/java-app:5.0'
    }
}