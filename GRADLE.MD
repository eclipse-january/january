How to use January from a Gradle Build
======================================

Build
-----
This guide assumes that you are familiar with gradle and have a build.gradle file or other named gradle where you would like to add a January dependency into your build.

Goomph
------
The easiest way to allow p2 repositories to resolve in your gradle build is to use goomph: https://github.com/diffplug/goomph

Steps
-----
1. Add  
~~~~ 
"com.diffplug.gradle.oomph.ide" version "3.8.1"
~~~~  
to the 'plugins { }' block of your gradle file.
2. Add  
~~~~ 
apply plugin: 'com.diffplug.gradle.oomph.ide' 
~~~~ 
to use the plugin
3. Add 

~~~~ 
oomphIde {
    repo 'http://download.eclipse.org/january/releases/2.0.2/repository'
    iu   'org.eclipse.january'
}
~~~~

4. Add dependency 
~~~~ 
compile "org.eclipse.january:org.eclipse.january:2.0.2" 
~~~~ 
to your file.

When you rebuild now january will be available to your gradle project.
