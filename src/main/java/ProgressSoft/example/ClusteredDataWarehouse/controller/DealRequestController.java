package ProgressSoft.example.ClusteredDataWarehouse.controller;

import ProgressSoft.example.ClusteredDataWarehouse.entity.DealRequest;
import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.DealRequestNotFoundException;
import ProgressSoft.example.ClusteredDataWarehouse.service.DealRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deal-requests")
public class DealRequestController {

    private final DealRequestService dealRequestService;

    @Autowired
    public DealRequestController(DealRequestService dealRequestService) {
        this.dealRequestService = dealRequestService;
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    public ResponseEntity<DealRequest> createDealRequest(@Valid @RequestBody DealRequest dealRequest) {
        DealRequest savedDealRequest = dealRequestService.saveDealRequest(dealRequest);
        return new ResponseEntity<>(savedDealRequest, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<DealRequest> getAllDealRequests() {
        return dealRequestService.findAllDealRequests();
    }

    @GetMapping(
            path = "/{id}" ,
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<DealRequest> getDealRequestById(@PathVariable Long id) {

        Optional<DealRequest> tempDealRequest = dealRequestService.findDealRequestById(id);

        System.out.println("suiii");
        DealRequest dealRequest = tempDealRequest.orElseThrow(() -> new DealRequestNotFoundException("the Request with this ID " + id + " not found"));

        System.out.println("suiii");


        return new ResponseEntity<>(dealRequest, HttpStatus.FOUND);
    }

    // we can add more controller methods as needed
}
