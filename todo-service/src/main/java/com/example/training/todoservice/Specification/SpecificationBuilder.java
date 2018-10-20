package com.example.training.todoservice.Specification;

import com.example.training.todoservice.model.Todo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder {
    private final List<SearchCriteria> params = new ArrayList<>();

    public SpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Todo> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Todo>> specs = new ArrayList<Specification<Todo>>();
        for (SearchCriteria param : params) {
            specs.add(new TodoSpecification(param));
        }

        Specification<Todo> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
