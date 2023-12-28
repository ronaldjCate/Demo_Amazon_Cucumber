pipeline{
agent any
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
                    bat "${mvnHome}\\bin\\mvn clean verify -Dcucumber.filter.tags=\"${tags}\""
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