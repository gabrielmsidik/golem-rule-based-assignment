package com.sidikg.rulebasedassignment.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Getter
@Setter
public class LogicNode {
    private String defaultValue;
    private Map<String, LogicNode> childLogicNodes;

    private static final String MATERIAL = "material";

    public LogicNode(String defaultValue, Map<String, LogicNode> childLogicNodes) {
        this.defaultValue = defaultValue;
        this.childLogicNodes = childLogicNodes;
    }

    public LogicNode(String defaultValue) {
        this.defaultValue = defaultValue;
        this.childLogicNodes = new HashMap<>();
    }
    public LogicNode() {
    }

    public AssignmentWithDerivationCommentary getClassAssignment(Golem golem) {
        // base case
        List<String> commentary = new ArrayList<>();
        if (childLogicNodes == null || childLogicNodes.values().size() == 0) {
            return new AssignmentWithDerivationCommentary(defaultValue, commentary);
        }
        // recursion
        for (Map.Entry<String, LogicNode> stringLogicNodeEntry : childLogicNodes.entrySet()) {
            String selector = stringLogicNodeEntry.getKey();
            LogicNode childNode = stringLogicNodeEntry.getValue();

            if (getSelectorFunction(selector).apply(golem)) {
                AssignmentWithDerivationCommentary classAssignment = childNode.getClassAssignment(golem);
                List<String> assignmentPath = classAssignment.getPath();
                assignmentPath.add(0,selector);
                return classAssignment;
            }
        }
        return new AssignmentWithDerivationCommentary(defaultValue, commentary);
    }

    public Function<Golem, Boolean> getSelectorFunction(String s) {
        switch (s) {
            case "IS_HYBRID_MATERIAL":
                return golem -> golem.getMaterials().size() > 1;
            case "HAS_STEEL":
                return golem -> golem.getMaterials().contains(Material.STEEL);
            case "HAS_CLAY":
                return golem -> golem.getMaterials().contains(Material.CLAY);
            case "HAS_BRONZE":
                return golem -> golem.getMaterials().contains(Material.BRONZE);
            case "HAS_MARBLE":
                return golem -> golem.getMaterials().contains(Material.MARBLE);
            case "HAS_ALABASTER":
                return golem -> golem.getMaterials().contains(Material.ALABASTER);
            case "HAS_GRANITE":
                return golem -> golem.getMaterials().contains(Material.GRANITE);
            case "IS_AIR":
                return golem -> ElementType.AIR.equals(golem.getElementType());
            case "IS_EARTH":
                return golem -> ElementType.EARTH.equals(golem.getElementType());
            case "IS_FIRE":
                return golem -> ElementType.FIRE.equals(golem.getElementType());
            case "IS_WATER":
                return golem -> ElementType.WATER.equals(golem.getElementType());
            case "HEAVY_WEIGHT":
                return golem -> golem.getWeight().compareTo(BigDecimal.valueOf(1000)) > 0;
            case "MIDDLE_WEIGHT":
                return golem -> golem.getWeight().compareTo(BigDecimal.valueOf(1000)) <= 0
                        && golem.getWeight().compareTo(BigDecimal.valueOf(100)) > 0;
            case "IS_SUPER_POWER":
                return golem -> golem.getShem().contains(Glyph.ALEF);
            default:
                return golem -> false;
        }
    }
}
