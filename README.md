## local machine


### image

$ aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ aws ecr create-repository --repository-name springboot-gradle-docker-aws --region us-east-2

output

    {
        "repository": {
            "repositoryArn": "arn:aws:ecr:us-east-2:761280559302:repository/springboot-gradle-docker-aws",
            "registryId": "761280559302",
            "repositoryName": "springboot-gradle-docker-aws",
            "repositoryUri": "761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws",
            "createdAt": "2021-01-25T15:20:29-06:00",
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

$ docker build --build-arg DEPENDENCY=build/dependency -t springboot-gradle-docker-aws .

$ docker run -p 8080:8080 springboot-gradle-docker-aws:latest

open browser window, check localhost:8080. or a get request.

back to terminal and control cg6

$ docker tag springboot-gradle-docker-aws:latest 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

$ docker push 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ aws ec2 create-key-pair --key-name MyKeyPair --query 'KeyMaterial' --output text > ~/codebase/MyKeyPair.pem

$ ssh -i /Users/gandalf/codebase/MyKeyPair.pem ec2-user@ec2-3-22-125-17.us-east-2.compute.amazonaws.com

scp -i /Users/gandalf/codebase/MyKeyPair.pem -r /Users/gandalf/codebase/springboot-gradle-docker-aws ec2-user@ec2-3-22-125-17.us-east-2.compute.amazonaws.com:/home/ec2-user/codebase

#### ec2 instance (aka, aws virtual machine)

$ mkdir codebase

$ sudo yum update -y

$ sudo amazon-linux-extras install docker

$ sudo service docker start

$ sudo  usermod -a -G docker ec2-user

restart session

since aws ecr is private, before we can authorize ourselves to our repo we need to add the credentials from our local machine to our new machine. this might not be best practice, proceed at your own risk. ()

find the .aws folder and replicate the config and credentials file on your ec2 instance. (my .aws folder is in my home folder.)

    $ mkdir .aws
    $ touch config
    $ touch credentials
    $ vim config
        i
        *whatever it says in the default section of your local .aws/config file (which hopefully is not your root profile)
        esc + wq
    $ vim credentials
        i
        *whatever it says in the default section of your local .aws/config file (which hopefully is not your root profile)
        esc + wq

alternatively, you probably could've `aws configure`'d, and put your config/credentials in that way. maybe, i didn't try it.

$ cd ~/config

$ docker pull 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

$ docker run 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

docker stop $(docker ps -aq)
docker run springboot-gradle-docker-aws:latest

docker run -p 80:8080/tcp springboot-gradle-docker-aws:latest
docker run --expose 80 springboot-gradle-docker-aws:latest

https://docs.docker.com/engine/reference/commandline/run/

    Connect a container to a network (--network)

    When you start a container use the --network flag to connect it to a network. This adds the busybox container to the my-net network.

    $ docker run -itd --network=my-net busybox

    You can also choose the IP addresses for the container with --ip and --ip6 flags when you start the container on a user-defined network.

    $ docker run -itd --network=my-net --ip=10.10.9.75 busybox

    If you want to add a running container to a network use the docker network connect subcommand.
    
    