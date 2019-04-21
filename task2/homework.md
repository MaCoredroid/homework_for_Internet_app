### Resources consumption of REST service
*If the pictures can't be displayed properly, use shadowsocks to fix it*<br>
At first I tried prometheus , which is an end point of Spring Boot actuator, but <br>
it just gave me a bunch of information, but I'd rather prefer charts.<br>
[![2.png](https://i.postimg.cc/zfr4ZXNH/2.png)](https://postimg.cc/Wd550Vhs)
So I tried Prometheus docker image， but get many nasty bugs.<br>
Fotunately, I found YourKit Java profiler. <br>
[![1.png](https://i.postimg.cc/SKbbSf6s/1.png)](https://postimg.cc/QFmyS5nG)
I send the request with jmeter. <br>
[![3.png](https://i.postimg.cc/Fz7BgYy8/3.png)](https://postimg.cc/sGCm3D04)
#### Send 50 get requests at the same time:
It is quite clear that the memory usage has a sudden increase , but cpu usage remains the same
[![4.png](https://i.postimg.cc/htgNNtcz/4.png)](https://postimg.cc/HVZSyHJd)
#### Send 250 get requests at the same time:
It can be seem that both cpu and memory usage has a sudden increase.
[![5.png](https://i.postimg.cc/XNtrfT3D/5.png)](https://postimg.cc/QVkNsYFp)
[![6.png](https://i.postimg.cc/TYmpCC32/6.png)](https://postimg.cc/0bkkNGSh)
#### Send 750 get requests at the same time
This is a disaster, the cpu usage has come to a very sharp point.
[![7.png](https://i.postimg.cc/nVmFJMb0/7.png)](https://postimg.cc/HjpD0YLy)
[![8.png](https://i.postimg.cc/sDRVDy3y/8.png)](https://postimg.cc/SjD0DBXt)
*In this kind of demanding requests, it seems that cpu usage is the major problem.*<br>
*It is quite interseting that the memory usage doesn't come down at once just like the cpu usage*<br>
*Maybe that's because it is a process to collect memory back and taht takes time. *<br>




#### Author:517021910070
