package com.example.exercise2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepositoryClone extends PagingAndSortingRepository<Student, Long> {

    Page<Student> findAllByOrderByAgeDescIeltsScore(Pageable pageable);

}
