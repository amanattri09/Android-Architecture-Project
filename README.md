# Android-Architecture-Project

This project is a Demo of creating a stable Android structure for any Api/Database based project. <br>
Project structure is based on Clean architecture by Robert C Martin<br>

<b>Project uses following major dependencies in this project : </b><br>

-RX Java <br>
-Dagger Hilt <br>
-Live Data <br>

<b>Benifits of using this project: </b><br>

-All the error during any Api call all reaches back to BaseActivity. <br>
-Session expired is easily managed as all error reaches back on same point of code  <br>
-Project uses a test api to show data on screen <br>
-Project also works offline.When device is connected, Data is converted to json and saved in shared prefrence and when app is opened offline then data is displayed from Shared prefrence


<img src="https://github.com/amanattri09/Android-Architecture-Project/blob/master/media/media_1.jpeg" width="500" style="max-width:300%;">
 
