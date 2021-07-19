package com.srivathsanvenkateswaran.mysoothe.models

import com.srivathsanvenkateswaran.mysoothe.R

data class Collection(
    val name: String,
    val imageRes: Int
)

val favoritesCollections = listOf<Collection>(
    Collection(
        name = "Short mantras",
        imageRes = R.drawable.short_mantras
    ),
    Collection(
        name = "Stress and anxiety",
        imageRes = R.drawable.stress_and_anxiety
    ),
    Collection(
        name = "Overwhelmed",
        imageRes = R.drawable.overwhelmed
    ),
    Collection(
        name = "Nature and meditations",
        imageRes = R.drawable.nature_meditations
    ),
    Collection(
        name = "Self-massage",
        imageRes = R.drawable.self_massage
    ),
    Collection(
        name = "Nightly wind down",
        imageRes = R.drawable.nightly_wind_down
    ),
)

val alignYourBodyCollections = listOf<Collection>(
    Collection(
        name = "Inversions",
        imageRes = R.drawable.inversions
    ),
    Collection(
        name = "Quick yoga",
        imageRes = R.drawable.quick_yoga
    ),
    Collection(
        name = "Stretching",
        imageRes = R.drawable.stretching
    ),
    Collection(
        name = "Tabata",
        imageRes = R.drawable.tabata
    ),
    Collection(
        name = "HIIT",
        imageRes = R.drawable.hiit
    ),
    Collection(
        name = "Pre-natal yoga",
        imageRes = R.drawable.pre_natal_yoga
    ),
)

val alignYourMindCollections = listOf<Collection>(
    Collection(
        name = "Meditate",
        imageRes = R.drawable.meditate
    ),
    Collection(
        name = "With kids",
        imageRes = R.drawable.with_kids
    ),
    Collection(
        name = "Aromatherapy",
        imageRes = R.drawable.aromatherapy
    ),
    Collection(
        name = "On the go",
        imageRes = R.drawable.on_the_go
    ),
    Collection(
        name = "With pets",
        imageRes = R.drawable.with_pets
    ),
    Collection(
        name = "High stress",
        imageRes = R.drawable.high_stress
    ),
)