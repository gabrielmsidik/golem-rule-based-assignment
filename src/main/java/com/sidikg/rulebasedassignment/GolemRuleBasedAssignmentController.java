package com.sidikg.rulebasedassignment;

import com.sidikg.rulebasedassignment.domain.AssignmentWithDerivationCommentary;
import com.sidikg.rulebasedassignment.domain.Golem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GolemRuleBasedAssignmentController {

    @Autowired
    private GolemClassAssignmentLogicConfig golemClassAssignmentLogicConfig;

    @GetMapping("/ping")
    public String ping() {
        return "Hello World";
    }

    @PostMapping("/checkIsAlive")
    public boolean checkIsAlive(@RequestBody Golem golem) {
        return golem.isAlive();
    }

    @PostMapping("/classAssignment")
    public AssignmentWithDerivationCommentary getClassAssignment(@RequestBody Golem golem) {
        return golemClassAssignmentLogicConfig.getClassAssignment(golem);
    }

    @PostMapping("/getGolemClassAssignmentLogicProperties")
    public String getGolemClassAssignmentLogicProperties(@RequestBody Golem golem) {
        return golemClassAssignmentLogicConfig.getName() + ":" + golemClassAssignmentLogicConfig.getEnvironment();
    }
}
