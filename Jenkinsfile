pipeline {
   agent any
    environment {
       Browser = 'REMOTE'
    }
   stages {
      stage('checkout') {
         steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Ram2103/QA_Testing_BootCamp.git']]])
         }
      }

      stage('Build') {
         steps {
             sh 'mvn clean test'
        }
      }
   }
}
