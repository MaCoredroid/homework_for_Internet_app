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
#### Input format:

x1 y1 r1<br>
x2 y2 r2<br>
in `txt` file <br>
for example: 0 0 4<br>
Denots a circle whose center is (0,0) with radius as 4<br>
Therefore, the `area` of this circle is `16π` <br>
The restful service is right there.
#### Author:517021910070
