# Admin-panel-website-template
This is a admin panel of a marketing company developed by me, during my internship for a customer of the company in which I worked as an Intern for six months. This web portal is developed using bootstrap and libraries from a UI toolkit called Shards https://designrevision.com/demo/shards/
This uses REST APIs to connect to server which in MySql which is created in MySql wrokbench.
This web portal has login, user sessions, add/delete/update employee, customers, products etc., This also allows to track an Employee, however all the datas are posted into the server is done from the mobile application developed along with this web portal(by my colleague). This web portal only enables the admins of the company to track off the daily activities of the employees working under them by updating the activites through the mobile app.
# How to run?
This uses REST APIs so you need Eclipse and Tomcat Server and db file(included in the repo) in MySql Workbench
You can see the REST APIs services in src/main/java
And the HTML,CSS,Js and all other website related files in src/main/webapp

# Eclipse 
1. Open the project in eclipse
2. Open application.properties from target/classes/application.properties
3. Change the db name password db url according to your configuration
4. Goto file->Export->War file in eclipse
5. Select destination and select Ok

Import the db file in MySql workbench and change the server name according your server connection.

# Server
1. Download and install tomcat server.
2. Place the War file in the TomcatRootDirectory/webapps/
3. Start the tomcat server.
4. The war file which we placed will be automatically deployed
5. Then type the address of the tomcat server mostly http://localhsot:<port number>/webapps/<WAR file name>/
6. It will automatically load the index.html.

Form there you can continue using the website.



