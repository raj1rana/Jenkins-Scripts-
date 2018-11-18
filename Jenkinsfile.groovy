node('node') {
    currentBuild.result = "SUCCESS"
        try {

               stage('Pull-msater') {
                 // pulling master from the repo
                   git 'https://github.com/raj1rana/mongoDB-docker.git'

                   }
                stage('pull-staging'){
                       //pulling staging from the repo
                    git branch: 'staging', url: 'https://github.com/raj1rana/mongoDB-docker.git'
                   }
                stage('deploy-staging') {
                     //deploy to staging server
                   sh 'rsync -avz  -e ssh --exclude  .git/ var/lib/jenkins/workspace/pipeline-test/.*  ubuntu@13.232.107.33:/home/ubuntu/Docker-files/'
                 }
                stage('deploy-production'){
                    //deploy to production server
                   sh 'rsync -avz -e ssh --exclude .git /var/lib/jenkins/workspace/pipeline-test/.*  ubuntu@13.232.107.33:/home/ubuntu/master'
                 }
                stage('mail fail/sucess'){
    if( currentResult == "sucess" ) { 
      mail bcc: '', body: 'your build passed ', cc: '', from: '', replyTo: '', subject: 'Build passed', to: 'rajendar1rana@gmail.com'
 
} else{ 
    mail bcc: '', body: 'your build Faild ', cc: '', from: '', replyTo: '', subject: 'Build faild', to: 'rajendar1rana@gmail.com'
}  
  }
  
}