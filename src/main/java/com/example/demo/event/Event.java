package com.example.demo.event;

import java.time.LocalDate;

public record Event (Integer id,
                     String name,
                     LocalDate date, LocalDate eventDate,
                     LocalDate createdDate,
                     LocalDate updatedDate){
}
