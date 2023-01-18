package com.revature.controllers;

import com.revature.models.InnerTransferLog;
import com.revature.models.InnerTransferLogDTO;
import com.revature.services.InnerTransferLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/transfer")
public class InnerTransferLogController {
    private InnerTransferLogService transferLogService;

    @Autowired
    public InnerTransferLogController(InnerTransferLogService innerTransferLogService) {
        this.transferLogService = innerTransferLogService;
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<InnerTransferLog>> getTransfersByAccount(@PathVariable int accountId) {
        Optional<List<InnerTransferLog>> transfers = transferLogService.findByAccountId(accountId);
        if (transfers.isPresent()) {
            return ResponseEntity.ok(transfers.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InnerTransferLog> doTransfer(@RequestBody InnerTransferLogDTO transferLogDTO) {
        try {
            return ResponseEntity.ok(transferLogService.doTransfer(transferLogDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
