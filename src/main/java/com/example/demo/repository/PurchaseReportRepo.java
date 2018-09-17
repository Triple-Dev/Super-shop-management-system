package com.example.demo.repository;

import com.example.demo.Model.PurchaseReport;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseReportRepo extends CrudRepository<PurchaseReport,Long> {
}
