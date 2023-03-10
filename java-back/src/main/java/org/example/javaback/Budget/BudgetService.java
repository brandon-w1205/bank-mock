package org.example.javaback.Budget;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

//    GET method for all budgets
    public List<Budget> getAllBudgets() {
        List<Budget> budgets = new ArrayList<>();
        budgetRepository.findAll().forEach(budgets::add);
//        List<Course> courses = new ArrayList<>(courseRepository.findByTopicId(topic_id));
        return budgets;
    }

//    GET ONE method for one account
    public Budget getBudget(String name) {
        Budget aBudget = new Budget();
        for(Budget budget : getAllBudgets()) {
            if(name.equals(budget.getName())) {
                aBudget = budget;
            }
        }
        return aBudget;
    }

//    POST method to create a new account
    public void addBudget(Budget budget) {
        budgetRepository.save(budget);
    }

//    PUT method to edit an account
    public void updateBudget(Budget budget) {
        budgetRepository.save(budget);
    }

//    DELETE method to delete an account
    public void deleteBudget(String name) {
        getAllBudgets().removeIf(budget -> budget.getName().equals(name));
    }
}
