package com.zaki.savetravels.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

    @Entity
    @Table(name="saveTravels")
    public class SaveTravels {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long    id;
        @NotNull
        @Size(min = 5, max = 200, message = "should be more than 5 and less than 200 baby")
        private     String  expense;
        @NotNull
        @Size(min = 5, max = 200)
        private     String  description;
        @NotNull
        @Size(min = 3, max = 40)
        private String vendor;
        @NotNull
        @Min(5)
        private     Integer amount;
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private     Date    createdAt;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private     Date    updatedAt;

        public SaveTravels() {
        }
        public SaveTravels(String expense, String desc, String vendor, int amount) {
            this.expense = expense;
            this.description = desc;
            this.vendor = vendor;
            this.amount = amount;
        }

        // other getters and setters removed for brevity
        @PrePersist
        protected void onCreate(){
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = new Date();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getExpense() {
            return expense;
        }

        public void setExpense(String expense) {
            this.expense = expense;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
