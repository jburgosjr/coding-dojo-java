package com.JairoBurgos.Licenses.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Licenses.models.License;


@Repository
public interface LicenseRepo extends CrudRepository<License,Long> {
	List<License> findTopByOrderByNumberDesc();

}
