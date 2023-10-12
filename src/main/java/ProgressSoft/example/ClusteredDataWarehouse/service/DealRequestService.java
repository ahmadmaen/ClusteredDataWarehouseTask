package ProgressSoft.example.ClusteredDataWarehouse.service;

import ProgressSoft.example.ClusteredDataWarehouse.entity.DealRequest;
import ProgressSoft.example.ClusteredDataWarehouse.repository.DealRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealRequestService {
    private final DealRequestRepository dealRequestRepository;

    @Autowired
    public DealRequestService(DealRequestRepository dealRequestRepository) {
        this.dealRequestRepository = dealRequestRepository;
    }

    public DealRequest saveDealRequest(DealRequest dealRequest) {
        return dealRequestRepository.save(dealRequest);
    }

    public List<DealRequest> findAllDealRequests() {
        return dealRequestRepository.findAll();
    }

    public Optional<DealRequest> findDealRequestById(Long id) {
        return dealRequestRepository.findById(id);
    }
}
