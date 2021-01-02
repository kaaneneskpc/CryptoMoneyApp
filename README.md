# CryptoMoneyApp

Application showing the world of crypto money in real time
In this application, api structure , retroif library and rxjava and composite logic were used.

## What's an API?

API is the acronym for Application Programming Interface, which is a software intermediary that allows two applications to talk to each other. 
Each time you use an app like Facebook, send an instant message, or check the weather on your phone, you’re using an API.

What Is an Example of an API?
When you use an application on your mobile phone, the application connects to the Internet and sends data to a server. 
The server then retrieves that data, interprets it, performs the necessary actions and sends it back to your phone. 
The application then interprets that data and presents you with the information you wanted in a readable way. This is what an API is - all of this happens via API.

This application used nomics api.More information : https://nomics.com

## What's the Retrofit?

Retrofit is Square Inc. for Java and Android. It is an HTTP client released under the Apache 2.0 license by the company.

You can provide the communication between your application and your REST API Web service via Retrofit.

--Definitions
Define the Retrofit to your project in the build.gradle file located under the app directory.
![image](https://user-images.githubusercontent.com/32849662/103460722-b0320c80-4d29-11eb-9d4b-c4b153263a8e.png)
<br>
Define the INTERNET access permission to your manifest file.
![image](https://user-images.githubusercontent.com/32849662/103460728-bc1dce80-4d29-11eb-9102-a7dfd93678d0.png)

More Information : https://square.github.io/retrofit/

Extra setup for json :
<br>
![image](https://user-images.githubusercontent.com/32849662/103460755-f5eed500-4d29-11eb-8aea-67e44f41cb0e.png)

## RxJava-Composite

CompositeDisposable is a convenient class for bundling up multiple Disposables, so that you can dispose them all with one method call on CompositeDisposable.

You can add disposables to a CompositeDisposable with CompositeDisposable#add
Instead of calling dispose() on each Disposable individually, you call CompositeDisposable#clear() to dispose all Disposables that have been added. 
If you want to dispose all current Disposables and automatically dispose any Disposables that are added in the future, call CompositeDisposable#dispose(). 
It kind of makes sense, you are literally disposing the CompositeDisposable when you call dispose() on it, so it makes sense that any Disposables you add are disposed.

More Information : https://github.com/ReactiveX/RxJava

#Overviews

![Ekran Alıntısı](https://user-images.githubusercontent.com/32849662/103460822-7ad9ee80-4d2a-11eb-8421-ecae76aae0ba.PNG)


 
