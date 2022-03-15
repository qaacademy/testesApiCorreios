pipeline {
    agent any

    stages {
            stage ('E2E - API Test'){
            steps {
                sh 'echo Iniciando testes e2e'
                sh 'mvn clean install'
            }
        }
        stage ('Reports'){
            steps {
                 cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1 
            }
        }

    }

}