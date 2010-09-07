package br.com.caelum.goodbuy.testes;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;

public class RemocaoProduto {

	public static void main(String[] args) {

		Produto produto = criaProduto();

		new ProdutoDao().remove(produto);

	}

	private static Produto criaProduto() {
		Produto produto = new ProdutoDao().carrega(1L);
		return produto;
	}

}
