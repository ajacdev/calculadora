def COLOR_MAP =[
            'SUCCESS':'good',
            'FAILURE':'danger',
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
        SONAR_PROJECT_KEY = 'pruebapractica '
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${GIT_BRANCH}", url: "${GIT_REPO}"
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    
        
        stage('Code Coverage') {
            steps {
                sh 'mvn clean cobertura:cobertura'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
    
    post {
        always {
            echo 'Slack Notification'
            slackSend channel: '#pruebapractica',
            color: COLOR_MAP[currentBuild.currentResult],
            message: "*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More Info at: ${env.BUILD_URL}"
       
        }
    }
    

}

