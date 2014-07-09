# Requirements

Requires [Play Framework](http://www.playframework.com/documentation/2.3.x/Home) with all its requirements ("activator" within classpath, etc)

Requires SQL database; see conf/application.conf lines 39+ for configuration. The tables are created by framework. 

# Startup

	$ cd /path/to/hello-java
	$ activator
	[hello-java] $ run

Open [http://localhost:9000/](http://localhost:9000/).

# TODOs

- rename project (not only within Eclipse!)
- use Ajax to init/refresh views
- add task filter: all, by list, done, ...
- beautify layout for small screens
- input validation in controllers.Interactions (maybe using play.data.validation.Constraints?)?
- allow tasks to be "undone"