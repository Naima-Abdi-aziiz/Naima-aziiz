package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private Map<Long, Staff> staffRepo = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffRepo.values());

    }
    public Staff getStaffById(Long id) {
        return staffRepo.get(id);
    }
    public Staff createStaff(Staff staff) {
        long id = idCounter.incrementAndGet();
        staff.setId(id);
        staffRepo.put(id, staff);
        return staff;
    }
    public Staff updateStaff(Long id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffRepo.put(id, updatedStaff);
        return updatedStaff;
    }
    public void deleteStaff(Long id) {
        staffRepo.remove(id);
    }

}
