package models;

import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;

// see http://www.playframework.com/documentation/2.3.x/JavaEbean
public class MyServerConfigStartup implements ServerConfigStartup {
	@Override
	public void onStart(ServerConfig serverConfig) {
		serverConfig.setDatabaseSequenceBatchSize(1);
	}
}