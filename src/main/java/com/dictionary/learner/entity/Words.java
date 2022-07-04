package com.dictionary.learner.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="`Words`")
public class Words implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`word`")
    private String word;

    @Column(name = "`wordclass`")
    private String wordClass;

    @Column(name ="`definition`")
    private String definition;

    @Column(name ="`view`")
    private int view;

    public Words(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
