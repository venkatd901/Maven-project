//CODE_CHANGES = getGitChanges() ---- logic should be there to catch code changes in repo

pipeline {

	agent any 

	/*environment {
		NEW_VERSION = '1.2.5'
		#Use of server credentials defined or declared in jenkins credential manager credentials("credentialId")
		# To use this feature i.e use of Jenkins-credentials in Jenkinsfils - Credential Binding PLugin is need to be installed
		SERVER_CREDENTIALS = credentials('')
	}*/

	stages {
		stage("build"){
			
			/*when {
				#Boolean condition OR Condition matching for a particular branch
				expression  {
					env.BRANCH_NAME/BRANCH_NAME == 'dev' && CODE_CHANGES ==true
				}
			}*/

			steps {
				echo 'Hello building the app.....'
				//Using defined environment variable, Also take care of the single and double quotes to use environment variable
				//echo "Hello building the app.....${NEW_VERSION}"
				}
			}
		
		stage("test") {
			/*when {
				#Boolean condition OR Condition matching for a particular branch
				expression  {
					env.BRANCH_NAME/BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
				}
			}*/

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
				/*
				# If we need credentials for a single stage then we can use below way
				# for that we have 2 plugins usage 
				withCredentials([
					usernamPassword(credentials: 'SERVER_CREDENTIALS_ID' , usernameVariable: USER, passwordVariable: PWD - that we have saved in Jenkins credentials_manager)
				]) {
					sh "some scripts ${USER} ${PWD}"	

				}*/
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
