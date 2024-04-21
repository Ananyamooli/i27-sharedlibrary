import com.i27academy.builds.Calculator
def call(Map pipelineParams) {
    Calculator calculator = new Calculator (this)
    pipeline {
        agent any
        environment {
            APP_NAME ="${pipelineParams.appName}"
        }
        stages {
            stage ('Addditonal stage') {
                steps {
                    script {
                        echo "printing sum of 2 numbers"
                        println calculator.add(10,20)
                        echo "my microservice name is:${APP_NAME}"
                    }
                }
            }
        }
    }
}
