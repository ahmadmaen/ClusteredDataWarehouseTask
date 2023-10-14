package ProgressSoft.example.ClusteredDataWarehouse.controller;

import ProgressSoft.example.ClusteredDataWarehouse.entity.DealRequest;
import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.DealRequestNotFoundException;
import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.ValidationException;
import ProgressSoft.example.ClusteredDataWarehouse.service.DealRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<DealRequest> createDealRequest(@Valid @RequestBody DealRequest dealRequest , BindingResult bindingResult) {

        //check if there is any validation error on the data.
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> {
                throw new ValidationException(error.getDefaultMessage());
            });
        }
        //once there are no errors , lets save the data on the object.
        DealRequest savedDealRequest = dealRequestService.saveDealRequest(dealRequest);

        //return the object
        return new ResponseEntity<>(savedDealRequest, HttpStatus.CREATED);

    }

    @GetMapping()
    public List<DealRequest> getAllDealRequests() {
        //return all DealRequest using dealRequestService.
        return dealRequestService.findAllDealRequests();
    }

    @GetMapping(
            path = "/{id}" ,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<DealRequest> getDealRequestById(@PathVariable Long id) {
        //get the DealRequest from the database
        Optional<DealRequest> tempDealRequest = dealRequestService.findDealRequestById(id);

        //check if the DealRequest is null
        DealRequest dealRequest = tempDealRequest.orElseThrow(() -> new DealRequestNotFoundException("the Request with this ID " + id + " not found"));

        //return the object
        return new ResponseEntity<>(dealRequest, HttpStatus.FOUND);
    }

    // we can add more controller methods as needed
}
