package com.example.post.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeViewDTO {
    private Long id;
    private Long commentId;
    private Date date;




}
