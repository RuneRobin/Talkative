package ryanv.talkative.common.data

import net.minecraft.nbt.CompoundTag
import net.minecraft.resources.PackResources$ResourceOutput
import ryanv.talkative.consts.NBTConstants

class MarkerData(var modelLocation: PackResources$ResourceOutput, var baseColour: Int = 0xFFFFFF, var outlineColour: Int = 0xFFFFFF) {

    companion object {
        fun deserialize(tag: CompoundTag): MarkerData {
            var modelLocation = PackResources$ResourceOutput(tag.getString(NBTConstants.MARKER_LOCATION))
            var data = MarkerData(modelLocation)

            if (tag.contains(NBTConstants.MARKER_COLOUR))
                data.baseColour = tag.getInt(NBTConstants.MARKER_COLOUR)
            if (tag.contains(NBTConstants.MARKER_OUTLINE))
                data.outlineColour = tag.getInt(NBTConstants.MARKER_OUTLINE)

            return data
        }
    }

}