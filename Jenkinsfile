pipeline{
    agent any
    stages{
        stage('Checkout Code'){
               steps{
                     git branch: 'main',
                            url: 'https://github.com/rritesh029/springboot-crud-rds-aws-deploy'
                     }
               }

        stage('Build using Maven Docker') {
             agent {
                docker {
                    image 'maven:3.9.4-eclipse-temurin-17'      // ✅ Maven + Java 17
                    args '-v $HOME/.m2:/root/.m2'               // ✅ Optional: Cache dependencies
                    }
                }
                steps {
                    sh 'mvn clean install'
                }
        }
    }
}