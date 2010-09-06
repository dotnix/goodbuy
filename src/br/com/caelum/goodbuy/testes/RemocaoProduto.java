package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.modelo.Produto;

public class RemocaoProduto {

	public static void main(String[] args) {
		Session session = CriadorDeSession.getSession();

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



}
