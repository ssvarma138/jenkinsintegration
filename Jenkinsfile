node {
   def mvnHome
   stage('Preparation') {


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