How to use January from a Gradle Build
======================================

Build
-----
This guide assumes that you are familiar with gradle and have a build.gradle file or other named gradle where you would like to add a January dependency into your build.

Steps
-----
1. Make sure  
~~~~ 
mavenCentral()
~~~~  
is in your repositories{} block


2. Add dependency 
~~~~ 
compile "org.eclipse.january:org.eclipse.january:2.1.0" 
~~~~ 
to your file.

When you rebuild now january will be available to your gradle project.


