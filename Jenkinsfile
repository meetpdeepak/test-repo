pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                git branch: 'master', url: 'https://github.com/meetpdeepak/test-repo.git'
            }
        }

        stage('Setup') {
            steps {
                // Ensure that Maven is available on PATH
                // Install dependencies (if necessary)
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Run TestNG tests
                bat 'mvn test -DsuiteXmlFile=testng.xml'
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
