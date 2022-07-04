package com.dictionary.learner.repository;

import com.dictionary.learner.entity.Words;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IWordsRepository extends JpaRepository<Words, Integer>, JpaSpecificationExecutor<Words> {

    public Page<Words> findAll(Specification<Words> where, Pageable pageable);
    public Words findByWord(String word);
    public List<Words> findByWordClass(String wordClass);

}
