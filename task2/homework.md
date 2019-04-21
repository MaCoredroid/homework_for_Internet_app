### Resources consumption of REST service
At first I tried prometheus , which is an end point of Spring Boot actuator, but <br>
it just gave me a bunch of information, but I'd rather prefer charts.<br>
[![2.png](https://i.postimg.cc/zfr4ZXNH/2.png)](https://postimg.cc/Wd550Vhs)
So I tried Prometheus docker image， but get many nasty bugs.<br>
Fotunately, I found YourKit Java profiler. <br>
[![1.png](https://i.postimg.cc/SKbbSf6s/1.png)](https://postimg.cc/QFmyS5nG)
I send the request with jmeter. <br>
[![3.png](https://i.postimg.cc/Fz7BgYy8/3.png)](https://postimg.cc/sGCm3D04)
#### Send 50 get requests at the same time:
It is quite clear that the memory usage has a sudden increase 
[![4.png](https://i.postimg.cc/htgNNtcz/4.png)](https://postimg.cc/HVZSyHJd)






#### Author:517021910070
