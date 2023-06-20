package com.crud.crud.Repositories;

import com.crud.crud.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel,Long> {

}
