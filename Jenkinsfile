pipeline {                                              //Ritesh: This starts the pipeline block
    agent any                                           //Ritesh: Use any available Jenkins agent

    environment {                                       //Ritesh: Define environment variables
        JAVA_HOME = "/opt/java/openjdk"                //Ritesh: Set JAVA_HOME if needed
        PATH = "${JAVA_HOME}/bin:${env.PATH}"          //Ritesh: Update PATH
    }

    stages {
        stage('Build with Maven') {                     //Ritesh: Compile & package
            steps {
                sh 'mvn clean install'                  //Ritesh: Maven build
            }
        }

        stage('Test') {                                 //Ritesh: Run unit tests
            steps {
                sh 'mvn test'                           //Ritesh: Run tests
            }
        }

        stage('Deploy App') {                           //Ritesh: Deployment logic placeholder
            steps {
                echo 'Deploy stage will go here'        //Ritesh
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment successful!'   //Ritesh
        }
        failure {
            echo '❌ Build or deployment failed!'        //Ritesh
        }
    }
}
