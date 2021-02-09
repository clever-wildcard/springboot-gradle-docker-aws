Warning: notes were written for unix/linux.

### Instructions for contributing the second+ time:

$ ./gradlew build

$ docker build --build-arg DEPENDENCY=build/dependency -t springboot-gradle-docker-aws .

$ docker run -p 8080:8080 springboot-gradle-docker-aws:latest

$ docker tag springboot-gradle-docker-aws:latest 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

$ aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ docker push 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ ssh -i ~/codebase/MyKeyPair.pem ec2-user@ec2-3-22-239-41.us-east-2.compute.amazonaws.com

$ aws ecr get-login-password --region us-east-2 | sudo docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ sudo docker pull 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

$ sudo docker stop springboot-gradle-docker-aws && sudo docker rm springboot-gradle-docker-aws



$ sudo docker run -d --name springboot-gradle-docker-aws -p 80:80 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest >> output.txt

### Instructions for the first time you contribute:

$ git clone https://github.com/clever-wildcard/springboot-gradle-docker-aws.git

$ git checkout -b relevantly-named-branch

Make exciting, beautiful changes. 

$ ./gradlew build

$ docker build --build-arg DEPENDENCY=build/dependency -t springboot-gradle-docker-aws .

$ docker run -p 8080:8080 springboot-gradle-docker-aws:latest

If your changes should be visible in a browser, then open one up and go to localhost:8080/whatever-endpoint-was-impacted.

CHECKING REST BASED CHANGES

Right, so let's say you've made the changes you want to make. 

$ docker tag springboot-gradle-docker-aws:latest 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest

Install aws cli v2: https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html

Let's say you're not the root user of this aws employee. Then the next thing you'd want to do is ask the root user on the employee (me, in this case) to be added to the IAM Users groups 'administrators'. Then the root user would get back to you with the console sign in link and/or an aws_access_key_id/aws_secret_access_key.

$ cd ~/.aws && ls

`$ touch config && open config` if config doesn't exist. Otherwise, `$ open config`

    [default]
    region = us-east-2
    output = json

(Again, these instructions are specific to this project. If you're using your own project, be careful about the region, both here, in any terminal commands, files to be used in terminal commands, and in the aws web console.)

Save and close.

`$ touch credentials && open credentials` if credentials doesn't exist. Otherwise, `$ open credentials`

    [default]
    aws_access_key_id = whatever access key id you were given or downloaded or whatever
    aws_secret_access_key = whatever secret access key you were given or downloaded or whatever

Save and close.

$ aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

$ docker push 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

Get the key pair from the root user. 

(Again, these instructions are specific to this project. There are instructions in the section below for generating your own key pair if you're making your own project.)

$ ssh -i ~/codebase/MyKeyPair.pem ec2-user@ec2-3-22-239-41.us-east-2.compute.amazonaws.com

Now you should be in the EC2 instance (which is basically just a virtual machine that, in this case, runs on an amazon flavor of linux).

EC2 instance `$ aws ecr get-login-password --region us-east-2 | sudo docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws`

NOTE! THAT COMMAND IS NOT IDENTICAL TO THE ONE YOU RAN ON YOUR LOCAL MACHINE! 

EC2 instance  `$ sudo docker pull 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest -d --name springboot-gradle-docker-aws`

EC2 instance `$ sudo docker stop springboot-gradle-docker-aws`

EC2 instance  `sudo docker run -d -p 80:80 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest --name springboot-gradle-docker-aws`

Check things work again. This time instead of going to localhost:80 to change, you'll start at annaofalltrades.com.

$ git add . && git commit -m "relevant comment" && git push

Done :). 


### To Recreate:

Make a new github project. 

    Though you don't have to, I recommend initializing it with a .gitignore file, a License file and a README.md file. If you like open source things I recommend Mozilla's license. If you like going with things that are commonly used, you might try the MIT or GnU ones.THe MIT and GnU ones. (Let me know if you're wondering what github is / why we need it / why initialize the project with those files and I'll update this README.md accordingly :)). 
    
    Your project page has a green button `Code`. Click that, then click the clipboard icon to copy the HTTPS link. 
    
    Right, so to keep things easy to read, I'm going to continue to use the info for this project in the rest of this readme, but be sure to use your own project name / git clone links / etc.
    
    On your local machine open up a command line interface (CLI). (Local machine is just jargon - in this case for your regular old laptop / computer.  To get to the CLI appropriate for your operating system: on a mac, search for terminal; on a windows, search for command prompt / powershell.) Oh, also, from here on out, if you see anything that starts with '$', that means type out the rest of that line on the terminal. For example, if you see `$ cd ~` in your terminal you'll just type `cd ~`. (I know, I called it a CLI earlier, but it'll be easier to write and read if we just pick one and refer to it hereafter.)

Make a new springboot project.

    Download a new springboot project instructions here.

Get and start docker

    Instructions here.

Get and set up git on your local machine.

    Instructions here.

Make an AWS employee.
    
    Instructions here.

Make an aws admin employee.

    instructions here.

Install aws cli v2.

    https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html
    
    Let's say you're not the root user of this aws employee. Then the next thing you'd want to do is ask the root user on the employee (me, in this case) to be added to the IAM Users groups 'administrators'. Then the root user would get back to you with the console sign in link and/or an aws_access_key_id/aws_secret_access_key.
    
    $ cd ~/.aws && ls
    
    `$ touch config && open config` if config doesn't exist. Otherwise, `$ open config`
    
        [default]
        region = us-east-2
        output = json
    
    (Again, these instructions are specific to this project. If you're using your own project, be careful about the region, both here, in any terminal commands, files to be used in terminal commands, and in the aws web console.)
    
    Save and close.
    
    `$ touch credentials && open credentials` if credentials doesn't exist. Otherwise, `$ open credentials`
    
        [default]
        aws_access_key_id = whatever access key id you were given or downloaded or whatever
        aws_secret_access_key = whatever secret access key you were given or downloaded or whatever
    
    Save and close.

Make an ecr.

    $ rm output.json 

    $ aws ecr create-repository --repository-name springboot-gradle-docker-aws --region us-east-2 >> output.json

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

Make a key pair.

    $ aws ec2 create-key-pair --key-name MyKeyPair --query 'KeyMaterial' --output text > ~/codebase/MyKeyPair.pem

Make a security group.

    Instructions here.

Get a Route 53 domain name.

    Instructions here.

Make an elastic ip address.

    Instructions here.

Make an EC2 instance.

    (An EC2 instance is basically just a virtual machine that, in this case, runs on an amazon flavor of linux)

    Instructions here.

Change source code.

    $ git checkout -b relevantly-named-branch

    (in this case, we'll make the changes needed so your web site/app shows up with a regular web site name)

        changes relating to port 80

    $ ./gradlew build

    $ docker build --build-arg DEPENDENCY=build/dependency -t springboot-gradle-docker-aws .
    
    $ docker run -p 8080:8080 springboot-gradle-docker-aws:latest

    If your changes should be visible in a browser, then open one up and go to localhost:8080/whatever-endpoint-was-impacted.
    
        CHECKING REST BASED CHANGES
    
    Right, so let's say you've made the changes you want to make.

Tag and push image to aws ecr.

    $ docker tag springboot-gradle-docker-aws:latest 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest
    
    $ aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws
    
    $ docker push 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws

SSH into EC2 instance. 

    $ ssh -i ~/codebase/MyKeyPair.pem ec2-user@ec2-3-22-239-41.us-east-2.compute.amazonaws.com

In EC2 instance:
    
    Since aws ecr is private, before we can authorize ourselves to our repo we need to add the credentials from our local machine to our new machine. this might not be best practice, proceed at your own risk. ()
    
    Find the .aws folder and replicate the config and credentials file on your ec2 instance. (my .aws folder is in my home folder.)
    
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
    
    Alternatively, you probably could've `aws configure`'d, and put your config/credentials in that way. maybe, i didn't try it.
    
    $ sudo amazon-linux-extras install docker
    
    $ sudo service docker start
    
    $ aws ecr get-login-password --region us-east-2 | sudo docker login --username AWS --password-stdin 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws
    
    NOTE! THAT COMMAND IS NOT IDENTICAL TO THE ONE YOU RAN ON YOUR LOCAL MACHINE!
    
    $ sudo docker pull 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest -d --name springboot-gradle-docker-aws

    $ sudo docker run -d --name springboot-gradle-docker-aws -p 80:80 761280559302.dkr.ecr.us-east-2.amazonaws.com/springboot-gradle-docker-aws:latest >> output.txt

Check things work again. This time instead of going to localhost:80 to change, you'll start at annaofalltrades.com.

$ git add . && git commit -m "relevant comment" && git push

Done :).


---

stuff we might use later
#RUN addgroup --system spring && adduser --system spring -G spring
RUN groupadd -r ec2-user -g
RUN adduser spring
USER spring:spring