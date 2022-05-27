//CODE_CHANGES = getGitChanges() ---- logic should be there to catch code changes in repo

def gv

pipeline {

	agent any 

	/*environment {
		NEW_VERSION = '1.2.5'
		#Use of server credentials defined or declared in jenkins credential manager credentials("credentialId")
		# To use this feature i.e use of Jenkins-credentials in Jenkinsfils - Credential Binding PLugin is need to be installed
		SERVER_CREDENTIALS = credentials('')
	}*/

	/*tools {
		Only 3 tools available  gradle,maven,jdk.
		# example
		maven 'Maven'
	}
	*/

	
	parameters {
			//string(name: 'VERSION' defaultValue: '', description: 'Version to be deployed')
			choice (name: 'VERSION', choices: ['1.0.0', '1.1.0', '1.2.0'], description: '')
			booleanParam(name: 'executeTests', defaultValue: true, description: '')
	}
	

	stages {

		stage("init_stage") {
			steps {
				script {
					gv  = load "script.groovy"
					echo "############################3"
				}
				}
			}

		stage("build") {
			
			/*when {
				#Boolean condition OR Condition matching for a particular branch
				expression  {
					env.BRANCH_NAME/BRANCH_NAME == 'dev' && CODE_CHANGES ==true
				}
			}*/

			steps {

				//echo 'Hello building the app.....'

				// Using defined environment variable, Also take care of the single and double quotes to use environment variable
				//echo "Hello building the app.....${NEW_VERSION}"
				//sh "mvn install" // Global Configuration installation name Maven
				script {
					gv.buildApp()
					}
				}
			}
		
		/*stage("test") {

			/*when {
				#Boolean condition OR Condition matching for a particular branch
				expression  {
					env.BRANCH_NAME/BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
				}
			}*/
			when {
				expression {
					params.executeTests == false
				}
			}
			steps {
				 script {
					gv.testApp()
					}
				}
			}
		*/
		stage("deploy_qa") {
			steps {
				script {
					gv.deployApp()
					}
				}
			}
		
		stage("deploy_prod") {
			steps {
				echo "Hello building the app in prod....."
				echo "Deploying version ${params.VERSION}.... to PROD"

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
