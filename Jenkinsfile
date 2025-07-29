pipeline {                                              //Ritesh: This starts the pipeline block
    agent any                                           //Ritesh: Use any available Jenkins agent

    environment {                                       //Ritesh: Define environment variables
        JAVA_HOME = "/opt/java/openjdk"                //Ritesh: Set JAVA_HOME if needed
        PATH = "${JAVA_HOME}/bin:${env.PATH}"          //Ritesh: Update PATH to include Java binaries
    }

    stages {
        stage('Build with Maven') {                     //Ritesh: Compile & package the app
            steps {
                sh 'mvn clean install'                  //Ritesh: Maven build
            }
        }

        stage('Test') {                                 //Ritesh: Run unit tests
            steps {
                sh 'mvn test'                           //Ritesh: Run tests
            }
        }

        stage('Deploy App') {                           //Ritesh: Deployment logic to run JAR
            steps {
                script {
                    def jarName = sh(
                        script: "ls target/*.jar | grep -v 'original' | head -n 1",
                        returnStdout: true
                    ).trim()                                                                 //Ritesh: Get built JAR name

                    sh "cp ${jarName} /app-deploy/app.jar"                                   //Ritesh: Copy JAR to host-mounted directory

                    sh '''
                        echo "🔄 Restarting Spring Boot App..."
                        pkill -f 'java -jar /app-deploy/app.jar' || true                    #Ritesh: Stop old app (safe)
                        nohup java -jar /app-deploy/app.jar > /app-deploy/log.txt 2>&1 &   #Ritesh: Run new JAR
                    '''
                }
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
