#### Homework3
First install docker following the document https://docs.docker.com/ <br>
 Try `sudo docker run hello-world` to check whether your have successfully installed docker. <br>
Run this command in your favourite shell <br>
`sudo usermod -a -G docker $USER`<br>
And then completely log out of your account and log back in (if in doubt, reboot!):<br>
Just type in `docker run -p 8080:8080 macoredroid/gateway:one` <br>
Alternatively,`docker pull macoredroid/gateway:one`<br>
Or visit `https://hub.docker.com/r/macoredroid/gateway`<br>
Just type in `docker run -p 8081:8081 macoredroid/calculate:one` <br>
Alternatively,`docker pull macoredroid/calculate:one`<br>
Or visit `https://hub.docker.com/r/macoredroid/calculate`<br>
Then use broswer to go to http://localhost:8080/ <br>
The restful service is right there.
#### Author:517021910070
