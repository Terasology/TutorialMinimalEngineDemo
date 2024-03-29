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
package org.terasology.tutorial.minimalenginedemo.world;

import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.terasology.engine.registry.CoreRegistry;
import org.terasology.engine.world.block.Block;
import org.terasology.engine.world.block.BlockManager;
import org.terasology.engine.world.chunks.Chunk;
import org.terasology.engine.world.chunks.Chunks;
import org.terasology.engine.world.generation.Region;
import org.terasology.engine.world.generation.WorldRasterizer;
import org.terasology.engine.world.generation.facets.ElevationFacet;

public class BuilderWorldRasterizer implements WorldRasterizer {

    private Block dirt;
    private Block grass;

    @Override
    public void initialize() {
        dirt = CoreRegistry.get(BlockManager.class).getBlock("TutorialMinimalEngineDemo:Dirt");
        grass = CoreRegistry.get(BlockManager.class).getBlock("TutorialMinimalEngineDemo:Grass");
    }

    @Override
    public void generateChunk(Chunk chunk, Region chunkRegion) {
        ElevationFacet elevationFacet = chunkRegion.getFacet(ElevationFacet.class);
        Vector3i relativePos = new Vector3i();
        for (Vector3ic position : chunkRegion.getRegion()) {
            float surfaceHeight = elevationFacet.getWorld(position.x(), position.z());
            if (position.y() < surfaceHeight - 1) {
                chunk.setBlock(Chunks.toRelative(position, relativePos), dirt);
            } else if (position.y() < surfaceHeight) {
                chunk.setBlock(Chunks.toRelative(position, relativePos), grass);
            }
        }
    }
}
