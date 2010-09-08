package br.com.caelum.goodbuy.infra;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSessionFactory implements ComponentFactory<SessionFactory>{

	@Override
	public SessionFactory getInstance() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		return factory;
	}
	
}
