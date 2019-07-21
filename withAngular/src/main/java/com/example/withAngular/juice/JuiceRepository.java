package com.example.withAngular.juice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface JuiceRepository extends JpaRepository<Juice, Long> {
}
