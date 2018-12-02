node{


    currentBuild.result = "SUCCESS"

    try {



        if (!env.CHNAGE_ID && env.BRANCH_NAME == 'master')

           { stage('Pull-msater') {
                 // pulling master from the repo
                   git 'https://gitURL'

                   }

             stage('deploy-production'){
                    //deploy to production server
                   sh 'rsync -avz -e ssh --exclude /var/lib/jenkins/workspace/pipeline-test/  user@xx.xx.xx.xx.:/home/ubuntu/master'

                 }

            }

        else {
             stage('pull-staging'){
                       //pulling staging from the repo
                    git branch: 'staging', url: 'https://gitURL'
                   }
             stage('deploy-staging') {
                     //deploy to staging server
                   sh 'rsync -avz  -e ssh --exclude .git  /var/lib/jenkins/workspace/pipeline-test/  user@xx.xx.xx.xx:/home/ubuntu/Docker-files/'
              }
            }


             stage('mail fail/sucess'){
                    mail body: 'project build successful',
                     from: 'xxxx@yyyyy.com',
                     replyTo: 'xxxx@yyyy.com',
                     subject: 'project build successful',
                     to: 'yyyyy@yyyy.com'
                 }
  
       }
       catch (err) {

        currentBuild.result = "FAILURE"

            mail body: "project build error is here: ${env.BUILD_URL}" ,
            from: 'xxxx@yyyy.com',
            replyTo: 'yyyy@yyyy.com',
            subject: 'project build failed',
            to: 'zzzz@yyyyy.com'

        throw err
    }

}
    
