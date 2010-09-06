package br.com.caelum.goodbuy.testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.goodbuy.modelo.Produto;

public class AdicaoDeProduto {

	public static void main(String[] args) {
		
		Session session = criaSession();
		
		Produto produto = criaProduto();
		
		salvaProduto(session, produto);
		
	}

	private static void salvaProduto(Session session, Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}

	private static Session criaSession() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	private static Produto criaProduto() {
		Produto produto = new Produto();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Informe o nome do produto: ");
			produto.setNome(br.readLine());

			System.out.println("Informe a descricao do produto: ");
			produto.setDescricao(br.readLine());
			
			System.out.println("Informe do preco do produto: ");
			produto.setPreco(Double.parseDouble(br.readLine()));
			
			
		} catch (Exception e) {
			System.out.println("Erro ao criar um produto: " + e.getMessage());
		}
			
		return produto;
	}

}
