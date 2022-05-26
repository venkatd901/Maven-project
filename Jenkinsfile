pipeline {
	agent any 

	stages {
		stage("build"){
			steps {
				echo "Hello building the app....."
				}
			}
		
		stage("test") {
			steps {
				echo "Testing the app....."
				}
			}
		
		stage("deploy_qa") {
			steps {
				echo "Hello building the app on qa....."
				}
			}
		
		stage("deploy_prod") {
			steps {
				echo "Hello building the app in prod....."
			}
		}
	}
}
