package org.openmetromaps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import de.topobyte.cachebusting.CacheBusting;

@WebListener
public class InitListener implements ServletContextListener
{

	final static Logger logger = LoggerFactory.getLogger(InitListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce)
	{
		logger.info("context initialized");

		logger.info("setting up website factories");
		Website.INSTANCE.setCacheBuster(filename -> {
			return "/" + CacheBusting.resolve(filename);
		});

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

		logger.info("shutting down Logback");
		LoggerContext loggerContext = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		loggerContext.stop();
	}

}
