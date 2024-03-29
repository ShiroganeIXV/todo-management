package com.dianawu.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
