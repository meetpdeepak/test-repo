pipeline {
    agent any
    tools {
        // Define the Maven tool name as configured in Jenkins
        maven 'Maven3' // Replace 'Maven3' with the name you used in Jenkins configuration
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
                // The Maven executable will be automatically available in the PATH
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the Selenium TestNG tests
                sh 'mvn test'
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
