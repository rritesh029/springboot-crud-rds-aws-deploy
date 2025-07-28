pipeline {                                              //Ritesh: This starts the pipeline block
    agent any                                           //Ritesh: Use any available Jenkins agent (server/EC2)

    environment {                                       //Ritesh: Define environment variables
        JAVA_HOME = "/opt/java/openjdk"                //Ritesh: Set JAVA_HOME if needed for Maven
        PATH = "${JAVA_HOME}/bin:${env.PATH}"          //Ritesh: Update PATH with JAVA path
    }

    stages {                                            //Ritesh: Define steps (called "stages") in pipeline

        stage('Checkout Code') {                        //Ritesh: Stage 1 - Pull code from GitHub (Jenkins clone itself)
            steps {
                git credentialsId: 'github-token',      //Ritesh: Use GitHub token credential ID stored in Jenkins
                    url: 'https://github.com/rritesh029/springboot-crud-rds-aws-deploy',
                    branch: 'main'
            }
        }

        stage('Build with Maven') {                     //Ritesh: Stage 2 - Run Maven build
            steps {
                sh 'mvn clean install'                  //Ritesh: Execute Maven build
            }
        }

        stage('Deploy App') {                           //Ritesh: Stage 3 - You can customize this for actual deployment
            steps {
                echo 'Deploy stage will go here'        //Ritesh: Placeholder for deployment logic
                // Example: sh 'scp target/app.jar ec2-user@your-ec2:/path/'
            }
        }
    }

    post {                                              //Ritesh: Post-build steps
        success {
            echo '✅ Build and deployment successful!'   //Ritesh: Message for successful pipeline
        }
        failure {
            echo '❌ Build or deployment failed!'        //Ritesh: Message if pipeline fails
        }
    }
}
