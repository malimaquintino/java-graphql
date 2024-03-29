package com.malimaquintino.javagraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInputDto {
    private long id;
    private String name;
    private String description;
    private long groupId;
    private List<String> membersEmail;
    private List<String> adminsEmail;
}
