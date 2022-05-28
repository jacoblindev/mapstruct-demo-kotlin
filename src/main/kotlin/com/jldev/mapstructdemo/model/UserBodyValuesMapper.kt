package com.jldev.mapstructdemo.model

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named

@Mapper
interface UserBodyValuesMapper {
    companion object {
        @JvmStatic
        @Named("inchToCentimeter")
        fun inchToCentimeter(inch: Int): Double {
            return inch * 2.54
        }

        @JvmStatic
        @PoundToKilogramMapper
        fun poundToKilogram(pound: Int): Double {
            return pound * 0.4535
        }
    }

    @Mapping(source = "inch", target = "centimeter", qualifiedByName = ["inchToCentimeter"])
    @Mapping(source = "pound", target = "kilogram", qualifiedBy = [PoundToKilogramMapper::class])
    fun userBodyValuesConverter(imperial: UserBodyValuesImperial): UserBodyValuesMetric
}