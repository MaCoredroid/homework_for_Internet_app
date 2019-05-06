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
Then use broswer to go to http://localhost:8080/ to visit Eureka control panel <br>
Username:admin Password:pwd
Then use broswer to go to http://localhost:8081/ to visit calculate overlapped circles <br>
#### Result:
[![Capture.png](https://i.postimg.cc/Y9BLpRNk/Capture.png)](https://postimg.cc/HJ3kzQPP)
[![Capture1.png](https://i.postimg.cc/7YtCCw1K/Capture1.png)](https://postimg.cc/qznBSf5K)
#### Caution
Always run gateway before other services!<br>
I tested it in another virtual debian, and the command works.<br>
However, if the client failed to register to the Eureka.<br>
You can change https://github.com/MaCoredroid/homework_for_Internet_app/blob/master/homework3/calculate/demo/src/main/resources/application.properties<br>
eureka.client.service-url.defaultZone=http://admin:pwd@localhost:8080/eureka<br>
In my example, the **localhost** was changed to **172.17.0.2**<br>
Just as the ip address in Eureka control panel <br>
[![Capture2.png](https://i.postimg.cc/8CMBBjtp/Capture2.png)](https://postimg.cc/WDpkspBC)

#### Author:517021910070
