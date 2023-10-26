package com.jilnash.task.controller;

import com.jilnash.task.model.Revenue;
import com.jilnash.task.repo.RevenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Controller for handling /cafe requests.
 */

@RestController
@RequestMapping("/cafe")
public class MainController {

    @Autowired
    private RevenueRepo revenueRepo;

    /**
     * Calculates the revenue of the cafe by number of customers and average spend per customer
     * and saves the value into table in database
     *
     * @param cafeName - name of the cafe
     * @param customerNum - number of customers, should be positive integer number
     * @param avgSpend - average spend per customer, should be positive double number
     * @return returns the revenue by avgSpend * customerNum operation
     * @throws IOException if the required parameters have wrong values or not set
     */

    @PostMapping
    public Double calcCafeRevenue(@RequestParam(required = false) String cafeName,
                                   @RequestParam(required = false) Integer customerNum,
                                   @RequestParam(required = false) Double avgSpend) throws IOException {

        if (cafeName == null)
            throw new IOException("Cafe name should be set");

        if (customerNum == null)
            throw new IOException("Customer number should be set");

        if (avgSpend == null)
            throw new IOException("Average spend should be set");

        if (customerNum < 0)
            throw new IOException("Customer number cannot be negative");

        if (avgSpend < 0)
            throw new IOException("Average spend per customer cannot be negative");

        revenueRepo.save(new Revenue(cafeName, customerNum * avgSpend));

        return customerNum * avgSpend;
    }

    /**
     *
     * @return returns last five requests
     */

    @GetMapping
    public List<Revenue> getLastFive() {

        List<Revenue> revenues = revenueRepo.findAll();

        if (revenues.size() < 5)
            return revenues;

        return revenues.subList(revenues.size() - 5, revenues.size());
    }
}
