package com.example.bankSystem.repository;

import com.example.bankSystem.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("select a from Address a where a.city=:city and a.country=:country and a.apartment=:apartment " +
            "and a.building=:building and a.street=:street")
    Address findAddressByFields(@Param("city") String city,@Param("country") String country,
                                    @Param("apartment")String apartment,@Param("building")String building,
                                    @Param("street")String street);

}