package com.sidikg.rulebasedassignment.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Golem {
    private String name;
    private Set<Material> materials;
    private Heart heart;
    private ElementType elementType;
    private List<Glyph> shem;
    private BigDecimal weight;

    public boolean isAlive() {
        return materials.size() > 0 && heart.isAliveConfiguration() && shem.size() > 3 && weight.compareTo(BigDecimal.valueOf(5)) > 0;
    }

    public Set<Material> getMaterials() {
        return materials == null ? new HashSet<>() : materials;
    }

    public List<Glyph> getShem() {
        return shem == null ? new ArrayList<>() : shem;
    }

    public BigDecimal getWeight() {
        return weight == null ? BigDecimal.TEN : weight;
    }

    public ElementType getElementType() {
        return elementType;
    }
}
