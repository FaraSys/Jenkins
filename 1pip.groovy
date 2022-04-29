#!groovy
// Check ub and deb properties
properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }
    options {
        buildDiscarder(logrotator(numToKeepstr: '10', artifactNumToKeepstr: '10'))
        timestamps()
    }
    stages {
        stage ("First") {
            step {
                sh 'ssh root@10.1.1.101 \'hostmane\''
            }
            step {
                sh 'ssh root@10.1.1.102 \'hostmane\''
            }
        }
        stage ("Second") {
            step {
                sh 'ssh root@10.1.1.101 \'echo \'10.1.1.102 deb1\'\' >> /etc/hosts'
            }
            step {
                sh 'ssh root@10.1.1.102 \'echo \'10.1.1.101 ub1\'\' >> /etc/hosts'
            }
        }
    }
}