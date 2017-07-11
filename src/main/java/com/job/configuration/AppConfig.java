package com.job.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.job.formatter.PaysFormatter;
import com.service.config.MailSenderConfiguration;
/*
 * @author EL HAHY Zakaria
 */
@Configuration
@PropertySource(value = { "classpath:job-userauth-local.properties","classpath:configMail.properties" }, ignoreResourceNotFound = true)
@Import(value = { PersistanceConfiguratione.class,DataSourceConfiguratione.class,MailSenderConfiguration.class })
@EnableWebMvc
@ComponentScan(basePackages = {"com.service","com.job"})
public class AppConfig extends WebMvcConfigurerAdapter{
	
		@Autowired
		PaysFormatter paysFormatter;

		/**
	     * Configure TilesConfigurer.
	     */
		@Bean
		public TilesConfigurer tilesConfigurer(){
		    TilesConfigurer tilesConfigurer = new TilesConfigurer();
		    tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
		    tilesConfigurer.setCheckRefresh(true);	    
		    return tilesConfigurer;
		}
	
	    @Bean
	    public LocaleResolver localeResolver(){
			CookieLocaleResolver resolver = new CookieLocaleResolver();
			resolver.setDefaultLocale(new Locale("en"));
			resolver.setCookieName("myLocaleCookie");
			resolver.setCookieMaxAge(4800);
			return resolver;
	    }
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
			interceptor.setParamName("mylocale");
			registry.addInterceptor(interceptor);
	    }

		/**
	     * Configure ViewResolvers to deliver preferred views.
	     */
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			TilesViewResolver viewResolver = new TilesViewResolver();
			registry.viewResolver(viewResolver);
		}
	
		/**
	     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	     */
		
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }
	    
	    @Bean
		public MessageSource messageSource() {
		    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		    messageSource.setBasename("/i18/usermsg");
		    messageSource.setDefaultEncoding("UTF-8");
		    return messageSource;
		}
	    
	    
	    @Override
	    public void addFormatters (FormatterRegistry registry) {
		    registry.addFormatter(paysFormatter);
	    }    
}

