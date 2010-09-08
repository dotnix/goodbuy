package br.com.caelum.goodbuy.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;

public class RemocaoProduto {
	private static Session session;
	public static void main(String[] args) {

		Produto produto = criaProduto();

		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		session = new CriadorDeSession(factory).getInstance();

		new ProdutoDao(session).remove(produto);

	}

	private static Produto criaProduto() {
		Produto produto = new ProdutoDao(session).carrega(1L);
		return produto;
	}

}
