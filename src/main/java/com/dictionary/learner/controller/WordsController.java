package com.dictionary.learner.controller;


import com.dictionary.learner.entity.Words;
import com.dictionary.learner.entity.dto.WordsDTO;
import com.dictionary.learner.form.CreatingWordForm;
import com.dictionary.learner.form.ViewFilterForm;
import com.dictionary.learner.service.IWordsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (value = "api/v1/words")
@Validated
public class WordsController {

    @Autowired
    private IWordsService wordsService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<WordsDTO> getAllWord(Pageable pageable, @RequestParam(value = "search", required = false) String search, ViewFilterForm filterForm){

        Page<Words> wordsPages = wordsService.getAllWords(pageable, search, filterForm);

        List<WordsDTO> dtos = modelMapper.map(wordsPages.getContent(), new TypeToken<List<WordsDTO>>(){}.getType());

        Page<WordsDTO> dtoPages = new PageImpl<>(dtos, pageable, wordsPages.getTotalElements());

        return dtoPages;
    };

    @PostMapping
    public void createWord(@RequestBody @Valid CreatingWordForm form){
        wordsService.createNewWord(form);
    }

    @GetMapping("/{word}")
    public WordsDTO getOneWord(@PathVariable String word){
        Words entity = wordsService.findByWord(word);
        WordsDTO dto = modelMapper.map(entity, WordsDTO.class);
        return dto;
    };

    @GetMapping("/id/{id}")
    public Words getWordById(@PathVariable Integer id){
        return wordsService.getWordsById(id);
    };


    @GetMapping("/wordclass/{wordClass}")
    public List<Words> getWordsByWordclass(@PathVariable String wordClass){
        return wordsService.getWordsByClass(wordClass);
    };

}
