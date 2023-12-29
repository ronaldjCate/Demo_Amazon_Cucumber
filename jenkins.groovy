import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
pipeline{
    agent any
    tools {
        maven 'maven_3_9_5'
        jdk 'JDK21'
    }
    stages{
        stage('Compile Stage'){
            steps{
                script{
                    def mvnHome = tool name: 'maven_3_9_5', type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]){
                        bat "${mvnHome}\\bin\\mvn clean compile"
                    }
                }
            }
        }
        stage('Test Stage'){
            steps{
                script{
                    def mvnHome = tool name: 'maven_3_9_5',type: 'maven'
                    withEnv(["PATH+MAVEN=${mvnHome}/bin"]){
                        bat "mvn clean verify -Dcucumber.features=src/test/resources/features -Dcucumber.filter.tags=${tags} -Dcucumber.plugin=json:target/build/cucumber.json -Dcucumber.glue=bdd.stepDefinition"
                    }
                }
            }
        }
        stage ('Cucumber Reports'){
            steps{
                cucumber buildStatus: "UNSTABLE",
                        fileIncludePattern: "**/cucumber.json",
                        jsonReportDirectory: 'target'
            }
        }
    }
}