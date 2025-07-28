pipeline {                                                  //Ritesh
    agent any                                               //Ritesh

    stages {
        stage('Clone Code') {                               //Ritesh
            steps {
                git branch: 'main',                         //Ritesh
                    url: 'https://github.com/your-username/your-repo.git' //Ritesh
            }
        }

        stage('Build with Maven') {                         //Ritesh
            steps {
                sh 'mvn clean install'                      //Ritesh
            }
        }
    }
}
