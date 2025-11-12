package com.mbb.Book.Trip.repository;

import com.mbb.Book.Trip.model.Booking;
import com.mbb.Book.Trip.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {


    @Query(value = "select * from driver_info where cab_id=:cabId",nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") int cabId);
}
