package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Resource;

@Resource
public class ProdutosController {
	
	private final ProdutoDao dao;
	
	public ProdutosController(ProdutoDao dao) {
		this.dao = dao;
	}
	
	public List<Produto> lista(){
		return dao.listaTudo();
	}
	
	public void adiciona(Produto produto) {
		dao.salva(produto);
	}
	
	public void formulario(){
		
	}
}
