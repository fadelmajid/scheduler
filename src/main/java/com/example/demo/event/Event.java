package com.example.demo.event;

import java.util.Date;

public record Event (Integer id,
                     String name,
                     Date event_date,
                     Date created_date,
                     Date updated_date){
}
