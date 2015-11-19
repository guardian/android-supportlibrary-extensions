CenteredViewPager
=======

# What is this?
A slightly modified ViewPager that centers its children.

# How to use this?
Just drop this view into your layout and it should work without any special considerations. Make sure you override the 
```
getPageWidth(...)
```
method in your Adapter for the best effect.
# How to build this?
Open the root directory in Android Studio. On the right hand side of the window hit the "Gradle" tab, and under the 
```
:library
```
job click 'build'. An .aar will be built into the build directory.

# License
CenteredViewPager is released under the Apache 2.0 license.
