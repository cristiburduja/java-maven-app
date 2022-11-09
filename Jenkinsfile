def gv 
pipeline {
    agent any 
    tools {
        maven 'Maven'  // numele din Global Tool Configuration
    }
        stages {

                stage("init groovy") {
                    steps 
                            {
                                script {
                                    gv =load "script.groovy"   //name of script groovy

                                }

                            }

                }
                stage("build jar") {
                    steps {
                        script {
                            sh "mvn clean package"   //always clean THE PREVOIUS JAR FILE
                            echo "building the maven app "
                            gv.buildApp()
                        }

                    }

                }

                stage("build docker image ") {
                    steps {
                        script {

                            echo "building the docker image "
                         // docker login docker push  docker build 
                         withCredentials([usernamePassword(credentialsId:'docker-hubrepo',passwordVariable: 'PASS',usernameVariable:'USER')])        // usernamePassword -> type of the Credentials 
                                                        // poti pune orice nume la PASS si USER
                                        { // now I am logged and I can execute docker comands
                                            sh 'docker build -t hugoodevops/java-maven:1.0 .'
                                            sh "echo $PASS | docker login -u $USER --password-stdin"   // docker host after stdin if you push on AWS
                                            sh 'docker push hugoodevops/java-maven:1.0'

                                        }
                        }

                    }

                }



        }
    
}









//Complete





// pipeline { 
//     agent any  // node 
//     environment {
//             NEW_VERSION = '1.3'
//             SERVER_CREDENTIALS = credentials('server-credentials')   //ID ul de la Credentials intre '', pe care il adaugi cand dai Add Credentials

//     } 
//     parameters{

//         string(name: 'Version', defaultValue: '')
//         choice (name: 'Version', choices: ['1.1','1.2'])
//         booleanParam(name: 'executeTests',defaultValue: true)
//     }
//     tools { //for a front end :maven,gradle
//         maven 'Maven'  // dupa maven trebuie sa pui numele din Global tool configuration de la Name


//     }
//     stages {    //different stages 
//         stage ('init'){

//             steps {
//                    // groovy starts
//                 script {
//                         gv =script.groovy   //numele fileului; aici cumva importi functiile

//                 }
//             }
//         }
//         stage('build') {
//             // when {
//             //         expression {
//             //             BRANCH_NAME == 'devops' && CODE_CHANGES == true   //enviroment variable; daca se indeplineste, se executa steps
//             //         } 
//             // }
//             steps {
//                 // if you use java here goes : sh 'npm install'  sh 'npm build'
//                 // echo 'Hello build'
//                 // echo "building version ${NEW_VERSION}"
//                 script{
//                     gv.buildApp()
//                 }
               
//                 //sh "mvn install"   // sh ca sa execute shell script, bat ca sa execute batch 

//                 }
//             }
//            stage('test') {
//             when {
//                 expression {
//                         params.exeuteTests == true   // daca e true, se va executa steps
//                     }
//             }
//             steps {
//                 echo 'test'
//                  }
//             }
//             stage('deploy') {
//             steps {
//             script{
//                 gv.deployApp()
//             }
                
//                 }
//             }
//         }
//      }
