pipeline {
 agent 'any'
 options {
   skipStagesAfterUnstable()
 }
 stages {
// Build dev
    stage('BuildDev') {
       when {
        branch 'dev'
      }
     steps {
	   
			sh """
            echo "build has been done"
             """
     }
   }
  //  Build staging
   stage('BuildStaging'){
      when {
        branch 'staging'
      }
    //  code 
    steps {
	   
			sh """
            echo "build has been done"
             """
     }
   }
   // Build Master 
   stage('BuildMaster') {
      when {
        branch 'master'
      }
     steps {
       //code
       sh """
           echo "build has been done"
         """
     }
   }
  //  test dev
    stage('TestDev') {
       when {
        branch 'dev'
      }
     steps {
	   
			sh """
            echo "test has been done"
             """
     }
   }
  // test staging
    stage('TestStaging') {
       when {
        branch 'staging'
      }
     steps {
	   
			sh """
            echo "test has been done"
             """
     }
   }
  // test master
    stage('TestMaster') {
       when {
        branch 'master'
      }
     steps {
	   
			sh """
            echo "test has been done"
             """
     }
   }
  //  deploy dev
   stage('DeployDev') {
       when {
        branch 'dev'
      }
     steps {
	   
			sh """
            echo "Deploy has been done"
             """
     }
   }
  //  deploy staging
  stage('DeployStaging') {
       when {
        branch 'staging'
      }
     steps {
	   
			sh """
            echo "Deploy has been done"
             """
     }
   }
  //  deploy master
  stage('DeployMaster') {
       when {
        branch 'master'
      }
     steps {
	   
			sh """
            echo "Deploy has been done"
             """
     }
   }

 }
 }
