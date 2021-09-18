package com.sidikg.rulebasedassignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssignmentWithDerivationCommentary {
    private String assignment;
    private List<String> path;
}
