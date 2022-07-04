package com.dictionary.learner.service;

import com.dictionary.learner.entity.Words;
import com.dictionary.learner.form.CreatingWordForm;
import com.dictionary.learner.form.ViewFilterForm;
import com.dictionary.learner.repository.IWordsRepository;
import com.dictionary.learner.specification.WordSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WordsService implements IWordsService{

    @Autowired
    private IWordsRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Words> getAllWords(Pageable pageable,String search, ViewFilterForm filterView){

        //where word like '%search%' AND view >=5 AND view <=15
        Specification<Words> where = WordSpecification.buildWhere(search, filterView);
        return repository.findAll(where, pageable);
    };


    @Override
    public Words getWordsById(int id){
        return repository.findById(id).get();
    };

    @Override
    public Words findByWord(String word){
        return repository.findByWord(word);
    }

    @Override
    public List<Words> getWordsByClass(String wordClass){
        return repository.findByWordClass(wordClass);
    }

    @Override
    public void createNewWord(CreatingWordForm form){
        //covert form to word
        Words word = modelMapper.map(form, Words.class);

        repository.save(word);
    };

    @Override
    public void deleteWord(int id){

    };

}
