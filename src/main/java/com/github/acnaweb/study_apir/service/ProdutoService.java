package com.github.acnaweb.study_apir.service;
import java.util.List;
import java.util.Optional;

import com.github.acnaweb.study_apir.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.dto.produto.ProdutoRequestCreate;
import com.github.acnaweb.study_apir.dto.produto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apir.model.Produtos;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produtos criarProduto(ProdutoRequestCreate dto){
        return produtoRepository.save(dto.toModel());
    }
    public Optional<Produtos> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }
    public List<Produtos> buscarTodos(){
    return produtoRepository.findAll();
    }
    public Optional<Produtos> atualizarProduto(Long id, ProdutoRequestUpdate dto){
     return produtoRepository.findById(id)
             .map(p-> produtoRepository.save(dto.toModel(p)));
    }
    public boolean deletarProduto(Long id){
        if(produtoRepository.existsById(id)){
         produtoRepository.deleteById(id);
         return true;
        }
        return false;
    }
}
