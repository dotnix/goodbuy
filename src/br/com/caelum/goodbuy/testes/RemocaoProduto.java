package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.goodbuy.modelo.Produto;

public class RemocaoProduto {

	public static void main(String[] args) {
		Session session = criaSessao();

		Produto produto = criaProduto(session);

		removeProduto(session, produto);

	}

	private static void removeProduto(Session session, Produto produto) {
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
	}

	private static Produto criaProduto(Session session) {
		Produto produto = (Produto) session.load(Produto.class, 1L);
		return produto;
	}

	private static Session criaSessao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

}
