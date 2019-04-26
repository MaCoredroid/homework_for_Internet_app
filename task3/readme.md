#### Docker first attempt
First install docker following the document https://docs.docker.com/ <br>
 Try `sudo docker run hello-world` to check whether your have successfully installed docker. <br>
In command line, just type in <br>
Run this command in your favourite shell <br>
`sudo usermod -a -G docker $USER`<br>
And then completely log out of your account and log back in (if in doubt, reboot!):<br>
`docker run -p 8080:8080 macoredroid/task3:firstattempt` <br>
Then use broswer to go to http://localhost:8080/ <br>
The restful service is right there.
#### Author:517021910070
