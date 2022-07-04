package com.dictionary.learner.specification;

import com.dictionary.learner.entity.Words;
import com.dictionary.learner.form.ViewFilterForm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class WordSpecification {

    @SuppressWarnings("deprecation")
    public static Specification<Words> buildWhere (String search, ViewFilterForm filterView){

        Specification<Words> where = null;

        if ( !StringUtils.containsWhitespace(search) ){
            search = search.trim();
            CustomSpecification word = new CustomSpecification("word", search);
            where = Specification.where(word);
        }
        if (filterView != null && filterView.getMinView() != null){
            CustomSpecification minView = new CustomSpecification("minView", filterView.getMinView());
            if(where == null){
                where = minView;
            } else {
                where = where.and(minView);
            }
        }

        if(filterView !=null && filterView.getMaxView() != null){
            CustomSpecification maxView = new CustomSpecification("maxView", filterView.getMaxView());

            if(where == null){
                where = maxView;
            } else {
                where = where.and(maxView);
            }
        }


        return where;
    }

}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Words>{

    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Words> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder){
        if(field.equalsIgnoreCase("word")) {
            return criteriaBuilder.like(root.get("word"), "%" + value.toString() + "%");
        }

        if(field.equalsIgnoreCase("minView")){
            return criteriaBuilder.greaterThanOrEqualTo(root.get("view"), value.toString());
        }

        if(field.equalsIgnoreCase("maxView")){
            return criteriaBuilder.lessThanOrEqualTo(root.get("view"), value.toString());
        }


        return null;
    }

}