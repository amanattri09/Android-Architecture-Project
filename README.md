# Android-Architecture-Project

This project is a Demo of creating a stable Android structure for any Api/Database Based project. <br>
Project structure is based on Clean architecture by Robert C Martin<br>

Project uses following major dependencies in this project :<br>
-RX Java <br>
-Dagger Hilt <br>
-Live Data <br>

Benifits of using this project: <br>
-All the error during any Api call all reaches back to BaseActivity. <br>
-Session expired is easily managed as all error reaches back on same point of code  <br>
-Project uses a test api to show data on screen <br>
-Project also works offline.When device is connected, Data is converted to json and saved in shared prefrence and when app is opened offline then data is displayed from Shared prefrence
