package ProgressSoft.example.ClusteredDataWarehouse.repository;


import ProgressSoft.example.ClusteredDataWarehouse.entity.DealRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRequestRepository extends JpaRepository<DealRequest , Long> {

    // extending the 'JpaRepository' will provide basic CRUD operations out of the box.
    // we can add custom query methods here if needed.

}
