# springboot-gradle-docker-aws

https://docs.aws.amazon.com/codepipeline/latest/userguide/tutorials-ecs-ecr-codedeploy.html

$ aws ecr create-repository --repository-name springboot-gradle-docker-aws

output 

    {
        "repository": {
            "repositoryArn": "arn:aws:ecr:us-east-2:761280559302:repository/springboot-gradle-docker-aws",
            "registryId": "761280559302",
            "repositoryName": "springboot-gradle-docker-aws",
            "repositoryUri": "761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws",
            "createdAt": "2021-01-24T17:34:45-06:00",
            "imageTagMutability": "MUTABLE",
            "imageScanningConfiguration": {
                "scanOnPush": false
            },
            "encryptionConfiguration": {
                "encryptionType": "AES256"
            }
        }
    }

$ ./gradlew build

$ docker tag springboot-gradle-docker-aws:latest 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

$ aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ docker push 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ touch taskdef.json

paste:

    {
        "executionRoleArn": "arn:aws:iam::761280559302:role/ecsTaskExecutionRole",
        "containerDefinitions": [
            {
                "name": "springboot-gradle-docker-aws",
                "image": "springboot-gradle-docker-aws",
                "essential": true,
                "portMappings": [
                    {
                        "hostPort": 80,
                        "protocol": "tcp",
                        "containerPort": 80
                    }
                ]
            }
        ],
        "requiresCompatibilities": [
            "FARGATE"
        ],
        "networkMode": "awsvpc",
        "cpu": "256",
        "memory": "512",
        "family": "springboot-gradle-docker-aws"
    }

change cpu to 1024 and memory to 2048

$ aws ecs register-task-definition --cli-input-json file://taskdef.json >> taskdefoutput.json

After the task definition is registered, edit your file to remove the image name and include the <IMAGE1_NAME> placeholder text in the image field.

later, you can see if you can actually delete taskdef.json at this point. keep it, and keep it in your code repo for now.

vpc-d50782be

subnet-b16872cb

subnet-fb15b890

sg-49ec413a

target-group-1 arn: arn:aws:elasticloadbalancing:us-east-2:761280559302:targetgroup/target-group-1/b2be20e2fe56ff95

there's some create-service stuff.

$ aws ecs create-service --service-name springboot-gradle-docker-aws --cli-input-json file://create-service.json

$ aws ecs describe-services --cluster springboot-gradle-docker-aws --services springboot-gradle-docker-aws


