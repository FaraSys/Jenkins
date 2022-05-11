#!groovy
// Run docker build
properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label "master"
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }