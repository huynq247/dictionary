package com.dictionary.learner.service;

import com.dictionary.learner.entity.Words;
import com.dictionary.learner.form.CreatingWordForm;
import com.dictionary.learner.form.ViewFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IWordsService {

    public Page<Words> getAllWords(Pageable pageable, String search, ViewFilterForm filterView);

    public Words getWordsById(int id);

    public List<Words> getWordsByClass(String wordClass);

    public Words findByWord(String word);

    public void createNewWord(CreatingWordForm form);

    public void deleteWord(int id);

}
