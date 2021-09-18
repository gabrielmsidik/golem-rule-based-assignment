package com.sidikg.rulebasedassignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Heart {
    private Gem leftGem;
    private Gem rightGem;

    public Heart() {
        leftGem = Gem.DIAMOND;
        rightGem = Gem.DIAMOND;
    }

    public Heart(Gem gem) {
        leftGem = gem;
        rightGem = gem;
    }

    public boolean isAliveConfiguration() {
        // a pure diamond heart does not provide the correct magical mix to make the golem alive
        // an empty heart provides no magic
        // any other combination can power a golem
        return !(leftGem == Gem.DIAMOND && rightGem == Gem.DIAMOND) || (leftGem == null && rightGem == null);
    }
}
