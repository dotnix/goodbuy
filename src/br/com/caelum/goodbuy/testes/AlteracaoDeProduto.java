package br.com.caelum.goodbuy.testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.modelo.Produto;

public class AlteracaoDeProduto {

	public static void main(String[] args) {
		Session session = CriadorDeSession.getSession();
		
		Produto produto = criaProduto(session);
		
		atualizaProduto(session, produto);

	}

	private static void atualizaProduto(Session session, Produto produto) {
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
	}

	private static Produto criaProduto(Session session) {
		Produto produto = (Produto) session.load(Produto.class, 1L);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(produto);
			System.out.println("Informe o novo preço do produto: ");
			produto.setPreco(Double.parseDouble(br.readLine()));
			
		} catch (Exception e) {
			System.out.println("Erro ao atulizar o preço do produto: " + e.getMessage());
		}
		
		return produto;
	}

}
