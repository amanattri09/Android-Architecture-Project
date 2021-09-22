# Android-Architecture-Project

This project is a Demo of creating a stable Android structure for any Api/Database based project. <br>
Project structure is based on Clean architecture by Robert C Martin<br>

<b>Project uses following major dependencies in this project : </b><br>

-RX Java <br>
-Dagger Hilt <br>

<b>Benifits of using this project: </b><br>

-All the errors during any api call , reaches back to BaseActivity. <br>
-Session expired is easily managed for all screen as all error reaches back on same point of code  <br>
-Project also works offline.When device is connected, Data is converted to json and saved in Shared Prefrence and when app is opened offline then data is displayed from Shared Prefrence <br>
-Project will give you an opportunity to learn about Extentions functions,Lambda's,Sealed classes and Genric classes <br>
-Project shows reusable code for displaying progress bar and error dialog for any screen and api. <br>
-There is common flow for consuming any api and handling their responses. Once all errors/cases are handled for single api the same flow will work for all apis so you have reduced 
the probability of any api based error to almost 0% :)


<img src="https://github.com/amanattri09/Android-Architecture-Project/blob/master/media/media_2.png" width="500" style="max-width:200%;">  

<img src="https://github.com/amanattri09/Android-Architecture-Project/blob/master/media/media_3.png" width="500" style="max-width:200%;">
 
