import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
pipeline{
    agent any
    tools {
        maven 'M3'
        jdk 'JAVA21'
    }

    stages {

        stage ('Build') {
            steps {
                bat ("mvn clean install -DskipTests")
                bat ("mvn clean verify")
            }
        }

        stage ('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        bat("mvn clean verify -Dcucumber.features=src/test/resources/features -Dcucumber.filter.tags=${tags} -Dcucumber.plugin=json:target/build/cucumber.json -Dcucumber.glue=bdd.stepDefinition")
                        echo 'Ejecucion de pruebas sin errores...'
                    }
                    catch (ex) {
                        echo 'Finalizo ejecucion con fallos...'
                        error ('Failed')
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