package com.projetosoftwareteusz.teusz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetosoftwareteusz.teusz.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}