package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController{
    @Autowired
    private StaffService staffService;
    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaff();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable Long id) {
        Staff staff = staffService.getStaffById(id);
        if (staff == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(staff);
    }
    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff created = staffService.createStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        Staff updated = staffService.updateStaff(id, staff);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
    }



