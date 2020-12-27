package com.example.springwebapp.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface checkRepository extends CrudRepository<checkEdUser,Long> {
    @Query(value = "Select Max(d.id_chek) from check_ed_user d", nativeQuery = true)
    Long findMax();

}
