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
	
	/*// Build Status or build  status change in comparison to previous build status
	post {
		always {
		// Sending Emails to team about the build status of jobs even pipeline failed
		}
		
		success {
		// only relevant when build success
			
		}
		failure {
		// only relevant when build failed
			
		}
	}
	*/
}
