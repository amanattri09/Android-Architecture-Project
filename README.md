# Android-Architecture-Project

This project is Demo of creating a stable Android structure for any Repositary/Api/Database Based project. <br>
Project structure is based on clearn architectur by Robert C Martin<br>

Projects uses following major dependencies in this project :<br>
-RX Java <br>
-Dagger Hilt <br>
-Live Data <br>
-Sealed class 

Benifits of using this project: <br>
-All the error during any Api call all reaches back to BaseActivity. <br>
-Session expired can be easily managed as all error reaches back on same point of code  <br>
-Project uses a test api to show data on screen <br>
-Project also works offline.When device is connected, Data is converted to json and saved in shared prefrence and when app is opened offline then data is displayed from Shared prefrence
