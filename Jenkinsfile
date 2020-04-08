node {
   def mvnHome
   stage('Preparation') {

     git 'https://github.com/ssvarma138/jenkinsintegration.git'
      mvnHome = tool 'maven_3_6_3'
   }
   stage('compile') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {

            sh '"$MVN_HOME/bin/mvn" clean compile'

      }
   }
   stage ('Test'){
       withEnv(["MVN_HOME=$mvnHome"]) {

            sh '"$MVN_HOME/bin/mvn" test'

      }
   }



}
