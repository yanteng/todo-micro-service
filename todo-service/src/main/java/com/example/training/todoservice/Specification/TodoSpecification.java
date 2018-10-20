package com.example.training.todoservice.Specification;

import com.example.training.todoservice.model.Todo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
public class TodoSpecification implements Specification<Todo> {
    private SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Todo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (searchCriteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                return cb.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
            } else {
                return cb.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
            }
        }
        if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
            return cb.lessThanOrEqualTo(root.get(searchCriteria.getKey()), (Date) searchCriteria.getValue());
        }
        if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
            return cb.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), (Date) searchCriteria.getValue());
        }
        return null;
    }
}
