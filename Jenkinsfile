pipeline {
    agent any
    tools {
        maven 'Maven3' // Replace 'Maven3' with the name configured in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                git branch: 'master', url: 'https://github.com/meetpdeepak/test-repo.git'
            }
        }

        stage('Setup') {
            steps {
                // Use Maven from Jenkins tool configuration
                // Ensure Maven is correctly set up in PATH
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the Selenium TestNG tests
                bat 'mvn test'
            }
        }

        stage('Publish Report') {
            steps {
                // Publish ExtentReports (if the reports are generated as HTML)
                publishHTML(target: [
                    reportDir: 'reports',
                    reportFiles: 'DeepakExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }

    post {
        always {
            // Archive test results and reports
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'reports/*.html', allowEmptyArchive: true
        }
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed. Check the logs for details.'
        }
    }
}
