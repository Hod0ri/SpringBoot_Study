package com.example.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileBoardVO {
    private int b_no;
    private String title;
    private String content;
    private String writer;
    private Date reg_date;
}
