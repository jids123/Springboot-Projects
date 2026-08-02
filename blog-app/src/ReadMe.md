Through the years, I've been building up my programming experience, making projects here and there, getting more into Python and Different Game Engines.
This project brings me back to recreating one of the past things I've learned in college, which is Springboot web applications.
I followed a djramware tutorial on how to create a Blog Web Application with CRUD functionality.

The Blog Web Application doesn't put a new spin on Blog Application, and simply lets us make something that can make, edit, delete, and show posts. The web application does not have any databases as of yet, as it stores data inside arrays.

As of July 25, 2026, I have finished the backend functionality of this project, allowing to make, edit, delete, and show posts, then resets back to 0 once you shut down the server. I am currently looking into adding a little design tweak so it feels more like a full website.

August 2, 2026. I have uploaded the whole project here on Github. This is the latest Springboot project, and all other one have faults (except the one I collabed with my classmates).

Known Bugs and Issues:
You'll encounter this problem when following the djamware tutorial. Once the website is live, trying to edit the post you just created shows an error where the Data's cannot be fetched because an Optional cannot get an "id" type on Post. The problem lies in the File's Controller in the method where the edit_post.html connects.
The simple problem was that it was not an Optional. So I changed it to an Optional, checked if the optional isEmpty, then the function worked.