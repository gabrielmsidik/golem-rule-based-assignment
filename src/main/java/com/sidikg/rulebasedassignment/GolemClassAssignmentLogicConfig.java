package com.sidikg.rulebasedassignment;

import com.sidikg.rulebasedassignment.domain.AssignmentWithDerivationCommentary;
import com.sidikg.rulebasedassignment.domain.Golem;
import com.sidikg.rulebasedassignment.domain.LogicNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "golem-config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GolemClassAssignmentLogicConfig {
    private String name;
    private String environment;
    private LogicNode rootLogicNode;

    public String getConfigurationAsString() {
        return this.getName() + ":" + this.getEnvironment();
    }

    public AssignmentWithDerivationCommentary getClassAssignment(Golem golem) {
        return rootLogicNode == null ? new AssignmentWithDerivationCommentary("", new ArrayList<>(Arrays.asList("Root Logic Node not provided")))
    : rootLogicNode.getClassAssignment(golem);
    }
}
