# Prerequisites

Based on [Play Framework](http://www.playframework.com/documentation/2.3.x/Home), which is not required to start though. All required dependecies will be installed during startup

# Requirements

Requires SQL database; see conf/application.conf lines 39+ for configuration. I recommend utf8mb4 charset. All tables are created by framework. 

# Startup

	$ cd /path/to/project
	$ ./activator
	[hello-java] $ run

Open [http://localhost:9000/](http://localhost:9000/).

# Shutdown

- end server: CTRL+D
- end activator: CTRL+C

# TODOs

- rename project (not only within Eclipse!), currently "hello-java" :-)
- use Ajax to init/refresh views
- add task filter: all, by list, done, ...
- beautify layout for small screens
- input validation in controllers.Interactions (maybe using play.data.validation.Constraints?)?
- allow tasks to be "undone"