package ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateEntryException extends DataIntegrityViolationException {

    public DuplicateEntryException(String s) {
        super(s);
    }

}
