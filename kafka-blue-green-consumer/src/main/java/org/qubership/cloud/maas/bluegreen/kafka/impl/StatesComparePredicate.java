package org.qubership.cloud.maas.bluegreen.kafka.impl;

import org.qubership.cloud.bluegreen.api.model.State;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
class StatesComparePredicate {
    GroupId groupId;

    boolean test(State current, State sibling) {
        return groupId instanceof VersionedGroupId vg && Objects.equals(current, vg.getState()) && Objects.equals(sibling, vg.getSiblingState());
    }
}
