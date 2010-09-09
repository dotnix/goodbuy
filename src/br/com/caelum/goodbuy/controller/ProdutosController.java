package br.com.caelum.goodbuy.controller;

import java.util.List;

import br.com.caelum.goodbuy.dao.ProdutoDao;
import br.com.caelum.goodbuy.modelo.Produto;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get @Path("produtos/novo")
	public void formulario() {
	}
	
	@Get @Path("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}
	
	@Put @Path("/produtos/{produto.id}")
	public void altera(Produto produto) {
		validacaoObrigatorio(produto);
		
		validator.onErrorUse(Results.page()).of(ProdutosController.class).edita(produto.getId());
		
		dao.atualiza(produto);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	
	@Post @Path("/produtos")
	public void adiciona(final Produto produto) {
		
		validacaoObrigatorio(produto);
		
		validator.onErrorUse(Results.page()).of(ProdutosController.class).formulario();
		
		dao.salva(produto);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Delete @Path("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(ProdutosController.class).lista();
	}
	
	@Get @Path("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}

	private void validacaoObrigatorio(final Produto produto) {
		validator.checking(new Validations() {
			{
				that(produto.getNome() != null && produto.getNome().length() >= 3, 
						"produto.nome", "nome.obrigatorio");
				
				that(produto.getDescricao() != null && produto.getDescricao().length() <= 40, 
						"produto.descricao","descricao.obrigatorio");
				
				that(produto.getPreco() != null && produto.getPreco() > 0.0, 
						"produto.preco", "preco.positivo");
				
			}});
	}
	
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}
	
	@Get @Path("/produtos/busca.json")
	public void bucaJson(String q){
		result.use(Results.json()).from(dao.busca(q))
		.exclude("id", "descricao")
		.serialize();
	}
}
