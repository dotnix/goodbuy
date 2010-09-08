package br.com.caelum.goodbuy.testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.infra.CriadorDeSessionFactory;
import br.com.caelum.goodbuy.modelo.Produto;

public class AdicaoDeProduto {

	public static void main(String[] args) {

		Produto produto = criaProduto();
		
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		new ProdutoDao(session).salva(produto);

	}

	private static Produto criaProduto() {
		Produto produto = new Produto();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

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
