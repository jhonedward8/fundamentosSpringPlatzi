package com.fundamentos.springboot.fundamentos.repository;


import com.fundamentos.springboot.fundamentos.dto.UserDto;
import com.fundamentos.springboot.fundamentos.entity.User;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u where u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByFecahBetween(LocalDate begin, LocalDate end);

    List<User> findByNameContainingOrderByIdDesc(String name);

    /*@Query("select new com.fundamentos.springboot.fundamentos.dto.UserDto(u.id, u.name, u.fecha)"+
        "from User u where u.fecha=:parametroFecha and u.email=:parametroEmail")
    Optional<UserDto> getAllByFechaAndEmail(
            @Param("parametroFecha") LocalDate date,
            @Param("parametroEmail") String email);*/

    List<User> findAll();
}
