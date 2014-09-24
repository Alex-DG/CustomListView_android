CustomListView
==============

Demonstrate how to use a custom listView which displays on each lines a picture with its set of tags (which describe the picture) and an event on item click to display a fullscreen of the picture.

- JSON data are used and downloaded (AsyncTask), then parsed to populate the list.
- A cache management system is setup for pictures





Addional information :

- I've created a custom php service to get data from my PhpMyAdmin database, I've created a table to contain my wallpapers.

- Also before that I've created a java parser (jsoup = java html parser) to gather the information of each wallpapers from a website Then I've inserted each wallpapers that I've got with the set of information for each one in my phpMyadmin database. 

- My php service fetches each wallpaper thanks a SQL query from my phpmyadmin database and display this information in json on a page. So then I just have to connect to this page fetch the json data and create an object wallpaper for each set of data that I got and use these objects in my Android applications
