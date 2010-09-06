package br.com.caelum.goodbuy.testes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;

public class AlteracaoDeProduto {

	public static void main(String[] args) {
		Produto produto = criaProduto();
		new ProdutoDao().atualiza(produto);

	}


	private static Produto criaProduto() {
		Produto produto = new ProdutoDao().buscaPorId(1L);
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
