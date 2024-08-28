def COLOR_MAP = [
    'SUCCESS': 'good',
    'FAILURE': 'danger'
]

pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        GIT_REPO = 'https://github.com/ajacdev/calculadora.git'
        GIT_BRANCH = 'main'
        scannerHome = tool 'Sonar'
        SONAR_PROJECT_KEY = 'pruebapractica'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${GIT_BRANCH}", url: "${GIT_REPO}"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn clean cobertura:cobertura'
            }
        }
    }

    post {
        always {
            echo 'Slack Notification'
            slackSend (
                channel: '#pruebapractica',
                color: COLOR_MAP[currentBuild.currentResult],
                message: "*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\nMore Info at: ${env.BUILD_URL}"
            )
        }
    }
}
