pipeline{
    agent any
    stages{
        stage('Checkout Code'){
               steps{
                     git branch: 'main',
                            URL: https://github.com/rritesh029/springboot-crud-rds-aws-deploy
                     }
               }
        }
        stage('build'){
            steps{
                sh 'mvn clean install'
                }
            }
    }
}