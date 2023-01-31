package com.dowpro.library_design_system.data

import com.dowpro.library_design_system.composables.cards.RedContent

class MockCreator {

    companion object {
        fun lazyColumnScreenContents(): List<RedContent> = listOf(
            RedContent("Title 1", "Body"),
            RedContent("Title 2", "Body"),
            RedContent("Title 3", "Body"),
        )
    }
}