def gv

pipeline{
    agent any
    
    parameters {
        choice(name: "Git_Branch_Name", choices: ["dev", "QA", "Prod"],  description: "Select the branch to checkout")
    }
    
    stages{
          stage('code quality check via sonarQube') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'dev' || 
                        env.BRANCH_NAME == 'QA' ) {
                        echo 'I execute on the DEV and QA branch'
                        gv = load "pipeline_config.groovy"
                        echo "sonarQube code quality check"
                        gv.qualityanalysis()
                    } else {
                        echo 'I execute elsewhere' 
                  }
                }
            }
        }
           stage('Generate Junit Test Report') {
            steps {
              script {
                  if (env.BRANCH_NAME == 'dev' || 
                      env.BRANCH_NAME == 'QA' ) {
                      gv = load "pipeline_config.groovy"
                      echo "Generated Test report..."
                      gv.testReport()
                } else {
                        echo 'I execute elsewhere' 
                  }
              }
            }
         }
           stage("Build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
         }
       stage("Roll Back") {
             steps {
                 script {
                   echo "roll back to previous version"
                   gv.rollback()
             }
          }
        }
    }
        post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
 
 
}
