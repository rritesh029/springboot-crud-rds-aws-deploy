pipeline {                                              //Ritesh: This starts the pipeline block
    agent any                                           //Ritesh: Use any available Jenkins agent

    environment {                                       //Ritesh: Define environment variables
        JAVA_HOME = "/opt/java/openjdk"                //Ritesh: Set JAVA_HOME if needed
        PATH = "${JAVA_HOME}/bin:${env.PATH}"          //Ritesh: Update PATH
    }

    stages {
        stage('Build with Maven') {                     //Ritesh: Compile & package
            steps {
                echo '📦 Building application...'       //ChatGPT
                sh 'mvn clean install -DskipTests'      //Ritesh: Maven build (tests skipped)
            }
        }

        stage('Test') {                                 //Ritesh: Run unit tests
            steps {
                echo '🧪 Running tests...'              //ChatGPT
                sh 'mvn test'                           //Ritesh: Run tests
            }
        }

        stage('Deploy App') {                           //Ritesh: Deployment logic placeholder
            steps {
                echo '🚀 Deploying application...'      //ChatGPT
                script {
                    //ChatGPT: Extract JAR path, skipping "original" jars from shading
                    def jarName = sh(script: "ls target/*.jar | grep -v 'original' | head -n 1", returnStdout: true).trim()    //Ritesh

                    //ChatGPT: Ensure deploy dir exists
                    sh "mkdir -p /app-deploy"            //ChatGPT

                    //ChatGPT: Copy JAR to host-shared deploy folder
                    sh "cp ${jarName} /app-deploy/app.jar"     //Ritesh

                    //ChatGPT: Kill running app if exists (ignore errors)
                    sh "pkill -f '/app-deploy/app.jar' || true"     //Ritesh

                    //ChatGPT: Restart the app on port 8081
                    sh "nohup java -jar /app-deploy/app.jar --server.port=8081 > /app-deploy/log.txt 2>&1 &"   //Ritesh
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment successful!'   //Ritesh
            echo '🌍 Visit http://<EC2-IP>:8081 to access the app'  //ChatGPT
        }
        failure {
            echo '❌ Build or deployment failed!'        //Ritesh
        }
    }
}
