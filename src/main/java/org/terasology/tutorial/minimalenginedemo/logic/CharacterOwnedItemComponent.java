/*
 * Copyright 2020 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.tutorial.minimalenginedemo.logic;

import org.terasology.engine.entitySystem.Owns;
import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.component.Component;

/**
 * A single-slot inventory.
 * <p>
 * The character can own a single item while having this component attached.
 */
public class CharacterOwnedItemComponent implements Component<CharacterOwnedItemComponent> {
    @Owns
    public EntityRef item;

    public CharacterOwnedItemComponent() {
    }

    public CharacterOwnedItemComponent(EntityRef item) {
        this.item = item;
    }

    @Override
    public void copyFrom(CharacterOwnedItemComponent other) {
        this.item = other.item;
    }
}
