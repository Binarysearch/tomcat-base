pipeline {
    agent {
        docker {
            image 'binarysearch/maven-with-docker-alpine:0.0.1'
        }
    }
    environment {
        DOCKER_USER = 'binarysearch'
        DOCKER_REPOSITORY = 'tomcat-base'
        DOCKER_NETWORK_NAME = 'dev_enviroment_default'

        DOCKER_CONTAINER_NAME_DEV = 'tomcat-base-dev'
        DOCKER_NETWORK_ALIAS_DEV = 'tomcat-base-dev'

        DOCKER_CONTAINER_NAME = 'tomcat-base'
        DOCKER_NETWORK_ALIAS = 'tomcat-base'
    }
    stages {
        stage('Build') {
            steps {
                sh 'printenv'
                sh 'mvn clean compile'
            }
        }
        stage('Test and verify') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Deliver dev') {
            when {
                expression {
                    return env.BRANCH_NAME == 'develop'
                }
            }
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-password', variable: 'DOCKER_PASS')]) {
                        sh 'docker login --username=${DOCKER_USER} --password=${DOCKER_PASS}'
                    }
                    sh 'docker build --build-arg api_version_arg=dev --rm -f Dockerfile -t ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev .'
                    sh 'docker push ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev'
                    sh 'docker container rm ${DOCKER_CONTAINER_NAME_DEV} -f || true'
                    sh 'docker run -d --network=${DOCKER_NETWORK_NAME} --network-alias=${DOCKER_NETWORK_ALIAS_DEV} --name=${DOCKER_CONTAINER_NAME_DEV} ${DOCKER_USER}/${DOCKER_REPOSITORY}:dev'
                }
            }
        }
        stage('Deliver') {
            when {
                expression {
                    return env.BRANCH_NAME == env.TAG_NAME
                }
            }
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker-password', variable: 'DOCKER_PASS')]) {
                        sh 'docker login --username=${DOCKER_USER} --password=${DOCKER_PASS}'
                    }
                    sh 'docker build --build-arg api_version_arg=${TAG_NAME} --rm -f Dockerfile -t ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME} .'
                    sh 'docker push ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME}'
                    sh 'docker container rm ${DOCKER_CONTAINER_NAME} -f || true'
                    sh 'docker run -d --network=${DOCKER_NETWORK_NAME} --network-alias=${DOCKER_NETWORK_ALIAS} --name=${DOCKER_CONTAINER_NAME} ${DOCKER_USER}/${DOCKER_REPOSITORY}:${TAG_NAME}'
                }
            }
        }
    }
}