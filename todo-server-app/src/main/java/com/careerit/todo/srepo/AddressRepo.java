package com.careerit.todo.srepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerit.todo.smodel.Address;

public interface AddressRepo extends JpaRepository<Address,Long> {

}
