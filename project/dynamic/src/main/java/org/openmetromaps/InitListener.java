package org.openmetromaps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class InitListener implements ServletContextListener
{

	final static Logger logger = LoggerFactory.getLogger(InitListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		logger.info("context initialized");

		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("config.properties");
		Properties config = new Properties();
		try {
			config.load(input);
			input.close();
		} catch (IOException e) {
			logger.error("Unable to load configuration", e);
		}

		logger.info("done");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)
	{
		logger.info("context destroyed");

		logger.info("shutting down LogManager");
		LogManager.shutdown();
	}

}
