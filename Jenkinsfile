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
                script {
                    def jarName = sh(script: "ls target/*.jar | grep -v 'original' | head -n 1", returnStdout: true).trim()    //Ritesh: Get JAR name excluding original JAR
                    sh "cp ${jarName} /app-deploy/app.jar"                       //Ritesh: Copy JAR to shared folder (mapped to host)
                    sh "pkill -f 'java -jar' || true"                           //Ritesh: Stop old app if running (safe kill)
                    sh "nohup java -jar /app-deploy/app.jar > /app-deploy/log.txt 2>&1 &"  //Ritesh: Start app in background
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
