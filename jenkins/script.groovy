def buildJar() {
    echo "building the application..."
    sh 'mvn clean package'
} 

def buildImage() {
    echo "building the docker image..."
        //withCredentials([usernamePassword(credentialsId: 'ACR', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        //sh 'docker build -t advisingbank/demo-app .'
        //sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh 'docker push nanajanashia/demo-app:jma-2.0'
        dockerImage = docker.build registryName + ":$BUILD_NUMBER"
    //}
    } 

def pushImage() {
    echo 'Pushing the build image...'
         docker.withRegistry( "http://${registryUrl}", registryCredential ) {
         dockerImage.push()
         }
} 
def runImage() {
    echo 'running the application in a container...'
    sh 'docker run -d -p 7500:8080 --rm --name mymavenContainer ${registryUrl}/${registryName}:$BUILD_NUMBER'
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
