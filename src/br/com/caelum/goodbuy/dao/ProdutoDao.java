package br.com.caelum.goodbuy.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.goodbuy.infra.CriadorDeSession;
import br.com.caelum.goodbuy.modelo.Produto;

public class ProdutoDao {
	
	private Session session;
	
	public ProdutoDao(){
		session = CriadorDeSession.getSession();
	}
	
	public void salva(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}
	

	public void atualiza(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.update(produto);
		tx.commit();
	}
	
	public Produto buscaPorId(Long id){
		return (Produto) session.load(Produto.class, id);
	}
	
	public void remove(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
	}
	
	
}
